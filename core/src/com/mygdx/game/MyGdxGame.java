package com.mygdx.game;

import java.awt.Color;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class MyGdxGame extends ApplicationAdapter {
	
	private OrthographicCamera cam;
	
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
		cam = new OrthographicCamera(30, 30);
		cam.position.set(0, 0, 0);
		cam.zoom = 50;
		cam.update();
	}

	public void generateFloor() {
		DungeonGenerator dgen = new DungeonGenerator();
		testDungeon = DungeonGenerator.generateDungeon();
		
//		testDungeon = new Map();
//		{
//			for (int i = 0; i < 200; i++)
//			{
//				for (int j = 0; j < 200; j++)
//				{
//					if (j % 2 == 0)
//					{
//						testDungeon.addTile(new Tile(true, i, j));
//					}
//					
//					else 
//					{
//						testDungeon.addTile(new Tile(false, i, j));
//					}
//				}
//			}
//		}
		//testRects = DungeonGenerator.generateRectangles();
		Tile testTile = new Tile(Sprites.DUNGEON_FLOOR_PLAIN);
		for (int i = 0; i < testDungeon.getTiles().size(); i++)
		{
			if (!testDungeon.getTiles().get(i).isWalkable())
			{
				testDungeon.getTiles().get(i).setTexture(Sprites.DUNGEON_FLOOR_EMPTY);
			}
			else
			testDungeon.getTiles().get(i).setTexture(Sprites.DUNGEON_FLOOR_PLAIN);
		}
	}

	@Override
	public void render () {
		handleInput();
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		batch.begin();
		//testPlayer.Draw(batch);
		//debug.begin(ShapeType.Filled);
		
		//debug.setColor(Color.BLACK);
		
		//for (int i = 0; i < testRects.size(); i++)
		//{
		//	debug.rect(testRects.get(i).getX(), testRects.get(i).getY(), testRects.get(i).getWidth() , testRects.get(i).getHeight());
		//}
		testDungeon.Draw(batch);
		
		//batch.draw(img, 25, 200);
		//debug.end();
		batch.end();
	}
	
	private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            cam.zoom += 0.02;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            cam.zoom -= 0.02;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            cam.translate(-60, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            cam.translate(60, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            cam.translate(0, -60, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            cam.translate(0, 60, 0);
        }
        //cam.zoom = MathUtils.clamp(cam.zoom, 0.1f, 100/cam.viewportWidth);

       // float effectiveViewportWidth = cam.viewportWidth * cam.zoom;
       // float effectiveViewportHeight = cam.viewportHeight * cam.zoom;

       // cam.position.x = MathUtils.clamp(cam.position.x, effectiveViewportWidth / 2f, 100 - effectiveViewportWidth / 2f);
       // cam.position.y = MathUtils.clamp(cam.position.y, effectiveViewportHeight / 2f, 100 - effectiveViewportHeight / 2f);
    }
}
