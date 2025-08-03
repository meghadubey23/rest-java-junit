import apiexecution.RunAPIs;
import data.UserInfoData;
import data.UserLoginData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class APITests extends BaseTest {
//    APIs from: https://reqres.in/

    @ParameterizedTest
    @MethodSource("utilities.ReadExpectedResponses#userLoginJsonProvider")
    @DisplayName("Login as a valid user")
    void userLogin(String expected_response) {
        UserLoginData testData1 = new UserLoginData();
        testData1.setExpectedResponse(expected_response);

        RunAPIs api = new RunAPIs();
        api.postUserLogin(testData1);
    }

    @ParameterizedTest
    @MethodSource("utilities.ReadExpectedResponses#failedUserLoginJsonProvider")
    @DisplayName("Invalid user login")
    void userLoginUnsuccessful(String expected_response) {
        UserLoginData testData1 = new UserLoginData();
        testData1.setPassword(false);
        testData1.setExpectedResponse(expected_response);
        testData1.setExpectedStatusCode(400);

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("error", "Missing password");
        testData1.setMap(map);

        RunAPIs api = new RunAPIs();
        api.postUserLogin(testData1);
    }

    @ParameterizedTest
    @Tag("smoke")
    @MethodSource("utilities.ReadExpectedResponses#singleUserJsonProvider")
    @DisplayName("Get Single User API should return 200 OK for valid user IDs")
    void runGetSingleUserReturns200(String expected_response) {
        UserInfoData testData1 = new UserInfoData();
        testData1.setUserId(2);
        testData1.setExpectedResponse(expected_response);

        UserInfoData testData2 = new UserInfoData();
        testData2.setUserId(25);
        testData2.setExpectedStatusCode(404);

        RunAPIs api = new RunAPIs();
        api.getSingleUser(List.of(testData1, testData2));
    }

    @ParameterizedTest
    @MethodSource("utilities.ReadExpectedResponses#userListJsonProvider")
    @DisplayName("Get Users List API should return 200 OK for valid API request")
    void runGetListReturns200(String expected_response) {
        UserInfoData testData1 = new UserInfoData();
        testData1.setExpectedResponse(expected_response);

        RunAPIs api = new RunAPIs();
        api.getUsersList(List.of(testData1));
    }
}
