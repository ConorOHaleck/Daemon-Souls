package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Floor extends Tile {

	public Floor(Texture img) {
		super(img);
		this.setCanCollide(true);
	}
	
}
