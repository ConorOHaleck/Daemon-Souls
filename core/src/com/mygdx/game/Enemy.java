package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Enemy extends Creature {
	Class<Imp> MonsterImp = Imp.class;

	public Enemy() {
		// TODO Auto-generated constructor stub
	}

	//where we are in world space
	float mapX = 0;
	float mapY = 0;

	public void move(float x, float y)
	{
		Tile oldTile;
		Tile newTile;
		
		oldTile = MyGdxGame.testDungeon.getTileAt((this.xPos)/Tile.WIDTH, (this.yPos/Tile.HEIGHT));
		oldTile.setOccupant(null);
		oldTile.setCanCollide(false);
		
		mapX +=x;
		mapY +=y;
		xPos += Tile.WIDTH * x;
		yPos += Tile.HEIGHT * y;
		
		newTile = MyGdxGame.testDungeon.getTileAt((this.xPos)/Tile.WIDTH, (this.yPos/Tile.HEIGHT));
		//newTile.setOccupant(MyGdxGame.testEnemy);
		newTile.setCanCollide(true);
		//System.out.println("EnemyX: " + (this.xPos/Tile.WIDTH));
		//System.out.println("EnemyY: " + (this.yPos/Tile.HEIGHT));

		MyGdxGame.setGameState(MyGdxGame.PLAYER_TURN);
	}

	public Enemy(TextureRegion img) {
		// TODO Auto-generated constructor stub
		this.mapX = 0;
		this.mapY = 0;
		this.img = img;
	}
	
	public void chase() {
		
		if (this.xPos < MyGdxGame.testPlayer.xPos) {
			this.move(1, 0);
		
		} else if (this.xPos > MyGdxGame.testPlayer.xPos) {
			this.move(-1, 0);
			
		} else if (this.yPos > MyGdxGame.testPlayer.yPos) {
			this.move(0, -1);
			
		} else if (this.yPos < MyGdxGame.testPlayer.yPos) {
			this.move(0, 1);
		}
	}
	
	public int tryAttack() { //k, so the idea here was to check what kind of monster was here and return the appropriate flag, Connor if you want to handle it differently, go ahead.
		
		if (Math.abs(MyGdxGame.testPlayer.xPos - this.xPos) <= Tile.WIDTH && Math.abs(this.yPos - MyGdxGame.testPlayer.yPos) <= Tile.HEIGHT) {
			//System.out.println("Target Found");
			//System.out.println(Math.abs(this.xPos - MyGdxGame.testPlayer.xPos));
			//System.out.println(Tile.WIDTH);
			
			return MyGdxGame.IMP;
		}
		//System.out.println("Attack Failed");
		MyGdxGame.setGameState(MyGdxGame.PLAYER_TURN);
		return -1;
	}


}
