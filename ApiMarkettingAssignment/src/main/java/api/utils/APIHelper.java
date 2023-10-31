package api.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;
import api.requestPOJO.LoginRequest;
import api.requestPOJO.RegisterUserRequest;
import api.responsePOJO.LoginResponse;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIHelper {
	RequestSpecification reqSpec;
	String token = "65b3881f-fab9-429f-af8c-985ec8247458";

	public APIHelper() {
		RestAssured.baseURI = EnvironmentDetails.getProperty("baseURL");
		reqSpec = RestAssured.given();
	}

	public Response login(String email, String password) {
		LoginRequest loginRequest = LoginRequest.builder().email(email).password(password).build();
		reqSpec.headers(getHeaders(true));
		Response response = null;
		try {
			reqSpec.body(new ObjectMapper().writeValueAsString(loginRequest)); // Serializing loginrequest class to byte
																				// stream
			response = reqSpec.post("/login");
			response.then().log().all();
			if (response.getStatusCode() == HttpStatus.SC_CREATED) {
				List<LoginResponse> loginResponse = response.getBody().as(new TypeRef<List<LoginResponse>>() {
				});
				this.token = loginResponse.get(0).getToken();
			}
		} catch (Exception e) {
			Assert.fail("Login functionality is failing due to :: " + e.getMessage());
		}
		return response;
	}

	public Response userRegister(RegisterUserRequest registerUserRequest) {

		reqSpec = RestAssured.given();
		Response response = null;
		try {
			reqSpec.headers(getHeaders(false));
			reqSpec.body(new ObjectMapper().writeValueAsString(registerUserRequest)); // Serializing registerUserRequest
																						// Request POJO classes to byte
																						// stream
			response = reqSpec.post("/api/authaccount/registration");
			// response.then().log().all();
		} catch (Exception e) {
			Assert.fail("User Registration functionality is failing due to :: " + e.getMessage());
		}
		return response;

	}

	public Response getUserByID(int pathParam) {

		reqSpec = RestAssured.given();
		Response response = null;
		try {
			reqSpec.headers(getHeaders(false));
			response = reqSpec.get("/api/users/" + pathParam);

		} catch (Exception e) {
			Assert.fail("Get User by ID functionality is failing due to :: " + e.getMessage());
		}
		return response;

	}

	public Response getUserByPages(int queryParam) {

		reqSpec = RestAssured.given();
		Response response = null;
		try {
			reqSpec.headers(getHeaders(false));
			response = reqSpec.get("/api/users?page=" + queryParam);

		} catch (Exception e) {
			Assert.fail("Get User by ID functionality is failing due to :: " + e.getMessage());
		}
		return response;

	}
	
	public HashMap<String, String> getHeaders(boolean forLogin) {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		if (!forLogin) {
			headers.put("token", token);
			headers.put("Authorization", "bearer " + token);
		}
		return headers;
	}


	/*
	 * public Response getUserByID(Map<String, Integer> pathParam) {
	 * 
	 * reqSpec = RestAssured.given(); Response response = null; try {
	 * reqSpec.headers(getHeaders(false));
	 * 
	 * for(Map.Entry<String, Integer> m:pathParam.entrySet()){
	 * //System.out.println("m value : "+m.getValue()); //reqSpec.pathParam(,
	 * m.getValue()); response = reqSpec.get("/api/users/"+m.getValue());
	 * //System.out.println(response.prettyPrint()); } //response =
	 * reqSpec.get("/api/users/"); //System.out.println(response.then().log()); }
	 * catch (Exception e) {
	 * Assert.fail("Get User by ID functionality is failing due to :: " +
	 * e.getMessage()); } return response;
	 * 
	 * }
	 */

}
