package com.mygdx.game;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
	
	//all units are for map measurement are 1 tile from here on out
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	//int mapWidth = 20; //change me for maps 
	
	public void addTile(Tile tile)
	{
		tiles.add(tile);
	}
	
	public ArrayList<Tile> getTiles()
	{
		return this.tiles;
	}
	
	public void Draw(SpriteBatch bat)
	{
		for (int i = 0; i < tiles.size(); i++)
		{
			bat.draw(tiles.get(i).getTexture(), tiles.get(i).getX() * Tile.WIDTH, tiles.get(i).getY() * Tile.HEIGHT);
		}
	}
}
