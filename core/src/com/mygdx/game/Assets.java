package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	//Animations and player Images
	public static Animation move_up;
	public static Animation move_left;
	public static Animation move_down;
	public static Animation move_right;
	
	public static Animation spell_up;
	public static Animation spell_left;
	public static Animation spell_down;
	public static Animation spell_right;
	
	public static Animation attack_up;
	public static Animation attack_left;
	public static Animation attack_down;
	public static Animation attack_right;
	
	public static Animation death;
	
	public static TextureRegion player_up;
	public static TextureRegion player_left;
	public static TextureRegion player_down;
	public static TextureRegion player_right;
	
	
	// Array lists to store all assets
	public static ArrayList<Floor> floorTiles = new ArrayList<Floor>();
	public static ArrayList<Wall> wallTiles = new ArrayList<Wall>();
	public static ArrayList<Creature> creatureTiles = new ArrayList<Creature>();

	// Variable to hold animation frame durations (change as necessary)
	private static float time = 0.025F;

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

	// Method to instantiate all assets and prime for use.
	public static void initAssets() {

		// Initialize Floor Tiles
		for (AtlasRegion image : floor.getRegions()) {
			Floor floor = new Floor(image);
			floorTiles.add(floor);
		}

		// Initialize Wall Tiles
		for (AtlasRegion image : wall.getRegions()) {
			Wall wall = new Wall(image);
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
		spell_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		spell_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		spell_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		spell_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 5);

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		move_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		move_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		move_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		move_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(barbF, x, y, size, size));
		}
		death = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y = 1536;

		// Up-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbF, x, y, bigSize, bigSize));
		}
		attack_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Left-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbF, x, y, bigSize, bigSize));
		}
		attack_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Down-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbF, x, y, bigSize, bigSize));
		}
		attack_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Right-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbF, x, y, bigSize, bigSize));
		}
		attack_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Images
		player_up = new TextureRegion(barbF, 0, (size * 8), size, size);
		player_left = new TextureRegion(barbF, 0, (size * 9), size, size);
		player_down = new TextureRegion(barbF, 0, (size * 10), size, size);
		player_right = new TextureRegion(barbF, 0, (size * 11), size, size);
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
		spell_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		spell_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		spell_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		spell_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 5);

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		move_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		move_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		move_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		move_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(barbM, x, y, size, size));
		}
		death = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y = 1536;

		// Up-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbM, x, y, bigSize, bigSize));
		}
		attack_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Left-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbM, x, y, bigSize, bigSize));
		}
		attack_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Down-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbM, x, y, bigSize, bigSize));
		}
		attack_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Right-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(barbM, x, y, bigSize, bigSize));
		}
		attack_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Images
		player_up = new TextureRegion(barbM, 0, (size * 8), size, size);
		player_left = new TextureRegion(barbM, 0, (size * 9), size, size);
		player_down = new TextureRegion(barbM, 0, (size * 10), size, size);
		player_right = new TextureRegion(barbM, 0, (size * 11), size, size);
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
		spell_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		spell_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		spell_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		spell_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 5);

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		move_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		move_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		move_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		move_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(knigF, x, y, size, size));
		}
		death = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y = 1536;

		// Up-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigF, x, y, bigSize, bigSize));
		}
		attack_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Left-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigF, x, y, bigSize, bigSize));
		}
		attack_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Down-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigF, x, y, bigSize, bigSize));
		}
		attack_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Right-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigF, x, y, bigSize, bigSize));
		}
		attack_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Images
		player_up = new TextureRegion(knigF, 0, (size * 8), size, size);
		player_left = new TextureRegion(knigF, 0, (size * 9), size, size);
		player_down = new TextureRegion(knigF, 0, (size * 10), size, size);
		player_right = new TextureRegion(knigF, 0, (size * 11), size, size);
		y = 0; // (Just in case..)
	}

	// Male
	public static void initKnightM() {
		// Animations
		// Upward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		spell_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		spell_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		spell_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		spell_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 5);

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		move_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		move_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		move_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		move_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(knigM, x, y, size, size));
		}
		death = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y = 1536;

		// Up-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigM, x, y, bigSize, bigSize));
		}
		attack_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Left-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigM, x, y, bigSize, bigSize));
		}
		attack_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Down-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigM, x, y, bigSize, bigSize));
		}
		attack_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Right-facing attack
		for (int x = 0; x < 1152; x += bigSize) {
			list.add(new TextureRegion(knigM, x, y, bigSize, bigSize));
		}
		attack_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += bigSize;

		// Images
		player_up = new TextureRegion(knigM, 0, (size * 8), size, size);
		player_left = new TextureRegion(knigM, 0, (size * 9), size, size);
		player_down = new TextureRegion(knigM, 0, (size * 10), size, size);
		player_right = new TextureRegion(knigM, 0, (size * 11), size, size);
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
		spell_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		spell_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		spell_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		spell_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Up-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		attack_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		attack_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		attack_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		attack_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		move_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		move_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		move_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		move_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(monkF, x, y, size, size));
		}
		death = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];

		// Images
		player_up = new TextureRegion(monkF, 0, (size * 8), size, size);
		player_left = new TextureRegion(monkF, 0, (size * 9), size, size);
		player_down = new TextureRegion(monkF, 0, (size * 10), size, size);
		player_right = new TextureRegion(monkF, 0, (size * 11), size, size);
		y = 0; // (Just in case..)
	}

	public static void initMonkM() {
		// Animations
		// Upward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		spell_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		spell_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		spell_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		spell_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Up-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		attack_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		attack_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		attack_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		attack_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		move_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		move_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		move_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		move_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(monkM, x, y, size, size));
		}
		death = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];

		// Images
		player_up = new TextureRegion(monkM, 0, (size * 8), size, size);
		player_left = new TextureRegion(monkM, 0, (size * 9), size, size);
		player_down = new TextureRegion(monkM, 0, (size * 10), size, size);
		player_right = new TextureRegion(monkM, 0, (size * 11), size, size);
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
		spell_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		spell_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		spell_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		spell_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Up-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		attack_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		attack_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		attack_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		attack_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		move_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		move_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		move_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;
		
		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		move_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(wizF, x, y, size, size));
		}
		death = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];

		// Images
		player_up = new TextureRegion(wizF, 0, (size * 8), size, size);
		player_left = new TextureRegion(wizF, 0, (size * 9), size, size);
		player_down = new TextureRegion(wizF, 0, (size * 10), size, size);
		player_right = new TextureRegion(wizF, 0, (size * 11), size, size);
		y = 0; // (Just in case..)
	}

	// Male
	public static void initWizardM() {
		// Animations
		// Upward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		spell_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Leftward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		spell_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Downward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		spell_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Rightward-facing spellcast
		for (int x = 0; x < 448; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		spell_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Up-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		attack_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		attack_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		attack_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing attack
		for (int x = 0; x < 512; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		attack_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Upward-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		move_up = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Left-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		move_left = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Down-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		move_down = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += size;

		// Right-facing movement
		for (int x = 0; x < 576; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		move_right = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];
		y += (size * 9);

		// Player death
		for (int x = 0; x < 384; x += size) {
			list.add(new TextureRegion(wizM, x, y, size, size));
		}
		death = new Animation(time, list.toArray(arr));
		list = new ArrayList<TextureRegion>();
		arr = new TextureRegion[10];

		// Images
		player_up = new TextureRegion(wizM, 0, (size * 8), size, size);
		player_left = new TextureRegion(wizM, 0, (size * 9), size, size);
		player_down = new TextureRegion(wizM, 0, (size * 10), size, size);
		player_right = new TextureRegion(wizM, 0, (size * 11), size, size);
		y = 0; // (Just in case..)
	}

}