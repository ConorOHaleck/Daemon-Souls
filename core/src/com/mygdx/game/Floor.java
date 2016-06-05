package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Floor extends Tile {

	public Floor(TextureRegion img) {
		super(img);
		this.setCanCollide(true);
	}

	public Floor(AtlasRegion image, int i, int j) {
		super(image, i, j);
	}
	
}
