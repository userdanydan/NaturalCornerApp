package com.daniel.mars_rover.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.daniel.mars_rover.Plateau;
import com.daniel.mars_rover.Position;
import com.daniel.mars_rover.Rover;
import com.daniel.mars_rover.exception.OutOfTheGridException;
import com.daniel.mars_rover.exception.PositionAlreadyOccupiedException;

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
		//Plateau class knows about positions' availability and size of the grid (Expert GRASP pattern), 
		//so we are able to give it responsability to move the rover in order to avoid occupied places or out of the grid positions.
//		boolean expected = true;
//		Rover rover = new Rover(new Position(1, 1, true), Rover.NORTH, "");
//		plateau.moveRover(rover, 'M');
//		boolean actual = plateau.getPosition(rover.getPosition().getX(), rover.getPosition().getY()).isOccupied();
//		assertEquals(expected, actual);
//		
//		expected = false;
//		actual = plateau.getPosition(1, 1).isOccupied();
//		assertEquals(expected, actual);
//
//		expected = true;
//		rover = new Rover(new Position(0, 1, true), Rover.EAST, "");
//		try {
//			plateau.moveRover(rover, 'M');
//			fail("Should have thrown an OutOfTheGridException");
//		}catch(OutOfTheGridException e) {
//			assertTrue(expected);			
//		}
//		
		
//		plateau.getPosition(2, 2).setOccupied(true);
		Position expected = new Position(2, 2, true);
		Rover rover = new Rover(new Position(3, 2, true), Rover.EAST, "");
		plateau.moveRover(rover, 'M');
		Position actual =  rover.getPosition();
		assertEquals(expected,actual);
		
		expected = new Position(4, 2, true);
		rover = new Rover(new Position(3, 2, true), Rover.WEST, "");
		plateau.moveRover(rover, 'M');
		actual =  rover.getPosition();
		assertEquals(expected,actual);
		
		expected = new Position(3, 3, true);
		rover = new Rover(new Position(3, 2 , true), Rover.NORTH, "");
		plateau.moveRover(rover, 'M');
		actual =  rover.getPosition();
		assertEquals(expected,actual);
		
		
		expected = new Position(3, 1, true);
		rover = new Rover(new Position(3, 2 , true), Rover.SOUTH, "");
		plateau.moveRover(rover, 'M');
		actual =  rover.getPosition();
		assertEquals(expected,actual);
		
		expected = new Position(3, 5, true);
		rover = new Rover(new Position(3, 3 , true), Rover.NORTH, "");
		plateau.moveRover(rover, 'M');
		plateau.moveRover(rover, 'M');
		actual =  rover.getPosition();
		assertEquals(expected,actual);
		
		
		
//		try {
//			plateau.moveRover(rover, 'M');
//			fail("Should have thrown an PositionAlreadyOccupiedException");
//		}catch(PositionAlreadyOccupiedException e) {
//			assertTrue(expected);
//		}

	}
}
