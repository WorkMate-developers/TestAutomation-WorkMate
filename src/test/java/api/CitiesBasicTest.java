package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * This is a basic test that verifies whether the response code for GET /cities is 200. It also prints the response.
 */

public class CitiesBasicTest {

    private static final Logger log = LoggerFactory.getLogger(CitiesBasicTest.class);
    private final String testName = this.getClass().getName();

    @Test(groups = {"regression"})
    @Parameters({"backendServerUrl"})
    public void getCities(String backendServerUrl) {

        log.info("Starting test: " + testName);

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(Endpoints.HTTP + backendServerUrl + Endpoints.API)
                .build();

        Response response = given().spec(requestSpecification).get(Endpoints.CITIES);

        log.debug("Actual response:\n" + response.getBody().asPrettyString());

        assert response.getStatusCode() == 200 : "Invalid response code! Actual response code: " + response.getStatusCode();

    }
}
