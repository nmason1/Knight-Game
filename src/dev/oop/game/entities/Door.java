package dev.oop.game.entities;

import java.awt.Graphics;

import dev.oop.game.Handler;
import dev.oop.game.gfx.Assets;
import dev.oop.game.tile.Tiles;

public class Door extends StaticEntity
{

	public Door(Handler handler, float x, float y) 
	{
		/*This method will serve
		 * as a constructor for the Door
		 * class
		 */
		super(handler, x, y, Tiles.TILE_WIDTH, Tiles.TILE_HEIGHT*2);
	
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics graphic) 
	{
		/*This method will serve to
		 * render the door to the
		 * screen
		 */
		graphic.drawImage(Assets.door,(int) (x - handler.getGameCamera().getxOffSet()),(int) (y - handler.getGameCamera().getyOffSet()),width,height, null);
		
	}

	@Override
	public void hudRender(Graphics graphic) {
		// TODO Auto-generated method stub
		
	}

}
