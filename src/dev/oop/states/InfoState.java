package dev.oop.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import dev.oop.Info.Info;
import dev.oop.game.Handler;

public class InfoState extends State
{


	private Info info;
	

	public InfoState(Handler handler) {
		super(handler);
		/*This class will serve as a constructor
		 * for the info state class
		 */
       info = new Info(handler);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics graphic) 
	{
		

		

     info.render(graphic);
		
	
		
	}
}
