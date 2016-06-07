package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class HUD {

	private Skin skin;
	Stage stage;
	private Table table;
	
	public void create(){
		stage = new Stage();
		skin = new Skin();
		Gdx.input.setInputProcessor(stage);
		final TextureRegion blankTile = new TextureRegion(Assets.wallTiles.get(0).getImg());
		
		
		//Configure a style
		ImageButtonStyle imgStyle = new ImageButtonStyle();
		imgStyle.imageUp = new TextureRegionDrawable(blankTile);
		skin.add("imgBtnStyle", imgStyle);
		
		//Make button
		ImageButton btn = new ImageButton(skin, "imgBtnStyle");
		
	
		
		table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		
		//Add stuff here.
		//table.add(stuff);
		table.add(btn);
	}
	
	
	

	public void render ()  {
		//Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		//stage.draw();
		
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
