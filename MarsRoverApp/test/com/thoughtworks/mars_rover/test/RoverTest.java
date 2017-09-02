package com.thoughtworks.mars_rover.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.mars_rover.Position;
import com.thoughtworks.mars_rover.Rover;

public class RoverTest {
	private Rover rover;
	@Before
	public void setUp() throws Exception {
		 rover =  new Rover(new Position(3, 1), Rover.NORTH, "");
	}

	@After
	public void tearDown() throws Exception {
		rover=null;
	}
	@Test
	public void testGetterAndSetterRoverPosition() {
		Position expected = new Position(4, 5);
		rover.setPosition(expected);
		Position actual = rover.getPosition();
		assertEquals(expected, actual);

		
	}
	@Test
	public void testGetterAndSetterRoverDirection() {
		char expected = Rover.EAST;
		rover.setDirection(expected);
		char actual = rover.getDirection();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetterAndSetterRoverInstructions() {
		String expected  = "LMLMLMLMM";
		rover.setInstructions(expected);
		String actual = rover.getInstructions();
		assertEquals(expected, actual);

	}
	
	@Test
	public void testRotate() {
		char expected = Rover.EAST;
		rover.setDirection(Rover.NORTH);
		rover.rotate('L');
		char actual = rover.getDirection();
		assertEquals(expected, actual);
		
		expected = Rover.SOUTH;
		rover.setDirection(Rover.WEST);
		rover.rotate('R');
		actual = rover.getDirection();
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testMove() {
		Position expected = new Position(3, 2);
		rover.setDirection(Rover.NORTH);
		rover.move();
		Position actual= rover.getPosition();
		assertEquals(expected, actual);
		
		expected = new Position(2, 2);
		rover.setDirection(Rover.EAST);
		rover.move();
		actual= rover.getPosition();
		assertEquals(expected, actual);
		
		expected = new Position(3, 2);
		rover.setDirection(Rover.WEST);
		rover.move();
		actual= rover.getPosition();
		assertEquals(expected, actual);
		
		expected = new Position(3, 1);
		rover.setDirection(Rover.SOUTH);
		rover.move();
		actual= rover.getPosition();
		assertEquals(expected, actual);
	}

}
