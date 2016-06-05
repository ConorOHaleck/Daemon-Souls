/*
 * Hey guys! I have extra resources that are usable (effect, items, spell, trap, utility, water)
 * I just wanted to get you the main things (walls, floors, players). I'm thinking of just lumping
 * the other resources into classes based on boolean canCollide..
 * 
 * Additionally, players are actually 64*64 blocks, but we can change this if needed.
 */

package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	// AssetManager
	public AssetManager manager = new AssetManager();

	// Array lists to store all assets
	public static ArrayList<Floor> floorTiles = new ArrayList<Floor>();
	public static ArrayList<Wall> wallTiles = new ArrayList<Wall>();
	public static ArrayList<Animation> playerAnim = new ArrayList<Animation>();
	public static ArrayList<TextureRegion> playerImage = new ArrayList<TextureRegion>();
	public static ArrayList<Creature> creatureTiles = new ArrayList<Creature>();

	// Variable to hold animation frame durations (change as necessary)
	private static float time = 2F;

	// This is the overall spritesheet with all tiles should you need it..
	// private static Texture spriteSheet = new Texture("DungeonSprites.png");

	// Texture atlases for all tiles used.
	private static TextureAtlas creatures = new TextureAtlas("CurrentAssets/Creatures/creatures.atlas");
	private static TextureAtlas effect = new TextureAtlas("CurrentAssets/Effect/effect.atlas");
	private static TextureAtlas floor = new TextureAtlas("CurrentAssets/Floor/floor.atlas");
	private static TextureAtlas items = new TextureAtlas("CurrentAssets/Items/item.atlas");
	private static TextureAtlas spell = new TextureAtlas("CurrentAssets/Spell/spells.atlas");
	private static TextureAtlas trap = new TextureAtlas("CurrentAssets/Trap/trap.atlas");
	private static TextureAtlas utility = new TextureAtlas("CurrentAssets/Utility/utility.atlas");
	private static TextureAtlas wall = new TextureAtlas("CurrentAssets/Walls/walls.atlas");
	private static TextureAtlas water = new TextureAtlas("CurrentAssets/Water/water.atlas");

	// SpriteSheets for Players
	private static Texture barbF = new Texture("CurrentAssets/Player/Barbarian (F)/female barbarian sheet.png");
	private static Texture barbM = new Texture("CurrentAssets/Player/Barbarian (M)/male barbarian sheet.png");

	private static Texture knigF = new Texture("CurrentAssets/Player/Knight (F)/female knight sheet.png");
	private static Texture knigM = new Texture("CurrentAssets/Player/Knight (M)/male knight sheet.png");

	private static Texture monkF = new Texture("CurrentAssets/Player/Monk (F)/female monk sheet.png");
	private static Texture monkM = new Texture("CurrentAssets/Player/Monk (M)/male monk sheet.png");

	private static Texture wizF = new Texture("CurrentAssets/Player/Wizard (F)/female wizard sheet.png");
	private static Texture wizM = new Texture("CurrentAssets/Player/Wizard (M)/male wizard sheet.png");

	// Variables to hold temporary information.
	private static int size = 64;
	private static int bigSize = 192;
	private static int y = 0;
	private static ArrayList<TextureRegion> list = new ArrayList<TextureRegion>();
	private static TextureRegion arr[] = new TextureRegion[10];
	private static TextureRegion faceUp;
	private static TextureRegion faceLeft;
	private static TextureRegion faceDown;
	private static TextureRegion faceRight;

	// Method to return this assetManager
	public AssetManager getManager() {
		return manager;
	}

	// Method to return ArrayList of Animations
	// public static ArrayList

	// Method to instantiate all assets and prime for use.
	public static void initAssets() {

		// Initialize Floor Tiles
		for (AtlasRegion image : floor.getRegions()) {
			Floor floor = new Floor(image, 0, 0);
			floorTiles.add(floor);
		}

		// Initialize Wall Tiles
		for (AtlasRegion image : wall.getRegions()) {
			Wall wall = new Wall(image, 0, 0);
			wallTiles.add(wall);
		}

		// Initialize Creature 'Tiles'
		for (AtlasRegion image : creatures.getRegions()) {
			Creature creature = new Creature(image, 0, 0);
			creatureTiles.add(creature);
		}
	}

	// Initialize Players..

	// Initialize Barbarian Players
	// Female
	public static void initBarbarianF() {
		// Animations
		// Upward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		Animation upSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(upSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		Animation leftSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(leftSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		Animation downSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(downSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		Animation rightSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(rightSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 5);

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		Animation upMove = new Animation(time, list.toArray(arr));
		playerAnim.add(upMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		Animation leftMove = new Animation(time, list.toArray(arr));
		playerAnim.add(leftMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		Animation downMove = new Animation(time, list.toArray(arr));
		playerAnim.add(downMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		Animation rightMove = new Animation(time, list.toArray(arr));
		playerAnim.add(rightMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		Animation death = new Animation(time, list.toArray(arr));
		playerAnim.add(death);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y = 1536;

		// Up-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbF, x, y, bigSize, bigSize));
		}
		Animation upAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(upAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Left-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbF, x, y, bigSize, bigSize));
		}
		Animation leftAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(leftAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Down-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbF, x, y, bigSize, bigSize));
		}
		Animation downAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(downAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Right-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbF, x, y, bigSize, bigSize));
		}
		Animation rightAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(rightAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Images
		playerImage.add(faceUp = new TextureRegion(barbF, 0, (size * 8), size, size));
		playerImage.add(faceLeft = new TextureRegion(barbF, 0, (size * 9), size, size));
		playerImage.add(faceDown = new TextureRegion(barbF, 0, (size * 10), size, size));
		playerImage.add(faceRight = new TextureRegion(barbF, 0, (size * 11), size, size));
		//faceLeft = new TextureRegion
		y = 0; // (Just in case..)
	}

	// Male
	public static void initBarbarianM() {
		// Animations
		// Upward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		Animation upSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(upSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		Animation leftSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(leftSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		Animation downSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(downSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		Animation rightSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(rightSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 5);

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		Animation upMove = new Animation(time, list.toArray(arr));
		playerAnim.add(upMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		Animation leftMove = new Animation(time, list.toArray(arr));
		playerAnim.add(leftMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		Animation downMove = new Animation(time, list.toArray(arr));
		playerAnim.add(downMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		Animation rightMove = new Animation(time, list.toArray(arr));
		playerAnim.add(rightMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		Animation death = new Animation(time, list.toArray(arr));
		playerAnim.add(death);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y = 1536;

		// Up-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbM, x, y, bigSize, bigSize));
		}
		Animation upAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(upAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Left-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbM, x, y, bigSize, bigSize));
		}
		Animation leftAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(leftAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Down-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbM, x, y, bigSize, bigSize));
		}
		Animation downAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(downAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Right-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbM, x, y, bigSize, bigSize));
		}
		Animation rightAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(rightAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Images
		playerImage.add(faceUp = new TextureRegion(barbM, 0, (size * 8), size, size));
		playerImage.add(faceLeft = new TextureRegion(barbM, 0, (size * 9), size, size));
		playerImage.add(faceDown = new TextureRegion(barbM, 0, (size * 10), size, size));
		playerImage.add(faceRight = new TextureRegion(barbM, 0, (size * 11), size, size));
		y = 0; // (Just in case..)
	}

	// Initialize Knight Players
	// Female
	public static void initKnightF() {
		// Animations
		// Upward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		Animation upSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(upSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		Animation leftSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(leftSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		Animation downSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(downSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		Animation rightSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(rightSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 5);

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		Animation upMove = new Animation(time, list.toArray(arr));
		playerAnim.add(upMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		Animation leftMove = new Animation(time, list.toArray(arr));
		playerAnim.add(leftMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		Animation downMove = new Animation(time, list.toArray(arr));
		playerAnim.add(downMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		Animation rightMove = new Animation(time, list.toArray(arr));
		playerAnim.add(rightMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		Animation death = new Animation(time, list.toArray(arr));
		playerAnim.add(death);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y = 1536;

		// Up-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigF, x, y, bigSize, bigSize));
		}
		Animation upAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(upAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Left-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigF, x, y, bigSize, bigSize));
		}
		Animation leftAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(leftAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Down-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigF, x, y, bigSize, bigSize));
		}
		Animation downAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(downAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Right-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigF, x, y, bigSize, bigSize));
		}
		Animation rightAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(rightAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Images
		playerImage.add(faceUp = new TextureRegion(knigF, 0, (size * 8), size, size));
		playerImage.add(faceLeft = new TextureRegion(knigF, 0, (size * 9), size, size));
		playerImage.add(faceDown = new TextureRegion(knigF, 0, (size * 10), size, size));
		playerImage.add(faceRight = new TextureRegion(knigF, 0, (size * 11), size, size));
		y = 0; // (Just in case..)
	}

	// Male
	public static void initKnightM() {
		// Animations
		// Upward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		Animation upSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(upSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		Animation leftSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(leftSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		Animation downSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(downSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		Animation rightSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(rightSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 5);

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		Animation upMove = new Animation(time, list.toArray(arr));
		playerAnim.add(upMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		Animation leftMove = new Animation(time, list.toArray(arr));
		playerAnim.add(leftMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		Animation downMove = new Animation(time, list.toArray(arr));
		playerAnim.add(downMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		Animation rightMove = new Animation(time, list.toArray(arr));
		playerAnim.add(rightMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		Animation death = new Animation(time, list.toArray(arr));
		playerAnim.add(death);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y = 1536;

		// Up-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigM, x, y, bigSize, bigSize));
		}
		Animation upAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(upAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Left-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigM, x, y, bigSize, bigSize));
		}
		Animation leftAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(leftAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Down-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigM, x, y, bigSize, bigSize));
		}
		Animation downAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(downAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Right-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigM, x, y, bigSize, bigSize));
		}
		Animation rightAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(rightAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Images
		playerImage.add(faceUp = new TextureRegion(knigM, 0, (size * 8), size, size));
		playerImage.add(faceLeft = new TextureRegion(knigM, 0, (size * 9), size, size));
		playerImage.add(faceDown = new TextureRegion(knigM, 0, (size * 10), size, size));
		playerImage.add(faceRight = new TextureRegion(knigM, 0, (size * 11), size, size));
		y = 0; // (Just in case..)

	}

	// Initialize Monk Players
	// Female
	public static void initMonkF() {
		// Animations
		// Upward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		Animation upSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(upSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		Animation leftSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(leftSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		Animation downSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(downSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		Animation rightSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(rightSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Up-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		Animation upAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(upAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		Animation leftAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(leftAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		Animation downAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(downAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		Animation rightAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(rightAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		Animation upMove = new Animation(time, list.toArray(arr));
		playerAnim.add(upMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		Animation leftMove = new Animation(time, list.toArray(arr));
		playerAnim.add(leftMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		Animation downMove = new Animation(time, list.toArray(arr));
		playerAnim.add(downMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		Animation rightMove = new Animation(time, list.toArray(arr));
		playerAnim.add(rightMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		Animation death = new Animation(time, list.toArray(arr));
		playerAnim.add(death);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];

		// Images
		playerImage.add(faceUp = new TextureRegion(monkF, 0, (size * 8), size, size));
		playerImage.add(faceLeft = new TextureRegion(monkF, 0, (size * 9), size, size));
		playerImage.add(faceDown = new TextureRegion(monkF, 0, (size * 10), size, size));
		playerImage.add(faceRight = new TextureRegion(monkF, 0, (size * 11), size, size));
		y = 0; // (Just in case..)
	}

	public static void initMonkM() {
		// Animations
		// Upward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		Animation upSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(upSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		Animation leftSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(leftSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		Animation downSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(downSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		Animation rightSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(rightSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Up-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		Animation upAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(upAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		Animation leftAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(leftAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		Animation downAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(downAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		Animation rightAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(rightAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		Animation upMove = new Animation(time, list.toArray(arr));
		playerAnim.add(upMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		Animation leftMove = new Animation(time, list.toArray(arr));
		playerAnim.add(leftMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		Animation downMove = new Animation(time, list.toArray(arr));
		playerAnim.add(downMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		Animation rightMove = new Animation(time, list.toArray(arr));
		playerAnim.add(rightMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		Animation death = new Animation(time, list.toArray(arr));
		playerAnim.add(death);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];

		// Images
		playerImage.add(faceUp = new TextureRegion(monkM, 0, (size * 8), size, size));
		playerImage.add(faceLeft = new TextureRegion(monkM, 0, (size * 9), size, size));
		playerImage.add(faceDown = new TextureRegion(monkM, 0, (size * 10), size, size));
		playerImage.add(faceRight = new TextureRegion(monkM, 0, (size * 11), size, size));
		y = 0; // (Just in case..)
	}

	// Initialize Wizard Players
	// Female
	public static void initWizardF() {
		// Animations
		// Upward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		Animation upSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(upSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		Animation leftSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(leftSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		Animation downSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(downSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		Animation rightSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(rightSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Up-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		Animation upAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(upAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		Animation leftAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(leftAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		Animation downAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(downAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		Animation rightAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(rightAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		Animation upMove = new Animation(time, list.toArray(arr));
		playerAnim.add(upMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		Animation leftMove = new Animation(time, list.toArray(arr));
		playerAnim.add(leftMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		Animation downMove = new Animation(time, list.toArray(arr));
		playerAnim.add(downMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		Animation rightMove = new Animation(time, list.toArray(arr));
		playerAnim.add(rightMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		Animation death = new Animation(time, list.toArray(arr));
		playerAnim.add(death);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];

		// Images
		playerImage.add(faceUp = new TextureRegion(wizF, 0, (size * 8), size, size));
		playerImage.add(faceLeft = new TextureRegion(wizF, 0, (size * 9), size, size));
		playerImage.add(faceDown = new TextureRegion(wizF, 0, (size * 10), size, size));
		playerImage.add(faceRight = new TextureRegion(wizF, 0, (size * 11), size, size));
		y = 0; // (Just in case..)
	}

	// Male
	public static void initWizardM() {
		// Animations
		// Upward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		Animation upSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(upSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		Animation leftSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(leftSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		Animation downSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(downSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		Animation rightSpellCast = new Animation(time, list.toArray(arr));
		playerAnim.add(rightSpellCast);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Up-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		Animation upAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(upAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		Animation leftAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(leftAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		Animation downAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(downAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		Animation rightAttack = new Animation(time, list.toArray(arr));
		playerAnim.add(rightAttack);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		Animation upMove = new Animation(time, list.toArray(arr));
		playerAnim.add(upMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		Animation leftMove = new Animation(time, list.toArray(arr));
		playerAnim.add(leftMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		Animation downMove = new Animation(time, list.toArray(arr));
		playerAnim.add(downMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		Animation rightMove = new Animation(time, list.toArray(arr));
		playerAnim.add(rightMove);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		Animation death = new Animation(time, list.toArray(arr));
		playerAnim.add(death);
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];

		// Images
		playerImage.add(faceUp = new TextureRegion(wizM, 0, (size * 8), size, size));
		playerImage.add(faceLeft = new TextureRegion(wizM, 0, (size * 9), size, size));
		playerImage.add(faceDown = new TextureRegion(wizM, 0, (size * 10), size, size));
		playerImage.add(faceRight = new TextureRegion(wizM, 0, (size * 11), size, size));
		y = 0; // (Just in case..)
	}

}