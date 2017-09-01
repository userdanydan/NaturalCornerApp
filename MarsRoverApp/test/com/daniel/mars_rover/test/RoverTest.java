package com.daniel.mars_rover.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.daniel.mars_rover.Position;
import com.daniel.mars_rover.Rover;

public class RoverTest {
	private Rover rover;
	@Before
	public void setUp() throws Exception {
		 rover =  new Rover(new Position(3, 1, true), Rover.NORTH);
	}

	@After
	public void tearDown() throws Exception {
		rover=null;
	}
	@Test
	public void testGetterAndSetterRoverPosition() {
		Position expected = new Position(4, 5, false);
		rover.setPosition(expected);
		Position actual = rover.getPosition();
		assertEquals(expected, actual);

		
	}
	@Test
	public void testGetterAndSetterRoverDirection() {
		String expected = Rover.EAST;
		rover.setDirection(expected);
		String actual = rover.getDirection();
		assertEquals(expected, actual);
	}

}
