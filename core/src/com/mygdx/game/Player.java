package com.mygdx.game;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
public class Player extends Creature {
	Class<Knight> KnightClass = Knight.class;
	Class<Barbarian> BarbClass = Barbarian.class;
	Class<Monk> MonkClass = Monk.class;
	Class<Wizard> WizClass = Wizard.class;
	
	public static final int RIGHT = 0;
	public static final int UP = 1;
	public static final int LEFT = 2;
	public static final int DOWN = 3;
	
	private int facing;
	
	Item[] inventory = new Item[6];

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//where we are in world space
	float mapX = 0;
	float mapY = 0;

	public void move(float x, float y)
	{
		Tile oldTile;
		Tile newTile;
		
		oldTile = MyGdxGame.testDungeon.getTileAt((this.xPos/Tile.WIDTH), (this.yPos/Tile.WIDTH));
		oldTile.setOccupant(null);
		
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
		
		newTile = MyGdxGame.testDungeon.getTileAt((this.xPos/Tile.WIDTH), (this.yPos/Tile.WIDTH));
		
		if(newTile.getOccupant().getClass()==Item.class){
			Item itemGet = (Item) newTile.getOccupant();
			itemGet.pickUp(this);
		}
		
		newTile.setOccupant(MyGdxGame.testPlayer);
		
		//System.out.println("PlayerX: " + (this.xPos/Tile.WIDTH));
		//System.out.println("PlayerY: " + (this.yPos/Tile.HEIGHT));
			
		//} else {
			
		//}
		
		MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
	}
	
	public void ability1(Player player) {
		//System.out.println("One");
		int targetX;
		int targetY;
		Creature target = null;
		
		if (this.getFacing() == RIGHT) {
			targetX = (this.xPos/Tile.WIDTH) + 1;
			targetY = (this.yPos/Tile.HEIGHT);
		//	System.out.println("TargetX: " + targetX);
			//System.out.println("TargetY: " + targetY);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			//System.out.println(target);
			
		} else if (MyGdxGame.testPlayer.getFacing() == UP) {
			targetX = (this.xPos/Tile.WIDTH);
			targetY = (this.yPos/Tile.HEIGHT) + 1;
			//System.out.println("TargetX: " + targetX);
			//System.out.println("TargetY: " + targetY);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			//System.out.println(target);
			
		} else if (MyGdxGame.testPlayer.getFacing() == LEFT) {
			targetX = (this.xPos/Tile.WIDTH) - 1;
			targetY = (this.yPos/Tile.HEIGHT);
			//System.out.println("TargetX: " + targetX);
			//System.out.println("TargetY: " + targetY);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			//System.out.println(target);
			
			
		} else if (MyGdxGame.testPlayer.getFacing() == DOWN) {
			targetX = (this.xPos/Tile.WIDTH);
			targetY = (this.yPos/Tile.HEIGHT) - 1;
			//System.out.println("TargetX: " + targetX);
			//System.out.println("TargetY: " + targetY);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			//System.out.println(target);
		}
		
		if (KnightClass.isInstance(MyGdxGame.testPlayer)) {         
			System.out.println("Stab");
			
			try {
				((Knight) player).stab(target);
				
			} catch (NullPointerException e) {
				System.out.println("The attack missed!");
			}
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
		} else if (BarbClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Chop");
			
			try {
				((Barbarian) player).chop(target);
				
			} catch (NullPointerException e) {
				System.out.println("The attack missed!");
			}
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
			
		} else if (MonkClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Jab");
			
			try {
				((Monk) player).jab(target);
				
			} catch (NullPointerException e) {
				
			}
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
			
		} else if (WizClass.isInstance(MyGdxGame.testPlayer)) {       //To finish when I do ranged combat
			System.out.println("Fireball");
			//determine target
			//MyGdxGame.testPlayer.fireball(targets go here);
			
		} else {
			System.out.println("Error");
		}
	}
	
	public void ability2(Player player) {
		//System.out.println("Two");
		
		int targetX;
		int targetY;
		Creature target = null;
		
		if (this.getFacing() == RIGHT) {
			targetX = (this.xPos/Tile.WIDTH) + 1;
			targetY = (this.yPos/Tile.HEIGHT);
		//	System.out.println("TargetX: " + targetX);
			//System.out.println("TargetY: " + targetY);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			//System.out.println(target);
			
		} else if (MyGdxGame.testPlayer.getFacing() == UP) {
			targetX = (this.xPos/Tile.WIDTH);
			targetY = (this.yPos/Tile.HEIGHT) + 1;
			//System.out.println("TargetX: " + targetX);
			//System.out.println("TargetY: " + targetY);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			//System.out.println(target);
			
		} else if (MyGdxGame.testPlayer.getFacing() == LEFT) {
			targetX = (this.xPos/Tile.WIDTH) - 1;
			targetY = (this.yPos/Tile.HEIGHT);
			//System.out.println("TargetX: " + targetX);
			//System.out.println("TargetY: " + targetY);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			//System.out.println(target);
			
			
		} else if (MyGdxGame.testPlayer.getFacing() == DOWN) {
			targetX = (this.xPos/Tile.WIDTH);
			targetY = (this.yPos/Tile.HEIGHT) - 1;
			//System.out.println("TargetX: " + targetX);
			//System.out.println("TargetY: " + targetY);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			//System.out.println(target);
		}
		
		if (KnightClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Shield Bash");
			
			try {
				((Knight) player).shieldBash(target);
				
			} catch (NullPointerException e) {
				System.out.println("The attack missed!");
			}
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
		} else if (BarbClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Cleave");
			((Barbarian) player).cleave(); 
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN); //This looks different because target acquisition for cleave is handled differently.
			
		} else if (MonkClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Flurry");
			
			try {
				((Monk) player).flurry(target);
				
			} catch (NullPointerException e) {
				System.out.println("The attack missed!");
			}
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
		} else if (WizClass.isInstance(MyGdxGame.testPlayer)) {        //To finish when I do ranged combat
			System.out.println("Ice Lance");
			//determine target
			//MyGdxGame.testPlayer.iceLance(target goes here);
			
		} else {
			System.out.println("Error");
		}
	}
	
	public void ability3(Player player) {
		//System.out.println("Three");
		
		if (KnightClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Bulwark");
			((Knight) player).bulwark();
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
		} else if (BarbClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("RAAAAAAAAAGGGGEEEE!!!!!");
			((Barbarian) player).rage();
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
		} else if (MonkClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Serenity");
			((Monk) player).serenity();
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
		} else if (WizClass.isInstance(MyGdxGame.testPlayer)) {            //I'll deal with this later
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

	public int getFacing() {
		return facing;
	}

	public void setFacing(int facing) {
		this.facing = facing;
	}
}
