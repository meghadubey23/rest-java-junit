package apiexecution;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Assertions;
import utilities.ReadAPIs;

public class BaseAPI {

    protected RequestSpecification request;

    public BaseAPI() {
        RestAssured.baseURI = ReadAPIs.getBaseUri();
    }

    protected void verifyResponse(Response response, String json_resp_exp) {
        Assertions.assertStatusCode(response, 200);
        if (json_resp_exp != null) {
            Assertions.assertJsonEquals(json_resp_exp, response);
        }
    }

    protected void verifyResponse(Response response) {
        verifyResponse(response, null);
    }
}

