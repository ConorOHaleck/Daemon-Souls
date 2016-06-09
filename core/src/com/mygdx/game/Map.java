package com.mygdx.game;
import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Map {

	//all units are for map measurement are 1 tile from here on out
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	public static final int MAP_WIDTH = 200; //change me for maps 
	ArrayList<Rectangle> rooms = new ArrayList<Rectangle>();

	//any and all non-player entities that exist on this Map
	ArrayList<Monster> populants = new ArrayList<Monster>();
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
		int j = 0;
		for (int i = 0; i < monsters.size(); i++)
		{
			Rectangle room = rooms.get(j);
			Vector2 center = new Vector2();
			center = room.getCenter(center);
			int xPos = (int) center.x;
			int yPos = (int) center.y;

			//quadrant?

			if ((int)room.getWidth()/2 > 0 && (int)room.getHeight()/2 > 0 )
			{
				int quadrant = rng.nextInt(4);

				if (quadrant == 0)
				{
					xPos += rng.nextInt((int) room.getWidth()/2);
					yPos += rng.nextInt((int) room.getHeight()/2);
				}

				if (quadrant == 1)
				{
					xPos -= rng.nextInt((int) room.getWidth()/2);
					yPos += rng.nextInt((int) room.getHeight()/2);
				}

				if (quadrant == 2)
				{
					xPos -= rng.nextInt((int) room.getWidth()/2);
					yPos -= rng.nextInt((int) room.getHeight()/2);
				}


				if (quadrant == 3)
				{
					xPos -= rng.nextInt((int) room.getWidth()/2);
					yPos += rng.nextInt((int) room.getHeight()/2);
				}
			}


			System.out.println("XSpawn: " + xPos);
			System.out.println("YSpawn: " + xPos);
			Monster monster = monsters.get(i);

			monster.setPos(xPos *32, yPos * 32);
			getTileAt(xPos, yPos).setOccupant(monster);
			populants.add(monster);

			j++;

			if (j >= rooms.size())
			{
				j = 0;
			}
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
			bat.draw(tiles.get(i).getImg(), tiles.get(i).getX()*Tile.WIDTH-Tile.WIDTH, tiles.get(i).getY() * Tile.HEIGHT);
		}
	}

	public void makeStairs() {
		Random rng = new Random();
		Tile tile;
		int stairX = rng.nextInt(Map.MAP_WIDTH)*Tile.WIDTH;
		int stairY = rng.nextInt(Map.MAP_WIDTH)*Tile.HEIGHT;

		tile = MyGdxGame.testDungeon.getTileAt((stairX/Tile.WIDTH), (stairY/Tile.HEIGHT));

		if (tile.isCanCollide() == false) {
			tile.setStairs(true);
			MyGdxGame.stairX = stairX;
			MyGdxGame.stairY = stairY;
		} else {
			makeStairs();
		}
	}
}
