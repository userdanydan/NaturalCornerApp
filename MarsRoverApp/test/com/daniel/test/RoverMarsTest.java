package com.daniel.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RoverMarsTest {
	private RoverMars roverMars;
	@Before
	public void setUp() throws Exception {
		 roverMars = new RoverMars();
	}

	@After
	public void tearDown() throws Exception {
		roverMars=null;
	}
	
	
	@Test
	public void testGetAndSetPlateau(){
		Plateau expected = new Plateau(5, 5);
		roverMars.setPlateau(expected);
		Plateau actual = roverMars.getPlateau();
		assertEquals(expected, actual);
		
	}
	@Test
	public void testGetAndSetRover(){
		//First rover
		Rover expected = new Rover(1, 2, Rover.NORTH);
		roverMars.addRover(expected);
		Rover actual = roverMars.getRover(0);
		assertEquals(expected, actual);	
		//Second rover
		expected = new Rover(3, 3, Rover.EAST);
		roverMars.addRover(expected);
		actual = roverMars.getRover(1);
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testMoveRovers(){
		//First rover
		Rover expected = new Rover(1, 3, Rover.NORTH);
		roverMars.addRover(new Rover(1, 2, Rover.NORTH));
		roverMars.moveRovers();
		Rover actual = roverMars.getRover(0);
		assertEquals(expected, actual);	
		
		//Second rover
		expected = new Rover(5, 1, Rover.EAST);
		roverMars.addRover(new Rover(3, 3, Rover.EAST));
		roverMars.moveRovers();
		actual = roverMars.getRover(1);
		assertEquals(expected, actual);	
		
	}
	

}
