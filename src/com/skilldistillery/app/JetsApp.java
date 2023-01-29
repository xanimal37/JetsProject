package com.skilldistillery.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.entities.AirField;
import com.skilldistillery.entities.Jet;

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
		System.out.println("Welcome to the AirField!");
		System.out.println("What would you like to do?");
		// do main loop
		mainLoop(input);
		// loop ends
		System.out.println("Goodbye!");
	}

	// builds fleet
	private List<Jet> getJetData(String filename) {
		// list to hold jet objects
		List<Jet> jets = new ArrayList<>();
		// standard construction for buffer object to read text file
		try (BufferedReader bufIn = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				// System.out.println(line);
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
				+ "\n8. Remove a Jet from Fleet\\n9. Quit\n";
		
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
				break;
			case 2:
				System.out.println("Flying all Jets!");
				break;
			case 3:
				System.out.println("Displaying fastest Jet!");
				break;
			case 4:
				System.out.println("Displaying Jet with the longest range!");
				break;
			case 5:
				System.out.println("Loading all Cargo Jets!");
				break;
			case 6:
				System.out.println("Dogfight!!!");
				break;
			case 7:
				System.out.println("Add a Jet!");
				break;
			case 8:
				System.out.println("Remove a Jet!");
				break;
			case 9:
				System.out.println("Quitting!");
				airfieldOpen = false;
				break;
			default:
				System.out.println("Please enter a valid option.");
				break;
			}
		}
		// repeat

	}

}
