package data;

public class TestCaseData {
    private int userId = 0;
    private int expectedStatusCode = 200;
    private String expectedResponse = null;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExpectedStatusCode() {
        return expectedStatusCode;
    }

    public void setExpectedStatusCode(int expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
    }

    public String getExpectedResponse() {
        return expectedResponse;
    }

    public void setExpectedResponse(String expectedResponse) {
        this.expectedResponse = expectedResponse;
    }
}
