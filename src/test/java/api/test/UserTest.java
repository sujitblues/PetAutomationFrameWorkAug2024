package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Payload.userPayload;
import api.endPoints.UserCrudOperation;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserTest {
	Faker faker;
	userPayload payload;
	@BeforeTest
	public void createData()
	{
		faker=new Faker();
		payload.setId(faker.hashCode());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().emailAddress());
		payload.setPassword(faker.internet().password());
		payload.setPhone(faker.phoneNumber().cellPhone());
		payload.setUsername(faker.name().username());
		payload.setUserStatus("avaliable");
		
	}
	
	
	@Test(priority=1)
	public void createUserTest()
	{
		Response response=UserCrudOperation.createUser(payload);
		int statuscode=response.statusCode();
		Assert.assertEquals(statuscode, 200);
	}
	@Test(priority=2)
	public void updateUserTest()
	{
		Response response=UserCrudOperation.updateUser(payload,this.payload.getUsername());
		int statuscode=response.statusCode();
		Assert.assertEquals(statuscode, 200);
	}
	@Test(priority=3)
	public void getUserTest()
	{
		Response response=UserCrudOperation.getUser(this.payload.getUsername());
		int statuscode=response.statusCode();
		Assert.assertEquals(statuscode, 200);
		
	}
	@Test(priority=4)
	public void deleteUserTest()
	{
		Response response=UserCrudOperation.deleteUser(this.payload.getUsername());
		int statuscode=response.statusCode();
		Assert.assertEquals(statuscode, 204);
	}
}
