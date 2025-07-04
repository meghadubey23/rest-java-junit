import apiexecution.RunAPIs;
import exceptions.UnauthorizedException;
import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class APITests extends BaseTest {
//    APIs from: https://reqres.in/

    @Test
    @DisplayName("Get Single User API should return 200 OK for valid API request")
    void runGetSingleUserReturns200() {
        RunAPIs api = new RunAPIs();
        api.getSingleUser();
    }

    @Test
    @DisplayName("Returns Unauthorized Exception")
    void runGetSingleUserReturnsUnAuthorized() throws JSONException {

        UnauthorizedException exception = assertThrows(UnauthorizedException.class, () -> {
            RunAPIs api = new RunAPIs();
            api.getSingleUser();
        });

        assertTrue(exception.getMessage().contains("401 Unauthorized:"));
    }

    @Test
    @DisplayName("Get Users List API should return 200 OK for valid API request")
    void runGetListReturns200() {
        RunAPIs api = new RunAPIs();
        api.getUsersList();
    }
}
