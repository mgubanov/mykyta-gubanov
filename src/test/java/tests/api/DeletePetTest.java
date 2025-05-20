package tests.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeletePetTest extends ApiBaseTest {

    @Test
    public void deletePetById() {
        given()
                .header("api_key", "api_key") // Optional here
                .when()
                .delete(petFindByIdPath.formatted(defaultPet.getId()))
                .then()
                .statusCode(200)
                .body(equalTo("Pet deleted"));

        // Verify pet is no longer found
        given()
                .when()
                .get(petFindByIdPath.formatted(defaultPet.getId()))
                .then()
                .statusCode(404)
                .body(equalTo("Pet not found"));
    }

    @Test
    public void deletePetByInvalidId() { //this should return 404
        given()
                .header("api_key", "api_key") // Optional here
                .when()
                .delete(petFindByIdPath.formatted(invalidId))
                .then()
                .statusCode(404)
                .body(equalTo("Pet not found"));
    }
}

