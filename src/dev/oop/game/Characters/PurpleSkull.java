package dev.oop.game.Characters;


import java.awt.Color;

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

import dev.oop.game.Handler;
import dev.oop.game.entities.Entity;
import dev.oop.game.gfx.Animation;
import dev.oop.game.gfx.Assets;
import dev.oop.game.tile.Tiles;

public class PurpleSkull extends Enemy
{
	
	private Animation moveR;
	private boolean movingRight = true;
	private boolean defeated;
	

	public PurpleSkull(Handler handler, float x, float y, int width, int height)
	{
		/*This method will serve as a constructor
		 * for the purple skull class and 
		 * will initialize all variables
		 */
		super(handler, x, y, width, height);
		
		bounds.x = 10;
		bounds.y = 10;
		bounds.width = 57;
		bounds.height = 60;
	
		moveR = new Animation(150, Assets.psRight);
	}

	@Override
	public void tick() 
	{
		checkDefeat();
		if(!isDefeated())
		{
		moveR.tick();
	//	move();
		moveBounds();
		}
	}
	


	@Override
	public void render(Graphics graphic) 
	{
		//graphic.drawImage(Assets.playBtn,(int) (x-handler.getGameCamera().getxOffSet()), (int) (y-handler.getGameCamera().getyOffSet()), width, height, null);
		if(!isDefeated())
		{
		graphic.drawImage(moveR.getCurrentFrame(),(int) (x- handler.getGameCamera().getxOffSet()), (int) (y - handler.getGameCamera().getyOffSet()), width, height, null);
		}
		
		else if(isDefeated())
				{
			bounds.x = 0;
			bounds.y = 0;
			bounds.width = 0;
			bounds.height = 0;
				}
		
	//	graphic.setColor(Color.red);
	//	graphic.fillRect((int) (x+bounds.x-handler.getGameCamera().getxOffSet()), (int) (y+bounds.y-handler.getGameCamera().getyOffSet()), bounds.width, bounds.height);
	}

	
	public void checkDefeat()
	{
		/*This method will be used to set
		 * defeated to true if the player
		 * lands on top of the enemy
		 */
		
		if(checkEntityCollisions(1,-3))
		{
			
			defeated = true;
		
		}
	}

	public  void moveBounds()
	{
		int tx = (int) (x + xMove + bounds.x + bounds.width) / Tiles.TILE_WIDTH;
		int tx2 = (int) (x + xMove + bounds.x) / Tiles.TILE_WIDTH;
		

			
			if(isMovingRight())
			{
		if(!collision(tx, (int)(y+bounds.y) / Tiles.TILE_HEIGHT) && !collision(tx, (int)(y+bounds.y + bounds.height) / Tiles.TILE_HEIGHT))
		{
			if(!checkEntityCollisions(xMove, 0f))
			{
			x+=xMove;
			}
			else if(checkEntityCollisions(-xMove, 0f))
			{
				x-=xMove;
				movingRight = false;
			}
		}
		else 
			movingRight = false;
		
			}
			
			
		if(!isMovingRight())
		{
		
			if(!collision(tx2, (int)(y+bounds.y) / Tiles.TILE_HEIGHT) && !collision(tx2, (int)(y+bounds.y + bounds.height) / Tiles.TILE_HEIGHT))
			{
			if(!checkEntityCollisions(-xMove, 0f))
			{
				
			
				x-=xMove;
			}
			else if(checkEntityCollisions(xMove, 0f))
			{
				x+=xMove;
				movingRight = true;
			}
			
			}
		else
			
			movingRight = true;
		}
		
		
		
		
	
		
		

	}
	


	private boolean isMovingRight() 
	{
		return movingRight;
	}

	private void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public void move()
	{
		x+= xMove;
		if(mvStart == false)
		{
		
			mvStart = true;
			new Thread(new mvThread()).start();
		}
		
	}

	
	public class mvThread implements Runnable
	{

		@Override
		public void run() {
			while(true)
			{
			try {
				xMove = speed;
				Thread.sleep(7500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			
			
			try 
			{
				xMove = -speed;
				Thread.sleep(7500);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		  }
		}
		
	}


	@Override
	public void hudRender(Graphics graphic) {
		// TODO Auto-generated method stub
		
	}
	
	
	private boolean isDefeated() {
		return defeated;
	}

	private void setDefeated(boolean defeated) {
		this.defeated = defeated;
	}
	

}
