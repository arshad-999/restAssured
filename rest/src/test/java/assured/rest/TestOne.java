package assured.rest;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;
import static io.restassured.RestAssured.*;

public class TestOne {

	@Test
	public void test1() {
		Response resp=RestAssured.get("https://reqres.in/api/users?page=2");
		int re=resp.getStatusCode();
		resp.getTime();
		System.out.println(resp.getStatusLine());
		System.out.println(resp.getTime());
		System.out.println(resp.getBody());
		System.out.println(resp.getHeader("content-type"));
		Assert.assertEquals(re, 201);
		
	}
	@Test
	public void test2() {
		RestAssured.baseURI	="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200);
	
	}
	
}
