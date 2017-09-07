package be.natural_corner.rest.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
import be.natural_corner.domain.User;
import be.natural_corner.repositories.IUserRepository;
import be.natural_corner.rest.UserController;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	private Logger log = LoggerFactory.getLogger(UserControllerTest.class);

	private User userExpected;
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private IUserRepository repository;
	
	@Autowired
	private UserController userController;
	@Before
	public void setUp() {
		// Saving a user for the test and see if the REST methods return the same values.
		userExpected = repository.save(new User(0L, "firstName", "lastName", 
				"nickName", "password", 
				new Address("street", "number", "boxNumber", "postCode", "town", "country"), 
				"eMailAddress", "phone", LocalDateTime.of(2017, Month.DECEMBER, 31, 23, 59),
				"ipAddress"));		
	}
	@After
	public void tearDown() {
		userExpected=null;
	}
	@Test
	public void testGetUserById() {
		//Test for the user with the id equals to user test id.
		ResponseEntity<String> response = this.restTemplate.getForEntity("/users/{id}", String.class, String.valueOf(this.userExpected.getId()));
		
		
		// Let's see if the values are the same.
		ResponseEntity<User> userResponseEntity = new ResponseEntity<User>(this.userExpected, HttpStatus.OK);
		
		// Is the HTTP status OK at least?
		int expectedIntStatus = userResponseEntity.getStatusCodeValue();
		int actualIntStatus  = response.getStatusCodeValue();
		assertEquals(expectedIntStatus, actualIntStatus);
		
		
		//Having parsed response, verify the equality of the fields.
		testResponseUserActualWithUserExpected(userExpected, response);

	}
	
	
	@Test
	public void testGetAllUsers() {
		// Get the number of users in the database.
		long nbUsersInDB = repository.count();
		int nbOfUsersAdded = 5;
		long expected = nbUsersInDB + nbOfUsersAdded;
		// Add 5 new users in the database.
		for(int i=0; i<nbOfUsersAdded; i++) {
			int randomNumber = ThreadLocalRandom.current().nextInt();
			User user = repository.save(new User(0L, "firstName", "lastName", 
					"nickName", "password", 
					new Address("street", "number", "boxNumber", "postCode", "town", "country"), 
					"eMailAddress"+randomNumber+"@email.com", "phone", LocalDateTime.of(2017, Month.DECEMBER, 31, 23, 59),
					"ipAddress"));
		}
		// Retreive all the users in the DB by the rest service.
		ResponseEntity<String> response = this.restTemplate.getForEntity("/users", String.class);

		//HTTP status.
		int expectedIntStatus = 200;
		int actualIntStatus  = response.getStatusCodeValue();
		assertEquals(expectedIntStatus, actualIntStatus);
		//Just check if the response has the same number of users after the insertions with the GET response.
		try {
			JSONArray JSONArrayResponse = new JSONArray(response.getBody());
			long actual  = JSONArrayResponse.length();
			assertEquals(expected, actual);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testAddUser() {
		// Let's create a user with a peculiar email address which will allows us to compare after the PUT operation.
		String eMailExpected = "eMailAddress"+ThreadLocalRandom.current().nextInt()+"@testAddUser.com";
		User userExpected =new User("pwd", eMailExpected);
		
		//Using the addUser method from UserController class.
		ResponseEntity<User> userResponseEntityExpected = userController.addUser(userExpected);
		
		// Lets verify if the code status is OK.
		HttpStatus statusCodeExpected = HttpStatus.CREATED;
		
		HttpStatus statusCodeActual = HttpStatus.valueOf(userResponseEntityExpected.getStatusCodeValue());
		
		assertEquals(statusCodeExpected, statusCodeActual );
		
		
		//First we want to see if the ResponseEntity<User> is the same as the one we created earlier.
		User userActual = new ResponseEntity<User>(userExpected, HttpStatus.OK).getBody();

		
		assertEquals(userResponseEntityExpected.getBody(), userActual);
		
		//Having done that, we want to know if a user with the same email exists when we use the REST API.		
		ResponseEntity<String> response = this.restTemplate.getForEntity("/users/{id}", String.class, String.valueOf(userResponseEntityExpected.getBody().getId()));

		
		//Finally, lets verify if the user objects are the same.
		
		testResponseUserActualWithUserExpected(userExpected, response);
	}
	@Test
	public void testUpdateUser() {
		
		// We are going to compare the old nickname with the new one.
		
		String actual = this.userExpected.getNickName();
		
		//Just update the user test.
		
		this.userExpected.setNickName("testNickNameUpdate");
		
		//Retreive the user after he has been updated and sent with an HTTP PUT method.
		
		ResponseEntity<User> userActual = this.userController.updateUser(this.userExpected);
		
		
		// Lets verify if the code status is OK.
		HttpStatus statusCodeExpected = HttpStatus.CREATED;
		
		HttpStatus statusCodeActual = HttpStatus.valueOf(userActual.getStatusCodeValue());
		
		assertEquals(statusCodeExpected, statusCodeActual);
		
		
		//Having done that, we want to know if a user with the same email exists when we use the REST API.		
		ResponseEntity<String> response = this.restTemplate.getForEntity("/users/{id}", String.class, String.valueOf(userActual.getBody().getId()));

		
		//Finally, lets verify if the user objects are the same.
		
		testResponseUserActualWithUserExpected(userExpected, response);		
		
	}
	private void testResponseUserActualWithUserExpected(User userExpected, ResponseEntity<String> response) {
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
				userExpected.getFirstName(), userExpected.getLastName(), userExpected.getNickName(),
				userExpected.getAddress().getStreet(), userExpected.getAddress().getNumber(),
				userExpected.getAddress().getBoxNumber(), userExpected.getAddress().getPostCode(),
				userExpected.getAddress().getTown(), userExpected.getAddress().getCountry(),
				userExpected.geteMailAddress(), userExpected.getPhone(), userExpected.getInscriptionDateTime(),
				userExpected.getIpAddress(), String.valueOf(userExpected.getId())
		};
		log.error(Arrays.toString(actuals));
		assertArrayEquals(expecteds, actuals);
	}
	

}
