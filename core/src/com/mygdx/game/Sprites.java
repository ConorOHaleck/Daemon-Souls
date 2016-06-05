//This is a 'dictionary' of commonly repeated or needed texture assets.
//It might be better to serialize them in a data file or something

package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Sprites {
	
//	public static final Texture DUNGEON_FLOOR_PLAIN = new Texture("max.jpg");
//	public static final Texture PLAYER = new Texture("playerFix.png");
//	public static final Texture DUNGEON_FLOOR_EMPTY = new Texture("empty.png");
	
	public static final TextureRegion DUNGEON_FLOOR_PLAIN = Assets.floorTiles.get(0).getImg();
	public static final TextureRegion DUNGEON_FLOOR_EMPTY = Assets.wallTiles.get(0).getImg();
	
	public static final TextureRegion P_UP = Assets.playerImage.get(0);
	public static final TextureRegion P_LEFT = Assets.playerImage.get(1);
	public static final TextureRegion P_DOWN = Assets.playerImage.get(2);
	public static final TextureRegion P_RIGHT = Assets.playerImage.get(3);
	
	
	


}
