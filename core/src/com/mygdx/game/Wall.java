package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Wall extends Tile {
	
	public Wall(Texture img) {
		super(img);
		this.setCanCollide(true);
	}

	public Wall(AtlasRegion image, int i, int j) {
		super(image, i, j);
	}

}
