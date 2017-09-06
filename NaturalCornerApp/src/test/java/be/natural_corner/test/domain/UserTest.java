package be.natural_corner.test.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.natural_corner.domain.User;

public class UserTest {

	private User user;
	@Before
	public void setUp() throws Exception {
		user = new User();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetId() {
		int expected = 100;
		user.setId(expected);
		int actual = user.getId();
	}

	@Test
	public void testSetId() {
		
	}

	@Test
	public void testGetFirstName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFirstName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLastName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLastName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNickName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNickName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testGeteMailAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeteMailAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPhone() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPhone() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInscriptionDateTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetInscriptionDateTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIpAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIpAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserIntStringStringStringStringAddressStringStringLocalDateTimeString() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
