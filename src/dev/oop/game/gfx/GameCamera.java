package dev.oop.game.gfx;

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

import dev.oop.game.Game;
import dev.oop.game.Handler;
import dev.oop.game.entities.Entity;

public class GameCamera 
{
	
	
	private float xOffSet, yOffSet;
	private Handler handler;
	
	public GameCamera(Handler handler, float xOffSet,float yOffSet)
	{
		/*This method will serve as the 
		 * constructor for the GameCamera class
		 */
		
		this.handler= handler;
		this.xOffSet = xOffSet;
		this.yOffSet = yOffSet;
	
	}
	
	public void centerOnChar(Entity e)
	{
		
		xOffSet = e.getX() - handler.getWidth() / 2 + e.getWidth()/2;
		yOffSet = e.getY() - handler.getHeight() / 2 + e.getHeight()/2;
		checkForBlank();
		
	}
	
	public void move(float xAmount, float yAmount)
	{
		xOffSet += xAmount;
		yOffSet += yAmount;
		checkForBlank();
	}
	
	
	
	public void checkForBlank()
	{
		if(xOffSet < 0)
		{
			xOffSet = 0;
		}
		
		if (xOffSet > 5000)
		{
			xOffSet = 5000;
		}
		
		if(yOffSet < 0)
		{
			yOffSet = 0;
		}
		
		if(yOffSet > (handler.getWorld().getHeight()) * 70)
		{
		
		}

	}



	public float getxOffSet() 
	{
		return xOffSet;
	}

	public void setxOffSet(float xOffSet) 
	{
		this.xOffSet = xOffSet;
	
	}

	public float getyOffSet() {
		return yOffSet;
	}

	public void setyOffSet(float yOffSet) {
		this.yOffSet = yOffSet;
		
	}

}
