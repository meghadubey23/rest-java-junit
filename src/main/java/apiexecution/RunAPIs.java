package apiexecution;

import io.restassured.response.Response;
import utilities.ReadAPIs;
import utilities.ReportLog;

import static io.restassured.RestAssured.given;

public class RunAPIs extends BaseAPI {
    public void getSingleUser(String expected_response) {
        String endPoint = ReadAPIs.getSingleUserEndpoint();
        ReportLog.log(String.format("Starting execution for %s endpoint", endPoint));
        Response response = given()
                .when()
                .spec(getRequestSpec())
                .get(endPoint)
                .then()
                .extract()
                .response();
        verifyResponse(response, expected_response);
    }

    public void getUsersList(String expected_response) {
        String endPoint = ReadAPIs.getUsersList();
        ReportLog.log(String.format("Starting execution for %s endpoint", endPoint));
        Response response = given()
                .get(endPoint)
                .then()
                .extract().response();
        verifyResponse(response, expected_response);
    }
}
