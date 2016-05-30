package com.mygdx.game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
public class Player extends Creature {
	Class<Knight> KnightClass = Knight.class;
	Class<Barbarian> BarbClass = Barbarian.class;
	Class<Monk> MonkClass = Monk.class;
	Class<Wizard> WizClass = Wizard.class;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//where we are in world space
	float mapX = 0;
	float mapY = 0;

	public void move(float x, float y)
	{
		mapX +=x;
		mapY +=y;
		//float x2 = xPos;
		//float y2 = yPos;
		
		//float newX = x2 += Tile.WIDTH * x;
		//float newY = y2 += Tile.WIDTH * y;
		
		//Tile nTile = MyGdxGame.testDungeon.getTile(newX, newY);
		
		//if (nTile.isCanCollide() == false) {
			xPos += Tile.WIDTH * x;
			yPos += Tile.HEIGHT * y;
			
		//} else {
			
		//}
		
		MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
	}
	
	public void ability1() {
		System.out.println("One");
		
		if (KnightClass.isInstance(MyGdxGame.testPlayer)) {              //Targets for attack skills will be determined in here.
			System.out.println("Stab");
			//determine target
			//MyGdxGame.testPlayer.stab(target goes here);
			
		} else if (BarbClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Chop");
			//determine target
			//MyGdxGame.testPlayer.chop(target goes here);
			
		} else if (MonkClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Jab");
			//determine target
			//MyGdxGame.testPlayer.jab(target goes here);
			
		} else if (WizClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Fireball");
			//determine target
			//MyGdxGame.testPlayer.fireball(targets go here);
			
		} else {
			System.out.println("Error");
		}
	}
	
	public void ability2() {
		System.out.println("Two");
		
		if (KnightClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Shield Bash");
			//determine target
			//MyGdxGame.testPlayer.shieldBash(target goes here);
			
		} else if (BarbClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Cleave");
			//determine target
			//MyGdxGame.testPlayer.cleave(target goes here);
			
		} else if (MonkClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Flurry");
			//determine target
			//MyGdxGame.testPlayer.flurry(target goes here);
			
		} else if (WizClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Ice Lance");
			//determine target
			//MyGdxGame.testPlayer.iceLance(target goes here);
			
		} else {
			System.out.println("Error");
		}
	}
	
	public void ability3() {
		System.out.println("Three");
		
		if (KnightClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Bulwark");
			//MyGdxGame.testPlayer.bulwark();
			
		} else if (BarbClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("To be added");
			//determine target
			//MyGdxGame.testPlayer.cleave(target goes here);
			
		} else if (MonkClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("To be added");
			//determine target
			//MyGdxGame.testPlayer.flurry(target goes here);
			
		} else if (WizClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Teleport");
			//MyGdxGame.testPlayer.Teleport();
			
		} else {
			System.out.println("Error");
		}
	}

	public Player(Texture img) {
		// TODO Auto-generated constructor stub
		this.mapX = 0;
		this.mapY = 0;
		this.img = img;
	}
}
