package com.daniel.mars_rover.exception.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.daniel.mars_rover.Plateau;
import com.daniel.mars_rover.Position;
import com.daniel.mars_rover.Rover;
import com.daniel.mars_rover.RoverMars;
import com.daniel.mars_rover.exception.PositionAlreadyOccupiedException;

public class PositionAlreadyOccupiedExceptionTest extends RuntimeException {
	private RoverMars roverMars;
	@Before
	public void setUp() throws Exception {
		this.roverMars = new RoverMars(new Plateau(2, 2), new ArrayList<Rover>());
		roverMars.addRover(new Rover(new Position(0, 0, true), Rover.NORTH, ""));
		roverMars.addRover(new Rover(new Position(0, 1, true), Rover.SOUTH, ""));
	}

	@After
	public void tearDown() throws Exception {
		roverMars=null;
	}

	@Test
	public void testException() {
		Rover rover1 = roverMars.getRover(0);
		Rover rover2 = roverMars.getRover(1);
		try {
			rover1.move();
			fail();
		}catch(PositionAlreadyOccupiedException e) {
			assertTrue(true);
		}
	}

}
