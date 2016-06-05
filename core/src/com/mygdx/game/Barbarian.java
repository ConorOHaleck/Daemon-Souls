package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Barbarian extends Player{
	
	public Barbarian(String name, TextureRegion img) {
		super(img);
		this.setStrength(18);
		this.setAgility(6);
		this.setIntelligence(6);
		this.setVigor(15);
		
		this.setHealth(this.getVigor()*2);
		this.setMaxHp(this.getVigor()*2);
		this.setArmor(0);
		
		this.setName(name);
		this.setBerserkerBloodActive(ENABLED);
	}
	
	public void chop(Creature target) {
		int damage = (int) (0.7*this.getStrength());
		damage = this.flagCheckOffense(damage);
		System.out.println(this.getName() + " attacks " + target.getName() + " with a mighty chop!");
		target.getHit(damage);
	}
	
	public void cleave() {
		// This is the method that will be called first when cleave is used. 
		//It will determine which spaces are filled and call the appropriate overload.
		int targetX;
		int targetY;
		Creature target = null;
		Creature target2 = null;
		Creature target3 = null;
		
		if (this.getFacing() == RIGHT) {
			targetX = (this.xPos/Tile.WIDTH) + 1;
			targetY = (this.yPos/Tile.HEIGHT);
		//	System.out.println("TargetX: " + targetX);
			//System.out.println("TargetY: " + targetY);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			target2= (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY + 1).getOccupant();
			target3= (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY - 1).getOccupant();
			//System.out.println(target);
			
		} else if (MyGdxGame.testPlayer.getFacing() == UP) {
			targetX = (this.xPos/Tile.WIDTH);
			targetY = (this.yPos/Tile.HEIGHT) + 1;
			//System.out.println("TargetX: " + targetX);
			//System.out.println("TargetY: " + targetY);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			target2= (Creature) MyGdxGame.testDungeon.getTileAt(targetX + 1, targetY).getOccupant();
			target3= (Creature) MyGdxGame.testDungeon.getTileAt(targetX - 1, targetY).getOccupant();
			//System.out.println(target);
			
		} else if (MyGdxGame.testPlayer.getFacing() == LEFT) {
			targetX = (this.xPos/Tile.WIDTH) - 1;
			targetY = (this.yPos/Tile.HEIGHT);
			//System.out.println("TargetX: " + targetX);
			//System.out.println("TargetY: " + targetY);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			target2= (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY + 1).getOccupant();
			target3= (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY - 1).getOccupant();
			//System.out.println(target);
			
			
		} else if (MyGdxGame.testPlayer.getFacing() == DOWN) {
			targetX = (this.xPos/Tile.WIDTH);
			targetY = (this.yPos/Tile.HEIGHT) - 1;
			//System.out.println("TargetX: " + targetX);
			//System.out.println("TargetY: " + targetY);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			target2= (Creature) MyGdxGame.testDungeon.getTileAt(targetX + 1, targetY).getOccupant();
			target3= (Creature) MyGdxGame.testDungeon.getTileAt(targetX - 1, targetY).getOccupant();
			//System.out.println(target);
		}
		ArrayList<Creature> targetList = new ArrayList<Creature>();
		targetList.add(target);
		targetList.add(target2);
		targetList.add(target3);
		
		for (Creature t : targetList) {
			if (t != null) {
				this.cleave(t);
			}
		}
	}
	
	public void cleave(Creature target) {
		int damage = (int) (0.5*this.getStrength());
		damage = this.flagCheckOffense(damage);
		System.out.println(this.getName() + " cleaves to  " + target.getName() + " !");
		target.getHit(damage);
	}
	
	public void rage() {
		System.out.println(this.getName() + " goes into a raging frenzy!");
		this.rageActive();
		this.setRageDuration(3);
	}
}
