package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Map testDungeon;
	Player testPlayer;
	@Override
	public void create () {
		Gdx.graphics.setTitle("extremely good video game");
		batch = new SpriteBatch();
		img = new Texture("playerFix.png");
		testPlayer = new Player(img);
		generateFloor();
	}

	public void generateFloor() {
		testDungeon = new Map();
		Tile testTile = new Tile(Sprites.DUNGEON_FLOOR_PLAIN);
		for (int i = 0; i < 500; i++)
		{
			testDungeon.getTiles().add(testTile);
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		testDungeon.Draw(batch);
		testPlayer.Draw(batch);
		//batch.draw(img, 25, 200);
		
		batch.end();
	}
}
