package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	Robot rob = new Robot(10,10,South,9);
	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/basicRoom.wld";

		Roomba cleaner = new Roomba();
		World.setDelay(1);
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	

	// You will need to add many variables!!


	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		

		rob.turnLeft();
		rob.turnLeft();
		rob.turnLeft();

		rob.move();

		while (rob.nextToABeeper() == true){

			rob.pickBeeper();
		}

		rob.move();
		rob.turnLeft();
		rob.turnLeft();
		rob.turnLeft();
		rob.move();
		while (rob.nextToABeeper() == true){

			rob.pickBeeper();
		}
		rob.turnLeft();
		rob.turnLeft();
		rob.turnLeft();
		rob.move();
		rob.move();
		while (rob.nextToABeeper() == true){

			rob.pickBeeper();
		}
		rob.move();
		rob.move();
		rob.move();
		while (rob.nextToABeeper() == true){

			rob.pickBeeper();
		}
		rob.turnLeft();
		rob.turnLeft();
		rob.turnLeft();
		rob.move();
		rob.move();
		rob.turnLeft();	
		rob.turnLeft();
		rob.turnLeft();
		rob.move();
		rob.move();
		while (rob.nextToABeeper() == true){

			rob.pickBeeper();
		}
		rob.move();
		rob.move();
		rob.move();
		rob.move();
		while (rob.nextToABeeper() == true){

			rob.pickBeeper();
		}
		rob.turnLeft();
		rob.move();
		rob.turnLeft();
		rob.move();
		rob.move();
		rob.move();
		rob.move();
		while (rob.nextToABeeper() == true){

			rob.pickBeeper();
		}
		rob.turnLeft();
		rob.turnLeft();
		rob.turnLeft();
		rob.move();
		rob.turnLeft();
		rob.turnLeft();
		rob.turnLeft();
		rob.move();
		rob.move();
		while (rob.nextToABeeper() == true){

			rob.pickBeeper();
		}
		rob.move();
		while (rob.nextToABeeper() == true){

			rob.pickBeeper();
		}
		rob.move();

		
		
		

	

		int totalBeepers = 0; // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
		return totalBeepers;
	}
}
