package com.daniel.mars_over.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.daniel.mars_rover.Plateau;
import com.daniel.mars_rover.Position;
import com.daniel.mars_rover.Rover;
import com.daniel.mars_rover.RoverMars;

public class RoverMarsApplication {
	private String fileInput;
	private List<String> instructions;
	public RoverMarsApplication(String fileURL) {
		// TODO Auto-generated constructor stub
		this.fileInput=fileURL;
		instructions = readInstructions(fileInput);
	}

	public static void main(String ... args) {
		if(args.length==0 || args.length>1) {
			System.err.println("Error : Only one input argument allowed");
			System.exit(-1);			
		}
		RoverMarsApplication app = new RoverMarsApplication(args[0]);
		app.run();	
	}

	public void run() {
		// TODO Auto-generated method stub
		Plateau plateau = initializePlateauFromInstructions();
		List<Rover> rovers = initilazeRovers();
		RoverMars roverMarsMission = new RoverMars(plateau, rovers);
		rovers.forEach(r->roverMarsMission.addRover(r));
		roverMarsMission.moveRovers();
		rovers.forEach(System.out::println);
	}

	public List<Rover> initilazeRovers() {
		List<Rover> rovers = new ArrayList<>();
		for(int i=1; i<instructions.size(); i+=2) {
			int x = Character.getNumericValue(instructions.get(i).charAt(0));
			int y = Character.getNumericValue(instructions.get(i).charAt(2));
			char direction = instructions.get(i).charAt(4);
			Rover rover = new Rover(new Position(x, y), direction, instructions.get(i+1));
			rovers.add(rover);
		}
		return rovers;
	}

	public Plateau initializePlateauFromInstructions() {
		int plateauWidth = Character.getNumericValue(instructions.get(0).charAt(0));
		int plateauHeight = Character.getNumericValue(instructions.get(0).charAt(2));
		Plateau plateau = new Plateau(plateauWidth, plateauHeight);
		return plateau;
	}


	private static List<String> readInstructions(String fileURL) {
		List<String> instructions = new ArrayList<>();
		try {			
			Files.lines(Paths.get(fileURL)).forEach(str->instructions.add(str));		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return instructions;
	}

	public List<String> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}

}
