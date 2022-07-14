/*
 * [Adventure].java
 * Author:  [Aayan Verma] 
 * Submission Date:  [11 - 11 - 2021]
 *
 * Purpose: The program calls upon different methods from different classes 
 * to create an interactive story telling game, involving
 * a map and a treasure. This class is the main method as
 * it will contain most of the different outcomes and different directions
 * that the player can explore in order to find the treasure. Using
 * Object Oriented programming, the Advetnure.java class calls 7 different
 * classes in order to create a functional game. 
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */

import java.util.Scanner;
public class Adventure {
	static Room currentRoom;
	static String nextMove;
	static boolean look = false;
	
	//Main method for main loops of game
	
	public static void main(String[] args) {
		
		System.out.print("Welcome to UGA Adventures: Episode 1\n"+
				"The Adventure of the Cave of Redundancy Adventure\n"+
				"By:Aayan Verma\n");
		
		
		//Intialzing variables to start player on journey
		
		Player player1 = new Player();
		player1.setX(0);
		player1.setY(0);
		Map map = new Map();
		
		while (true) {
			currentRoom = map.getRoom(player1.getX(), player1.getY());
			
			// if room is dark & player does not have a lamp / lamp is not lit
			
			if((currentRoom.isDark() && player1.getLamp() == null) ||
					(currentRoom.isDark() && player1.getLamp() != null) && player1.getLamp().getLight() == false) {
				System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
				getNextMove();
				if(!nextMove.equalsIgnoreCase("light lamp")) {
					System.out.println("You have been eaten by a grue!");
					return;
				}
			}
			else {
				System.out.println(currentRoom.getDescription());
				if (look)
					showDetails();
				getNextMove();
			}
			
			if (nextMove.equalsIgnoreCase("look") && !look)
				look = true;
			
			//Get Lamp methods
			
			else if(nextMove.equalsIgnoreCase("get lamp")) {
				if (currentRoom.getLamp() != null) {
					player1.setLamp(currentRoom.getLamp());
					currentRoom.clearLamp();
					System.out.println("OK");
				}
				else
					System.out.println("No lamp present");
			}
			
			//Light the lamp
			
			else if (nextMove.equalsIgnoreCase("light lamp")) {
				if (player1.getLamp() != null) {
					player1.getLamp().setLight(true);
					System.out.println("OK");
				}
				else 
					System.out.println("You do not have the lamp to light");
			}
			
			//Get the key
			
			else if (nextMove.equalsIgnoreCase("get key")) {
				if (currentRoom.getKey() != null) {
					player1.setKey(currentRoom.getKey());
					currentRoom.clearKey();
					System.out.println("OK");
				}
				else
					System.out.println("No key present");
			}
			
			//Open the chest 
			
			else if (nextMove.equalsIgnoreCase("open chest")) {
				if (currentRoom.getChest() != null) {
					if (!(currentRoom.getChest().isLocked())) {
						System.out.println(currentRoom.getChest().getContents());
						System.exit(0);
					}
					else
						System.out.println("The chest is locked");
				}
				else 
					System.out.println("No chest to unlock");
			}
			
			//Unlock chest
			
			else if (nextMove.equalsIgnoreCase("unlock chest")) {
				if (currentRoom.getChest() != null) {
					if (player1.getKey() != null) {
						currentRoom.getChest().unLock(player1.getKey());
					}
					else
						System.out.println("Need a key to do any unlocking");
				}
				else 
					System.out.println("No chest to unlock");
			}
			else
				executeNextMove(player1);
		
			
		}
	}
	
	public static void showDetails() {
		if (currentRoom.getLamp() != null)
			System.out.println("There is an old oil lamp here that was made long ago");
		if (currentRoom.getKey() != null)
			System.out.println("You see the outline of a key on a dusty shelf that is covered in dust");
		if (currentRoom.getChest() != null)
			System.out.println("There is a large, wooden, massive, oaken chest here with the word \"CHEST\" carved into it");
		
		System.out.print("Exits are: ");
		if (currentRoom.canGoEast())
			System.out.print("EAST ");
		if (currentRoom.canGoWest())
			System.out.print("WEST ");
		if(currentRoom.canGoNorth())
			System.out.print("NORTH ");
		if (currentRoom.canGoSouth())
			System.out.print("SOUTH ");
		System.out.println("");
	}
	
	//Setting up get method for nextMove-
	private static void getNextMove() {
		
		Scanner keyboard = new Scanner(System.in);
		nextMove = keyboard.nextLine();
	}
	
	//Parameters for X and Y coordinate based on player inputs
	
	private static void executeNextMove(Player player) {
		if (nextMove.equalsIgnoreCase("east") && currentRoom.canGoEast())
			player.setY(player.getY() + 1);
		else if (nextMove.equalsIgnoreCase("west") && currentRoom.canGoWest())
			player.setY(player.getY() - 1);
		else if (nextMove.equalsIgnoreCase("north") && currentRoom.canGoNorth())
			player.setX(player.getX() - 1);
		else if (nextMove.equalsIgnoreCase("south") && currentRoom.canGoSouth())
			player.setX(player.getX() + 1);
		else 
			System.out.println("Can't go that way");
		look = false;
	}
	
	
}