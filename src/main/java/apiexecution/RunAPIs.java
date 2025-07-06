package apiexecution;

import data.TestCaseData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ReadAPIs;
import utilities.ReadPostBody;
import utilities.ReadProperty;
import utilities.ReportLog;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RunAPIs extends BaseAPI {

    public void postUserLogin(TestCaseData tdata) {
        String endPoint = ReadAPIs.getUserLoginEndpoint();
        String expectedResponse = tdata.getExpectedResponse();
        int expectedStatus = tdata.getExpectedStatusCode();

        Map<String, String> postBodyMap = new ReadPostBody("login").getJsonBody();
        if(tdata.isUsername())
            postBodyMap.put("email", ReadProperty.getProperty("email"));
        else
            postBodyMap.remove("email");
        if(tdata.isPassword())
            postBodyMap.put("password", ReadProperty.getProperty("password"));
        else
            postBodyMap.remove("password");

        ReportLog.log(String.format("Starting execution for %s endpoint", endPoint));

        Response response = given()
                .spec(getRequestSpec())
                .contentType(ContentType.JSON)
                .body(postBodyMap)
                .when()
                .post(endPoint);

        if (expectedResponse != null && expectedStatus != 0) {
            verifyResponse(response, expectedResponse, expectedStatus);
        } else if (expectedStatus != 0) {
            verifyResponse(response, null, expectedStatus);
        } else if (expectedResponse != null) {
            verifyResponse(response, expectedResponse, 200);
        } else {
            verifyResponse(response);
        }
    }

    public void getSingleUser(List<TestCaseData> testCaseData) {
        String getEndPoint = ReadAPIs.getSingleUserEndpoint();

        for (TestCaseData tdata : testCaseData) {
            String endPoint = String.format(getEndPoint, tdata.getUserId());
            String expectedResponse = tdata.getExpectedResponse();
            int expectedStatus = tdata.getExpectedStatusCode();

            ReportLog.log(String.format("Starting execution for %s endpoint", endPoint));

            Response response = given()
                    .spec(getRequestSpec())
                    .when()
                    .get(endPoint)
                    .then()
                    .extract()
                    .response();

            if (expectedResponse != null && expectedStatus != 0) {
                verifyResponse(response, expectedResponse, expectedStatus);
            } else if (expectedStatus != 0) {
                verifyResponse(response, null, expectedStatus);
            } else if (expectedResponse != null) {
                verifyResponse(response, expectedResponse, 200);
            } else {
                verifyResponse(response);
            }
        }
    }

    public void getUsersList(List<TestCaseData> testCaseData) {
        String endPoint = ReadAPIs.getUsersList();
        for (TestCaseData tdata : testCaseData) {
            String expectedResponse = tdata.getExpectedResponse();
            int expectedStatus = tdata.getExpectedStatusCode();

            ReportLog.log(String.format("Starting execution for %s endpoint", endPoint));

            Response response = given()
                    .spec(getRequestSpec())
                    .when()
                    .get(endPoint)
                    .then()
                    .extract()
                    .response();

            if (expectedResponse != null && expectedStatus != 0) {
                verifyResponse(response, expectedResponse, expectedStatus);
            } else if (expectedStatus != 0) {
                verifyResponse(response, null, expectedStatus);
            } else if (expectedResponse != null) {
                verifyResponse(response, expectedResponse, 200);
            } else {
                verifyResponse(response);
            }
        }
    }
}
