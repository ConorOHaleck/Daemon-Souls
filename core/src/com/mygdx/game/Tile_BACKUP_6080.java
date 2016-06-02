package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;

public class Tile extends Entity {
	
	public static final int WIDTH = 32;
	public static final int HEIGHT = 32;
<<<<<<< HEAD
	private Texture img;
	private boolean canCollide = false;
	
=======
	
	private int x;
	private int y;
	
	private boolean walkable = false;
	private Texture img;
	
	public Tile(boolean walkable)
	{
		this.walkable = walkable;
	}
	
	
>>>>>>> f982a337410325946f46c0b4d7773daef57d3757
	public Tile(Texture img)
	{
		this.img = img;
	}
	
<<<<<<< HEAD
=======
	public Tile(boolean walkable, int posX, int posY) {
		// TODO Auto-generated constructor stub
		this.walkable = walkable;
		this.x = posX;
		this.y = posY;
	}


>>>>>>> f982a337410325946f46c0b4d7773daef57d3757
	public Texture getTexture()
	{
		return img;
	}
<<<<<<< HEAD
	
<<<<<<< HEAD
=======

	public boolean isCanCollide() {
		return canCollide;
	}

	public void setCanCollide(boolean canCollide) {
		this.canCollide = canCollide;
	}
>>>>>>> 66beb7e915eed76d11bcdd264200288e6f245898
	
=======
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
>>>>>>> f982a337410325946f46c0b4d7773daef57d3757
	
}
