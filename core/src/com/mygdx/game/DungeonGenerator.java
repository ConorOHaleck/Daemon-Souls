package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Rectangle;

//Class full of static methods for generating new dungeon floors
public class DungeonGenerator {
	
	//Generates a dungeon and returns its geometric rectangle objects. Useful for debugging and discovering where "rooms" are.
	public static ArrayList<Rectangle> generateRectangles()
	{
		DungeonTree data = new DungeonTree(new Rectangle(0,0, Map.MAP_WIDTH,200), new Random());
		data.split(4, .55f, .65f);
		data.link();
		ArrayList<DungeonTree> tree = data.traverse(data, new ArrayList<DungeonTree>());
		ArrayList<Rectangle> dungeonRects = new ArrayList<Rectangle>();
		Map dungeonMap = new Map();
		for (int i = 0; i < tree.size(); i++)
		{
			if (tree.get(i).getRoom() != null)
			{
				dungeonRects.add(tree.get(i).getRoom());
				
			}
			if (tree.get(i).hallwayVert != null)
				dungeonRects.add(tree.get(i).hallwayVert);
			if (tree.get(i).hallwayHoriz != null)
				dungeonRects.add(tree.get(i).hallwayHoriz);
			
		}
		return dungeonRects;
	}
	
	//Generates a dungeon using the BSP algorithm and returns its corresponding Map object.
	public static Map generateDungeon()
	{
		//DungeonTree data = new DungeonTree(new Rectangle(0,0,700,500), new Random());
		//data.split(2, .45f, .65f);
		//data.link();
		//ArrayList<DungeonTree> tree = data.traverse(data, new ArrayList<DungeonTree>());
		ArrayList<Rectangle> dungeonRects = generateRectangles();
		Map dungeonMap = new Map();

		
		for (int x = 0; x < Map.MAP_WIDTH; x++)
		{
			for (int y = 0; y < 200; y++)
			{	
				boolean tileFound = false;
				for (int i = 0; i < dungeonRects.size(); i++)
				{
					if (dungeonRects.get(i).contains(x,y))
					{
						tileFound = true;
					}
				}
				
				if (tileFound)
				{
					dungeonMap.addTile(new Tile(true, x, y));
				}
				
				if (!tileFound)
				{
					dungeonMap.addTile(new Tile(false, x, y));
				}
			}
		}

		return dungeonMap;
	}
}
