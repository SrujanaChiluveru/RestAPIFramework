package api.Tests;

import org.testng.annotations.Test;

import api.Payloads.User;
import api.Utilities.DataProviders;
import api.endpoints.UserEndpoints;
import io.restassured.response.Response;

public class UserDataDrivenTests {

	@Test(priority = 1,dataProvider = "UserAlldata", dataProviderClass = DataProviders.class)
	public void CreateUser(String userId,String userName,String firstName, String lastName, String email,String phoneNo, String password) 
	{
		
		User userPayload= new User();
		userPayload.setId((int)Double.parseDouble(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(email);
		userPayload.setPhone(phoneNo);
		userPayload.setPassword(password);
		
		Response response= UserEndpoints.createUser(userPayload);
		response.then().log().all();
		
	}
	
	@Test(priority = 2,dataProvider = "UserName",dataProviderClass = DataProviders.class)
	public void DeleteUser(String userName)
	{
		Response response= UserEndpoints.deleteUser(userName);
		response.then().log().all();
		
	}
}
