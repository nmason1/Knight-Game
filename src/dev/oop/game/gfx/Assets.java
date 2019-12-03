package dev.oop.game.gfx;

import java.awt.image.BufferedImage;

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



public class Assets 
{
	public static BufferedImage[] knight_Right;
	public static BufferedImage[] knight_Left;
	public static BufferedImage[] jump;
	public static BufferedImage[] dmg;
	public static BufferedImage[] healthBar;
	public static BufferedImage[] knightAttack;
	public static BufferedImage playBtn;
	public static BufferedImage infoBtn;
	public static BufferedImage knightRightStanding;
	public static BufferedImage knightLeftStanding;
	public static BufferedImage mage;
	public static BufferedImage Rogue;
	public static BufferedImage[] psLeft;
	public static BufferedImage[] psRight;
	public static BufferedImage groundBlockOne;
	public static BufferedImage groundBlockTwo;
	public static BufferedImage groundBlockThree;
	public static BufferedImage groundBlockFour;
	public static BufferedImage groundBlockFive;
	public static BufferedImage backGroundOne;
	public static BufferedImage backGroundTwo;
	public static BufferedImage backColumn;
	public static BufferedImage backColumnOne;
	public static BufferedImage backColumnTwo;
	public static BufferedImage door;
	public static BufferedImage greenP;
	
