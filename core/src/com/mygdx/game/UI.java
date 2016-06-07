package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

public class UI {
	private Skin skin;
	private Stage stage;
	private Table table;
	private Label lblmOrF;
	private Label lblClass;
	private TextButton btnFemale;
	private TextButton btnMale;
	private TextButton btnBarbarian;
	private TextButton btnKnight;
	private TextButton btnMonk;
	private TextButton btnWizard;
	private TextButton btnFinished;
	private TextButton gender;
	private TextButton classChoice;
	private ButtonGroup<TextButton> classBtnGroup;
	private ButtonGroup<TextButton> genderBtnGroup;
	private String name = "testHorse";
	private int num = -1;
	private boolean finished = false;

	public void create() {
		stage = new Stage();
		skin = new Skin();
		Gdx.input.setInputProcessor(stage);

		//Create "white" Texture
		Pixmap pixWhite = new Pixmap(1, 1, Format.RGBA8888);
		pixWhite.setColor(Color.WHITE);
		pixWhite.fill();
		skin.add("white", new Texture(pixWhite));
		
		//Create "black" Texture
		Pixmap pixBlack = new Pixmap(1,1, Format.RGBA8888);
		pixBlack.setColor(Color.BLACK);
		pixBlack.fill();
		skin.add("black", new Texture(pixBlack));

		// Store the default libgdx font under the name "default".
		skin.add("default", new BitmapFont());

		//Configure labelStyle
		LabelStyle lblStyle = new LabelStyle();
		lblStyle.font = skin.getFont("default");
		lblStyle.fontColor = Color.WHITE;
		
		//Add Labels
		lblmOrF = new Label("Gender Preference: ", lblStyle);
		lblClass = new Label("Player Class Preference: ", lblStyle);
		
		//Configure btnStyleMale
		TextButtonStyle btnStyleMale = new TextButtonStyle();
		btnStyleMale.up = skin.newDrawable("white", Color.CYAN);
		btnStyleMale.down = skin.newDrawable("white");
		btnStyleMale.checked = skin.getDrawable("white");
		btnStyleMale.font = skin.getFont("default");
		btnStyleMale.downFontColor = Color.BLACK;
		skin.add("maleStyle", btnStyleMale);
		
		//Configure btnStyleFemale
		TextButtonStyle btnStyleFemale = new TextButtonStyle(btnStyleMale);
		btnStyleFemale.up = skin.newDrawable("white", Color.PINK);
		skin.add("femaleStyle", btnStyleFemale);
		
		//Create gender buttons
		btnFemale = new TextButton("Female", skin, "femaleStyle");
		btnMale = new TextButton("Male", skin, "maleStyle");
		
		//Create genderBtnGroup and add gender buttons
		genderBtnGroup = new ButtonGroup<TextButton>(btnMale, btnFemale);
		genderBtnGroup.setMaxCheckCount(1);
		
		//Configure class button styles
		TextButtonStyle btnStyleBarb = new TextButtonStyle(btnStyleFemale);
		btnStyleBarb.up = skin.newDrawable("white", Color.ORANGE);
		skin.add("barbStyle", btnStyleBarb);
		TextButtonStyle btnStyleKnight = new TextButtonStyle(btnStyleFemale);
		btnStyleKnight.up = skin.newDrawable("white", Color.GREEN);
		skin.add("knightStyle", btnStyleKnight);
		TextButtonStyle btnStyleMonk = new TextButtonStyle(btnStyleFemale);
		btnStyleMonk.up = skin.newDrawable("white", Color.YELLOW);
		skin.add("monkStyle", btnStyleMonk);
		TextButtonStyle btnStyleWiz = new TextButtonStyle(btnStyleFemale);
		btnStyleWiz.up = skin.newDrawable("white", Color.BLUE);
		skin.add("wizStyle", btnStyleWiz);		
		
		//Create class buttons
		btnBarbarian = new TextButton("Barbarian", skin, "barbStyle");
		btnKnight = new TextButton("Knight", skin, "knightStyle");
		btnMonk = new TextButton("Monk", skin, "monkStyle");
		btnWizard = new TextButton("Wizard", skin, "wizStyle");
	
		//Create classBtnGroup and add class buttons.
		classBtnGroup = new ButtonGroup<TextButton>(
				btnBarbarian, btnKnight, btnMonk, btnWizard);
		classBtnGroup.setMaxCheckCount(1);
		
		//Configure btnStyleFin
		TextButtonStyle btnStyleFin = new TextButtonStyle(btnStyleWiz);
		btnStyleFin.up = skin.newDrawable("white", Color.GOLD);
		skin.add("styleFin", btnStyleFin);
		
		//Create finish button
		btnFinished = new TextButton("I'm done choosing. Let's play!", skin, "styleFin");
		
		// Create a table that fills the screen. Everything else will go inside this table.
		table = new Table();
		table.setFillParent(true);
		stage.addActor(table);

		
		table.add(lblmOrF, btnMale, btnFemale);
		table.row();
		table.add( lblClass, btnBarbarian, btnKnight, btnMonk, btnWizard);
		table.row();
		table.add(btnFinished);
		
		
		btnFinished.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				gender = genderBtnGroup.getChecked();
				classChoice = classBtnGroup.getChecked();
				
				
				if (gender != null && classChoice != null){
					if(classChoice == btnBarbarian){
						num = 0;
						if (gender == btnMale){
							Assets.initBarbarianM();
							finished = true;
						} else if (gender == btnFemale){
							Assets.initBarbarianF();
							finished = true;
						} else {
							System.out.println("Error in ui assignment of Barbarian");
						} 
					} else if (classChoice == btnKnight){
						num = 1;
						if (gender == btnMale){
							Assets.initKnightM();
							finished = true;
						} else if (gender == btnFemale){
							Assets.initKnightF();
							finished = true;
						} else {
							System.out.println("Error in ui assignment of Knight");
						}
					} else if (classChoice == btnMonk){
						num = 2;
						if (gender == btnMale){
							Assets.initMonkM();
							finished = true;
						} else if (gender == btnFemale){
							Assets.initMonkF();
							finished = true;
						} else {
							System.out.println("Error in ui assignment of Monk");
						}
					} else if (classChoice == btnWizard){
						num = 3;
						if (gender == btnMale){
							Assets.initWizardM();
							finished = true;
						} else if (gender == btnFemale){
							Assets.initWizardF();
							finished = true;
						} else {
							System.out.println("Error in ui assignment of Wizard");
						}
					} 
					}
				if(finished) btnFinished.setText("Loading Excitement");
			}
		});
	}

	public void render ()  {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		//if (finished) kill switch
	}

	public void resize (int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	public void dispose () {
		stage.dispose();
		skin.dispose();
	}
}