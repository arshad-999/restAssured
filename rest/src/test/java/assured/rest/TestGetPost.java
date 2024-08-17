package assured.rest;
import org.json.simple.JSONObject;
import org.testng.annotations.*;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import org.testng.asserts.*;
import io.restassured.response.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class TestGetPost {
	//@Test
public void gettset() {
	RestAssured.baseURI="https://reqres.in/api";
	given().get("/users?page=2").then().statusCode(200)
	.body("data[4].first_name", equalTo("George"))
	.body("data.first_name", hasItems("George","Rachel"));
	
}
	@Test
	public void testPost() {
		Map<String, Object>map=new HashMap<>();
		
		map.put("name","Raghav");
		map.put("job","Teacher");
		
		System.out.println(map);
		
		JSONObject req =new JSONObject(map);
		
		System.out.println(req);
		RestAssured.baseURI="https://reqres.in/api";
		given()
		.header("content-type","application/json").body(req.toJSONString()).when().post("/user")
		.then().statusCode(201).log().all();
		
		
	}
}
