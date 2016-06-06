package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Entity {
	TextureRegion img;
	int xPos;
	int yPos;
	
	public Entity()
	{
		xPos = 0;
		yPos = 0;
	}
	
	public Entity(TextureRegion img, int x, int y)
	{
		this.img = img;
		this.xPos = x;
		this.yPos = y;
	}
	
	public Entity(AtlasRegion img, int x, int y)
	{
		this.img = img;
		this.xPos = x;
		this.yPos = y;
	}
	
	public void setPos(int i, int j)
	{
		xPos = i;
		yPos = j;
	}
	
	public void Draw(SpriteBatch bat)
	{
		bat.draw(this.img, this.xPos, this.yPos, 0, 0, Tile.WIDTH, Tile.HEIGHT, 1, 1, 90, true);
		
	}
}
