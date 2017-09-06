package be.natural_corner.test.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.natural_corner.domain.Address;

public class AddressTest {
	private Address address;
	@Before
	public void setUp() throws Exception {
		address=new Address();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructorWithoutParameters() {
		//Arrange
		Address address = null; 
		//Act
		address = new Address();
		//Assert
		assertNotNull("Object address should have been instantiated", address);
	}
	


	@Test
	public void testStreetGetterAndSetter() {
		String expected = "street test";
		address.setStreet(expected);
		String actual = address.getStreet();
		assertEquals(expected, actual);
	}

	@Test
	public void testNumberGetterAndSetter() {
		String expected = "100";
		address.setNumber(expected);
		String actual = address.getNumber();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBoxNumberGetterAndSetter() {
		String expected = "box number test";
		address.setBoxNumber(expected);
		String actual = address.getBoxNumber();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPostCodeGetterAndSetter() {
		String expected = "post code test";
		address.setPostCode(expected);
		String actual = address.getPostCode();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testTownGetterAndSetter() {
		String expected = "town test";
		address.setTown(expected);
		String actual = address.getTown();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCountryGetterAndSetter() {
		String expected = "country test";
		address.setCountry(expected);
		String actual = address.getCountry();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEquals() {
		boolean expected = true;
		Address address1 = new Address();
		Address address2 = new Address();
		assertNotNull(address1);
		assertNotNull(address2);
		String sameCountry="test country";
		address1.setCountry(sameCountry);
		address2.setCountry(sameCountry);
		assertEquals(address1, address2);
	}
}


