package dev.oop.game.tile;

import dev.oop.game.gfx.Assets;

public class Back_One extends Tiles
{
public Back_One(int id)
{
	/*This method will serve as a constructor for 
	 * the Back_One tile class
	 */
	
	super(Assets.backGroundOne, id);
}

@Override
public boolean isSolid()
{
	return false;
}

}
