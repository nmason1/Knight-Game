package dev.oop.game.entities;

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
import dev.oop.game.world.*;		
import java.awt.Rectangle;

import dev.oop.game.Game;
import dev.oop.game.Handler;
import dev.oop.game.PowerUps.PowerUps;

public abstract class Entity 
{
	protected Handler handler;
	protected float x,y;
	protected int width, height;
	protected Rectangle bounds;
	private PowerUps powerUp;
	
	

	

	public Entity(Handler handler,float x, float y, int width, int height)
	{
		/*this method will serve as a constructor
		 * for the entity class and will set the 
		 * x and y location variables.
		 */
		
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width=width;
		this.height=height;
		
		bounds = new Rectangle();
	
	
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset)
	{
		for(Entity e : handler.getWorld().getEntityManager().getEntities())
		{
			
			if(e.equals(this))
				continue;
			if(e.getCollisionbounds(0f, 0f).intersects(getCollisionbounds(xOffset,yOffset)))
					{
					return true;
					}
		}
		
		return false;
	}
	
	public Rectangle getCollisionbounds(float xOffset, float yOffset)
	{
		/*This method will be used to return
		 * the location of the bounds box
		 * on the entity.
		 * @param1 float xOffset
		 * @param2 float yOffset
		 */
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y+bounds.y + yOffset),bounds.width, bounds.height);
	}
	
	public float getX() {
		return x;
	}


	public void setX(float x) {
		this.x = x;
	}


	public float getY() {
		return y;
	}


	public void setY(float y) {
		this.y = y;
	}


	public int getWidth() {
		return width;
	}
	
	
	private PowerUps getPowerUp() {
		return powerUp;
	}

	private void setPowerUp(PowerUps powerUp) {
		this.powerUp = powerUp;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public abstract void tick();
	
	public abstract void hudRender(Graphics graphic);
	
	public abstract void render(Graphics graphic);
}
