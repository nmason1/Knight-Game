package dev.oop.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dev.oop.game.Handler;

public class MouseManager implements MouseListener
{

	public boolean play;
	private boolean info;
	private boolean[] buttons;
	
	public MouseManager()
	{
		/*This method will serve as a constructor for
		 * the MouseManager class
		 */
		
		buttons = new boolean[256];
		
		play = false;
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

	
	}
	
	public void tick()
	{

	
	}


	public boolean isPlay() {
		return play;
	}

	private void setPlay(boolean play) {
		this.play = play;
	}
	
	public boolean isInfo() {
		return info;
	}

	public void setInfo(boolean info) {
		this.info = info;
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{

		int mX = e.getX();
		int mY = e.getY();
	
		if(e.getButton() == MouseEvent.BUTTON1)
		{
		if(mX >= ((800 / 2) / 2) + 10 && mX <= (((800 / 2) / 2) + 410))
		{
			if(mY >= 200 && mY<=300)
			{
			play = true;
			}
		}
		}
		
		if(e.getButton() == MouseEvent.BUTTON1)
		{
		if(mX >= ((800 / 2) / 2) + 10 && mX <= (((800 / 2) / 2) + 410))
		{
			if(mY >= 300 && mY<=400)
			{
				info = true;
			}
		}
		}
		
		if(e.getButton() == MouseEvent.BUTTON1)
		{
		if(mX >= ((800 / 2) / 2) + 10 && mX <= (((800 / 2) / 2) + 410))
		{
			if(mY >= 400 && mY<=500)
			{
			
				System.exit(0);
			}
		}
		}

		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
