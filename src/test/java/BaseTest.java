import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utilities.ReportLog;

public class BaseTest {

    @BeforeAll
    public static void startTestBeforeALl() {
        ReportLog.log("Before All API test");
    }

    @BeforeEach
    public void startTest() {
        ReportLog.log("Before Each API test");
    }

    @AfterAll
    public static void startTestAfterALl() {
        ReportLog.log("After All API test");
    }

    @AfterEach
    public void AfterTest() {
        ReportLog.log("After Each API test");
    }

}
