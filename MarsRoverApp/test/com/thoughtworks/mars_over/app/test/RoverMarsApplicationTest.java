package com.thoughtworks.mars_over.app.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.mars_over.app.RoverMarsApplication;
import com.thoughtworks.mars_rover.Plateau;
import com.thoughtworks.mars_rover.Position;
import com.thoughtworks.mars_rover.Rover;

public class RoverMarsApplicationTest {
	private RoverMarsApplication app;
	@Before
	public void setUp() throws Exception {
		app = new RoverMarsApplication("input.txt");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRun() {
		
	}
	
	@Test
	public void testInputFile() {
		app.run();
		String expected = "5 5\n" + "1 2 N\n" + "LMLMLMLMM\n" + "3 3 E\n" + "MMRMMRMRRM\n"; 
		StringBuilder sb = new StringBuilder();
		app.getInstructions().forEach(str->sb.append(str+"\n"));
		String actual = sb.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testInitializePlateauFromInstructions() {
		Plateau expected  = new Plateau(5, 5);
		Plateau actual = app.initializePlateauFromInstructions();
		assertEquals(expected.getHeight(), actual.getHeight());
		assertEquals(expected.getWidth(), actual.getWidth());
	}
	
	@Test
	public void testInitializeRovers() {
		List<Rover> expecteds = new ArrayList<>();
		Rover expected1 = new Rover(new Position(1, 2), Rover.NORTH, "");

		//Second rover
		Rover expected2 = new Rover(new Position(3, 3), Rover.EAST, "");

		expecteds.add(expected1);
		expecteds.add(expected2);
		
		List<Rover> actuals = app.initilazeRovers();	
		Assert.assertArrayEquals(expecteds.toArray(new Rover[0]), actuals.toArray(new Rover[0]));
	}
	
//	
//
//	@Test
//	public void testCreateFileOutput() {
//		app.run();
//		String 
//	}
}


















