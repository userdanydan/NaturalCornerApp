package com.daniel.mars_rover;


public class Plateau {
	// basic array
	private Position[][] plateau;
	private int width,  height;
	public Plateau(int x, int y) {
		// TODO Auto-generated constructor stub
		plateau = new Position[x][y];
		
	}




	public int getWidth() {
		// TODO Auto-generated method stub
		return plateau.length;
	}



	public int getHeight() {
		// TODO Auto-generated method stub
		return plateau[0].length;
	}
	
	
	
	

}
