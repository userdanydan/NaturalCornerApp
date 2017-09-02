package com.daniel.mars_rover.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.daniel.mars_rover.Plateau;
import com.daniel.mars_rover.Position;
import com.daniel.mars_rover.Rover;
import com.daniel.mars_rover.exception.OutOfTheGridException;

public class PlateauTest {
	
	private Plateau plateau;
	@Before
	public void setUp() throws Exception {
		 plateau = new Plateau(5, 4);
	}

	@After
	public void tearDown() throws Exception {
		plateau=null;
	}

	@Test
	public void testGetters() {
		//X coordinate
		// length + 1
		int expected = 6;
		int actual = plateau.getWidth();
		assertEquals(expected, actual);	 
		
		//Y coordinate
		expected = 5;
		actual = plateau.getHeight();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMoveRover() {
		
		Position expected = new Position(2, 2);
		Rover rover = new Rover(new Position(3, 2), Rover.EAST, "");
		plateau.moveRover(rover, 'M');
		Position actual =  rover.getPosition();
		assertEquals(expected,actual);
		
		expected = new Position(4, 2);
		rover = new Rover(new Position(3, 2), Rover.WEST, "");
		plateau.moveRover(rover, 'M');
		actual =  rover.getPosition();
		assertEquals(expected,actual);
		
		expected = new Position(3, 3);
		rover = new Rover(new Position(3, 2), Rover.NORTH, "");
		plateau.moveRover(rover, 'M');
		actual =  rover.getPosition();
		assertEquals(expected,actual);
		
		
		expected = new Position(3, 1);
		rover = new Rover(new Position(3, 2), Rover.SOUTH, "");
		plateau.moveRover(rover, 'M');
		actual =  rover.getPosition();
		assertEquals(expected,actual);
		
		expected = new Position(3, 5);
		rover = new Rover(new Position(3, 3), Rover.NORTH, "");
		plateau.moveRover(rover, 'M');
		plateau.moveRover(rover, 'M');
		actual =  rover.getPosition();
		assertEquals(expected,actual);
	

	}
}