	public static void init()
	{
		//LevelDesignSheet 
		
		/*This method will serve to initialize the
		 * sprite sheets and crop assets
		 * 
		 */
		SpriteSheet play = new SpriteSheet(ImageLoader.loadImage("/res/play.png"));
		SpriteSheet info = new SpriteSheet(ImageLoader.loadImage("/res/info.png"));
		
		SpriteSheet levelFront = new SpriteSheet(ImageLoader.loadImage("/res/inca_front.png"));
		
		SpriteSheet levelBack = new SpriteSheet(ImageLoader.loadImage("/res/inca_back2.png"));
		
		SpriteSheet standRight = new SpriteSheet(ImageLoader.loadImage("/res/knight.png"));
		
		SpriteSheet standLeft = new SpriteSheet(ImageLoader.loadImage("/res/knightleft.png"));
		
		SpriteSheet levelBack2 = new SpriteSheet(ImageLoader.loadImage("/res/inca_back.png"));
		
		SpriteSheet purpleSkull = new SpriteSheet(ImageLoader.loadImage("/res/ps.png"));
		
		SpriteSheet damage1 = new SpriteSheet(ImageLoader.loadImage("/res/hurt1.png"));
		SpriteSheet damage2 = new SpriteSheet(ImageLoader.loadImage("/res/hurt2.png"));
		SpriteSheet damage3 = new SpriteSheet(ImageLoader.loadImage("/res/hurt3.png"));

		SpriteSheet damage4 = new SpriteSheet(ImageLoader.loadImage("/res/hurt4.png"));
		
		SpriteSheet knightSwipe1 = new SpriteSheet(ImageLoader.loadImage("/res/attack0.png"));
		SpriteSheet knightSwipe2 = new SpriteSheet(ImageLoader.loadImage("/res/attack1.png"));
		
		SpriteSheet greenPotion = new SpriteSheet(ImageLoader.loadImage("/res/green.png"));
		
		SpriteSheet knightSwipe3 = new SpriteSheet(ImageLoader.loadImage("/res/attack2.png"));

		SpriteSheet knightSwipe4 = new SpriteSheet(ImageLoader.loadImage("/res/attack4.png"));

		
		SpriteSheet damage5 = new SpriteSheet(ImageLoader.loadImage("/res/hurt1.png"));
		SpriteSheet damage6 = new SpriteSheet(ImageLoader.loadImage("/res/hurt2.png"));
		SpriteSheet damage7 = new SpriteSheet(ImageLoader.loadImage("/res/hurt3.png"));
		SpriteSheet damage8 = new SpriteSheet(ImageLoader.loadImage("/res/hurt4.png"));
		SpriteSheet damage9 = new SpriteSheet(ImageLoader.loadImage("/res/hurt1.png"));
		SpriteSheet damage10 = new SpriteSheet(ImageLoader.loadImage("/res/hurt2.png"));
		SpriteSheet damage11 = new SpriteSheet(ImageLoader.loadImage("/res/hurt3.png"));
		SpriteSheet damage12 = new SpriteSheet(ImageLoader.loadImage("/res/hurt4.png"));
		SpriteSheet damage13 = new SpriteSheet(ImageLoader.loadImage("/res/hurt4.png"));
		

		
		SpriteSheet run0 = new SpriteSheet(ImageLoader.loadImage("/res/run1.png"));
		SpriteSheet run1 = new SpriteSheet(ImageLoader.loadImage("/res/run2.png"));
		SpriteSheet run2 = new SpriteSheet(ImageLoader.loadImage("/res/run3.png"));
		SpriteSheet run3 = new SpriteSheet(ImageLoader.loadImage("/res/run4.png"));
		SpriteSheet run4 = new SpriteSheet(ImageLoader.loadImage("/res/run5.png"));
		SpriteSheet run5 = new SpriteSheet(ImageLoader.loadImage("/res/run6.png"));
		SpriteSheet run6 = new SpriteSheet(ImageLoader.loadImage("/res/run7.png"));
		SpriteSheet run7 = new SpriteSheet(ImageLoader.loadImage("/res/run8.png"));
	
		
		
		
		SpriteSheet run0Left = new SpriteSheet(ImageLoader.loadImage("/res/run1left.png"));
		SpriteSheet run1Left = new SpriteSheet(ImageLoader.loadImage("/res/run2left.png"));
		SpriteSheet run2Left = new SpriteSheet(ImageLoader.loadImage("/res/run3left.png"));
		SpriteSheet run3Left = new SpriteSheet(ImageLoader.loadImage("/res/run4left.png"));
		SpriteSheet run4Left = new SpriteSheet(ImageLoader.loadImage("/res/run5left.png"));
		SpriteSheet run5Left = new SpriteSheet(ImageLoader.loadImage("/res/run6left.png"));
		SpriteSheet run6Left = new SpriteSheet(ImageLoader.loadImage("/res/run7left.png"));
		SpriteSheet run7Left = new SpriteSheet(ImageLoader.loadImage("/res/run8left.png"));
		
		SpriteSheet jump0 = new SpriteSheet(ImageLoader.loadImage("/res/jump1.png"));
		SpriteSheet jump1 = new SpriteSheet(ImageLoader.loadImage("/res/jump2.png"));
		SpriteSheet jump2 = new SpriteSheet(ImageLoader.loadImage("/res/jump3.png"));
		SpriteSheet jump3 = new SpriteSheet(ImageLoader.loadImage("/res/jump4.png"));
		SpriteSheet jump4 = new SpriteSheet(ImageLoader.loadImage("/res/jump5.png"));
		SpriteSheet jump5 = new SpriteSheet(ImageLoader.loadImage("/res/jump6.png"));
		SpriteSheet jump6 = new SpriteSheet(ImageLoader.loadImage("/res/jump7.png"));
		SpriteSheet hp = new SpriteSheet(ImageLoader.loadImage("/res/healthBar.png"));

		
		
		
		
		knight_Right = new BufferedImage[8];
		knight_Left = new BufferedImage[8];
		jump = new BufferedImage[7];
		psRight = new BufferedImage[16];
		healthBar = new BufferedImage[20];
		knightAttack = new BufferedImage[5];
		
		dmg = new BufferedImage[13];
		
		
		knightAttack[0] = knightSwipe1.crop(16,64, 64, 64);

		
		dmg[0] = damage1.crop(20,45,64,64);
		dmg[1] = damage2.crop(20,45,64,64);
		dmg[2] = damage3.crop(20,45,64,64);
		dmg[3] = damage4.crop(20,45,64,64);
		dmg[4] = damage5.crop(20,45,64,64);
		dmg[5] = damage6.crop(20,45,64,64);
		dmg[6] = damage7.crop(20,45,64,64);
		dmg[7] = damage1.crop(20,45,64,64);
		dmg[8] = damage2.crop(20,45,64,64);
		dmg[9] = damage3.crop(20,45,64,64);
		dmg[10] = damage4.crop(20,45,64,64);
		dmg[11] = damage5.crop(20,45,64,64);
		dmg[12] = damage6.crop(20,45,64,64);
		
		knight_Right[0] = run0.crop(20,45,64,64);
		knight_Right[1] = run1.crop(20,45,64,64);
		knight_Right[2] = run2.crop(20,45,64,64);
		knight_Right[3] = run3.crop(20,45,64,64);
		knight_Right[4] = run4.crop(20,45,64,64);
		knight_Right[5] = run5.crop(20,45,64,64);
		knight_Right[6] = run6.crop(20,45,64,64);
		knight_Right[7] = run7.crop(20,45,64,64);
		
		
		knight_Left[0] = run0Left.crop(50,45,64,64);
		knight_Left[1] = run1Left.crop(50,45,64,64);
		knight_Left[2] = run2Left.crop(50,45,64,64);
		knight_Left[3] = run3Left.crop(50,45,64,64);
		knight_Left[4] = run4Left.crop(50,45,64,64);
		knight_Left[5] = run5Left.crop(50,45,64,64);
		knight_Left[6] = run6Left.crop(50,45,64,64);
		knight_Left[7] = run7Left.crop(50,45,64,64);
		
		jump[0] = jump0.crop(20,45,64,64);
		jump[1] = jump1.crop(20,45,64,64);
		jump[2] = jump2.crop(20,45,64,64);
		jump[3] = jump3.crop(20,45,64,64);
		jump[4] = jump4.crop(20,45,64,64);
		jump[5] = jump5.crop(20,45,64,64);
		jump[6] = jump6.crop(20,45,64,64);
		
		
		knightLeftStanding = standLeft.crop(50,45,64,64);
		
		knightRightStanding = standRight.crop(20,45,64,64);
		groundBlockOne = levelFront.crop(96,32, 32,32);
		groundBlockTwo = levelFront.crop(0,40, 32,32);
		groundBlockThree = levelFront.crop(60,32, 32,32);
		groundBlockFour = levelFront.crop(40,32, 32,32);
		groundBlockFive = levelFront.crop(40,96, 32,32);
		backGroundOne = levelBack.crop(128, 0, 32, 32);
		backGroundTwo = levelBack.crop(80, 32, 32, 32);
		door = levelBack2.crop(0, 160, 64, 64);
		
		playBtn = play.crop(0,0, 120, 122);
		infoBtn = info.crop(0, 0, 120, 122);
		
		
		greenP = greenPotion.crop(0, 0, 375, 375);


		
		psRight[0] = purpleSkull.crop(0, 0, 42,42);
		psRight[1] = purpleSkull.crop(42, 0, 42,42);
		psRight[2] = purpleSkull.crop(84, 0, 42,42);
		psRight[3] = purpleSkull.crop(126, 0, 42,42);
		psRight[4] = purpleSkull.crop(0, 42, 42,42);
		psRight[5] = purpleSkull.crop(42, 42, 42,42);
		psRight[6] = purpleSkull.crop(84, 42, 42,42);
		psRight[7] = purpleSkull.crop(126, 42, 42,42);
		psRight[8] = purpleSkull.crop(0, 84, 42,42);
		psRight[9] = purpleSkull.crop(42, 84, 42,42);
		psRight[10] = purpleSkull.crop(84, 84, 42,42);
		psRight[11] = purpleSkull.crop(126, 84, 42,42);
		psRight[12] = purpleSkull.crop(0, 126, 42,42);
		psRight[13] = purpleSkull.crop(42, 126, 42,42);
		psRight[14] = purpleSkull.crop(84, 126, 42,42);
		psRight[15] = purpleSkull.crop(126, 126, 42,42);
	
		
		healthBar[0] = hp.crop(0,64,128,32);
		healthBar[1] = hp.crop(0,64,60,32);
		healthBar[2] = hp.crop(0,64,40,32);
		healthBar[3] = hp.crop(0,64,25,32);
		healthBar[4] = hp.crop(0,64,20,32);
		healthBar[5] = hp.crop(0,64,15,32);
		healthBar[6] = hp.crop(0,64,10,32);
		healthBar[7] = hp.crop(0,64,8,32);
		healthBar[8] = hp.crop(0,64,6,32);
		healthBar[9] = hp.crop(0,64,4,32);
		healthBar[10] = hp.crop(127,64,1,32);
		healthBar[11] = hp.crop(0,64,1,32);
		healthBar[12] = hp.crop(0,64,50,32);
		healthBar[13] = hp.crop(0,64,30,32);
		healthBar[14] = hp.crop(0,64,25,32);
		healthBar[15] = hp.crop(0,64,20,32);
		healthBar[16] = hp.crop(0,64,15,32);
		healthBar[17] = hp.crop(0,64,11,32);
		healthBar[18] = hp.crop(0,64,7,32);
		healthBar[19] = hp.crop(0,64,1,32);
		

		

	}

}
