package dev.oop.game.Characters;

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

import java.util.Timer;
import java.util.TimerTask;

import dev.oop.game.Handler;
import dev.oop.game.entities.Entity;
import dev.oop.game.tile.Tiles;

public abstract class Enemy extends Entity 
{
	protected int health;
	protected int attack;
	protected int defense;
	protected float speed;
	protected float xMove;
	protected boolean direction;
	public boolean mvStart;
	Timer timer;

	public Enemy(Handler handler, float x, float y, int width, int height) 
	{
		super(handler, x, y, width, height);
		
		health = 200;
		attack = 30;
		defense = 60;
		speed = 1f;
		speed= .08f;
		xMove = speed;
		mvStart = false;
		direction = false;
	}
	

		

		


	
	protected boolean collision(int x, int y)
	{
		/*This method will be used
		 * to check for collision
		 * 
		 */
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
