package dev.oop.Info;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import dev.oop.game.Handler;
import dev.oop.states.State;

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

public class Info extends State
{
	
	private String helperText1 = "This is a short Demo game where you will fight";
	private String helperText2 = "as a knight against the King Skull. Free roam enabled :D";
	private String helperText3 = "To defeat enemies jump on top of them.";
	private String helperText4 = "The green flask is a spped boost power up!";


	private Rectangle back;

	public Info(Handler handler) 
	{
		super(handler);
		back = new Rectangle((((handler.getGame().getWidth() / 2) / 2) + 100), 400, 100,50);

	}

	@Override
	public void tick() 
	{
		
	}

	@Override
	public void render(Graphics graphic) 
	{
		Graphics2D g2d = (Graphics2D) graphic;

		
		Font infoFont = new Font("Arial", Font.PLAIN, 50);
		Font subText = new Font("Arial", Font.ITALIC, 20);

		
		graphic.setFont(infoFont);
		graphic.setColor(Color.white);

		graphic.drawString("-----THE A-TEAM-----", ((handler.getGame().getWidth() / 2) / 2) + 10, 100);
		
		graphic.setFont(subText);
		
		graphic.drawString("Nick Mason J.r", ((handler.getGame().getWidth() / 2) / 2) + 10, 150);
		
		graphic.drawString("Angelica Everett", ((handler.getGame().getWidth() / 2) / 2) + 10, 200);
		
		graphic.drawString("Sebastion Raggio", ((handler.getGame().getWidth() / 2) / 2) + 10, 250);
		
		graphic.drawString(helperText1, 100, 300);

		graphic.drawString(helperText2, 100, 320);
		
		graphic.drawString(helperText3, 100, 340);
		
		graphic.drawString(helperText4, 100, 360);


		
		//g2d.draw(back);
		
	//	graphic.drawString("back", ((handler.getGame().getWidth() / 2) / 2) + 125, 432);

		
	}

}
