package com.mygdx.game;

import java.awt.Color;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Map testDungeon;
	Player testPlayer;
	ShapeRenderer debug;
	ArrayList<Rectangle> testRects = new ArrayList<Rectangle>();
	@Override
	public void create () {
		debug = new ShapeRenderer();
		Gdx.graphics.setTitle("extremely good video game");
		batch = new SpriteBatch();
		img = new Texture("playerFix.png");
		testPlayer = new Player(img);
		generateFloor();
	}

	public void generateFloor() {
		DungeonGenerator dgen = new DungeonGenerator();
		//testDungeon = DungeonGenerator.generateDungeon();
		testRects = DungeonGenerator.generateRectangles();
		//Tile testTile = new Tile(Sprites.DUNGEON_FLOOR_PLAIN);
		//for (int i = 0; i < testDungeon.getTiles().size(); i++)
		//{
		//	if (!testDungeon.getTiles().get(i).isWalkable())
		//	{
		//		testDungeon.getTiles().get(i).setTexture(Sprites.DUNGEON_FLOOR_EMPTY);
		//	}
		//	else
		//	testDungeon.getTiles().get(i).setTexture(Sprites.DUNGEON_FLOOR_PLAIN);
		//}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		testPlayer.Draw(batch);
		debug.begin(ShapeType.Filled);
		
		//debug.setColor(Color.BLACK);
		
		for (int i = 0; i < testRects.size(); i++)
		{
			debug.rect(testRects.get(i).getX(), testRects.get(i).getY(), testRects.get(i).getWidth() , testRects.get(i).getHeight());
		}
		//testDungeon.Draw(batch);
		
		//batch.draw(img, 25, 200);
		debug.end();
		batch.end();
	}
}
