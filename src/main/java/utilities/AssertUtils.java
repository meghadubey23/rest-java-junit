package utilities;

import exceptions.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.skyscreamer.jsonassert.JSONAssert;

public class AssertUtils {

    public static void assertStatusCode(Response response, int expected) {
        try {
            Assertions.assertEquals(expected, response.getStatusCode());
            ReportLog.log(String.format("%s is correct", response.getStatusCode()));
        } catch (Exception e) {
            ReportLog.log(String.format("Actual code: %s", response.getStatusCode()));
            ReportLog.log(String.format("Expected code: %s", expected));

            throwExceptionForStatusCode(response.getStatusCode(), response.getBody().asString());
        }

    }

    public static void assertJsonEquals(String expectedResponseJson, String actualResponseJson) {
        try {
            JSONAssert.assertEquals(expectedResponseJson, actualResponseJson, false);
            ReportLog.log("JSON response is correct");
        } catch (Exception e) {
            ReportLog.log(String.format("Actual Response: %s", actualResponseJson));
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
