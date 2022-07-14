/*
 * [Lamp].java
 * Author:  [Aayan Verma] 
 * Submission Date:  [11 - 11 - 2021]
 *
 * Purpose: Lamp.java is a class in order to simply, return if the
 * lamp has been lit or not. Using the getLight and setLight methods, it
 * is able to return a boolean on whether the lamp is lit,
 * or the process of lighting it. 
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

public class Lamp {

	/*
	 * Instance variables and methods go here, you're responsible for 
	 * choosing and naming them.
	 */

	
	private boolean isLit;
	
	//Get and Set methods for if light is lit or not
	
	public boolean getLight() {
		return isLit;
	}
	
	public void setLight(boolean isLit) {
		this.isLit = isLit;
	}
	
}
