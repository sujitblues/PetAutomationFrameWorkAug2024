package api.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Payload.Category;
import api.Payload.Tags;
import api.Payload.petPayload;
import api.Payload.userPayload;
import api.endPoints.UserCrudOperation;
import api.endPoints.petCrudOperation;
import io.restassured.response.Response;

public class petTest {

	Faker faker;
	petPayload payload;
	@BeforeTest
	public void createPetData()
	{
		faker=new Faker();
		payload.setId(faker.hashCode());
		Category cat=new Category();
		cat.setId(faker.hashCode());
		cat.setName(faker.animal().name());
		payload.setName(faker.animal().name());
		String[] photoUrls= {"http://photourl"};
		payload.setPhotoUrls(photoUrls);
		Tags tag=new Tags();
		tag.setId(faker.hashCode());
		tag.setName(faker.animal().name());
		List<Tags> tags=new ArrayList<Tags>();
		tags.add(tag);
		payload.setTags(tags);
		payload.setStatus("available");
		
		
		
	}
	
	
	@Test(priority=1)
	public void createPetTest()
	{
		Response response=petCrudOperation.createPet(payload);
		int statuscode=response.statusCode();
		Assert.assertEquals(statuscode, 200);
	}
	@Test(priority=2)
	public void updatePetTest()
	{
		Response response=petCrudOperation.updatePet(payload,this.payload.getId());
		int statuscode=response.statusCode();
		Assert.assertEquals(statuscode, 200);
	}
	@Test(priority=3)
	public void getPetTest()
	{
		Response response=petCrudOperation.getPet(this.payload.getId());
		int statuscode=response.statusCode();
		Assert.assertEquals(statuscode, 200);
		
	}
	@Test(priority=4)
	public void deletePetTest()
	{
		Response response=petCrudOperation.deletePet(this.payload.getId());
		int statuscode=response.statusCode();
		Assert.assertEquals(statuscode, 204);
	}
}
