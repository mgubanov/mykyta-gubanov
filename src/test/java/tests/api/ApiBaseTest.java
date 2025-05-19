package tests.api;

import api.models.Pet;
import api.models.Tag;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class ApiBaseTest {

    protected String petPath = "/pets";
    protected String petFindByStatusPath = "/pet/findByStatus";
    protected String petFindByTagsPath = "/pet/findByTags";
    protected String petFindByIdPath = "/pet/%s";
    protected Pet defaultPet;
    protected int invalidId;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
        RestAssured.requestSpecification = RestAssured
                .given()
                .accept("application/json")
                .contentType(ContentType.JSON);
    }

    @BeforeMethod
    void prepareTestData() {
        var id = ThreadLocalRandom.current().nextInt(1, 10001);
        invalidId = ThreadLocalRandom.current().nextInt(10000, 11000);

        defaultPet = Pet.builder()
                .id(id)
                .name("pet" + id)
                .build();

        given()
                .body(defaultPet)
                .when()
                .post("/pet")
                .then()
                .statusCode(200);
    }

    void getAndVerifyPet(Pet pet) {
        given()
                .when()
                .get(petFindByIdPath.formatted(pet.getId()))
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(pet.getId()))
                .body("name", equalTo(pet.getName()))
                .body("category.id", equalTo(pet.getCategory().getId()))
                .body("category.name", equalTo(pet.getCategory().getName()))
                .body("tags.id", containsInAnyOrder(pet.getTags().stream().map(Tag::getId).toArray()))
                .body("tags.name", containsInAnyOrder(pet.getTags().stream().map(Tag::getName).toArray()))
                .body("status", equalTo(pet.getStatus()))
                .body("photoUrls", equalTo(pet.getPhotoUrls()));
    }
}
