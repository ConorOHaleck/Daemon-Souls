package com.mygdx.game;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
	
	//all units are for map measurement are 1 tile from here on out
	ArrayList<Tile> tiles = new ArrayList<Tile>();
<<<<<<< HEAD
	int mapWidth = 20; //change me for maps 
=======
	//int mapWidth = 20; //change me for maps 
>>>>>>> f982a337410325946f46c0b4d7773daef57d3757
	
	public void addTile(Tile tile)
	{
		tiles.add(tile);
	}
	
	public ArrayList<Tile> getTiles()
	{
		return this.tiles;
	}
	
	public Tile getTile(float x, float y) {
		Tile tile;
		
		for (int i = 0; i < tiles.size(); i++) {
			tile = tiles.get(i);
			if (tile.xPos == x && tile.yPos == y) {
				return tile;
				
			} else {
				System.out.println("Tile not found");
				return null;
			}
		}
		System.out.println("Tile not found");
		return null;
		
	}
	
	public void Draw(SpriteBatch bat)
	{
<<<<<<< HEAD
		int x = 0;
		int y = 0;
		for (int i = 0; i < tiles.size(); i++)
		{
			bat.draw(tiles.get(i).getTexture(), x * Tile.WIDTH, y * Tile.HEIGHT);
			x++;
			if (i % mapWidth == 0 && i != 0)
			{
				x = 0;
				y += 1;
			}
=======
		for (int i = 0; i < tiles.size(); i++)
		{
			bat.draw(tiles.get(i).getTexture(), tiles.get(i).getX() * Tile.WIDTH, tiles.get(i).getY() * Tile.HEIGHT);
>>>>>>> f982a337410325946f46c0b4d7773daef57d3757
		}
	}
}
