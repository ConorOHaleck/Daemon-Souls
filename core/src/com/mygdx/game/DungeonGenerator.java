package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Rectangle;

public class DungeonGenerator {
	Map floor;
	DungeonTree data;
	
	public static ArrayList<Rectangle> generateRectangles()
	{
		DungeonTree data = new DungeonTree(new Rectangle(100,50,500,400), new Random());
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
		DungeonTree data = new DungeonTree(new Rectangle(0,0,700,500), new Random());
		data.split(2, .45f, .65f);
		data.link();
		ArrayList<DungeonTree> tree = data.traverse(data, new ArrayList<DungeonTree>());
		ArrayList<Rectangle> dungeonRects = generateRectangles();
		Map dungeonMap = new Map();

		
		for (int i = 0; i < 25; i++)
		{
			
			for (int j = 0; j < 25; j++)
			{	boolean matchFound = false;
				for (int k = 0; k < dungeonRects.size(); k++)
				{
					
					if (dungeonRects.get(k).contains(i, j))
					{
						Tile toAdd = new Tile(true);
						dungeonMap.addTile(toAdd);
						matchFound = true;
					}
				}
				if (!matchFound)
				{
					Tile toAdd = new Tile(false);
					dungeonMap.addTile(toAdd);
				}
			}
		}

		return dungeonMap;
	}
}
