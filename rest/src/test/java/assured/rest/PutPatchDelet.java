package assured.rest;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PutPatchDelet {
	@Test
public void putTest() {
	
	

	
	JSONObject req =new JSONObject();
	req.put("name", "Arsh");
	req.put("job", "Engineer");
	System.out.println(req);
	RestAssured.baseURI="https://reqres.in/api";
	given()
	.header("content-type","application/json").body(req.toJSONString()).when().put("/users/2")
	.then().statusCode(200).log().all();
	
	
}
	@Test
	public void patchTest() {
		
			JSONObject req =new JSONObject();
			req.put("name", "Arsh");
			req.put("job", "Engineer");
			System.out.println(req);
			RestAssured.baseURI="https://reqres.in/";
			given()
			.header("content-type","application/json").body(req.toJSONString()).when().patch("api/users/2")
			.then().statusCode(200).log().all();
			
			
		
	}
	@Test
	public void deletTest() {
		
		
		RestAssured.baseURI="https://reqres.in/";
		
		given().when().delete("api/users/2")
		.then().statusCode(204).log().all();
		
		
	
}
	
	
}
