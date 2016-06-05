package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	TextureRegion img;
	static Map testDungeon;  
	static Barbarian testPlayer;
	static Imp testEnemy;
	public static final int PLAYER_TURN = 0;
	public static final int ENEMY_TURN = 1;
	public static final int IMP = 0;
	private static int gameState = 0;
	OrthographicCamera playerCam;
	
	@Override
	public void create () {
		Assets.initAssets(); //Must call before accessing tiles.
		Assets.initBarbarianM();//Must call (appropriate method) before accessing player assets.
		Gdx.graphics.setTitle("extremely good video game");
		  float w = Gdx.graphics.getWidth();                                      
	       float h = Gdx.graphics.getHeight();   
		playerCam = new OrthographicCamera(32, 32 * (h/w));
		playerCam.position.set(0, 0, 0);
		playerCam.zoom = 15;
		playerCam.update();
		batch = new SpriteBatch();
		img =  Assets.playerImage.get(0);
		testPlayer = new Barbarian("Sir test", img);
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
		
		Tile startTile = testDungeon.getTileAt(0, 0);
		startTile.setOccupant(testPlayer);
		
		Tile enemyTile = testDungeon.getTileAt((testEnemy.xPos/Tile.WIDTH), (testEnemy.yPos/Tile.HEIGHT));
		enemyTile.setOccupant(testEnemy);
				
		
		/*for (int x = 0; x < 200; x++)
		{
			for (int y = 0; y < 200; y++)
			{
				testDungeon.getTileAt(x, y);
			}
		} */
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
		batch.draw(Assets.playerImage.get(0), 25, 200);
		
		if (getGameState() == PLAYER_TURN) {
			if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
				testPlayer.setFacing(Player.LEFT);
				testPlayer.move(-1f, 0);
				
			}

			if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
				testPlayer.setFacing(Player.RIGHT);
				testPlayer.move(1f, 0);
			}

			if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
				testPlayer.setFacing(Player.DOWN);
				testPlayer.move(0, -1f);
			}

			if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
				testPlayer.setFacing(Player.UP);
				testPlayer.move(0, 1f);
			}
			
			if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
				testPlayer.ability1(testPlayer);
			}
			
			if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
				testPlayer.ability2(testPlayer);
			}
			
			if(Gdx.input.isKeyJustPressed(Input.Keys.E)) {
				testPlayer.ability3(testPlayer);
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
			
			newTurn(testPlayer);
			
		}

		batch.end();
	}

	public int getGameState() {
		return MyGdxGame.gameState;
	}

	public static void setGameState(int gameState) {
		MyGdxGame.gameState = gameState;
	}
	
	public static void newTurn(Creature player) {
		if (player.isBulwarkActive() == Creature.ENABLED) {
			player.setBulwarkDuration(player.getBulwarkDuration() - 1);
			
			if (player.getBulwarkDuration() <= 0) {
				player.setBulwarkActive(Creature.DISABLED);
			}
			
		} else if (player.getRageActive() == Creature.ENABLED) {
			player.setRageDuration(player.getRageDuration() - 1);
			
			if (player.getRageDuration() <= 0) {
				player.setRageActive(Creature.DISABLED);
				player.rageDeactive();
			}
		}
	}
}
