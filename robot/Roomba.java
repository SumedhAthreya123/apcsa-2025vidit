package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	
	// Main method to make this self-contained
	public static void main(String[] args) {
		World.setDelay(0);
		World.readWorld("robot/finalTestWorld2024.wld");
		World.setVisible(true);
		Robot rob = new Robot(26,101,East,9);

		
		

		int totalBeeper = 0;
		int totalPile = 0;
		int area = 1;
		int BeepersInPile = 0;
		int LargestPile = 0;
		int a = 0;
		int b = 0;
		
		for (int i = 1; i <= 100;) {
			while (rob.frontIsClear()) {
				if (rob.nextToABeeper()) {
					totalPile++;
				}
				while (rob.nextToABeeper()) {
					rob.pickBeeper();
					totalBeeper++;
					BeepersInPile++;
				}
				if (BeepersInPile > LargestPile) {
					LargestPile = BeepersInPile;
					a = rob.avenue();
					b = rob.street();
				}

				BeepersInPile = 0;
				rob.move();
				area++;
			}

			if (rob.facingEast()) {
				rob.turnLeft();
				if (rob.nextToABeeper()) {
					totalPile++;
				}
				while (rob.nextToABeeper()) {
					rob.pickBeeper();
					totalBeeper++;
					BeepersInPile++;
				
				}
				// have to create a new avenue and street for the x and y coordinates
				if (BeepersInPile > LargestPile) {
					LargestPile = BeepersInPile;
					a = rob.avenue();
					b = rob.street();
				}
				BeepersInPile = 0;
// have to keep checking the space and adding to the area
				if (rob.frontIsClear()) {
					rob.move();
					area++;
					rob.turnLeft();

				} else {
					i = 101;
				}
			} else if (rob.facingWest()) {
				rob.turnLeft();
				rob.turnLeft();
				rob.turnLeft();

				if (rob.nextToABeeper()) {
					totalPile++;
				}
				while (rob.nextToABeeper()) {
					rob.pickBeeper();
					totalBeeper++;
					BeepersInPile++;
				}
				if (BeepersInPile > LargestPile) {
					LargestPile = BeepersInPile;
					a = rob.avenue();
					b = rob.street();
				}
				BeepersInPile = 0;

				if (rob.frontIsClear()) {
					rob.move();
					area++;
					rob.turnLeft();
					rob.turnLeft();
					rob.turnLeft();
				} else {
					i = 101;
				}

			}
		}
		// final steps are the print statements
		System.out.println("The area is " + area);
		System.out.println("The total number of piles are " + totalPile);
		System.out.println("The total number of beepers are " + totalBeeper);
		System.out.println("The largest pile is " + LargestPile);
		System.out.println("The dirty percentage is " + ((double)totalPile/area));
		System.out.println("The coordinates are: The x coordinate is "  + a + " and the y coordinate is " + b);
		System.out.println("The average amount of beepers are " + ((double)totalBeeper/totalPile));
		System.out.println("The robot cleaned up a total of " + totalBeeper + " beepers.");

		
		 // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
		
	}
}


// had to repeat a bunch of code to check all of the beepers
	

	// declared here so it is visible in all the methods!
	

	// You will need to add many variables!!


	

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		
		

		

		
		 // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
	

