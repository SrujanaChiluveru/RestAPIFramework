package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.Payloads.User;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;



public class UserEndpoints2 {
	
	//Method to read properties  file
	public static ResourceBundle getURL() {
		
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		
		return routes;
		
	}

	public static Response createUser(User payload) {
		//getting string from properties 
		String post_url= getURL().getString("post_url");
		
		Response response = given()
				.header("api_key", "special-key")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(post_url);
		return response;
	}

	public static Response readUser(String userName) {

		Response response = given().header("api_key", "special-key").pathParam("username", userName).when().get(getURL().getString("get_url"));
		return response;

	}

	public static Response updateUser(String userName, User payload) {

		Response response = given().header("api_key", "special-key").pathParam("username", userName).contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(payload)
				.when().get(getURL().getString("put_url"));
		return response;

	}

	public static Response deleteUser(String userName) {

		Response response = given().header("api_key", "special-key").pathParam("username", userName).accept(ContentType.JSON).when()
				.get(getURL().getString("delete_url"));
		return response;

	}
}
