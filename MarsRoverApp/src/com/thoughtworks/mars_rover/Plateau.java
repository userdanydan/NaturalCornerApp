package com.thoughtworks.mars_rover;

// Not mandatory for this exercise but it abstracts the data structure underlying the plateau.
// He has the knowledge about moving the rovers.
// Can potentially with little modifications keep tracks of the positions occupied by the rovers or throwing an exception in case of rovers in the same positon.
public class Plateau {
	// basic array
	private Position[][] plateau;
	private int width,  height;
	public Plateau(int x, int y) {
		// TODO Auto-generated constructor stub
		plateau = new Position[x+1][y+1];
		for(int i=0; i<plateau.length; i++) {
			for(int j=0; j<plateau[0].length; j++) {
				plateau[i][j]= new Position(i, j);
			}
		}
		
	}
	public int getWidth() {
		// TODO Auto-generated method stub
		return plateau.length;
	}
	public int getHeight() {
		// TODO Auto-generated method stub
		return plateau[0].length;
	}
	public void moveRover(Rover rover, char instruction){

		switch(instruction) {
			case 'M':
				rover.move();
				break;
			case 'L':
				rover.rotate('L');
				break;
			case 'R':
				rover.rotate('R');
				break;
		}	
		System.out.println(rover);
	}
	// Convenient method to get coordinates' position.
	public Position getPosition(int x, int y) {
		return plateau[x][y];
	}
		
	

}
