package apiexecution;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.AssertUtils;
import utilities.ReadAPIs;

public class BaseAPI {

    protected static RequestSpecification requestSpec;

    public BaseAPI() {
        RestAssured.baseURI = ReadAPIs.getBaseUri();
    }

    static {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(ReadAPIs.getBaseUri())
                .addHeader("x-api-key", "reqres-free-v1")
                .build();
    }

    protected RequestSpecification getRequestSpec() {
        return requestSpec;
    }

    protected void verifyResponse(Response response, String json_resp_exp) {
        AssertUtils.assertStatusCode(response, 200);
        if (json_resp_exp != null) {
            AssertUtils.assertJsonEquals(json_resp_exp, response.getBody().asString());
        }
    }

    protected void verifyResponse(Response response) {
        verifyResponse(response, null);
    }
}

