package dev.oop.states;

import java.awt.Graphics;

import dev.oop.game.Game;
import dev.oop.game.Handler;

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

public abstract class State 
{
	
	private static State currentState = null;
	protected Handler handler;
	
	public State(Handler handler)
	{
		this.handler = handler;
	}
	

	public static void setState(State state)
	{
		/*This method will be
		 * used to set the current
		 * state of the game
		 * @param1 State state
		 */
		currentState = state;
	}
	
	public static State getState()
	{
		/*This method will be used
		 * to return the current state
		 */
		return currentState;
	}
	
	
	
	
	public abstract void tick();
	
	public abstract void render(Graphics graphic);

}
