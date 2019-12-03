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

import java.awt.Color;
import java.awt.Graphics;

import dev.oop.game.Game;
import dev.oop.game.Handler;
import dev.oop.game.PowerUps.PowerUps;
import dev.oop.game.entities.Entity;
import dev.oop.game.gfx.Animation;
import dev.oop.game.gfx.Assets;
import dev.oop.game.tile.Tiles;
import dev.oop.game.world.World;

public class Knight extends Character
{
	

	private Animation moveRight;
	private Animation moveLeft;
	private Animation jump;
	private Animation hud;
	private Animation dmg;
	private Animation attack;
	private boolean KO;
	private boolean attacking;
	private boolean takingDamage;
	private boolean walking;
	private boolean speedBuffed;
	


	private boolean isFacingRight;
	private boolean animating = false;
	

	public Knight(Handler handler, float x, float y)
	{
		/*This method will serve as the
		 * constructor for the knight
		 * class
		 */
		super(handler, x, y, Character.DEFAULT_CHAR_WIDTH, Character.DEFAULT_CHAR_HEIGHT);
		
		bounds.x = 10;
		
		bounds.y = 19;
		
		bounds.height = 40;
		bounds.width = 40;
		
		takingDamage = false;
		attacking = false;
		KO = false;
		walking = false;
		speedBuffed = false;
		
		moveRight = new Animation(100, Assets.knight_Right);
		moveLeft = new Animation(100, Assets.knight_Left);
		jump = new Animation(100, Assets.jump);
		hud = new Animation(500, Assets.healthBar);
		dmg = new Animation(200, Assets.dmg);
		attack = new Animation(100,Assets.knightAttack);
	}

	private boolean isAnimating() {
		return animating;
	}

	private void setAnimating(boolean isAnimating) {
		this.animating = animating;
	}

	@Override
	public void tick() 
	{
		boostCheck();
		getInput();
		healthCheck();
		moveRight.tick();
		moveLeft.tick();
		jump.tick();
		move(); 
	    handler.getGameCamera().centerOnChar(this);
	}
	
	@Override
	public void render(Graphics graphic) 
	{
		
		if(((checkEntityCollisions(xMove,0f) || checkEntityCollisions(0f,yMove))) && (!isWalking() && !isAnimating()))
		{
			graphic.drawImage(dmg.getCurrentFrame(),(int) (x-handler.getGameCamera().getxOffSet()), (int) (y-handler.getGameCamera().getyOffSet()), width, height, null);
			

			if(!isTakingDamage())
			{
			new Thread(new takingDmg()).start();
			}
		}
		

		if(isAnimating())
		{
			graphic.drawImage(jump.getCurrentFrame(),(int) (x-handler.getGameCamera().getxOffSet()), (int) (y-handler.getGameCamera().getyOffSet()), width, height, null);
		}
		
	
		else if((xMove > 0))
		{
			if(isJumping() && (!isAnimating() && !isTakingDamage()))
			{
				walking = true;
				graphic.drawImage(jump.getCurrentFrame(),(int) (x-handler.getGameCamera().getxOffSet()), (int) (y-handler.getGameCamera().getyOffSet()), width, height, null);
			}
			else if(!isJumping() && !isTakingDamage())
	         graphic.drawImage(moveRight.getCurrentFrame(),(int) (x-handler.getGameCamera().getxOffSet()), (int) (y-handler.getGameCamera().getyOffSet()), width, height, null);
		}
		else  if((xMove < 0))
		{
			
			if(isJumping() && (!isAnimating() && !isTakingDamage()))
			{
				walking = true;
				graphic.drawImage(jump.getCurrentFrame(),(int) (x-handler.getGameCamera().getxOffSet()), (int) (y-handler.getGameCamera().getyOffSet()), width, height, null);
			}
			else
			graphic.drawImage(moveLeft.getCurrentFrame(),(int) (x-handler.getGameCamera().getxOffSet()), (int) (y-handler.getGameCamera().getyOffSet()), width, height, null);
		}
		
		else if(isJumping() && (!isAnimating() && !isTakingDamage()))
		{
			graphic.drawImage(jump.getCurrentFrame(),(int) (x-handler.getGameCamera().getxOffSet()), (int) (y-handler.getGameCamera().getyOffSet()), width, height, null);
		}
		


		
		else if(isFacingRight == true && !isTakingDamage()) 
		{
			graphic.drawImage(Assets.knightRightStanding,(int) (x-handler.getGameCamera().getxOffSet()), (int) (y-handler.getGameCamera().getyOffSet()), width, height, null);
		}
		
		else if(isFacingRight == false && !isTakingDamage())
		{
			graphic.drawImage(Assets.knightLeftStanding,(int) (x-handler.getGameCamera().getxOffSet()), (int) (y-handler.getGameCamera().getyOffSet()), width, height, null);
		}


		
		walking = false;
		//graphic.setColor(Color.blue);
		//graphic.fillRect((int) (x+bounds.x-handler.getGameCamera().getxOffSet()), (int) (y+bounds.y-handler.getGameCamera().getyOffSet()), bounds.width, bounds.height);
	}
	
	
	
	
	private boolean isWalking() {
		return walking;
	}

