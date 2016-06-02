package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Wall extends Tile {
	
	public Wall(Texture img) {
		super(img);
		this.setCanCollide(true);
	}

}
