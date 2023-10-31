package ValidateFunctionality;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.requestPOJO.RegisterUserRequest;
import api.responsePOJO.GetResponse;
import api.utils.APIHelper;
import api.utils.BaseTest;
import api.utils.JsonUtil;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

public class ValidateGetUserAPI extends BaseTest{
	APIHelper apiHelper;

    @BeforeClass
    public void beforeClass() {
        apiHelper = new APIHelper();
    }

    @Test(description = "validate get user by ID")
    public void validateGetUserByID() {
		/*
		 * Map<String, Integer> map = new HashMap<String,Integer>(); map.put("1",
		 * 278608); map.put("2", 123456);
		 */
    	int pathParam = 278608;
    	Response response=apiHelper.getUserByID(pathParam);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "User data retrieved successfully");
        String actualResponse = response.getBody().prettyPrint();
        System.out.println("Response Received : "+actualResponse);
    }
    
    
    @Test(description = "validate get user by pages")
    public void validateGetUserByPages() {
    	int queryParam = 1;
    	Response response=apiHelper.getUserByPages(queryParam);
    	List<GetResponse> getResponseList = response.getBody().as(new TypeRef<List<GetResponse>>() {
        });
    	
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "User data retrieved successfully for the specified page");
        
    }
}
