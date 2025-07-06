import apiexecution.RunAPIs;
import data.TestCaseData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class APITests extends BaseTest {
//    APIs from: https://reqres.in/

    @ParameterizedTest
    @MethodSource("utilities.ReadExpectedResponses#userLoginJsonProvider")
    @DisplayName("Login as a valid user")
    void userLogin(String expected_response) {
        TestCaseData testData1 = new TestCaseData();
        testData1.setExpectedResponse(expected_response);

        RunAPIs api = new RunAPIs();
        api.postUserLogin(testData1);
    }

    @ParameterizedTest
    @MethodSource("utilities.ReadExpectedResponses#userLoginJsonProvider")
    @DisplayName("Login as a valid user")
    void userLoginUnsuccessful(String expected_response) {
        TestCaseData testData1 = new TestCaseData();
        testData1.setExpectedResponse(expected_response);

        RunAPIs api = new RunAPIs();
        api.postUserLogin(testData1);
    }

    @ParameterizedTest
    @Tag("smoke")
    @MethodSource("utilities.ReadExpectedResponses#singleUserJsonProvider")
    @DisplayName("Get Single User API should return 200 OK for valid user IDs")
    void runGetSingleUserReturns200(String expected_response) {
        TestCaseData testData1 = new TestCaseData();
        testData1.setUserId(2);
        testData1.setExpectedResponse(expected_response);

        TestCaseData testData2 = new TestCaseData();
        testData2.setUserId(25);
        testData2.setExpectedStatusCode(404);

        RunAPIs api = new RunAPIs();
        api.getSingleUser(List.of(testData1, testData2));
    }

    @ParameterizedTest
    @MethodSource("utilities.ReadExpectedResponses#userListJsonProvider")
    @DisplayName("Get Users List API should return 200 OK for valid API request")
    void runGetListReturns200(String expected_response) {
        TestCaseData testData1 = new TestCaseData();
        testData1.setExpectedResponse(expected_response);

        RunAPIs api = new RunAPIs();
        api.getUsersList(List.of(testData1));
    }
}
