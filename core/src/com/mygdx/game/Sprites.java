//This is a 'dictionary' of commonly repeated or needed texture assets.
//It might be better to serialize them in a data file or something

package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Sprites {
	
//	public static final Texture DUNGEON_FLOOR_PLAIN = new Texture("max.jpg");
//	public static final Texture PLAYER = new Texture("playerFix.png");
//	public static final Texture DUNGEON_FLOOR_EMPTY = new Texture("empty.png");

		public static final TextureRegion DUNGEON_FLOOR_PLAIN = Assets.floorTiles.get(0).getImg();
		public static final TextureRegion DUNGEON_FLOOR_EMPTY = Assets.wallTiles.get(0).getImg();
		
		//Player stand-still images.
		public static final TextureRegion P_UP = Assets.player_up;
		public static final TextureRegion P_LEFT = Assets.player_left;
		public static final TextureRegion P_DOWN = Assets.player_down;
		public static final TextureRegion P_RIGHT = Assets.player_right;
		
		//Player animations.
		private static float stateTime = 0f;
		
		public static final TextureRegion playerAnimate(Animation action){
			stateTime += Gdx.graphics.getDeltaTime();
			return action.getKeyFrame(stateTime, true);
		}
		
		
		//Some example monster assets to play with. I think they should look okay for testing purposes.
		public static final TextureRegion IMP = Assets.creatureTiles.get(9).img;
		public static final TextureRegion APE_MAN = Assets.creatureTiles.get(5).img;
		public static final TextureRegion OGRE = Assets.creatureTiles.get(34).img;


	}
	



