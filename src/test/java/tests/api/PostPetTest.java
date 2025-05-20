package tests.api;

import api.models.Category;
import api.models.Pet;
import api.models.Status;
import api.models.Tag;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
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
    public void postPetWithoutId() {
        var id = ThreadLocalRandom.current().nextInt(1, 1000);

        var testPet = Pet.builder()
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
        String newName = "newName";
        String newStatus = "newStatus";

        given()
                .accept("*/*")
                .when()
                .post(petFindByIdPath.formatted(defaultPet.getId()) + "?name=" + newName + "&status=" + newStatus)
                .then()
                .statusCode(200);

        defaultPet.setName(newName);
        defaultPet.setStatus(newStatus);
        getAndVerifyPet(defaultPet);
    }

    @Test
    public void updatePetByPostWithInvalidId() {
        String newName = "newName";
        String newStatus = "newStatus";

        given()
                .accept("*/*")
                .when()
                .post(petFindByIdPath.formatted(invalidId) + "?name=" + newName + "&status=" + newStatus)
                .then()
                .statusCode(404)
                .body(equalTo("Pet not found"));
    }

    @Test
    public void updatePetByPostWithoutId() {
        String newName = "newName";
        String newStatus = "newStatus";

        given()
                .accept("*/*")
                .when()
                .post(petFindByIdPath + "?name=" + newName + "&status=" + newStatus)
                .then()
                .statusCode(400)
                .body("message", containsString("Input error: couldn't convert `%s` to type `class java.lang.Long`"));
    }

    @Test
    void uploadImageTest() {
        int petId = 1;
        //This particular endpoint is buggy, on api/v3 returns 415
        //I've added path to real resource just to demonstate how this should work.
        var url = String.format("https://petstore.swagger.io/v2/pet/%s/uploadImage", petId);
        var fileName = "git.png";
        var file = new File(fileName);

        given()
                .multiPart("file", file, "image/png")
                .contentType("multipart/form-data")
                .accept("application/json")
                .when()
                .post(url)
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", containsString("File uploaded to ./" + fileName));
    }
}

