import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class GetRequest {
	
	String url = "http://dummy.restapiexample.com/api/v1/";
	
	
	@Test
	public void getRequestApi() {
   
   given()
    .when()
	 .get("https://reqres.in/api/users?page=2")
	.then()
	 .statusCode(200)
	 .body("data.id", hasItems(7))
	 .log().all();
	}

	@Test
	public void postRequestApi() {
	
   
   given()
      .contentType("application/json")
     .body("{\r\n" + 
     		"    \"name\": \"morpheus\",\r\n" + 
     		"    \"job\": \"leader\"\r\n" + 
     		"}")
    .when()
	 .post("https://reqres.in/api/users")
	.then()
	 .statusCode(201)
	 .log().all();
	}
	
	
	@Test
	public void putRequestApi() {
	
   
   given()
      .contentType("application/json")
     .body("{\r\n" + 
     		"    \"name\": \"morpheus\",\r\n" + 
     		"    \"job\": \"zion resident\"\r\n" + 
     		"}")
    .when()
	 .put("https://reqres.in/api/users/2")
	.then()
	 .statusCode(200)
	 .body("data.job", hasItems("zion resident"))
	 .log().all();
	}
	
	
	@Test
	public void deleteRequestApi() {
	
   
   given()
    .when()
	 .delete("https://reqres.in/api/users/2")
	.then()
	 .statusCode(204)
	 .log().all();
	}
	
}
