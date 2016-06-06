//This is a 'dictionary' of commonly repeated or needed texture assets.
//It might be better to serialize them in a data file or something

package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Sprites {
	
//	public static final Texture DUNGEON_FLOOR_PLAIN = new Texture("max.jpg");
//	public static final Texture PLAYER = new Texture("playerFix.png");
//	public static final Texture DUNGEON_FLOOR_EMPTY = new Texture("empty.png");

		public static final TextureRegion DUNGEON_FLOOR_PLAIN = Assets.floorTiles.get(0).getImg();
		public static final TextureRegion DUNGEON_FLOOR_EMPTY = Assets.wallTiles.get(0).getImg();
		
		//Player stand-still images.
		public static final TextureRegion P_UP = Assets.playerImage.get(0);
		public static final TextureRegion P_LEFT = Assets.playerImage.get(1);
		public static final TextureRegion P_DOWN = Assets.playerImage.get(2);
		public static final TextureRegion P_RIGHT = Assets.playerImage.get(3);
		
		//Player animations.
		public static final Animation SPELL_UP = Assets.playerAnim.get(0);
		public static final Animation SPELL_LEFT = Assets.playerAnim.get(1);
		public static final Animation SPELL_DOWN = Assets.playerAnim.get(2);
		public static final Animation SPELL_RIGHT = Assets.playerAnim.get(3);
		
		public static final Animation MOVE_UP = Assets.playerAnim.get(4);
		public static final Animation MOVE_LEFT = Assets.playerAnim.get(5);
		public static final Animation MOVE_DOWN = Assets.playerAnim.get(6);
		public static final Animation MOVE_RIGHT = Assets.playerAnim.get(7);
		
		public static final Animation ATTACK_UP = Assets.playerAnim.get(8);
		public static final Animation ATTACK_LEFT = Assets.playerAnim.get(9);
		public static final Animation ATTACK_DOWN = Assets.playerAnim.get(10);
		public static final Animation ATTACK_RIGHT = Assets.playerAnim.get(11);
		
		
		
		//Some example monster assets to play with. I think they should look okay for testing purposes.
		public static final TextureRegion IMP = Assets.creatureTiles.get(9).img;
		public static final TextureRegion APE_MAN = Assets.creatureTiles.get(5).img;
		public static final TextureRegion OGRE = Assets.creatureTiles.get(34).img;


	}
	



