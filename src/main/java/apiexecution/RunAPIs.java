package apiexecution;

import io.restassured.response.Response;
import utilities.Assertions;
import utilities.ReadAPIs;
import utilities.ReportLog;

import static io.restassured.RestAssured.given;

public class RunAPIs {
    public void getSingleUser() {
        ReportLog.log("Starting execution for run get user API....");
        Response response = given()
                .when()
                .get(ReadAPIs.getSingleUser())
                .then()
                .extract().response();

        Assertions.assertStatusCode(response, 200);
        String json_resp_exp = "{\n" +
                "    \"data\": {\n" +
                "        \"id\": 2,\n" +
                "        \"email\": \"janet.weaver@reqres.in\",\n" +
                "        \"first_name\": \"Janet\",\n" +
                "        \"last_name\": \"Weaver\",\n" +
                "        \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\n" +
                "    },\n" +
                "    \"support\": {\n" +
                "        \"url\": \"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral\",\n" +
                "        \"text\": \"Tired of writing endless social media content? Let Content Caddy generate it for you.\"\n" +
                "    }\n" +
                "}";
        Assertions.assertJsonEquals(json_resp_exp, response);


        ReportLog.log("Test passed");

    }

    public void getUsersList() {
        ReportLog.log("Starting execution for run get list API....");
        Response response = given()
                .when()
                .get(ReadAPIs.getUsersList())
                .then()
                .extract().response();

        Assertions.assertStatusCode(response, 200);
//        Assertions.assertJsonEquals("{\"id\":1,\"name\":\"Megha\"}", response);


        ReportLog.log("Test passed");

    }
}
