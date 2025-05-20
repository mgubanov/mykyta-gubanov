package tests.api;

import api.models.Category;
import api.models.Pet;
import api.models.Status;
import api.models.Tag;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PutPetTest extends ApiBaseTest {

    @Test
    public void updatePetByPut() {
        var id = ThreadLocalRandom.current().nextInt(1, 1000);
        var categoryId = ThreadLocalRandom.current().nextInt(1000, 2000);
        var tagId = ThreadLocalRandom.current().nextInt(2000, 3000);

        var testPet = Pet.builder()
                .id(defaultPet.getId())
                .name("pet" + id)
                .category(new Category(categoryId, "categoryName" + categoryId))
                .tags(List.of(new Tag(tagId, "tagName" + tagId)))
                .photoUrls(List.of("test/url"))
                .status(Status.PENDING.name().toLowerCase())
                .build();

        given()
                .body(testPet)
                .when()
                .put(petPath)
                .then()
                .statusCode(200)
                .body("id", equalTo(defaultPet.getId()))
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
    public void updatePetByPutWithInvalidId() {
        var id = ThreadLocalRandom.current().nextInt(1, 1000);
        var categoryId = ThreadLocalRandom.current().nextInt(1000, 2000);
        var tagId = ThreadLocalRandom.current().nextInt(2000, 3000);

        var testPet = Pet.builder()
                .id(invalidId)
                .name("pet" + id)
                .category(new Category(categoryId, "categoryName" + categoryId))
                .tags(List.of(new Tag(tagId, "tagName" + tagId)))
                .photoUrls(List.of("test/url"))
                .status(Status.PENDING.name().toLowerCase())
                .build();

        given()
                .body(testPet)
                .when()
                .put(petPath)
                .then()
                .statusCode(404)
                .body(equalTo("Pet not found"));
    }
}

