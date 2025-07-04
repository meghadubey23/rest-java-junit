import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utilities.ReportLog;

public class BaseTest {

    @BeforeAll
    static void startTestBeforeALl() {
        ReportLog.log("Before All API test");
    }

    @BeforeEach
    void startTest() {
        ReportLog.log("Before Each API test");
    }

}
