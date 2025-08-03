package apiexecution;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.AssertUtils;
import utilities.ReadAPIs;

public class BaseAPI {

    protected static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(ReadAPIs.getBaseUri())
            .addHeader("x-api-key", "reqres-free-v1")
            .build();

    protected void verifyResponse(Response response, String expectedJson, int expectedStatusCode) {
        AssertUtils.assertStatusCode(response, expectedStatusCode);

        if (expectedJson != null) {
            AssertUtils.assertJsonEquals(expectedJson, response.getBody().asString());
        }
    }

    protected void verifyResponse(Response response) {
        verifyResponse(response, null, 200);
    }

    protected void verifyResponse(Response response, String expectedJson) {
        verifyResponse(response, expectedJson, 200);
    }

    protected void verifyResponse(Response response, Integer statusCode) {
        verifyResponse(response, null, statusCode);
    }


}

