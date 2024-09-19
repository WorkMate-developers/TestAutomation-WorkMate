package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CitiesBasicTest {

    @Test(groups = {"regression"})
    public void getCities() {

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(Endpoints.HTTP + Endpoints.URI + Endpoints.API)
                .build().log().all();

        Response response = given().spec(requestSpecification).get(Endpoints.CITIES);

        response.getBody().prettyPrint();
    }
}
