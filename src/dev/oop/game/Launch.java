package dev.oop.game;

/**
* <h1>OOP_PROJECT</h1>
*
*This is a game where the user will get to play
*as a character and fight enemies, collect power ups,
*and collect golden tokens!
*
* @author Nick Mason j.r
* @version 1.0
* @since 2019-10-11
*/


public class Launch 
{
	
	public static void main(String[] args)
	{
		/*This method will serve as the main
		 * used to start the program.
		 */
		
		Game game = new Game("Sprite Mayhem", 800, 600);
		game.start();
		
	}
	


}
