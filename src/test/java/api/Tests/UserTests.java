package api.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.*;
import com.github.javafaker.Faker;
import api.Payloads.User;
import api.endpoints.UserEndpoints;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setUp() {
		
		faker= new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setUsername(faker.name().username());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		
	}
	@Test(priority = 1)
	public void testCreateUser() {
		Response response= UserEndpoints.createUser(userPayload);
		response.then().log().all();
				
	}
	
	@Test(priority = 2)
	public void getUserbyuserName() 
	{
		Response response= UserEndpoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
	}
	
	@Test(priority = 3)
	public void updateUserByuserName() 
	{
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		Response response= UserEndpoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		
	}
	
	@Test(priority = 4)
	public void deleteUser() 
	{
		Response response= UserEndpoints.deleteUser(this.userPayload.getUsername());
		response.then().log();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
