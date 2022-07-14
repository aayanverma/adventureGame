/*
 * [Player].java
 * Author:  [Aayan Verma] 
 * Submission Date:  [11 - 11 - 2021]
 *
 * Purpose: Player.java is utilized to create an object of the player
 * in the main method in order to track the players movements throughout Map.java
 * and Adventure.java, by using different get and set methods in order to 
 * track player movement and items in the inventory, the player class
 * helps simplify the main method code in order to have the game run more consistently.
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

public class Player {

	//Instance variables
	
	private Lamp theLamp;
	private Key theKey;
	private int x;
	private int y;
	
	//Get and Set methods
	
	public Lamp getLamp() {
		return theLamp;
	}
	
	public void setLamp(Lamp theLamp) {
		this.theLamp = theLamp;
	}
	
	public Key getKey() {
		return theKey;
	}
	
	public void setKey(Key theKey) {
		this.theKey = theKey;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
