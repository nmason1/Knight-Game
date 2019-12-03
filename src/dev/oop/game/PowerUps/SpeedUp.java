package dev.oop.game.PowerUps;

import java.awt.Color;
import java.awt.Graphics;

import dev.oop.game.Handler;
import dev.oop.game.Characters.Knight;
import dev.oop.game.entities.EntityManager;
import dev.oop.game.gfx.Assets;

public class SpeedUp extends PowerUps
{
	public boolean acquired;
	private EntityManager entity;
	private Knight knight;
	
	
	public SpeedUp(Handler handler,float x, float y, int width, int height) 
	{
		super(handler, x, y, width, height);
		bounds.x = 5;
		
		bounds.y = 12;
		
		bounds.height = 30;
		bounds.width = 40;
		acquired = false;
		this.knight = knight;
		
	}
	

	
	
	@Override
	public void tick()
	{
		if((checkEntityCollisions(-5,0f) || checkEntityCollisions(0f, 5)))
		{
			acquired = true;

		}

		
	}
	
	@Override
	public void render(Graphics graphic)
	{
		if(!isPickedUp())
		{
		
		 graphic.drawImage(Assets.greenP,(int) (x- handler.getGameCamera().getxOffSet()), (int) (y - handler.getGameCamera().getyOffSet()), width, height, null);
	     //graphic.setColor(Color.red);
	    //graphic.fillRect((int) (x+bounds.x-handler.getGameCamera().getxOffSet()), (int) (y+bounds.y-handler.getGameCamera().getyOffSet()), bounds.width, bounds.height);
		}
		else if(isPickedUp())
		{
		
		}

	}
	

	
	
	public boolean isPickedUp() {
		return acquired;
	}

	private void setPickedUp(boolean acquired) {
		this.acquired = acquired;
	}
	
}
