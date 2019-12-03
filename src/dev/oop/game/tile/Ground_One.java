package dev.oop.game.tile;


import java.awt.image.BufferedImage;

import dev.oop.game.gfx.Assets;

public class Ground_One extends Tiles
{

	public Ground_One(int id) 
	{
		super(Assets.groundBlockOne, id);
	}
	
	
	@Override
	public boolean isSolid()
	{
		return true;
	}


}
