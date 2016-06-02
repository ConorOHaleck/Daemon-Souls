package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;

public class Tile extends Entity {
	
	public static final int WIDTH = 32;
	public static final int HEIGHT = 32;
	private Texture img;
	
	public Tile(Texture img)
	{
		this.img = img;
	}
	
	public Texture getTexture()
	{
		return img;
	}
	
	
	
}
