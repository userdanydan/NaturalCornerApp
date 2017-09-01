package com.daniel.mars_rover.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.daniel.mars_rover.Plateau;
import com.daniel.mars_rover.Position;
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
		int expected = 5;
		int actual = plateau.getWidth();
		assertEquals(expected, actual);	 
		
		//Y coordinate
		expected = 4;
		actual = plateau.getHeight();
		assertEquals(expected, actual);
	}
	
	
}
