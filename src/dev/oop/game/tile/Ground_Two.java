package dev.oop.game.tile;

import java.awt.image.BufferedImage;

import dev.oop.game.gfx.Assets;

public class Ground_Two extends Tiles
{

	public Ground_Two(int id) 
	
	{
		/*This method will serve as a constructor
		 * to the Ground_Two class for the
		 * tile 
		 */
		super(Assets.groundBlockTwo, id);
	
	}
	
	@Override
	public boolean isSolid()
	{
		return true;
	}

}
