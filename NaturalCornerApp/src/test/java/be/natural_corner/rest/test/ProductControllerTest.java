package be.natural_corner.rest.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import be.natural_corner.domain.Address;
import be.natural_corner.domain.Product;
import be.natural_corner.domain.Product;
import be.natural_corner.repositories.IProductRepository;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

	private Logger log = LoggerFactory.getLogger(ProductControllerTest.class);

	private Product productTest;
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private IProductRepository repository;
	@Before
	public void setUp() {
		// Saving a product for the test and see if the REST methods return the same values.
		this.productTest=repository.save(new Product(0L, "Orange", new BigDecimal(1), "fruits", true, false));	
		log.debug(this.productTest.toString());
	}
	@After
	public void tearDown() {
		productTest=null;
	}
	@Test
	public void testGetProductById() {
		//Test for the product with the id equals to product test id.
		ResponseEntity<String> response = this.restTemplate.getForEntity("/products/{id}", String.class, String.valueOf(this.productTest.getProductId()));
		
		
		// Let's see if the values are the same.
		ResponseEntity<Product> productResponseEntity = new ResponseEntity<Product>(this.productTest, HttpStatus.OK);
		
		// Is the HTTP status OK at least?
		int expectedIntStatus = productResponseEntity.getStatusCodeValue();
		int actualIntStatus  = response.getStatusCodeValue();
		assertEquals(expectedIntStatus, actualIntStatus);
		
		
		//Having parsed response, verify the equality of the fields.

		String[] expecteds = null;
		try {
			JSONObject JSONResponse = new JSONObject(response.getBody());
			expecteds = new String[] {
					String.valueOf(JSONResponse.getInt("productId")), 
					JSONResponse.getString("productName"), 
					String.valueOf(JSONResponse.getDouble("unitPrice")),
					JSONResponse.getString("comment"), 
					"null",
					String.valueOf(JSONResponse.getBoolean("available")), 
					String.valueOf(JSONResponse.getBoolean("discount"))
			};
			if(expecteds==null) {
				log.error(JSONResponse.toString());
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] actuals = new String[] {
				String.valueOf(productTest.getProductId()), productTest.getProductName(),
				String.valueOf(productTest.getUnitPrice().doubleValue()), productTest.getComment(),
				"null", String.valueOf(productTest.isAvailable()), String.valueOf(productTest.isDiscount())
		}; 
		
		log.debug(Arrays.toString(actuals));
		assertArrayEquals(expecteds, actuals);
	}
	
	
	@Test
	public void testGetAllProducts() {
		// Get the number of products in the database.
		long nbProductsInDB = repository.count();
		int nbOfProductsAdded = 5;
		long expected = nbProductsInDB + nbOfProductsAdded;
		// Add 5 new products in the database.
		for(int i=0; i<nbOfProductsAdded; i++) {
			int randomNumber = ThreadLocalRandom.current().nextInt();
			Product product = repository.save(new Product(0L, "Orange", new BigDecimal(randomNumber), "orange d'Espagne", true, false));
		}
		// Retreive all the products in the DB by the rest service.
		ResponseEntity<String> response = this.restTemplate.getForEntity("/products", String.class);

		//HTTP status.
		int expectedIntStatus = 200;
		int actualIntStatus  = response.getStatusCodeValue();
		assertEquals(expectedIntStatus, actualIntStatus);
		//Just check if the response has the same number of products after the insertions with the GET response.
		try {
			JSONArray JSONArrayResponse = new JSONArray(response.getBody());
			long actual  = JSONArrayResponse.length();
			assertEquals(expected, actual);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
