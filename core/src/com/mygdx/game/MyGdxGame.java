package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	static Map testDungeon;  
	static Wizard testPlayer;
	static Enemy testEnemy;
	public static final int PLAYER_TURN = 0;
	public static final int ENEMY_TURN = 1;
	private static int gameState = 0;
	
	public int step = 0;
	@Override
	public void create () {
		Gdx.graphics.setTitle("extremely good video game");
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		testPlayer = new Wizard("Sir test", img);
		testEnemy =  new Enemy(img);
		generateFloor();
	}

	public void generateFloor() {
		testDungeon = new Map();
		Tile testTile = new Tile(Sprites.DUNGEON_FLOOR_PLAIN);
		for (int i = 0; i < 500; i++)
		{
			testDungeon.getTiles().add(testTile);
		}
		
		for (int i = 1; i < 20; i++) {
			testDungeon.getTiles().get(i).setCanCollide(false);
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		testDungeon.Draw(batch);
		testPlayer.Draw(batch);
		testEnemy.Draw(batch);
		//batch.draw(img, 25, 200);
		
		if (getGameState() == PLAYER_TURN) {
			if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
				testPlayer.move(-1f, 0);
			}

			if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
				testPlayer.move(1f, 0);
			}

			if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
				testPlayer.move(0, -1f);
			}

			if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
				testPlayer.move(0, 1f);
			}
			
			if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
				testPlayer.ability1();
			}
			
			if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
				testPlayer.ability2();
			}
			
			if(Gdx.input.isKeyJustPressed(Input.Keys.E)) {
				testPlayer.ability3();
			}
		}
		
		if (getGameState() == ENEMY_TURN) {
			
			if (step >= 0 && step <= 10) {
				testEnemy.move(1f, 0);
				step++;
				
			} else if (step > 10 && step <= 20) {
				testEnemy.move(0, 1f);
				step++;
				
			} else if (step > 20 && step <= 30) {
				testEnemy.move(-1f, 0);
				step++;
				
			} else if (step > 30 && step <= 40) {
				testEnemy.move(0, -1f);
				step++;
				
			} else if (step > 40) {
				step = 0;
			}
		}

		batch.end();
	}

	public int getGameState() {
		return MyGdxGame.gameState;
	}

	public static void setGameState(int gameState) {
		MyGdxGame.gameState = gameState;
	}
}
