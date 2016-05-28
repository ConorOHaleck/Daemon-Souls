package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

public class DungeonTree {

	DungeonNode value;
	DungeonTree left;
	DungeonTree right;
	
	public DungeonTree(Rectangle data)
	{
		this.value = new DungeonNode(data);
	}
	
	public void split(int depth)
	{
		this.left = new DungeonTree(new Rectangle(value.data.getX(), value.data.getY(), value.data.getWidth() /2, value.data.getHeight() /2));
		this.right = new DungeonTree(new Rectangle(value.data.getX()+ value.data.getWidth() /2, value.data.getY() + value.data.getHeight() /2, value.data.getWidth() /2, value.data.getHeight() /2));
		left.split(depth-1);
		right.split(depth-1);
	}
	
	public void link()
	{
		
	}
	
	private class DungeonNode
	{
		Rectangle data;
		
		public DungeonNode(Rectangle data)
		{
			this.data = data;
		}
		
		public void genRoom()
		{
			//lop off some width/height of the rectangle randomly
			
			//give it a random position within its former bounds
		}
	}
}


