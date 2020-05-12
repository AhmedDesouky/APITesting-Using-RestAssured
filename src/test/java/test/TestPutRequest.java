package test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestPutRequest {

	@SuppressWarnings("unchecked")
	@Test
	public void UpdateRecords(){
		int empid = 15410;

		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Zion"); // Cast
		requestParams.put("age", 50);
		requestParams.put("salary", 15000);

		request.body(requestParams.toJSONString());
		request.header("Content-Type", "application/json");
		Response response = request.put("/update/"+ empid);

		int statusCode = response.getStatusCode();
		System.out.println(response.getBody().asString());
		Assert.assertEquals(statusCode, 200); 

	}
}
