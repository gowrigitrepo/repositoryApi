package ValidateFunctionality;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.responsePOJO.StatusResponse;
import api.utils.APIHelper;
import api.utils.BaseTest;
import api.utils.EnvironmentDetails;
import api.utils.JsonUtil;
import api.utils.TestDataUtils;

public class ValidateLoginAPI extends BaseTest {
    APIHelper apiHelper;

    @BeforeClass
    public void beforeClass() {
        apiHelper = new APIHelper();
    }

    @Test(priority = 0, description = "validate login functionality with valid credentials")
    public void validateLoginWithValidCredentials() {
        Response login = apiHelper.login(EnvironmentDetails.getProperty("email"), EnvironmentDetails.getProperty("password"));
        Assert.assertEquals(login.getStatusCode(), HttpStatus.SC_CREATED, "Login is  working for valid credentials.");
        String actualResponse = login.jsonPath().prettyPrint();
        actualResponse = actualResponse.replace("[", "").replace("]", "");
        JsonUtil.validateSchema(actualResponse, "LoginResponseSchema.json");
        
    }

    @Test(priority = 1, description = "validate login functionality with invalid credentials")
    public void validateLoginWithInValidCredentials() {
        Response login = apiHelper.login(EnvironmentDetails.getProperty("email"), "password");
        Assert.assertEquals(login.getStatusCode(), HttpStatus.SC_UNAUTHORIZED, "Login is not returning proper status code with invalid credentials.");
        StatusResponse statusResponse = login.as(StatusResponse.class);
        Assert.assertEquals(statusResponse.getStatus(), TestDataUtils.getProperty("invalidCredentialsMessage"), "Status message is not returning as expected");
    }

}
