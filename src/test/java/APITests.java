import apiexecution.RunAPIs;
import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class APITests extends BaseTest {
//    APIs from: https://reqres.in/

    @Test
    @DisplayName("Get Single User API should return 200 OK for valid API request")
    void runGetSingleUserReturns200() throws JSONException {
        RunAPIs api = new RunAPIs();
        api.getSingleUser();
    }

    @Test
    @DisplayName("Get Users List API should return 200 OK for valid API request")
    void runGetListReturns200() throws JSONException {
        RunAPIs api = new RunAPIs();
        api.getUsersList();
    }
}
