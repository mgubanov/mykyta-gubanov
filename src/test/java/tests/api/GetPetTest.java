package tests.api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetPetTest extends ApiBaseTest {

    @Test
    public void getPetByValidId() {
        given()
                .when()
                .get(petFindById.formatted(pet.getId()))
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(pet.getId()));
    }

    @Test
    public void getPetByInvalidId() {
        given()
                .when()
                .get(petFindById.formatted(invalidId))
                .then()
                .statusCode(404)
                .contentType(ContentType.JSON)
                .body(equalTo("Pet not found"));

    }

    @Test
    public void getPetByInvalidFormatId() {
        given()
                .when()
                .get(petFindById.formatted("invalidId"))
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .body("message", equalTo("Input error: couldn't convert `invalidId` to type `class java.lang.Long`"));
    }

    @Test
    public void getPetByTag() {
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(pet.getId()));
    }

}

