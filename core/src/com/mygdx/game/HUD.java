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
	private static String log = "Combat Log: ";
	
	
	public static void create(){
		hudStage = new Stage();
		hudSkin = new Skin();
		//Gdx.input.setInputProcessor(hudStage);

		hudSkin.add("default", new BitmapFont());
		
		//Create combatLog's textFieldStyle
		TextFieldStyle textStyle = new TextFieldStyle();
		textStyle.fontColor = Color.CYAN;
		textStyle.font = hudSkin.getFont("default");
		hudSkin.add("textStyle", textStyle);
		
		//Create log
		combatLog = new TextField(log, hudSkin, "textStyle");
		combatLog.setText(log);
		combatLog.setMessageText(log);
		combatLog.setOrigin(Align.center);
		
		//Add actors to hudStage
		hudStage.addActor(combatLog);
		
	}
	
	
	

	public void render ()  {
		//Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
	
	public void setLog(String log){
		this.log = log;
	}
	
	
	
	
	
}
