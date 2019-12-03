package dev.oop.Menu;

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

import java.awt.Color;


import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import dev.oop.game.Handler;
import dev.oop.game.gfx.Assets;
import dev.oop.game.input.MouseManager;
import dev.oop.states.State;

public class Menu extends State
{


	private Rectangle play;
	private Rectangle info;
	private Rectangle exit;
	

	public Menu(Handler handler)
	{
		/*this method will serve as a constructor for 
		 * the menu class.
		 */
		super(handler);
		
		play = new Rectangle((((handler.getGame().getWidth() / 2) / 2) + 10), 200, 400,100);
		info = new Rectangle((((handler.getGame().getWidth() / 2) / 2) + 10), 300, 400,100);
		exit = new Rectangle((((handler.getGame().getWidth() / 2) / 2) + 10), 400, 400,100);

	}
	
	
	
	
	
	public void tick()
	{
		mouseCheck();
	}
	
	
	
	public void render(Graphics graphic)
	{
		

		
		
		Graphics2D g2d = (Graphics2D) graphic;
		
		Font menuFont = new Font("Arial", Font.BOLD, 50);
		
		graphic.setFont(menuFont);
		graphic.setColor(Color.CYAN);
		
		graphic.drawString("Sprite Mania", ((handler.getGame().getWidth() / 2) / 2) + 25, 100);
		graphic.setColor(Color.WHITE);
		graphic.drawString("PLAY", play.x +130, play.y + 70);
		graphic.drawString("INFO", info.x +130, info.y + 70);
		graphic.drawString("EXIT", exit.x +130, exit.y + 70);

		
		g2d.draw(play);
		g2d.draw(info);
		g2d.draw(exit);
		graphic.drawImage(Assets.greenP, 5,5,50,50, null);
		graphic.drawImage(Assets.playBtn,play.x +50, play.y + 20,50,50, null);

		graphic.drawImage(Assets.infoBtn,  info.x +50,info.y + 20,50,50, null);



	}


	private void mouseCheck()
	{
	if(handler.getMouseManager().isPlay())
	{
		State.setState(handler.getGame().getGameState());
	
	}
	
	if(handler.getMouseManager().isInfo())
	{
		State.setState(handler.getGame().getInfoState());
	
	}
	}





}
