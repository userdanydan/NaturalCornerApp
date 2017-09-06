package be.natural_corner.test.domain;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	public void testGetterAndSetterId() {
		long expected = 100;
		user.setId(expected);
		long actual = user.getId();
	}
	
	@Test
	public void testGetterAndSetterInscriptionDate() {
		LocalDateTime localDateTimeNow = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		String expected = localDateTimeNow.format(formatter);
		this.user.setInscriptionDateTime(localDateTimeNow);
		String actual = this.user.getInscriptionDateTime();
		assertEquals(expected, actual);
	}


}
