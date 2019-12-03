package dev.oop.game.tile;


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


import java.awt.image.BufferedImage;

public class Tiles 
{
	
	public static Tiles[] tiles = new Tiles[300];
	public static Tiles groundBlockOne = new Ground_One(0);
	public static Tiles groundBlockTwo = new Ground_Two(1);
	public static Tiles bGBlockOne = new Back_One(3);
	public static Tiles bGBlockTwo = new Back_Two(4);
	
	public static final int TILE_WIDTH  = 70;
	public static final int TILE_HEIGHT = 70;
	
	
	protected BufferedImage texture;
	
	protected final int id; // for tiles
	
	public Tiles(BufferedImage texture, int id)
	{
		
		/*This class will serve as
		 * a constructor for the 
		 * Tiles() class
		 */
		
		this.texture = texture;
		this.id = id;
		
		
		tiles[id] = this;
			
	}
	
	public void tick()
	{
		/*This method will serve to
		 * update the tile 
		 */
		
	}
	
	
	public void render(Graphics graphic, int x, int y)
	{
		graphic.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	
	public boolean isSolid()
	{
		/*This method will be used to determine if a 
		 * tile is solid.
		 */
		return false;
	}
	
	public int getId()
	{
		/*This method will return
		 * the tiles id
		 */
		return id;
	}
}
