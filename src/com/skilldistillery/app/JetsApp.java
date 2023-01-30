package com.skilldistillery.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.entities.AirField;
import com.skilldistillery.entities.AttackJet;
import com.skilldistillery.entities.CargoJet;
import com.skilldistillery.entities.FighterJet;
import com.skilldistillery.entities.Jet;
import com.skilldistillery.entities.PassengerJet;
import com.skilldistillery.entities.ResearchJet;

public class JetsApp {

	private AirField airField;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		JetsApp japp = new JetsApp();
		japp.launch(scanner);

		// main loop

		// close scanner
		scanner.close();

	}

	// runs program
	private void launch(Scanner input) {
		//create airfield
		airField = new AirField();
		//load starting state
		List<Jet> jetdata= initializeAirfield("jets.txt");
		
		System.out.println("Welcome to the AirField!");
		System.out.println("What would you like to do?");
		// do main loop
		mainLoop(input);
		// loop ends
		System.out.println("Goodbye!");
	}

	// builds fleet
	private List<Jet> initializeAirfield(String filename) {
		// list to hold jet objects
		List<Jet> jets = new ArrayList<>();
		// standard construction for buffer object to read text file
		try (BufferedReader bufIn = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				// System.out.println(line);
				//first put text data into an array
				String[] jetData = line.split(",");
				
				//store the elements - parse them once
				String model = jetData[1];
				int speed = Integer.parseInt(jetData[2]);
				int range = Integer.parseInt(jetData[3]);
				double price = Double.parseDouble(jetData[4]);
				
				//debug
				//System.out.println(jetData[0]+"-"+model+"-"+speed+"-"+range+"-"+price);
				//figured out the switch was missing a break!
				
				//determine the type of jet based on the first element
				switch(jetData[0]) {
				case "Research":
					//System.out.println("Adding a RESEARCH jet!");
					Jet researchJet = new ResearchJet(model,speed,range,price);
					airField.addToFleet(researchJet);
					break;
				case "Attack":
					//System.out.println("Adding a ATTACK jet!");
					Jet attackJet = new AttackJet(model,speed,range,price);
					airField.addToFleet(attackJet);
					break;
				case "Cargo":
					//System.out.println("Adding a CARGO jet!");
					Jet cargoJet = new CargoJet(model,speed,range,price);
					airField.addToFleet(cargoJet);
					break;
				case "Passenger":
					//System.out.println("Adding a PASSENGER jet!");
					Jet passengerJet = new PassengerJet(model,speed,range,price);
					airField.addToFleet(passengerJet);
					break;
				case "Fighter":
					//System.out.println("Adding a FIGHTER jet!");
					Jet fighterJet = new FighterJet(model,speed,range,price);
					airField.addToFleet(fighterJet);
					break;
				default:
					break;
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
	}

	// main program loop
	// includes input menu
	private void mainLoop(Scanner input) {
		String header = "*********** Airfield ***************";
		String menu = "1. Fleet List \n2. Fly all Jets \n3. View Fastest Jet \n"
				+ "4. View Jet with Longest Range\n5. Load all Cargo Jets\n6. Dogfight!\n7. Add Jet to Fleet"
				+ "\n8. Remove a Jet from Fleet\n9. Quit\n10. Fly Research Jets\n";
		
		// if false will end program
		boolean airfieldOpen = true;
		
		// show menu -- get input -- do things -- repeat
		while (airfieldOpen) {
			 
			// show menu
			System.out.println(header);
			System.out.print(menu);
			
			//option will be 0 if input fails due to type mismatch, which will go 
			//to top of while loop
			int option=0; //user choice
			
			// get input
			// try to handle int, if not, clear scanner and continue
			try {
				option = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter an integer value.");
			}
			finally {
				//clear SCANNER!!!
				//or else endless loop!
				input.nextLine();	
				}
			
			// process input
			switch (option) {
			case 1:
				System.out.println("Showing Fleet Roster!");
				airField.displayFleet();
				break;
			case 2:
				System.out.println("Flying all Jets!");
				airField.airShow();
				break;
			case 3:
				System.out.println("Displaying fastest Jet!");
				airField.getFastest();
				break;
			case 4:
				System.out.println("Displaying Jet with the longest range!");
				airField.getLongestRanged();
				break;
			case 5:
				System.out.println("Loading all Cargo Jets!");
				airField.loadCargoJets();
				break;
			case 6:
				System.out.println("Dogfight!!!");
				airField.scrambleJets();
				break;
			case 7:
				System.out.println("Add a Jet!");
				airField.addAJet(input);
				break;
			case 8:
				System.out.println("Remove a Jet!");
				airField.removeAJet(input);
				break;
			case 9:
				System.out.println("Quitting!");
				airfieldOpen = false;
				break;
			case 10:
				System.out.println("Researching");
				airField.flyResearchJets();
				break;
			default:
				System.out.println("Please enter a valid option.");
				break;
			}
		}
		// repeat

	}

}
