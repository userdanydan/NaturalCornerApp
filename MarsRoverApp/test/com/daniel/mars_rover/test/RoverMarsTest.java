package com.daniel.mars_rover.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.daniel.mars_rover.Plateau;
import com.daniel.mars_rover.Position;
import com.daniel.mars_rover.Rover;
import com.daniel.mars_rover.RoverMars;

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
		Rover expected = new Rover(new Position(1, 3, false), Rover.NORTH);
		roverMars.addRover(expected);
		Rover actual = roverMars.getRover(0);
		assertEquals(expected, actual);	
		//Second rover
		expected = new Rover(new Position(3, 3, false), Rover.EAST);
		roverMars.addRover(expected);
		actual = roverMars.getRover(1);
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testMoveRovers(){
		//First rover
		Rover expected = new Rover(new Position(1, 3, false), Rover.NORTH);
		roverMars.addRover(new Rover(new Position(1, 2, false), Rover.NORTH));
		roverMars.moveRovers();
		Rover actual = roverMars.getRover(0);
		assertEquals(expected, actual);	
		
		//Second rover
		expected = new Rover(new Position(5, 1, false),  Rover.EAST);
		roverMars.addRover(new Rover(new Position(3, 3, false),  Rover.EAST));
		roverMars.moveRovers();
		actual = roverMars.getRover(1);
		assertEquals(expected, actual);	
		
	}
	

}
