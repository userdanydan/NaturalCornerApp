package com.daniel.mars_rover;

import com.daniel.mars_rover.exception.OutOfTheGridException;
import com.daniel.mars_rover.exception.PositionAlreadyOccupiedException;

public class Plateau {
	// basic array
	private Position[][] plateau;
	private int width,  height;
	public Plateau(int x, int y) {
		// TODO Auto-generated constructor stub
		plateau = new Position[x+1][y+1];
		for(int i=0; i<plateau.length; i++) {
			for(int j=0; j<plateau[0].length; j++) {
				plateau[i][j]= new Position(i, j, false);
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
		System.out.println(rover);
		System.out.print("("+rover.getPosition().getX()+","+rover.getPosition().getY()+")");
		System.out.println();

		switch(instruction) {
			case 'M':
				//setting the current rover's position occupation to free.		
				//getPosition(rover.getPosition().getX(), rover.getPosition().getY()).setOccupied(false);
				
				
				//Rollback if next move impossible.
//				try {
//					checkAvailabilityNextPosition(rover);
//				}catch(OutOfTheGridException | PositionAlreadyOccupiedException e) {
//					getPosition(rover.getPosition().getX(), rover.getPosition().getY()).setOccupied(true);
//					throw e;
//				}
				//setting the rover's position according to rover's direction. 
				rover.move();
				break;
			case 'L':
				rover.rotate('L');
				break;
			case 'R':
				rover.rotate('R');
				break;
		}
		// TODO Auto-generated method stub
		
		
		// marking the new rover's position as occupied.
		// getPosition(rover.getPosition().getX(), rover.getPosition().getY()).setOccupied(true);
		
	}









	private void checkAvailabilityNextPosition(Rover rover) throws RuntimeException {
		//send a runtime exception if the rover is going to go out of the grid.
		//send a runtime exception if the position is already occupied by an other rover.
		switch(rover.getDirection()) {
			case Rover.EAST:
				if(rover.getPosition().getX()==0)
					throw new OutOfTheGridException();
				
//				if(getPosition(rover.getPosition().getX()-1, rover.getPosition().getY()).isOccupied())
//					throw new PositionAlreadyOccupiedException();
				
				break;
			case Rover.NORTH:
				if(rover.getPosition().getY()==this.getHeight()-1)
					throw new OutOfTheGridException();
				
//				if(getPosition(rover.getPosition().getX(), rover.getPosition().getY()+1).isOccupied())
//					throw new PositionAlreadyOccupiedException();
				
				break;
			case Rover.SOUTH:
				if(rover.getPosition().getY()==0)
					throw new OutOfTheGridException();
				
//				if(getPosition(rover.getPosition().getX(), rover.getPosition().getY()-1).isOccupied())
//					throw new PositionAlreadyOccupiedException();
				
				break;
			case Rover.WEST:
				if(rover.getPosition().getX()==this.getWidth()-1)
					throw new OutOfTheGridException();
				
//				if(getPosition(rover.getPosition().getX()+1, rover.getPosition().getY()).isOccupied())
//					throw new PositionAlreadyOccupiedException();
				
				break;
		}
	}
	// Convenient method to get coordinates' position.
	public Position getPosition(int x, int y) {
		return plateau[x][y];
	}
		
	

}
