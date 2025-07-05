import apiexecution.RunAPIs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class APITests extends BaseTest {
//    APIs from: https://reqres.in/

    @ParameterizedTest
    @Tag("smoke")
    @MethodSource("utilities.ReadExpectedResponses#singleUserJsonProvider")
    @DisplayName("Get Single User API should return 200 OK for valid user IDs")
    void runGetSingleUserReturns200(String expected_response) {
        RunAPIs api = new RunAPIs();
        api.getSingleUser(expected_response);
    }

    @ParameterizedTest
    @MethodSource("utilities.ReadExpectedResponses#userListJsonProvider")
    @DisplayName("Get Users List API should return 200 OK for valid API request")
    void runGetListReturns200(String expected_response) {
        RunAPIs api = new RunAPIs();
        api.getUsersList(expected_response);
    }
}
