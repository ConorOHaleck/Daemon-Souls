package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity {
	Texture img;
	Float xPos;
	Float yPos;
	
	public Entity()
	{
		xPos = 0.0f;
		yPos = 0.0f;
	}
	
	public Entity(Texture img, float x, float y)
	{
		this.img = img;
		this.xPos = x;
		this.yPos = y;
	}
	
	public void setPos(Float x, Float y)
	{
		xPos = x;
		yPos = y;
	}
	
	public void Draw(SpriteBatch bat)
	{
		bat.draw(img, xPos, yPos);
		
	}
}
