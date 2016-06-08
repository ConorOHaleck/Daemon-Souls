package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class HUD {

	private static Skin hudSkin;
	static Stage hudStage;
	private static Table hudTable;
	private static TextField combatLog;
	static String log;
	
	
	public static void create(){
		hudStage = new Stage();
		hudSkin = new Skin();
		Gdx.input.setInputProcessor(hudStage);
		
		
		final TextureRegion blankTile = new TextureRegion(Assets.wallTiles.get(0).getImg());
		
		
		//Configure a style
		ImageButtonStyle imgStyle = new ImageButtonStyle();
		imgStyle.imageUp = new TextureRegionDrawable(blankTile);
		hudSkin.add("imgBtnStyle", imgStyle);
		
		//Make button
		ImageButton btn = new ImageButton(hudSkin, "imgBtnStyle");
		
		hudSkin.add("defaultFont", new BitmapFont());
		
		//Create combatLog's textFieldStyle
		TextFieldStyle textStyle = new TextFieldStyle();
		textStyle.fontColor = Color.BLUE;
		textStyle.font = hudSkin.getFont("defaultFont");
		hudSkin.add("textStyle", textStyle);
		
		//Create log
		combatLog = new TextField("log", hudSkin, "textStyle");
		combatLog.setText(log);
		
		//Create table and add combatLog
		hudTable = new Table();
		hudTable.setFillParent(true);
		hudStage.addActor(hudTable);
		hudTable.add(combatLog).bottom().align(Align.right); //Choose where you want the actor
		
	}
	
	
	

	public void render ()  {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		hudStage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		hudStage.draw();
		
	}

	public void resize (int width, int height) {
		hudStage.getViewport().update(width, height, true);
	}

	public void dispose () {
		hudStage.dispose();
		getSkin().dispose();
	}

	public Skin getSkin() {
		return hudSkin;
	}

	public void setSkin(Skin skin) {
		this.hudSkin = skin;
	}
	
	
	
	
	
	
	
}
