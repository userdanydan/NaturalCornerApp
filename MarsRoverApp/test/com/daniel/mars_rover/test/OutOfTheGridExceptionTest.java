package com.daniel.mars_rover.test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.daniel.mars_rover.Plateau;
import com.daniel.mars_rover.Position;
import com.daniel.mars_rover.Rover;
import com.daniel.mars_rover.RoverMars;
import com.daniel.mars_rover.exception.OutOfTheGridException;

public class OutOfTheGridExceptionTest {
	private RoverMars roverMars;
	@Before
	public void setUp() throws Exception {
		this.roverMars = new RoverMars(new Plateau(2, 2), new ArrayList<Rover>());
		roverMars.addRover(new Rover(new Position(0, 0, false), Rover.NORTH));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
	}

}
