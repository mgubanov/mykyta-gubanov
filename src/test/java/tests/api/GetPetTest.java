package tests.api;

import api.models.Status;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetPetTest extends ApiBaseTest {

    @Test
    public void getPetByValidId() {
        getAndVerifyPet(defaultPet);
    }

    @Test
    public void getPetByInvalidId() {
        given()
                .when()
                .get(petFindByIdPath.formatted(invalidId))
                .then()
                .statusCode(404)
                .contentType(ContentType.JSON)
                .body(equalTo("Pet not found"));

    }

    @Test
    public void getPetByInvalidFormatId() {
        given()
                .when()
                .get(petFindByIdPath.formatted("invalidId"))
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .body("message", equalTo("Input error: couldn't convert `invalidId` to type `class java.lang.Long`"));
    }

    @Test
    public void getPetsByValidTag() {
        given()
                .accept(ContentType.JSON)
                .queryParam("tags", defaultPet.getTags().get(0).getName())
                .when()
                .get(petFindByTagsPath)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", hasItem(defaultPet.getId()));
    }

    @Test
    public void getPetsByInvalidTag() {
        given()
                .accept(ContentType.JSON)
                .queryParam("tags", "nonExistingTag")
                .when()
                .get(petFindByTagsPath)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", equalTo(0));// expects empty list for invalid tag
    }

    @Test
    public void getPetsByEmptyTag() {
        given()
                .accept(ContentType.JSON)
                .queryParam("tags", "")
                .when()
                .get(petFindByTagsPath)
                .then()
                .statusCode(400)
                .body(equalTo("No tags provided. Try again?"));
    }

    @Test(dataProvider = "statusProvider")
    public void getPetsByStatus(String status) {
        given()
                .accept(ContentType.JSON)
                .queryParam("status", status)
                .when()
                .get(petFindByStatusPath)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test(dataProvider = "invalidStatusProvider")
    public void getPetsByStatusByWrongValue(String invalidStatus) {
        given()
                .accept(ContentType.JSON)
                .queryParam("status", invalidStatus)
                .when()
                .get(petFindByStatusPath)
                .then()
                .statusCode(400)
                .body("message", equalTo("Input error: query parameter `status value `%s` is not in the allowable values `[available, pending, sold]`".formatted(invalidStatus)));
    }

    @DataProvider(name = "statusProvider")
    public Object[][] statusProvider() {
        return Arrays.stream(Status.values())
                .map(s -> new Object[]{s.toString().toLowerCase()})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "invalidStatusProvider")
    public Object[][] invalidStatusProvider() {
        return new Object[][]{
                {Status.AVAILABLE.toString()},//this is invalid value
                {"invalidStatus"},
                {""}
        };
    }
}

