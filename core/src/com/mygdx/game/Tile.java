package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;

public class Tile extends Entity {
	
	public static final int WIDTH = 32;
	public static final int HEIGHT = 32;
	
	private int x;
	private int y;
	
	private boolean walkable = false;
	private Texture img;
	
	public Tile(boolean walkable)
	{
		this.walkable = walkable;
	}
	
	
	public Tile(Texture img)
	{
		this.img = img;
	}
	
	public Tile(boolean walkable, int posX, int posY) {
		// TODO Auto-generated constructor stub
		this.walkable = walkable;
		this.x = posX;
		this.y = posY;
	}


	public Texture getTexture()
	{
		return img;
	}
	
	public void setTexture(Texture tex)
	{
		this.img = tex;
	}


	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return walkable;
	}


	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}
	
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}
	
}
