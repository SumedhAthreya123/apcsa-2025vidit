package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	
	// Main method to make this self-contained
	public static void main(String[] args) {
		World.setDelay(0);
		World.readWorld("robot/finalTestWorld2024.wld");
		World.setVisible(true);
		Robot rob = new Robot(26,101,East,9);

		
		

		int numBeeper = 0;
		int numPile = 0;
		int area = 1;
		int numBeepersInPile = 0;
		int numLargestPile = 0;
		int x=0;
		int y=0;
		
		for (int i = 1; i <= 100;) {
			while (rob.frontIsClear()) {
				if (rob.nextToABeeper()) {
					numPile++;
				}
				while (rob.nextToABeeper()) {
					rob.pickBeeper();
					numBeeper++;
					numBeepersInPile++;
				}
				if (numBeepersInPile > numLargestPile) {
					numLargestPile = numBeepersInPile;
					x = rob.avenue();
					y = rob.street();
				}

				numBeepersInPile = 0;
				rob.move();
				area++;
			}

			if (rob.facingEast()) {
				rob.turnLeft();
				if (rob.nextToABeeper()) {
					numPile++;
				}
				while (rob.nextToABeeper()) {
					rob.pickBeeper();
					numBeeper++;
					numBeepersInPile++;
				
				}
				if (numBeepersInPile > numLargestPile) {
					numLargestPile = numBeepersInPile;
					x = rob.avenue();
					y = rob.street();
				}
				numBeepersInPile = 0;

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
					numPile++;
				}
				while (rob.nextToABeeper()) {
					rob.pickBeeper();
					numBeeper++;
					numBeepersInPile++;
				}
				if (numBeepersInPile > numLargestPile) {
					numLargestPile = numBeepersInPile;
					x = rob.avenue();
					y = rob.street();
				}
				numBeepersInPile = 0;

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
		System.out.println("The area is " + area);
		System.out.println("The total number of piles are " + numPile);
		System.out.println("The total number of beepers are " + numBeeper);
		System.out.println("The largest pile is " + numLargestPile);
		System.out.println("The dirty percentage is " + ((double)numPile/area));
		System.out.println("The coordinates are: The x coordinate is "  + x + " and the y coordinate is " + y);
		System.out.println("The average amount of beepers are " + ((double)numBeeper/numPile));
		System.out.println("The robot cleaned up a total of " + numBeeper + " beepers.");

		
		 // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
		
	}
}



	

	// declared here so it is visible in all the methods!
	

	// You will need to add many variables!!


	

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		
		

		

		
		 // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
	

