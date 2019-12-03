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
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader 
{
public static BufferedImage loadImage(String image)
{
	try {
		return ImageIO.read(ImageLoader.class.getResource(image));
	} 
	
	catch (IOException e) 
	{
		System.out.println("error: cannot load image!");
		e.printStackTrace();
		System.exit(1);
	}
	return null;
}
}
