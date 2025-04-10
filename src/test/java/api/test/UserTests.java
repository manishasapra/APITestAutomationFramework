package api.test;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;


import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setData() {
		
		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	
		}
	
	@Test(priority=1)
	public void testPostUser()
	{
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		Response response = UserEndPoints.getUser(this.userPayload.getUsername());
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		//check data afer update
		Response responseAfterupdate = UserEndPoints.getUser(this.userPayload.getUsername());
		AssertJUnit.assertEquals(responseAfterupdate.getStatusCode(), 200);
		
		
	}
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
	
	

}
