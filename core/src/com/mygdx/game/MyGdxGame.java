package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	SpriteBatch menuBatch;

	TextureRegion img;
	TextureRegion reticleImg;

	UI ui = new UI();
	static Map testDungeon;  
	static Imp testEnemy;
	static Reticle playerReticle;
	public static final int PLAYER_TURN = 0;
	public static final int ENEMY_TURN = 1;
	public static final int MENU = -1;
	public static final int PLAYER_MOVEMENT = 0;
	public static final int TARGETING_RANGED = 1;
	public static final int INIT_PLAYER = 2;
	public static final int FIREBALL = 0;
	public static final int ICE_LANCE = 1;
	public static final int IMP = 0;
	private static int gameState = MENU;
	private static int controlState = 0;
	private static int reticleType = 0;
	OrthographicCamera playerCam;
	private static int sec = 1;
	static String name = "nothing";
	private static int classChoice = -1;
	static Player testPlayer;

	@Override
	public void create () {
		Assets.initAssets();
		ui.create();
		Assets.initKnightM();
		Gdx.graphics.setTitle("Daemon Souls");
		float w = Gdx.graphics.getWidth();                                      
		float h = Gdx.graphics.getHeight();   
		//ui.setSkin(new Skin(Gdx.files.internal("yC0rv.png")));
		playerCam = new OrthographicCamera(32, 32 * (h/w));
		//combatLog = new TextField("Combat Log: ", skin);
		playerCam.position.set(0, 0, 0);
		playerCam.zoom = 20;
		playerCam.update();
		menuBatch = new SpriteBatch();
		batch = new SpriteBatch();
		testPlayer = new Wizard("Sir test", Sprites.P_DOWN);
		reticleImg = Sprites.P_DOWN;
		testEnemy =  new Imp(Sprites.IMP);
		playerReticle = new Reticle(reticleImg);
		generateFloor();
	}

	public void generateFloor() {
		DungeonGenerator mapGen = new DungeonGenerator();

		testDungeon = mapGen.generateDungeon();

		for (int i = 0; i < testDungeon.tiles.size(); i++)
		{
			if (!testDungeon.getTiles().get(i).isCanCollide())
			{
				testDungeon.getTiles().get(i).setImg(Assets.floorTiles.get(0).getImg());
			}
			else
			{
				testDungeon.getTiles().get(i).setImg(Assets.floorTiles.get(35).getImg());
			}
		}

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
		Gdx.gl.glClearColor(1, 0, 0, 1); //Also, if we change the values of this constructor, the hideous red could become black.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		if (gameState == MENU)
		{
			menuBatch.begin();
			classChoice = ui.render();
			menuBatch.end();
		}
		
		if (gameState == INIT_PLAYER)
		{
			classChoice = ui.getNum();
			if (classChoice == 0)
			{
				testPlayer = new Barbarian(name, Assets.player_down);
				System.out.println("Created barbarian");
			}
			
			if (classChoice == 1)
			{
				testPlayer = new Knight(name, Assets.player_down);
				System.out.println("Created knight");
			}
			
			if (classChoice == 2)
			{
				testPlayer = new Monk(name, Assets.player_down);
				System.out.println("Created monk");
			}
			
			if (classChoice == 3)
			{
				testPlayer = new Wizard(name, Assets.player_down);
				System.out.println("Created wiz");
			}
			Tile startTile = testDungeon.getTileAt((int)testDungeon.rooms.get(1).x, (int)testDungeon.rooms.get(1).y);
			if (startTile.isCanCollide())
			{
				startTile = testDungeon.getTileAt(startTile.getX()+1, startTile.getY()+1);
			}
			startTile.setOccupant(testPlayer);
			testPlayer.setPos(startTile.getX() * 32, (startTile.getY()) * 32);
			gameState = PLAYER_TURN;
		}


		batch.setProjectionMatrix(playerCam.combined);
		testDungeon.Draw(batch);
		testPlayer.Draw(batch);
		testEnemy.Draw(batch);
		for (int i = 0; i < testDungeon.populants.size(); i++)
		{
			testDungeon.populants.get(i).Draw(batch);
		}

		if (getGameState() == PLAYER_TURN) {
			
			if (getControlState() == PLAYER_MOVEMENT) {
				if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
					testPlayer.img = Sprites.playerAnimate(Assets.move_left);
					testPlayer.setFacing(Player.LEFT);
					testPlayer.move(-1f, 0);
					testPlayer.img = Assets.player_left;
				}

				if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
					testPlayer.img = Sprites.playerAnimate(Assets.move_right);
					testPlayer.setFacing(Player.RIGHT);
					testPlayer.move(1f, 0);
					testPlayer.img = Assets.player_right;
				}

				if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
					testPlayer.img = Sprites.playerAnimate(Assets.move_down);
					testPlayer.setFacing(Player.DOWN);
					testPlayer.move(0, -1f);
					testPlayer.img = Assets.player_down;
				}

				if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
					testPlayer.img = Sprites.playerAnimate(Assets.move_up);
					testPlayer.setFacing(Player.UP);
					testPlayer.move(0, 1f);
					testPlayer.img = Assets.player_up;
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

				if(Gdx.input.isKeyJustPressed(Input.Keys.R)) {
					MyGdxGame.setControlState(MyGdxGame.PLAYER_MOVEMENT);
				}
				playerCam.position.set(testPlayer.xPos, testPlayer.yPos, 0);
				playerCam.update();

			} else if (getControlState() == TARGETING_RANGED) {


				if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
					playerReticle.move(-1f, 0);
				}

				if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
					playerReticle.move(1f, 0);
				}

				if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
					playerReticle.move(0, -1f);
				}

				if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
					playerReticle.move(0, 1f);
				}

				if (getReticleType() == FIREBALL) {
					playerReticle.drawFour(batch);

					if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
						//testPlayer.fireball();
					}

					if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
						testPlayer.ability2(testPlayer);
					}

					if(Gdx.input.isKeyJustPressed(Input.Keys.E)) {
						testPlayer.ability3(testPlayer);
					}

				} else if (getReticleType() == ICE_LANCE) {
					playerReticle.drawOne(batch);

					if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
						testPlayer.ability1(testPlayer);
					}

					if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
						//testPlayer.iceLance();
					}

					if(Gdx.input.isKeyJustPressed(Input.Keys.E)) {
						testPlayer.ability3(testPlayer);
					}
				}

				if(Gdx.input.isKeyJustPressed(Input.Keys.R)) {
					MyGdxGame.setControlState(MyGdxGame.PLAYER_MOVEMENT);
				}
			}
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

		if (player.getBashCd() > 0) {                    //I'll clean this up later
			player.setBashCd(player.getBashCd() - 1);
		}

		if (player.getFireballCD() > 0) {
			player.setFireballCD(player.getFireballCD() - 1);
		}

		if (player.getBulwarkCD() > 0) {
			player.setBulwarkCD(player.getBulwarkCD() - 1);
		}

		if (player.getCleaveCD() > 0) {
			player.setCleaveCD(player.getCleaveCD() - 1);
		}

		if (player.getFlurryCD() > 0) {
			player.setFlurryCD(player.getFlurryCD() - 1);
		}

		if (player.getSerenityCD() > 0) {
			player.setSerenityCD(player.getSerenityCD() - 1);
		}

		if (player.getTeleCD() > 0) {
			player.setTeleCD(player.getTeleCD() - 1);
		}
	}

	public static int getControlState() {
		return controlState;
	}

	public static void setControlState(int controlState) {
		MyGdxGame.controlState = controlState;
	}

	public static int getReticleType() {
		return reticleType;
	}

	public static void setReticleType(int reticleType) {
		playerReticle.setPos(testPlayer.xPos, testPlayer.yPos);
		MyGdxGame.reticleType = reticleType;
	}

	//Pauses game for number of seconds
	private static void slowYourRollBro(int sec){
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
