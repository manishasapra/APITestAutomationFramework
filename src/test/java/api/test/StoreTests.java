package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;



public class StoreTests {
	Faker faker;
	Store storePayload;
	
	@BeforeClass
	public void setData() {
		
		faker = new Faker();
		storePayload = new Store();
		storePayload.setId(faker.idNumber().hashCode());
		storePayload.setQuantity(faker.idNumber().hashCode());
		storePayload.setShipDate(faker.date().toString());
		
		
	
		}
	@Test(priority=1)
	public void testGetOrder()
	{
		Response response = StoreEndPoints.getOrder(this.storePayload.getId());
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority=2)
	public void testUpdateOrder()
	{
		storePayload.setId(faker.idNumber().hashCode());
		storePayload.setQuantity(faker.idNumber().hashCode());
		storePayload.setShipDate(faker.date().toString());
		Response response = StoreEndPoints.postOrder(storePayload);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		//check data afer update
		Response responseAfterupdate = StoreEndPoints.getOrder(this.storePayload.getId());
		AssertJUnit.assertEquals(responseAfterupdate.getStatusCode(), 200);
		
		
	}
	@Test(priority=3)
	public void testGetInventory()
	{
		Response response = StoreEndPoints.getInventory();
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority=4)
	public void testDeleteByOrderId()
	{
		Response response = StoreEndPoints.deleteOrder(this.storePayload.getId());
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
	

}
