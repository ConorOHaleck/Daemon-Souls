package com.mygdx.game;
import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Map {

	//all units are for map measurement are 1 tile from here on out
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	public static final int MAP_WIDTH = 200; //change me for maps 
	ArrayList<Rectangle> rooms = new ArrayList<Rectangle>();
	
	//any and all non-player entities that exist on this Map
	ArrayList<Entity> populants = new ArrayList<Entity>();
	Random rng = new Random();

	//Adds a tile to the map without any position information.
	public void addTile(Tile tile)
	{
		tiles.add(tile);
	}

	//Adds a geometric representation of a room to the map. Used for spawning monsters, items
	public void addRoom(Rectangle room)
	{
		rooms.add(room);
	}

	public void populateRooms(ArrayList<Monster> monsters)
	{
		for (int i = 0; i < rooms.size(); i++)
		{
			Rectangle room = rooms.get(i);
			
			int xPos = (int) (rng.nextInt((int) (Math.abs(room.getWidth()) + room.getX())));
			int yPos = (int) (rng.nextInt((int) (Math.abs(room.getHeight()) + room.getY())));
			
			
			Creature monster = monsters.get(rng.nextInt(monsters.size()));
			
			monster.setPos(xPos *32, yPos * 32);
			getTileAt(xPos, yPos).setOccupant(monster);
			populants.add(monster);
		}
	}


	//return the tile at the specified X,Y location. Assumes each tile is being added top to bottom, left to right.
	//Otherwise, you'll get garbage.
	public Tile getTileAt(int xpos, int ypos)
	{
		//System.out.println("Testing tile index retrieval");
		//System.out.println("Input X: " + xpos + " Y: " + ypos);
		//System.out.println("Tile X: " + tiles.get(ypos + xpos *MAP_WIDTH).getX());
		//System.out.println("Tile Y: " + tiles.get(ypos + xpos * MAP_WIDTH).getY());
		return tiles.get(ypos + xpos * MAP_WIDTH);
	}

	//Gets all tiles that belong to this Map.
	public ArrayList<Tile> getTiles()
	{
		return this.tiles;
	}

	//Draws the tile using the specified spritebatch.
	public void Draw(SpriteBatch bat)
	{
		for (int i = 0; i < tiles.size(); i++)
		{
			bat.draw(tiles.get(i).getImg(), tiles.get(i).getX() * Tile.WIDTH, tiles.get(i).getY() * Tile.HEIGHT);
		}
	}
}
