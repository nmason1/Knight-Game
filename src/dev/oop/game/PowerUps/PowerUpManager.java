package dev.oop.game.PowerUps;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.oop.game.Handler;
import dev.oop.game.Characters.Knight;
import dev.oop.game.Characters.PurpleSkull;
import dev.oop.game.entities.Entity;

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

public class PowerUpManager 
{
	
	
	private Handler handler;
	private PowerUps speedUp;

	private ArrayList<PowerUps> powerUp;
	
	public PowerUpManager(Handler handler)
	
	{
		/*This method will serve as a constructor
		 * for the power up class.
		 */
		
		
		
		this.handler = handler;
		speedUp = new SpeedUp(handler, 1080, 300, 50, 50);

		powerUp = new ArrayList<PowerUps>();
		
		powerUp.add(speedUp);
	}
	
	
	
	public void tick()
	{
		/*This method will be used to tick
		 * every entity in the array list
		 */
		for(int x =0; x < powerUp.size(); x++)
		{
			PowerUps power = powerUp.get(x);
			power.tick();
		}
		
		

	}
	
	public void render(Graphics graphic)
	{
		
		/*This method will serve to render 
		 * very entity to the screen.
		 */
		for(PowerUps power : powerUp)
		{
			power.render(graphic);	
		
		
		}
	
	}
	
	public void addPowerUp(PowerUps power)
	{
		/*This method will serve to
		 * add an entity to the array list
		 */
		powerUp.add(power);
	}
	
	public void rmvPowerUp(PowerUps power)
	{
		/*This method will serve to 
		 * remove an entity from the array list
		 */
		powerUp.remove(power);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<PowerUps> getPowerUp() 
	{
		/*This method will be used to
		 * return the arraList of entities
		 */
		return powerUp;
	}
	
	public PowerUps getSpeedUp() 
	{
		/*This method will be used to
		 * return the arraList of entities
		 */
		return speedUp;
	}

	public void setPowerUps(ArrayList<PowerUps> power) {
		this.powerUp = power;
	}

}
