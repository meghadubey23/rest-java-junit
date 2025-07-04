package utilities;

import io.restassured.response.Response;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assertions {

    public static void assertStatusCode(Response response, int expectedStatusCode) {

        try {
            assertEquals(expectedStatusCode, response.statusCode());
            ReportLog.log("API was successful");
        } catch (Exception e) {
            ReportLog.log("API was not successful");
            throw new RuntimeException(e);
        }
    }

    public static void assertJsonEquals(String expectedResponseJson, Response response) throws JSONException {
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
}
