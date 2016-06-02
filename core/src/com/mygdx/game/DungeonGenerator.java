package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Rectangle;

public class DungeonGenerator {
	Map floor;
	DungeonTree data;
	
	public static ArrayList<Rectangle> generateRectangles()
	{
		DungeonTree data = new DungeonTree(new Rectangle(0,0,200,200), new Random());
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
	
	public static Map generateDungeon()
	{
		//DungeonTree data = new DungeonTree(new Rectangle(0,0,700,500), new Random());
		//data.split(2, .45f, .65f);
		//data.link();
		//ArrayList<DungeonTree> tree = data.traverse(data, new ArrayList<DungeonTree>());
		ArrayList<Rectangle> dungeonRects = generateRectangles();
		Map dungeonMap = new Map();

		
		for (int x = 0; x < 200; x++)
		{
			for (int y = 0; y < 200; y++)
			{	
				boolean tileFound = false;
				for (int i = 0; i < dungeonRects.size(); i++)
				{
					if (dungeonRects.get(i).contains(x,y))
					{
						dungeonMap.addTile(new Tile(true, x, y));
						tileFound = true;
					}
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
