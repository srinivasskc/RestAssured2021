package tests;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

public class PutPatchDeleteExamples {

	@Test
	public void putTest() {

		// Storing Data in JSON
		JSONObject request = new JSONObject();
		request.put("name", "srinivas Kadiyala");
		request.put("job", "software tester");

		System.out.println(request.toJSONString());

		// put request:
		baseURI = "https://reqres.in/api";

		// Given the body with JSON String, Putting the data, Status Code of Response is
		// 200
		given().body(request.toJSONString()).when().put("/users/752").then().statusCode(200).log().all();
	}

	/*@Test
	public void getTest() {
	
		baseURI = "https://reqres.in/api";
		given().
			get("/users/427").
		then().
			statusCode(200);	
	}*/

	
	@Test
	public void patchTest() {
		// Storing Data in JSON
				JSONObject request = new JSONObject();
				request.put("name", "srinivas K");
				request.put("job", "software tester");

				System.out.println(request.toJSONString());

				// Patch request:
				baseURI = "https://reqres.in/api";

				// Given the body with JSON String, Patch the data, Status Code of Response is
				// 200
				given().
					body(request.toJSONString()).
				when().
					patch("/users/752").
				then().
					statusCode(200).log().all();
	}
	
	@Test
	public void deleteTest() {
		
		// Delete request:
		baseURI = "https://reqres.in/api";
		when().
			patch("/users/752").
		then().
			statusCode(200).log().all();
	}
	
	
	
	
	
	
}
