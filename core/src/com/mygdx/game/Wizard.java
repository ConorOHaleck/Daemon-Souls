package com.mygdx.game;


import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.TextureRegion;


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

		if (target != null) {
			Sprites.effectAnimate(Assets.iceball);
			this.iceLance(target);
			MyGdxGame.setControlState(MyGdxGame.PLAYER_MOVEMENT);
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
		}
	}

	public void iceLance(Creature target) {
		int damage = (int) (0.75*this.getIntelligence());
		MyGdxGame.updateLog(this.getName() + " fires a lance of ice!");
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
		
		Sprites.effectAnimate(Assets.fireball);  //this line right here
		
		MyGdxGame.updateLog(this.getName() + " tosses out a huge fireball!");
		
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
		target.getHit(damage);
	}

	public void teleport() {
		Random rng = new Random();
		Tile oldTile;
		Tile newTile;
		int newX = rng.nextInt(Map.MAP_WIDTH)*Tile.WIDTH;
		int newY = rng.nextInt(Map.MAP_WIDTH)*Tile.HEIGHT;

		newTile = MyGdxGame.testDungeon.getTileAt((newX/Tile.WIDTH), (newY/Tile.HEIGHT));

		if (newTile.isCanCollide() == false) {

			oldTile = MyGdxGame.testDungeon.getTileAt((this.xPos/Tile.WIDTH), (this.yPos/Tile.HEIGHT));
			oldTile.setOccupant(null);
			xPos = newX;
			yPos = newY;

			if (newTile.getOccupant() != null) {
				if(newTile.getOccupant().getClass()==Item.class){
					Item itemGet = (Item) newTile.getOccupant();
					itemGet.pickUp(this);
				}
			}

			newTile.setOccupant(MyGdxGame.testPlayer);

			System.out.println("PlayerX: " + (this.xPos/Tile.WIDTH));
			System.out.println("PlayerY: " + (this.yPos/Tile.HEIGHT));


			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
		
		} else {
			this.teleport();
		}
	}

}
