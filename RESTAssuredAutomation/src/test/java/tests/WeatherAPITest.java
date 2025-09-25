package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class WeatherAPITest {
	//@Test
	public void test_1() {
		
		//Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		Response response=get("https://api.openweathermap.org/data/2.5/weather?lat=12.971599&lon=77.594566&appid=626358824e2dddc5bf5828341a6ba89a");
		System.out.println(response.getStatusCode()); 
		System.out.println(response.getTime());
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	@Test
	public void test_2() {
		baseURI= "https://api.openweathermap.org/data/2.5";
		given().get("/weather?lat=12.971599&lon=77.594566&appid=626358824e2dddc5bf5828341a6ba89a")
		.then().statusCode(200)
		.body("name",equalTo("Bengaluru"))//"id",equalTo(1277333))
		.log().all();

		
	}
	
}
