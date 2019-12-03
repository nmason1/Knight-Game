package dev.oop.game;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.oop.interf.UI;
import dev.oop.states.GameState;
import dev.oop.states.InfoState;
import dev.oop.states.MenuState;
import dev.oop.states.State;
import dev.oop.Menu.Menu;
import dev.oop.game.Characters.Knight;
import dev.oop.game.gfx.*;
import dev.oop.game.input.KeyManager;
import dev.oop.game.input.MouseManager;


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



public class Game implements Runnable
{
	
	private UI ui;
	
	private int width;
	private int height;
	
	


	public String title;
	
	private boolean running = false;
	
	private Thread mainThread;
	
	private BufferStrategy bs;
	
	private Graphics graphic;
	
	
	//States
	public State gameState;
	public State menuState;
	public State infoState;
	//Key Manager
	private KeyManager keyManager;

	//Mouse Manager
	private MouseManager mouseManager;

	//Handler
	
	private Handler handler;
	
	//Camera
	private GameCamera gameCamera;
	
	
	public Game(String title, int width, int height)
	{
		/*This method will serve as a constructor 
		 * for the game class
		 */
		this.height = height;
		this.width = width;		
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	
	







	private void init()
	{
		/*This method will initialize
		 * the user interface
		 */
		ui = new UI(title,width,height);
		
	 	ui.getFrame().addMouseListener(mouseManager);
		ui.getFrame().addKeyListener(keyManager);
		ui.getCanvas().addMouseListener(mouseManager);
	


		Assets.init();
		
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 2,2);

	gameState = new GameState(handler);
	menuState = new MenuState(handler);
	infoState = new InfoState(handler);
	
	State.setState(menuState);
	}
	
	
	
	
	




	private void tick()
	{
		/*This method will serve to 
		 * update the screen/ user input
		 * history
		 */
		
		keyManager.tick();
		mouseManager.tick();
		
	if(State.getState() != null)
		State.getState().tick();
	}
	
	private void render()
	{
		
		/*This method will serve to
		 * draw to canvas
		 */
		bs = ui.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			ui.getCanvas().createBufferStrategy(2);
			return;
		}
		
		graphic = bs.getDrawGraphics();
		//clear screen
		graphic.clearRect(0, 0, width, height);
		
		
		//Draw
		if(State.getState() != null)
	     State.getState().render(graphic);

		bs.show();
		graphic.dispose();
	}
	
	
	public void run()
	{
		/*This will contain the instructions
		 * for the thread to follow
		 */
		init();
		
		int fps = 70;
		
		double timePerTick = 1000000000 / fps;
		
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
        //Game loop
		while(running)
		{
			
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			
			
			lastTime = now; 
			
			if(delta >= 1)
			{
			
			tick();
			render();


			}

		}
		
		stop();
	}
	
	
	public KeyManager getKeyManager()
	{
		/*This method will serve to 
		 * get the keyManager object
		 */
		return keyManager;
	}
	
	public GameCamera getGameCamera()
	{
		/*This method will return
		 * the gameCamera object
		 */
		
		return gameCamera;
	}
	
	public synchronized void start()
	{
		/*This method will start the
		 * mainThread for the Game class
		 */
		if(running)
			return;
		running = true;
		mainThread = new Thread(this);
		mainThread.start();
	}
	
	public synchronized void stop()
	{
		/*This method will stop the main
		 * Thread for the game
		 * class
		 */
		if(!running)
			return;
		running = false;
		try {
			mainThread.join();
		} catch (InterruptedException e) {
			System.out.println("error: Main thread could not be terminated!");
			e.printStackTrace();
		}
	}
	
	
	UI getUi() {
		return ui;
	}
	
	public State getGameState() {
		return gameState;
	}



	private void setGameState(State gameState) {
		this.gameState = gameState;
	}



	public State getInfoState() {
		return infoState;
	}










	public void setInfoState(State infoState) {
		this.infoState = infoState;
	}










	public State getMenuState() {
		return menuState;
	}



	public MouseManager getMouseManager() {
		return mouseManager;
	}



	public void setMouseManager(MouseManager mouseManager) {
		this.mouseManager = mouseManager;
	}



	private void setMenuState(State menuState) {
		this.menuState = menuState;
	}
	
	public int getWidth() 
	{
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

}
