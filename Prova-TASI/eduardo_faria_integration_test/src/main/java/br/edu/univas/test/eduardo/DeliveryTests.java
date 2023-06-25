package br.edu.univas.test.eduardo;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpStatus;
import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.edu.univas.test.eduardo.dto.DeliveryDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeliveryTests {

	private ObjectMapper mapper = new ObjectMapper();
	private final String deliveryURL = "http://localhost:8080/delivery/";

	// ================================POST=====================================

	// #1 - Post com sucesso
	@Test
	public void testCreateDelivery_withSuccess() {
		Long orderCode = 1001L;
		Response resp = createDeliveryWithId(orderCode);
		resp.then().assertThat().statusCode(HttpStatus.SC_CREATED);
	}

	// #2 - Post com falha por código existente
	@Test
	public void testCreateDelivery_withExistCode() {
		Long code = 1L;
		Response resp = RestAssured.get(deliveryURL + code);

		if (resp.getStatusCode() == HttpStatus.SC_OK) {
			RestAssured.given().contentType(ContentType.JSON).post(deliveryURL).then().assertThat()
					.statusCode(HttpStatus.SC_BAD_REQUEST);
		} else {
			Response write = createDeliveryWithId(code);
			write.then().assertThat().statusCode(HttpStatus.SC_CREATED);
		}
	}

	// #3 - Post com falha por JSON incorreto
	@Test
	public void testCreateDelivery_withWrongJson() {
		RestAssured.given().contentType(ContentType.JSON).post(deliveryURL).then().assertThat()
				.statusCode(HttpStatus.SC_BAD_REQUEST);
	}

	// ===================================GET====================================

	// #4 - Get com sucesso
	@Test
	public void testGetDeliveryById_withSuccessfull() {
		Long code = 15L;
		createDeliveryWithId(code);
		Response resp = RestAssured.get(deliveryURL + code);
		resp.then().assertThat().statusCode(HttpStatus.SC_OK);
	}

	// #5 - Get com falha quando objeto não existe
	@Test
	public void testGetDeliveryByd_withFail() {
		Long nonExistingDeliveryNumber = 600L;
		Response resp = RestAssured.get(deliveryURL + nonExistingDeliveryNumber);
		resp.then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
	}

	// =======================================PUT=============================

	// #6 - Put com sucesso
	@Test
	public void testPutDeliveryById_withSuccess() {
		Long code = 1L;

		Response action = RestAssured.put(deliveryURL + "active/" + code);
		action.then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
		assertEquals(HttpStatus.SC_NO_CONTENT, action.getStatusCode());

		Response resp = RestAssured.get(deliveryURL + code);
		resp.then().assertThat().statusCode(HttpStatus.SC_OK);
	}

	// #7 - Put com falha quando não existe code
	@Test
	public void testPutDelivery_withExistCode() {
		Long code = 700L;

		Response resp = RestAssured.get(deliveryURL + code);
		if (resp.getStatusCode() == HttpStatus.SC_OK) {
			Response action = RestAssured.put(deliveryURL + "active/" + code);
			action.then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
			assertEquals(HttpStatus.SC_NO_CONTENT, action.getStatusCode());
		} else {
			resp.then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
		}
	}

	private Response createDeliveryWithId(Long orderCode) {
		DeliveryDTO delivery = new DeliveryDTO(orderCode, "1123453344", "14/04/2023", 3756420, "Em entrega", true);

		Response resp = RestAssured.given().body(delivery).contentType(ContentType.JSON).post(deliveryURL);
		return resp;
	}

}
