package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class TestExample1 {

	@Test
	public void test() {
		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println("********************");

		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Response Time: " + response.getTime());
		System.out.println("Response Body: " + response.getBody().asString());
		System.out.println("Response Status Line: " + response.getStatusLine());
		System.out.println("Content-Type: " + response.getHeader("Content-Type"));

		System.out.println("********************");

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);

	}

	@Test
	public void validate_statuscode() {
		
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200);
	}
	
	@Test
	public void validate_jsonbody() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
		body("data[1].id", equalTo(8)).log().all().
		body("data[1].email", equalTo("lindsay.ferguson@reqres.in")).
		body("data[5].avatar",equalTo("https://reqres.in/img/faces/12-image.jpg"));
	}
	
	
}
