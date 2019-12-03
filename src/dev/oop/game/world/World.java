package dev.oop.game.world;

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
import dev.oop.game.utils.*;
import dev.oop.game.Game;
import dev.oop.game.Handler;
import dev.oop.game.Characters.Knight;
import dev.oop.game.Characters.PurpleSkull;
import dev.oop.game.PowerUps.PowerUpManager;
import dev.oop.game.entities.Door;
import dev.oop.game.entities.EntityManager;
import dev.oop.game.tile.Tiles;

public class World 
{
	private Handler handler;
	private int width, height;
	public static final int floorHeight = 600;
	private int[][] tiles;
	private static float spawnX;
	private static float spawnY;
	private EntityManager entityManager;
	private PowerUpManager puManager;
	

	
	public int getWidth() {
		return width;
	}





	public void setWidth(int width) {
		this.width = width;
	}





	public int getHeight() {
		return height;
	}





	public void setHeight(int height) {
		this.height = height;
	}




	
	public static float getSpawnX() 
	{
		return spawnX;
		
		
    }





	public void setSpawnX(float spawnX) {
		this.spawnX = spawnX;
	}





	public static float getSpawnY() {
		return spawnY;
	}





	public void setSpawnY(float spawnY) {
		this.spawnY = spawnY;
	}





	public World(Handler handler, String path)
	{
		/*This method will serve as a constructor 
		 * for the world class.
		 * @args String path
		 */
		
		this.handler = handler;
		
		entityManager = new EntityManager(handler, new Knight(handler, World.getSpawnX(), World.getSpawnY()));
		puManager = new PowerUpManager(handler);
	
		
		loadWorld(path);
		
		entityManager.getKnight().setX(spawnX);
		entityManager.getKnight().setY(spawnY);
		
	}
	
	
	
	
	
	public void tick()
	{
		/*This method will update position
		 * of tiles
		 */
		entityManager.tick();
		puManager.tick();
	}
	
	
	
	
	public void render(Graphics graphic)
	{
		/*this method will render
		 * the tiles to the screen
		 */
		
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffSet())/ Tiles.TILE_WIDTH;
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffSet() + handler.getWidth())/ Tiles.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffSet())/ Tiles.TILE_HEIGHT;;
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffSet() + handler.getHeight())/ Tiles.TILE_HEIGHT + 1);
		for(int y = yStart; y<yEnd; y++)
		{
		
			for(int x = xStart; x < xEnd; x++)
			{
			getTile(x,y).render(graphic,(int)(x*Tiles.TILE_WIDTH - handler.getGameCamera().getxOffSet()),(int)(y*Tiles.TILE_WIDTH - handler.getGameCamera().getyOffSet()));			
			}
		}
		
		
		entityManager.render(graphic);
		puManager.render(graphic);
		
	}
	

	
	public PowerUpManager getPuManager() {
		return puManager;
	}





	private void setPuManager(PowerUpManager puManager) {
		this.puManager = puManager;
	}





	public Tiles getTile(int x, int y)
	{
		/*This method will serve to return
		 * the value of a tile at a given
		 * position in the 2d array
		 */
		
		if(x<0 || y < 0 || x >= width || y >=height)
		{
			return Tiles.groundBlockOne;
		}
		Tiles t = Tiles.tiles[tiles[x][y]];
		if(t == null)
		{
			return Tiles.groundBlockOne;
		}
		
		return t;
	}
	
	
	
	private void loadWorld(String path)
	{
		/*This method will 
		 * load the world
		 * @args String path
		 */
		String file = Util.loadFileToString(path);
		String[] tokens = file.split("\\s+");
		width = Util.parseInt(tokens[0]);
		height = Util.parseInt(tokens[1]);
		spawnX = Util.parseInt(tokens[2]);
		spawnY = Util.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x <width; x++)
			{
				tiles[x][y] = Util.parseInt(tokens[(x+y * width) + 4]);
			}
		}
		
	}





	public EntityManager getEntityManager() {
		return entityManager;
	}





	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
