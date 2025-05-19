package tests.api;

import api.models.Pet;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.given;

public class ApiBaseTest {

    protected String petPath = "/pets";
    protected String petFindByStatus = "/pet/findByStatus";
    protected String petFindByTags = "/pet/findByTags";
    protected String petFindById = "/pet/%s";
    protected Pet pet;
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

        pet = Pet.builder()
                .id(id)
                .name("pet" + id)
                .build();

        given()
                .body(pet)
                .when()
                .post("/pet")
                .then()
                .statusCode(200);
    }
}
