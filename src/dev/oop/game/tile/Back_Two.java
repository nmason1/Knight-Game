package dev.oop.game.tile;

import dev.oop.game.gfx.Assets;

public class Back_Two extends Tiles
{
	public Back_Two(int id)
	{
		/*This method will serve as a constructor for 
		 * the Back_One tile class
		 */
		
		super(Assets.backGroundTwo, id);
	}
	
	@Override
	public boolean isSolid()
	{
		return false;
	}
}
