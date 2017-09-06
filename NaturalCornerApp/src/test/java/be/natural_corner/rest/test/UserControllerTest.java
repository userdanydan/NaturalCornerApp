package be.natural_corner.rest.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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

import be.natural_corner.NaturalCornerAppApplication;
import be.natural_corner.domain.Address;
import be.natural_corner.domain.User;
import be.natural_corner.repositories.UserRepository;
import junit.framework.Assert;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	private Logger log = LoggerFactory.getLogger(UserControllerTest.class);

	private User userTest;
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private UserRepository repository;
	@Before
	public void setUp() {
		// Saving a user for the test and see if the REST methods return the same values.
		userTest = repository.save(new User(0L, "firstName", "lastName", 
				"nickName", "password", 
				new Address("street", "number", "boxNumber", "postCode", "town", "country"), 
				"eMailAddress", "phone", LocalDateTime.of(2017, Month.DECEMBER, 31, 23, 59),
				"ipAddress"));		
	}
	@Test
	public void testGetUserById() {
		//Test for the user with the id equals to user test id.
		ResponseEntity<String> response = this.restTemplate.getForEntity("/users/{id}", String.class, String.valueOf(this.userTest.getId()));
		
		
		// Let's see if the values are the same.
		ResponseEntity<User> userResponseEntity = new ResponseEntity<User>(this.userTest, HttpStatus.OK);
		
		// Is the HTTP status OK at least?
		int expectedIntStatus = 200;
		int actualIntStatus  = response.getStatusCodeValue();
		assertEquals(expectedIntStatus, actualIntStatus);
		
		
		//Having parsed response, verify the equality of the fields.
		
		String[] expecteds = null;
		try {
			JSONObject JSONResponse = new JSONObject(response.getBody());
			expecteds = new String[] {
					JSONResponse.getString("firstName"), 
					JSONResponse.getString("lastName"), 
					JSONResponse.getString("nickName"), 
					JSONResponse.getJSONObject("address").getString("street"),
					JSONResponse.getJSONObject("address").getString("number"),
					JSONResponse.getJSONObject("address").getString("boxNumber"),
					JSONResponse.getJSONObject("address").getString("postCode"),
					JSONResponse.getJSONObject("address").getString("town"),
					JSONResponse.getJSONObject("address").getString("country"),
					JSONResponse.getString("eMailAddress"), 
					JSONResponse.getString("phone"), 
					JSONResponse.getString("inscriptionDateTime"), 
					JSONResponse.getString("ipAddress"), 
					String.valueOf(JSONResponse.getInt("id"))		
			};
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] actuals = new String[] {
				userTest.getFirstName(), userTest.getLastName(), userTest.getNickName(),
				userTest.getAddress().getStreet(), userTest.getAddress().getNumber(),
				userTest.getAddress().getBoxNumber(), userTest.getAddress().getPostCode(),
				userTest.getAddress().getTown(), userTest.getAddress().getCountry(),
				userTest.geteMailAddress(), userTest.getPhone(), userTest.getInscriptionDateTime(),
				userTest.getIpAddress(), String.valueOf(userTest.getId())
		};
		log.error(Arrays.toString(actuals));
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testGetAllUsers() {
		// Retreive all the users in the DB.
		ResponseEntity<String> response = this.restTemplate.getForEntity("/users", String.class);

		//HTTP status.
	}

}
