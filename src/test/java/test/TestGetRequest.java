package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGetRequest {

	@Test
	public void GetWeatherDetails() {
		
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/employees");

		// Now let us print the body of the message to see what response
		// we have received from the server
		String responseBody = response.getBody().asString();
		String responseStatusLine = response.getStatusLine().toString();
		System.out.println("Response Body is =>  " + responseBody);
		System.out.println("Response StatusLine is =>  " + responseStatusLine);
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
