package com.mygdx.game;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
	
	//all units are for map measurement are 1 tile from here on out
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	public static final int MAP_WIDTH = 200; //change me for maps 
	
	//Adds a tile to the map without any position information.
	public void addTile(Tile tile)
	{
		tiles.add(tile);
	}
	
	//return the tile at the specified X,Y location. Assumes each tile is being added top to bottom, left to right.
	//Otherwise, you'll get garbage.
	public Tile getTileAt(int xpos, int ypos)
	{
		System.out.println("Testing tile index retrieval");
		System.out.println("Input X: " + xpos + " Y: " + ypos);
		System.out.println("Tile X: " + tiles.get(ypos + xpos *MAP_WIDTH).getX());
		System.out.println("Tile Y: " + tiles.get(ypos + xpos * MAP_WIDTH).getY());
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
			bat.draw(tiles.get(i).getTexture(), tiles.get(i).getX() * Tile.WIDTH, tiles.get(i).getY() * Tile.HEIGHT);
		}
	}
}
