package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;

public class Tile extends Entity {
	
	public static final int WIDTH = 32;
	public static final int HEIGHT = 32;
	private Texture img;
	private boolean canCollide = false;
	private int x;
	private int y;
	private boolean walkable = false;
	
	
	public Tile(boolean walkable, int posX, int posY) {
		// TODO Auto-generated constructor stub
		this.walkable = walkable;
		this.x = posX;
		this.y = posY;
	}
	
	public Tile(Texture img)
	{
		this.img = img;
	}
	
	public Texture getTexture()
	{
		return img;
	}

	public boolean isCanCollide() {
		return canCollide;
	}

	public void setCanCollide(boolean canCollide) {
		this.canCollide = canCollide;
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
