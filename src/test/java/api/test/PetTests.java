package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.PetEndPoints;
import api.payload.Pet;
import io.restassured.response.Response;

public class PetTests {
	Faker faker;
	Pet petPayload;
	
	@BeforeClass
	public void setData() {
		
		faker = new Faker();
		petPayload = new Pet();
		petPayload.setId(faker.idNumber().hashCode());
		petPayload.setPetname(faker.name().name());
		
	
		}
	@Test(priority=1)
	public void testAddPet()
	{
		Response response = PetEndPoints.addPet(petPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	

}