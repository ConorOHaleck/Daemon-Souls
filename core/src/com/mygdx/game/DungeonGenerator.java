package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Rectangle;

public class DungeonGenerator {
	Map floor;
	DungeonTree data;
	
	public static Map generateDungeon()
	{
		DungeonTree data = new DungeonTree(new Rectangle(0,0,50,50), new Random());
		data.split(3);
		data.link();
		ArrayList<DungeonTree> tiles = data.traverse(data, new ArrayList<DungeonTree>());
		
		for (int i = 0; i < tiles.size(); i++)
		{
			
		}
		return null;
	}
}
