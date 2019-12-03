package dev.oop.game.gfx;

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

public class SpriteSheet 
{
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet)
	{
		/*This method will serve as a constructor 
		 * for the sprite sheet class
		 */
		this.sheet = sheet;
	}
	
	
	public BufferedImage crop(int x, int y, int width, int height)
	{
		/*This method will serve to crop a 
		 * sprite sheet
		 * @return sheet
		 */
		return sheet.getSubimage(x, y, width, height);
	}
}
