package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Wall extends Tile {
	
	public Wall(TextureRegion img) {
		super(img);
		this.setCanCollide(true);
	}

	public Wall(AtlasRegion image, int i, int j) {
		super(image, i, j);
	}

}
