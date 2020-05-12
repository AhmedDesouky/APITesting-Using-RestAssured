package test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestPostRequest {

	@SuppressWarnings("unchecked")
	@Test
	public void RegistrationSuccessful()
	{ 
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Hassan"); 
		requestParams.put("salary", "10000");
		requestParams.put("age", "30");
		
		request.body(requestParams.toJSONString());
		Response response = request.post("/create");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
	}
}
