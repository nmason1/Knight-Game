package dev.oop.interf;



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



import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class UI implements KeyListener, MouseListener
{
	private JFrame frame;
	private Canvas canvas;
	private String title;
	private int width;
	private int height;
	
	public UI(String title, int width, int height)
	{
		/*This method will serve as a 
		 * constructor for the method 
		 * UI
		 */
		this.title = title;
		this.width = width;
		this.height = height;
		
		createUI();
	}
	
	private void createUI()
	{
		
		/*This method will serve to intitialize
		 * the UI and all its components
		 * 
		 */
		frame = new JFrame(title);
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		canvas.setBackground(Color.black);
		
		
	
		frame.add(canvas);
		frame.pack();
	}
	
	private String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	private void setWidth(int width) {
		this.width = width;
	}

	private int getHeight() {
		return height;
	}

	private void setHeight(int height) {
		this.height = height;
	}

	private void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public Canvas getCanvas()
	{
		/*This method will be used to
		 * return the canvas
		 */
		return canvas;
	} 
	
	public JFrame getFrame()
	{
		/*This method will
		 *be used to return the
		 *frame
		 */
		
		return frame;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