	private void setWalking(boolean walking) {
		this.walking = walking;
	}

	private void healthCheck()
	{
		/*This method will serve to check 
		 * if the player has been damaged.
		 */
		if((checkEntityCollisions(xMove,0f) || checkEntityCollisions(0f,-speed)))
		{
		if(!isTakingDamage())
		{
			if(health <= 0)
			{
				health = 0;
			}
			
			else
				health -= 8;
		}
		}
	}
	
	private void boostCheck()
	{
		/*This method will be used
		 * to check if any stat buffs need to be 
		 * implemented every tick.
		 */
	
		checkPuCollisions(xMove,0f);
		checkPuCollisions(0f,yMove);
	}

	
	
	
	protected void healthHUD(Graphics graphic)
	{
		
		
		if(getHealth() > 182 && getHealth() < 201)
		{
		graphic.drawImage(hud.setIndex(0),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		else if(getHealth() > 150 && getHealth() < 181)
		{
			graphic.drawImage(hud.setIndex(1),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		else if(getHealth() > 130 && getHealth() < 150)
		{
			graphic.drawImage(hud.setIndex(2),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		else if(getHealth() > 110 && getHealth() < 130)
		{
			graphic.drawImage(hud.setIndex(3),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		else if(getHealth() > 80 && getHealth() < 110)
		{
			graphic.drawImage(hud.setIndex(4),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		else if(getHealth() > 60 && getHealth() < 80)
		{
			graphic.drawImage(hud.setIndex(5),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		else if(getHealth() > 40 && getHealth() < 60)
		{
			graphic.drawImage(hud.setIndex(6),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		else if(getHealth() > 30 && getHealth() < 40)
		{
			graphic.drawImage(hud.setIndex(7),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		else if(getHealth() > 20 && getHealth() < 30)
		{
			graphic.drawImage(hud.setIndex(8),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		
		else if(getHealth() > 10 && getHealth() < 20)
		{
			graphic.drawImage(hud.setIndex(9),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		else if(getHealth() <= 0)
		{
			health = 0;
		graphic.drawImage(hud.setIndex(10),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
	}
	
	
	
	
	protected void death()
	{
		KO = true;
	}
	
	protected boolean isKO()
	{
		return KO;
	}
	
	private boolean isTakingDamage() 
	{
		return takingDamage;
	}

	private void setTakingDamage(boolean takingDamage) 
	{
		this.takingDamage = takingDamage;
	}
	
	

	
	private synchronized void getInput()
	{
		xMove = 0;
		
		if(handler.getKeyManager().space)
		{

			if(!isAttacking())
			{
				attacking = true;
				new Thread(new attackingT()).start();
			}
		}
		
		
		if(handler.getKeyManager().up)
		{

if(!isJumping())
{
        new Thread(new thread()).start();
        if(!isAnimating())
        {
        	new Thread(new animationThread()).start();
        }
}
		}
		
		if(handler.getKeyManager().down)
		{
			//yMove = +speed;
		}
		
		if(handler.getKeyManager().left)
		{
			isFacingRight = false;
			xMove = -speed;
		}
		
		if(handler.getKeyManager().right)
		{
			isFacingRight = true;
			xMove = +speed;
		}
		
	}
	
	
	public boolean checkPuCollisions(float xOffset, float yOffset)
	{
		/*This method will be used to
		 * check for collisions with powerups
		 * @args1 float xOffset
		 * @args2 float yOffset
		 */
		if(!isSpeedBuffed())
		{
		for(PowerUps powerUp : handler.getWorld().getPuManager().getPowerUp())
		{

			if(powerUp.getCollisionbounds(0f, 0f).intersects(getCollisionbounds(xOffset,yOffset)))
					{
				
				if(powerUp == handler.getWorld().getPuManager().getSpeedUp())
				{
					new Thread(new speedBoost()).start();
				}
					
					}
		}
		}
		return false;
		
	}



public class thread implements Runnable
{
	@Override
	public void run()
	{
		try 
		{
			jumping = true;
			yMove = -jumpStrength;
			Thread.sleep(jumpTime);
			yMove = jumpStrength;

		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

public class animationThread implements Runnable
{
	@Override
	public void run()
	{
		try
		{
			animating = true;
			Thread.sleep(580);
			animating = false;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

public class takingDmg implements Runnable
{
	/*this method will set an index timer
	 * for when the character is taking 
	 * damage.
	 */
	@Override
	public void run()
	{
	
		try {
			takingDamage = true;
	//System.out.println(health);
			Thread.sleep(6000);
			takingDamage = false;
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}

public class attackingT implements Runnable
{
	@Override
	public void run()
	{
		try {
		
			Thread.sleep(1000);
			attacking = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


public class speedBoost implements Runnable
{
	/*This method will be used to start
	 * the timer for the speed boost
	 */
	@Override
	public void run()
	{
		
		try {
			speed+=.20;
			speedBuffed = true;
			Thread.sleep(15000);
			speed -=.20;
			speedBuffed = false;
		} catch (InterruptedException e) {
			System.out.println("Speed boost failed to implement.");
			e.printStackTrace();
		}
	}
}

private boolean isAttacking() {
	/*This method will serve to check whether
	 * or not the player is attacking.
	 */
	return attacking;
}

private void setAttacking(boolean isAttacking) {
	this.attacking = attacking;
}




@Override
public void hudRender(Graphics graphic) 

{
	/*This method will serve to check
	 * for collisions with enemy entities
	 * and update the characters health 
	 * accordingly. It will also start a
	 * thread that will set a timer for
	 * a taking dmg buffer
	 */

		
		
		if(getHealth() > 182 && getHealth() < 201)
		{
		graphic.drawImage(hud.setIndex(0),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		else if(getHealth() > 150 && getHealth() < 181)
		{
			graphic.drawImage(hud.setIndex(1),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		else if(getHealth() > 120 && getHealth() < 150)
		{
			graphic.drawImage(hud.setIndex(2),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		else if(getHealth() > 100 && getHealth() < 120)
		{
			graphic.drawImage(hud.setIndex(3),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		else if(getHealth() > 60 && getHealth() < 100)
		{
			graphic.drawImage(hud.setIndex(4),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		else if(getHealth() > 40 && getHealth() < 60)
		{
			graphic.drawImage(hud.setIndex(5),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		else if(getHealth() > 10 && getHealth() < 30)
		{
			graphic.drawImage(hud.setIndex(6),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
		else
		{
			health = 0;
		graphic.drawImage(hud.setIndex(7),(int) (x-handler.getGameCamera().getxOffSet()), (int) ((y-handler.getGameCamera().getyOffSet()) -20), 100, 10, null);
		}
		
	}
	

protected boolean isJumping() 
{
	return jumping;
}

private boolean isSpeedBuffed() {
	return speedBuffed;
}

private void setSpeedBuffed(boolean speedBuffed) {
	this.speedBuffed = speedBuffed;
}



private void setJumping(boolean jumping) {
	this.jumping = jumping;
}
 
}
