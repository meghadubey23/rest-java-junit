package utilities;

import exceptions.*;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONAssert;

public class Assertions {

    public static void assertStatusCode(Response response, int expected) {
        int actual = response.getStatusCode();
        if (actual != expected) {
            throwExceptionForStatusCode(actual, response.getBody().asString());
        }
    }

    public static void assertJsonEquals(String expectedResponseJson, Response response) {
        String actualJson = response.getBody().asString();
        try {
            JSONAssert.assertEquals(expectedResponseJson, actualJson, false);
            ReportLog.log("JSON response is correct");
        } catch (Exception e) {
            ReportLog.log(String.format("Actual Response: %s", actualJson));
            ReportLog.log(String.format("Expected Response: %s", expectedResponseJson));

            throw new RuntimeException(e);
        }
    }

    private static void throwExceptionForStatusCode(int statusCode, String body) {
        switch (statusCode) {
            case 400:
                throw new BadRequestException(body);
            case 401:
                throw new UnauthorizedException(body);
            case 403:
                throw new ForbiddenException(body);
            case 404:
                throw new NotFoundException(body);
            default:
                throw new StatusCodeMismatchException(200, statusCode); // default expected 200
        }
    }
}
