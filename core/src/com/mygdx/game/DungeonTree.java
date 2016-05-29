package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

public class DungeonTree {

	DungeonNode value;
	DungeonTree left;
	DungeonTree right;
	Rectangle hallway;
	
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
		Rectangle leftRect;
		Rectangle rightRect;
		Rectangle topRect;
		Rectangle botRect;
		if (this.left.value.data.getX() > this.right.value.data.getX())
		{
			rightRect = this.left.value.data;
			leftRect = this.right.value.data;
		}
		else
		{
			rightRect = this.right.value.data;
			leftRect = this.left.value.data;
		}
		
		if (this.left.value.data.getY() > this.right.value.data.getY())
		{
			topRect = this.left.value.data;
			botRect = this.right.value.data;
		}
		else
		{
			botRect = this.right.value.data;
			topRect = this.left.value.data;
		}
		
		if (topRect.getY() <= botRect.getY()+botRect.getHeight())
		{
			//generate horizontal hallway rect
			hallway = new Rectangle(leftRect.getX()+leftRect.getWidth(), topRect.getY(), rightRect.getX() - leftRect.getX() + leftRect.getWidth(), 1);
		}
		
		if (rightRect.getX() <= leftRect.getX()+leftRect.getWidth())
		{
			//generate vertical hallway rect
			hallway = new Rectangle(rightRect.getX(), topRect.getY(), 1, topRect.getY() - botRect.getY() + botRect.getHeight());
		}
		
		else
		{
			//generate L-shape rect
		}
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
			data.setWidth(data.getWidth() * .7f);
			data.setHeight(data.getHeight() * .7f);
			
		}
	}
}


