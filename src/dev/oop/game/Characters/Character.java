package dev.oop.game.Characters;

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
import dev.oop.game.tile.Tiles;

public abstract class Character extends Entity
{
	
	protected int health;
	protected int defense;
	protected int attack;
	protected float speed;
	protected float xMove, yMove;
	protected float jumpStrength;
	private Enemy enemy;
	protected boolean falling = false;
	
	protected final float gravity = .70f;
	protected boolean jumping = false;
	public final long jumpTime = 260;
	


	
	



	public static final int DEFAULT_CHAR_WIDTH = 60, DEFAULT_CHAR_HEIGHT = 60;
	
	
	

	public Character(Handler handler, float x, float y, int width, int height) 
	{
		/*This method will serve as a constructor for the
		 * Character class
		 */

		super(handler, x,y, width, height);
		
		health = 200;
		
		defense = 120;
		
		attack = 120;
		speed = .30f;
		
		xMove = 0;
		
		yMove = 0;
	
		jumpStrength = .90f;
		
		
	
		
	}
	

	
	public void move()
	{
		if(!checkEntityCollisions(xMove,0f))
		moveX();
		
		if(!checkEntityCollisions(0f,yMove))
	    moveY();
	}

	public void moveX()
	{
		
		/*This method will serve to detect
		 * collision when moving left and
		 * right
		 */
		
		
		
		if(xMove > 0) //right move
		{
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tiles.TILE_WIDTH;
			
			if(!collision(tx, (int)(y+bounds.y) / Tiles.TILE_HEIGHT) && !collision(tx, (int)(y+bounds.y + bounds.height) / Tiles.TILE_HEIGHT))
			{
				x+=xMove;
			}

		else 
		{
			x = tx * Tiles.TILE_WIDTH - bounds.x - bounds.width-1;
	
		}
		
		}		
		
		else if(xMove < 0) //left move
		{
			int tx = (int) (x + xMove + bounds.x) / Tiles.TILE_WIDTH;
			
			
			if(!collision(tx, (int)(y+bounds.y) / Tiles.TILE_HEIGHT) && !collision(tx, (int)(y+bounds.y + bounds.height) / Tiles.TILE_HEIGHT))
				x+=xMove;
			
		
		else
		{
			x=tx * Tiles.TILE_WIDTH + Tiles.TILE_WIDTH - bounds.x;
		}
			

		}
		
	}


	
	public void moveY()
	{
		/*This method will serve to
		 * detect collision when moving up and
		 * down
		 */
		
		if(yMove < 0) //up
		{
		int ty = (int) (y + yMove + bounds.y) / Tiles.TILE_HEIGHT;
			
			if(!collision((int) (x + bounds.x) / Tiles.TILE_WIDTH, ty) &&
					!collision((int) (x + bounds.x + bounds.width) / Tiles.TILE_WIDTH, ty)){
				y += yMove;
			}
			else
				yMove = 0;
		

	
		}
		
		else if(yMove > 0) //down
		{
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tiles.TILE_HEIGHT;
			
			if(!collision((int)(x+bounds.x) / Tiles.TILE_HEIGHT, ty) && !collision((int)(x+bounds.x + bounds.width) / Tiles.TILE_WIDTH, ty))
			{
				y += yMove;
			}
			else
			{
				jumping = false;
			}
		
			
		}
		
		
		

		
	}
	

	
	
	
	protected boolean collision(int x, int y)
	{
		/*This method will be used
		 * to check for collision
		 * 
		 */
		return handler.getWorld().getTile(x, y).isSolid();
		
	}
	

	

	
	
	protected boolean safeJump()
	{
		/*This method will be used to determine 
		 * if it is safe for the character to jump.
		 */
		
		int ty = (int) (y + yMove + bounds.y + bounds.height) / Tiles.TILE_HEIGHT;
		
		if(!collision((int)(x+bounds.x) / Tiles.TILE_HEIGHT, ty) && !collision((int)(x+bounds.x + bounds.width) / Tiles.TILE_HEIGHT, ty))
		{
			return true;
		}
		else return false;
	}
	

	
	
	

	public float getxMove() {
		return xMove;
	}


	public void setxMove(float xMove) {
		this.xMove = xMove;
	}


	public float getyMove() {
		return yMove;
	}


	public void setyMove(float yMove) {
		this.yMove = yMove;
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public int getDefense() {
		return defense;
	}


	public void setDefense(int defense) {
		this.defense = defense;
	}


	public int getAttack() {
		return attack;
	}


	public void setAttack(int attack) {
		this.attack = attack;
	}


	public float getSpeed() {
		return speed;
	}


	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
