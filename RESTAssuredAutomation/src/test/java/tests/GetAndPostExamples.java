package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

import org.testng.annotations.Test;
public class GetAndPostExamples {

	@Test
	public void testGet() {
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200)
		.body("data[4].first_name",equalTo("George")).
		body("data.first_name",hasItems("George","Byron","Rachelu"));
		
		
		
	}
	
}
