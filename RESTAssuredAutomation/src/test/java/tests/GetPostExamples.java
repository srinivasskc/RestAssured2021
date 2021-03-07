package tests;

import org.json.simple.JSONObject;
//This is for @Test
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

//RestAssured Given, BaseURI etc
import static io.restassured.RestAssured.*;

//import static io.restassured.matcher.RestAssuredMatchers.*;

//This is for EqualsTo() Assert
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GetPostExamples {

	/*@Test
	public void getTest() {
	
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[3].first_name", equalTo("Byron")).
			body("data.first_name",hasItems("Michael","Rachel"));
	}*/
	
	
	/*@Test
	public void postTest() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "srinivas");
		map.put("job", "tester");
		System.out.println(map);
		
		JSONObject request = new JSONObject(map);

		System.out.println(request);
		
		System.out.println(request.toJSONString());
		
	}*/
	
	@Test
	public void postJsonTest() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject request = new JSONObject();
		
		
		
		request.put("name", "srinivas");
		request.put("job", "tester");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
		
		
	}
	
	

}
