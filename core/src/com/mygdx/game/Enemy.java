package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Enemy extends Creature {

	public Enemy() {
		// TODO Auto-generated constructor stub
	}

	//where we are in world space
	float mapX = 0;
	float mapY = 0;

	public void move(float x, float y)
	{
		mapX +=x;
		mapY +=y;
		xPos += Tile.WIDTH * x;
		yPos += Tile.HEIGHT * y;

		MyGdxGame.setGameState(MyGdxGame.PLAYER_TURN);
	}

	public Enemy(Texture img) {
		// TODO Auto-generated constructor stub
		this.mapX = 0;
		this.mapY = 0;
		this.img = img;
	}


}
