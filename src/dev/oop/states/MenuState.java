package dev.oop.states;

import java.awt.Color;
import java.awt.Font;

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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import dev.oop.Menu.Menu;
import dev.oop.game.Game;
import dev.oop.game.Handler;

public class MenuState extends State
{
	
	private Menu menu;
	




	public MenuState(Handler handler) 
	
	{
		/*This method will serve as a constructor for 
		 * the menuState class.
		 */
		super(handler);
		menu = new Menu(handler);


		//menu = new Menu(handler);
	}

	@Override
	public void tick()
	
	{
		/*This method will serve to update
		 * the screen while in menuState
		 */

		menu.tick();
	
		
	}

	@Override
	public void render(Graphics graphic) 
	{
		/*This method will serve to render
		 * the menuState to the screen.
		 */
		// TODO Auto-generated method stub

	
	menu.render(graphic);
		
	}
	


}
