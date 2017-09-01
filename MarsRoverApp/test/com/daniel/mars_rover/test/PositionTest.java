package com.daniel.mars_rover.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.daniel.mars_rover.Position;
import com.daniel.mars_rover.Rover;

public class PositionTest {
	private Position pos;
	@Before
	public void setUp() throws Exception {
		 pos =  new Position(0, 0, Rover.NORTH);
	}

	@After
	public void tearDown() throws Exception {
		pos=null;
	}

	@Test
	public void testCoordonateGettersAndSetters() {
		int expected = 1;
		pos.setX(expected);
		int actual = pos.getX();
		assertEquals(expected, actual);
		
		expected = 3;
		pos.setY(expected);
		actual = pos.getY();
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testDirectionGetterAndSetter() {
		String expected = Rover.NORTH;
		pos.setDirection(expected);
		String actual  = pos.getDirection();
		assertEquals(expected, actual);
	}

}
