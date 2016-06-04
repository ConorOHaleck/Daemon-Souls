package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

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
		this.setImg(img);
	}
	
	public Tile(Texture img, int x, int y)
	{
		super(img, x, y);
	}
	
	public Tile(AtlasRegion image, int i, int j) {
		// TODO Auto-generated constructor stub
		super(image, i, j);
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
	
	
}
