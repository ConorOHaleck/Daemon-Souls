package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	static Map testDungeon;  
	static Wizard testPlayer;
	static Imp testEnemy;
	public static final int PLAYER_TURN = 0;
	public static final int ENEMY_TURN = 1;
	public static final int IMP = 0;
	private static int gameState = 0;
	OrthographicCamera playerCam;
	
	public int step = 0;
	@Override
	public void create () {
		Gdx.graphics.setTitle("extremely good video game");
		  float w = Gdx.graphics.getWidth();                                      
	       float h = Gdx.graphics.getHeight();   
		playerCam = new OrthographicCamera(32, 32 * (h/w));
		playerCam.position.set(0, 0, 0);
		playerCam.zoom = 15;
		playerCam.update();
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		testPlayer = new Wizard("Sir test", img);
		testEnemy =  new Imp(img);
		generateFloor();
	}

	public void generateFloor() {
		DungeonGenerator mapGen = new DungeonGenerator();
		
		testDungeon = mapGen.generateDungeon();
		
		for (int i = 0; i < testDungeon.tiles.size(); i++)
		{
			if (testDungeon.getTiles().get(i).walkable())
			{
				testDungeon.getTiles().get(i).setImg(Sprites.DUNGEON_FLOOR_PLAIN);
			}
			else
			{
				testDungeon.getTiles().get(i).setImg(Sprites.DUNGEON_FLOOR_EMPTY);
			}
		}
		
		for (int x = 0; x < 200; x++)
		{
			for (int y = 0; y < 200; y++)
			{
				testDungeon.getTileAt(x, y);
			}
		}
		//for (int i = 1; i < 20; i++) {
		//	testDungeon.getTiles().get(i).setCanCollide(false);
		//}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.setProjectionMatrix(playerCam.combined);
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
			playerCam.position.set(testPlayer.xPos, testPlayer.yPos, 0);
			playerCam.update();
		}
		
		if (getGameState() == ENEMY_TURN) {
			
			if (testEnemy.tryAttack() == IMP) {
				testEnemy.cut(testPlayer);
				setGameState(PLAYER_TURN);
				
			} else {
				testEnemy.chase();
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
