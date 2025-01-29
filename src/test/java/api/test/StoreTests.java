package api.test;

import org.testng.annotations.BeforeClass;
import com.github.javafaker.Faker;
import api.payload.Store;



public class StoreTests {
	Faker faker;
	Store storePayload;
	
	@BeforeClass
	public void setData() {
		
		faker = new Faker();
		storePayload = new Store();
		storePayload.setId(faker.idNumber().hashCode());
		
		
	
		}

}
