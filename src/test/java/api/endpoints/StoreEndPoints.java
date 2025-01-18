package api.endpoints;

import static io.restassured.RestAssured.given;


import io.restassured.response.Response;

public class StoreEndPoints {
	
	public static Response getOrder(Integer id) {
		Response response = given()
				.pathParam("orderid", id)
		.when()
		.get(Routes.getorder_url);
		
		
		return response;
	}
	public static Response deleteOrder(Integer id) {
		Response response = given()
				.pathParam("orderid", id)
		.when()
		.get(Routes.deletestore_url);
		
		
		return response;
	}

}
