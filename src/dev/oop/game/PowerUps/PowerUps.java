package dev.oop.game.PowerUps;

import java.awt.Graphics;

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

import dev.oop.game.Handler;
import dev.oop.game.entities.Entity;
import dev.oop.game.gfx.Assets;

public class PowerUps extends Entity
{
	
	private int speed;
	
	
	
	public PowerUps(Handler handler, float x, float y, int width, int height) 
	{
		super(handler, x, y, width, height);
		
	}

	@Override
	public void tick() 
	{
		// TODO Auto-generated method stub	
		
	}

	@Override
	public void hudRender(Graphics graphic) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics graphic) 
	{

	  
		
	}

	private int getSpeed() {
		return speed;
	}

	private void setSpeed(int speed) {
		this.speed = speed;
	}


}
