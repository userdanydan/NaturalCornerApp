package com.thoughtworks.mars_rover;

import java.util.ArrayList;
import java.util.List;
// This class is a general purpose class which initiate the system interaction.
// Instantiate and initialize the plateay and the rovers
// send instructions to rovers
public class RoverMars {
	
	private Plateau plateau;
	private List<Rover> rovers;
	
	public RoverMars() {
		// TODO Auto-generated constructor stub
		plateau = new Plateau(5, 5);
		rovers = new ArrayList<>();
	}
	
	public RoverMars(Plateau plateau, List<Rover> rovers) {
		super();
		this.plateau = plateau;
		this.rovers = new ArrayList<>();
	}

	public void setPlateau(Plateau plateau) {
		// TODO Auto-generated method stub
		this.plateau=plateau;
	}

	public Plateau getPlateau() {
		// TODO Auto-generated method stub
		return this.plateau;
	}

	public boolean addRover(Rover rover) {
		// TODO Auto-generated method stub
		return this.rovers.add(rover);
	}

	public Rover getRover(int i) {
		// TODO Auto-generated method stub
		return this.rovers.get(i);
	}
	// need to check if the rovers have already moved. 
	//Neceseray if the program needs to first add all the rovers.
	public void moveRovers() {
		// TODO Auto-generated method stub
		for(Rover rover : rovers) {
			if(!rover.isAlreayMoved()) {
				// Send message move rover to the object plateau.
				for(char instruction : rover.getInstructions().toCharArray()) {
					plateau.moveRover(rover, instruction);
				}
			}	
			rover.setAlreayMoved(true);
		}
	}

}
