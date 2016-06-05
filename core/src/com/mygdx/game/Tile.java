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
	private Entity occupant;
	
	
	public Tile(boolean walkable, int posX, int posY) {
		// TODO Auto-generated constructor stub
		this.walkable = walkable;
		this.x = posX;
		this.y = posY;
	}
	
	public Tile(Texture img)
	{
		this.setImg(img);
	}
	
	public Texture getTexture()
	{
		return getImg();
	}

	public boolean isCanCollide() {
		return canCollide;
	}

	public boolean walkable()
	{
		return walkable;
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

	public Texture getImg() {
		return img;
	}

	public void setImg(Texture img) {
		this.img = img;
	}
	
	public Entity getOccupant() {
		return occupant;
	}
	
	public void setOccupant(Entity occupant) {
		this.occupant = occupant;
	}
	
	
}
