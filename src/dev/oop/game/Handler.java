package dev.oop.game;

import dev.oop.game.PowerUps.PowerUpManager;
import dev.oop.game.entities.Entity;
import dev.oop.game.entities.EntityManager;
import dev.oop.game.gfx.GameCamera;
import dev.oop.game.input.KeyManager;
import dev.oop.game.input.MouseManager;
import dev.oop.game.world.World;
import dev.oop.interf.UI;
import dev.oop.states.State;

public class Handler 
{
	private Game game;
	private World world;
	private Entity entity;
	private EntityManager entityManager;
	private MouseManager mouseManager;
	private State state;
	


	private PowerUpManager puManager;






	public Handler(Game game)
	{
		/*This method will serve as the constructor 
		 * for the handler class
		 */
		this.game = game;
		
	}
	
	
	/*Getters and setters for
	 * basic operations
	 */
	
	public State getState() {
		return state;
	}




	private PowerUpManager getPuManager() {
		return puManager;
	}


	private void setPuManager(PowerUpManager puManager) {
		this.puManager = puManager;
	}

	
	private Entity getEntity() {
		return entity;
	}


	private void setEntity(Entity entity) {
		this.entity = entity;
	}

	
	public GameCamera getGameCamera()
	{
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager()
	{
		return game.getKeyManager();
	}
	public MouseManager getMouseManager() 
	{
		return game.getMouseManager();
	}


	private void setMouseManager(MouseManager mouseManager) {
		this.mouseManager = mouseManager;
	}


	
	public UI getUi()
	{
		return game.getUi();
	}

	public int getWidth()
	{
		return game.getWidth();
		
	}
	

	public EntityManager getEntityManager() {
		return entityManager;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public int getHeight()
	{
		return game.getHeight();
	}
	
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
