package dev.oop.game.entities;

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


import java.awt.Graphics;
import java.util.ArrayList;

import dev.oop.game.Handler;
import dev.oop.game.Characters.Knight;
import dev.oop.game.Characters.PurpleSkull;
import dev.oop.game.PowerUps.PowerUps;
import dev.oop.game.PowerUps.SpeedUp;

public class EntityManager 
{
	private Handler handler;
	private Knight knight;
	private PurpleSkull ps;
	private PurpleSkull ps2;
	private PurpleSkull ps3;
	private PurpleSkull ps4;
	private PurpleSkull ps5;
	private PurpleSkull ps6;


	

	private ArrayList<Entity> entities;
	
	public EntityManager(Handler handler, Knight knight)
	{
		this.handler = handler;
		this.knight = knight;
		ps = new PurpleSkull(handler, 450,335, 80, 80);
		ps2 = new PurpleSkull(handler, 550,335, 80, 80);
		ps3 = new PurpleSkull(handler, 1500,335, 80, 80);
		ps4 = new PurpleSkull(handler, 1500,240, 80, 80);
		ps5 = new PurpleSkull(handler, 2300,270, 80, 80);
		ps6 = new PurpleSkull(handler, 2400,270, 80, 80);


	

		entities= new ArrayList<Entity>();
	
	addEntity(knight);
	addEntity(ps);
	addEntity(ps2);
	addEntity(ps3);
	addEntity(ps4);
	addEntity(ps5);
	addEntity(ps6);



		
	}
	
	public void tick()
	{
		/*This method will be used to tick
		 * every entity in the array list
		 */
		for(int x =0; x < entities.size(); x++)
		{
			Entity entity = entities.get(x);
			entity.tick();
		}
		
		

	}
	
	


	public void render(Graphics graphic)
	{
		
		/*This method will serve to render 
		 * very entity to the screen.
		 */
		for(Entity entity : entities)
		{
			entity.render(graphic);	
			entity.hudRender(graphic);
		
		}
	
	}
	
	public void addEntity(Entity entity)
	{
		/*This method will serve to
		 * add an entity to the array list
		 */
		entities.add(entity);
	}
	
	public void rmvEntity(Entity entity)
	{
		/*This method will serve to 
		 * remove an entity from the array list
		 */
		entities.remove(entity);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<Entity> getEntities() 
	{
		/*This method will be used to
		 * return the arraList of entities
		 */
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public Knight getKnight() {
		return knight;
	}

	public void setKnight(Knight knight) {
		this.knight = knight;
	}
	
	public PurpleSkull getPS() {
		return ps;
	}

	public void setPS(PurpleSkull ps) {
		this.ps = ps;
	}
}
