package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestsExamples {
	
	@Test
	public void test1() {
		
		Response response = 	RestAssured.get("https://reqres.in/api/users?page=2"); 
		
		System.out.println("********************");
		
		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Response Time: " + response.getTime());
		System.out.println("Response Body: " + response.getBody().asString());
		System.out.println("Response Status Line: " + response.getStatusLine());
		System.out.println("Content-Type: " + response.getHeader("Content-Type"));
		
		System.out.println("********************");
		
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 201);
		
		
		
		
		
		
	}

}
