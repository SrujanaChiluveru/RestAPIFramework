package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.Payloads.User;
import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;



public class UserEndpoints {

	public static Response createUser(User payload) {
		Response response = given()
				.header("api_key", "special-key")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_url);
		return response;
	}

	public static Response readUser(String userName) {

		Response response = given().header("api_key", "special-key").pathParam("username", userName).when().get(Routes.get_url);
		return response;

	}

	public static Response updateUser(String userName, User payload) {

		Response response = given().header("api_key", "special-key").pathParam("username", userName).contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(payload)
				.when().get(Routes.put_url);
		return response;

	}

	public static Response deleteUser(String userName) {

		Response response = given().header("api_key", "special-key").pathParam("username", userName).accept(ContentType.JSON).when()
				.get(Routes.delete_url);
		return response;

	}
}
