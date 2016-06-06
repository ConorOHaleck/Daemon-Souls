package com.mygdx.game;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
=======
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;


public class Wizard extends Player{
	
	public Wizard(String name, TextureRegion img) {
		super(img);
		this.setStrength(4);
		this.setAgility(6);
		this.setIntelligence(18);
		this.setVigor(8);
		
		this.setHealth(this.getVigor()*2);
		this.setMaxHp(this.getVigor()*2);
		this.setArmor(0);
		
		this.setName(name);
		this.setMageArmor(ENABLED);
	}
	
	public void iceLance() {
		int targetX;
		int targetY;
		Creature target = null;
		targetX = (MyGdxGame.playerReticle.xPos/Tile.WIDTH);
		targetY = (MyGdxGame.playerReticle.yPos/Tile.HEIGHT);
		target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
		this.iceLance(target);
		MyGdxGame.setControlState(MyGdxGame.PLAYER_MOVEMENT);
		MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
	}
	
	public void iceLance(Creature target) {
		int damage = (int) (0.75*this.getIntelligence());
		System.out.println(this.getName() + " fires a lance of ice!");
		target.getHit(damage);
	}
	
	public void fireball() {
		int targetX;
		int targetY;
		Creature target = null;
		Creature target2 = null;
		Creature target3 = null;
		Creature target4 = null;
		targetX = (MyGdxGame.playerReticle.xPos/Tile.WIDTH);
		targetY = (MyGdxGame.playerReticle.yPos/Tile.HEIGHT);
		
		target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
		target2 = (Creature) MyGdxGame.testDungeon.getTileAt(targetX + 1, targetY).getOccupant();
		target3 = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY + 1).getOccupant();
		target4 = (Creature) MyGdxGame.testDungeon.getTileAt(targetX + 1, targetY + 1).getOccupant();
		
		ArrayList<Creature> targetList = new ArrayList<Creature>();
		targetList.add(target);
		targetList.add(target2);
		targetList.add(target3);
		targetList.add(target4);
		
		for (Creature t : targetList) {
			if (t != null) {
				this.fireball(t);
			}
		}
		
		MyGdxGame.testPlayer.setFireballCD(3);
		MyGdxGame.setControlState(MyGdxGame.PLAYER_MOVEMENT);
		MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
	}
	
	public void fireball(Creature target) {
		int damage = (int) (0.8*this.getIntelligence());
		System.out.println(this.getName() + " tosses out a huge fireball!");
		target.getHit(damage);
	}

}
