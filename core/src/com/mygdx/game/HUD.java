package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class HUD {

	private Skin skin;
	private Stage stage;
	private Table table;
	
	public void create(){
		stage = new Stage();
		setSkin(UI.getSkin());
		Gdx.input.setInputProcessor(stage);
		
		final TextureRegion blankTile = new TextureRegion(Assets.wallTiles.get(0).getImg());
		//final Texture icon1 = new Texture(0, 0, null);
		
		
		
		
		
	}
	
	
	

	public void render ()  {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		
	}

	public void resize (int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	public void dispose () {
		stage.dispose();
		getSkin().dispose();
	}

	public Skin getSkin() {
		return skin;
	}

	public void setSkin(Skin skin) {
		this.skin = skin;
	}
	
	
	
	
	
	
	
}
