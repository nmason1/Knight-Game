package dev.oop.states;

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

import java.awt.Graphics;

import dev.oop.game.Game;
import dev.oop.game.Handler;
import dev.oop.game.Characters.Knight;
import dev.oop.game.entities.Door;
import dev.oop.game.gfx.Assets;
import dev.oop.game.tile.Tiles;
import dev.oop.game.world.World;

public class GameState extends State
{
	
	
	private World world;
	
	
	
	public GameState(Handler handler)
	{
		/*This method will serve as a constructor for
		 * the GameStateClass
		 */
		super(handler);
		
		world = new World(handler, "src/res/worldOne.txt");
		
		handler.setWorld(world);
		
	
	
		
		
	
	}

	@Override
	public void tick() {
		/*This method will serve to continuously
		 * update the knight character per frame
		 */
		world.tick();
		
		
		
	}

	@Override
	public void render(Graphics graphic) 
	{
		world.render(graphic);
	
		
		
	}
	
}
