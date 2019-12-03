package dev.oop.game.gfx;

import java.awt.image.BufferedImage;

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


public class Animation 
{
	private int indexSpeed;
	private int index;
	private BufferedImage[] frames;
	
	private long lastTime;
	private long timer;
	
	public Animation(int indexSpeed, BufferedImage[] frames)
	{
		/*this method will serve
		 * as a constructor for the animation
		 * class
		 */
		
		this.indexSpeed = indexSpeed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public BufferedImage setIndex(int index)
	{
		return frames[index];
	}
	
	public void tick()
	{
		/*This method will serve 
		 * to update the current animation frame
		 * 
		 */
		
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > indexSpeed)
		{
			index++;
			timer =0;
			
			if(index >= frames.length)
				index =0;
		}
	}
	
	public BufferedImage getCurrentFrame()
	{
		return frames[index];
	}
}
