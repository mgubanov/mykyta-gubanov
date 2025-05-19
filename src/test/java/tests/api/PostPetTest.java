package tests.api;

import api.models.Category;
import api.models.Pet;
import api.models.Status;
import api.models.Tag;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostPetTest extends ApiBaseTest {

    @Test
    public void postPet() {
        var id = ThreadLocalRandom.current().nextInt(1, 1000);
        var categoryId = ThreadLocalRandom.current().nextInt(1000, 2000);
        var tagId = ThreadLocalRandom.current().nextInt(2000, 3000);

        var testPet = Pet.builder()
                .id(id)
                .name("pet" + id)
                .category(new Category(categoryId, "categoryName" + categoryId))
                .tags(List.of(new Tag(tagId, "tagName" + tagId)))
                .photoUrls(List.of("test/url"))
                .status(Status.AVAILABLE.name().toLowerCase())
                .build();

        given()
                .body(testPet)
                .when()
                .post(petPath)
                .then()
                .statusCode(200)
                .body("id", equalTo(testPet.getId()))
                .body("name", equalTo(testPet.getName()))
                .body("category.id", equalTo(testPet.getCategory().getId()))
                .body("category.name", equalTo(testPet.getCategory().getName()))
                .body("tags.id", containsInAnyOrder(testPet.getTags().stream().map(Tag::getId).toArray()))
                .body("tags.name", containsInAnyOrder(testPet.getTags().stream().map(Tag::getName).toArray()))
                .body("status", equalTo(testPet.getStatus()))
                .body("photoUrls", equalTo(testPet.getPhotoUrls()));

        getAndVerifyPet(testPet);
    }

    @Test
    public void postPetWithNullId() {
        var id = ThreadLocalRandom.current().nextInt(1, 1000);

        var testPet = Pet.builder()
                .id(null)
                .name("pet" + id)
                .build();

        given()
                .body(testPet)
                .when()
                .post(petPath)
                .then()
                .statusCode(500)
                .body("message", containsString("There was an error processing your request. It has been logged"));
    }

    @Test
    public void updatePetByPost() {

        given()
                .body(defaultPet)
                .when()
                .post(petPath.formatted(defaultPet.getId()))
                .then()
                .statusCode(200)
                .body("id", equalTo(defaultPet.getId()))
                .body("name", equalTo(defaultPet.getName()))
                .body("category.id", equalTo(defaultPet.getCategory().getId()))
                .body("category.name", equalTo(defaultPet.getCategory().getName()))
                .body("tags.id", containsInAnyOrder(defaultPet.getTags().stream().map(Tag::getId).toArray()))
                .body("tags.name", containsInAnyOrder(defaultPet.getTags().stream().map(Tag::getName).toArray()))
                .body("status", equalTo(defaultPet.getStatus()))
                .body("photoUrls", equalTo(defaultPet.getPhotoUrls()));

        getAndVerifyPet(defaultPet);
    }
}

