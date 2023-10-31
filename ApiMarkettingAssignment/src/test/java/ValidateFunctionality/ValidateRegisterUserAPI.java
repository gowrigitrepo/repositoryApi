package ValidateFunctionality;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.requestPOJO.RegisterUserRequest;
import api.utils.APIHelper;
import api.utils.BaseTest;
import api.utils.JsonUtil;
import io.restassured.response.Response;

public class ValidateRegisterUserAPI extends BaseTest{
	APIHelper apiHelper;

    @BeforeClass
    public void beforeClass() {
        apiHelper = new APIHelper();
    }

    @Test(description = "validate new user registration functionality")
    public void validateNewUserRegistration() {
    	String name,email;
    	int password;
    	name = "magig";
    	email = "magic@gmail.com";
    	password = 123456;
    	RegisterUserRequest registerUserRequest = RegisterUserRequest.builder().name(name).email(email).password(password).build();
        Response userRegister = apiHelper.userRegister(registerUserRequest);
        Assert.assertEquals(userRegister.getStatusCode(), HttpStatus.SC_CREATED, "User created successfully");
        String actualResponse = userRegister.jsonPath().prettyPrint();
        //actualResponse = actualResponse.replace("[", "").replace("]", "");
        JsonUtil.validateSchema(actualResponse, "UserRegisterResponseSchema.json");
        /*
         * response for successful user registration
         * {
    	"code": 0,
    	"message": "success",
    	"data": {
        "Id": 278608,
        "Name": "Customer",
        "Email": "Customer@gmail.com",
        "Token": "65b3881f-fab9-429f-af8c-985ec8247458"
    		}
		}
         */
        
    }
    @Test(description = "validate existing user registration functionality")
    public void validateExistingUserRegistration() {
    	String name,email;
    	int password;
    	name = "delta";
    	email = "delta@gmail.com";
    	password = 123456;
    	RegisterUserRequest registerUserRequest = RegisterUserRequest.builder().name(name).email(email).password(password).build();
        Response userRegister = apiHelper.userRegister(registerUserRequest);
        Assert.assertEquals(userRegister.getStatusCode(), HttpStatus.SC_OK, "User already exists");
        String actualResponse = userRegister.jsonPath().prettyPrint();
        actualResponse = actualResponse.replace("[", "").replace("]", "");
        JsonUtil.validateSchema(actualResponse, "UserRegisterResponseExistingUserSchema.json");
    }
}
