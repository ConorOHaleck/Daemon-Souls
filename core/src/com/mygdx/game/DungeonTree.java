package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
<<<<<<< HEAD

public class DungeonTree {

	DungeonNode value;
	DungeonTree left = null;
	DungeonTree right = null;
	Rectangle hallway;
	Random rng;
	
	public DungeonTree(Rectangle data, Random rng)
	{
		this.value = new DungeonNode(data);
	}
	
	public void split(int depth)
	{
		if (depth > 0)
		{
			this.left = new DungeonTree(new Rectangle(value.data.getX(), value.data.getY(), value.data.getWidth() /2, value.data.getHeight() /2), rng);
			this.right = new DungeonTree(new Rectangle(value.data.getX()+ value.data.getWidth() /2, value.data.getY() + value.data.getHeight() /2, value.data.getWidth() /2, value.data.getHeight() /2), rng);
			left.split(depth-1);
			right.split(depth-1);
		}
		else
		{
			System.out.println("Split successful!");
			return;
		}
	}
	
=======
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

public class DungeonTree {

	DungeonNode node;
	DungeonTree left = null;
	DungeonTree right = null;
	Rectangle hallwayVert;
	Rectangle hallwayHoriz;
	Random rng;

	public DungeonTree(Rectangle data, Random rng)
	{
		this.node = new DungeonNode(data);
		this.rng = rng;
	}

	public void split(int depth, float minRatio, float maxRatio)
	{
		float factor = -1;

		while (factor < minRatio || factor > maxRatio)
		{
			factor = rng.nextFloat();
		}

		if (depth > 0)
		{
			if (rng.nextInt(2) == 0)
			{
				System.out.println("Split factor:" + factor);
				this.left = new DungeonTree(new Rectangle(node.bounds.getX(), node.bounds.getY(), node.bounds.getWidth() * factor, node.bounds.getHeight()), rng);
				this.right = new DungeonTree(new Rectangle(node.bounds.getX()+this.left.node.bounds.getWidth(), node.bounds.getY(), node.bounds.getWidth()-this.left.node.bounds.getWidth(), node.bounds.getHeight()), rng);
			}
			else 
			{
				System.out.println("Split factor:" + factor);
				this.left = new DungeonTree(new Rectangle(node.bounds.getX(), node.bounds.getY(), node.bounds.getWidth(), node.bounds.getHeight() * factor), rng);
				this.right = new DungeonTree(new Rectangle(node.bounds.getX(), node.bounds.getY()+this.left.node.bounds.getHeight(), node.bounds.getWidth(), node.bounds.getHeight()-this.left.node.bounds.getHeight()), rng);

			}

			left.split(depth-1, minRatio, maxRatio);
			right.split(depth-1, minRatio, maxRatio);



		}
		else
		{
			this.node.genRoom();
			//System.out.println("Split successful!");
			return;
		}
	}

	public Rectangle getData()
	{
		return this.node.bounds;
	}

	public Rectangle getRoom()
	{
		return this.node.room;
	}

>>>>>>> f982a337410325946f46c0b4d7773daef57d3757
	public void link()
	{
		Rectangle leftRect;
		Rectangle rightRect;
		Rectangle topRect;
		Rectangle botRect;
<<<<<<< HEAD
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
		
=======
		
		Vector2 centerL;
		Vector2 centerR;

		if (this.left.node.bounds != null)
		{
			
			if (this.left.getRoom() != null)
			{
				centerL = this.left.getRoom().getCenter(new Vector2());
				centerR = this.right.getRoom().getCenter(new Vector2());
			}
			
			else
			{
				 centerL = this.left.node.bounds.getCenter(new Vector2());
				 centerR = this.right.node.bounds.getCenter(new Vector2());
			}
			if (centerL.x < centerR.x)
			{
				hallwayHoriz = new Rectangle(centerL.x, centerL.y, centerR.x - centerL.x, 2);
			}
			
			else
			{
				hallwayHoriz = new Rectangle(centerR.x, centerR.y, centerL.x - centerR.x, 2);
			}
			
			if (centerL.y < centerR.y)
			{
				hallwayVert = new Rectangle(centerL.x, centerL.y, 2, centerR.y - centerL.y);
			}
		

			if (left.left != null)
			{
				left.link();
				right.link();
			}

			//			if (this.left.node.room.getX() > this.right.node.room.getX())
			//			{
			//				rightRect = this.left.node.room;
			//				leftRect = this.right.node.room;
			//			}
			//			else
			//			{
			//				rightRect = this.right.node.room;
			//				leftRect = this.left.node.room;
			//			}
			//
			//			if (this.left.node.room.getY() > this.right.node.room.getY())
			//			{
			//				topRect = this.left.node.room;
			//				botRect = this.right.node.room;
			//			}
			//			else
			//			{
			//				topRect = this.right.node.room;
			//				botRect = this.left.node.room;
			//			}
			//
			//			if (topRect.getY() <= botRect.getY()+botRect.getHeight())
			//			{
			//				//generate horizontal hallway rect
			//				hallway = new Rectangle(leftRect.getX()+leftRect.getWidth(), rightRect.getY(), rightRect.getX() - leftRect.getX() - leftRect.getWidth(), 2);
			//			}
			//
			//			else if (leftRect.getX() <= rightRect.getX()+rightRect.getWidth())
			//			{
			//				//generate vertical hallway rect
			//				hallway = new Rectangle(rightRect.getX(), botRect.getY() , 2, topRect.getY() - botRect.getY() - botRect.getHeight());
			//			}
			//
			//			else
			//			{
			//				//generate L-shape rect
			//			}
		}
	}



	private class DungeonNode
	{
		Rectangle bounds;
		Rectangle room;

		public DungeonNode(Rectangle data)
		{
			this.bounds = data;
		}

>>>>>>> f982a337410325946f46c0b4d7773daef57d3757
		public void genRoom()
		{
			//lop off some width/height of the rectangle randomly
			//give it a random position within its former bounds
<<<<<<< HEAD
			data.setWidth(data.getWidth() * rng.nextFloat());
			data.setHeight(data.getHeight() * rng.nextFloat());
		}
	}
	
	public ArrayList<DungeonTree> traverse (DungeonTree root, ArrayList<DungeonTree> nodes){ 
	   
		nodes.add(root);
		if (root.left != null){
	        traverse(root.left, nodes);
	    }
	    //System.out.println(root.value);
	    if (root.right != null){
	        traverse(root.right, nodes);
	    }
	    System.out.println(root);
	    return nodes;
	}
	
	public ArrayList<Rectangle> getLeafData(ArrayList<DungeonTree> rects) {
		
		traverse(this, rects);
		
=======

			this.room = new Rectangle(bounds);
			float factor1 = -1;
			while (factor1 < .25f || factor1 > .85f)
			{
				factor1 = rng.nextFloat();
			}

			float factor2 = -1;
			while (factor2 < .45f || factor2 > .55f)
			{
				factor2 = rng.nextFloat();
			}
			room.setWidth(bounds.getWidth() * factor1);
			room.setHeight(bounds.getHeight() * factor2);
			Vector2 center = new Vector2();
			center = bounds.getCenter(center);
			room.setCenter(center);
			//room.setY(center.y - room.getHeight());
		}
	}

	public ArrayList<DungeonTree> traverse (DungeonTree root, ArrayList<DungeonTree> nodes){ 

		nodes.add(root);
		if (root.left != null){
			traverse(root.left, nodes);
		}
		//System.out.println(root.value);
		if (root.right != null){
			traverse(root.right, nodes);
		}
		//System.out.println(root);
		return nodes;
	}

	public ArrayList<Rectangle> getLeafData(ArrayList<DungeonTree> rects) {

		traverse(this, rects);

>>>>>>> f982a337410325946f46c0b4d7773daef57d3757
		//if (this.left != null)
		//{
		//	rects.add(this.value.data);
		//}
<<<<<<< HEAD
		
=======

>>>>>>> f982a337410325946f46c0b4d7773daef57d3757
		//else 
		//{
		//	rects.add(this.left.getLeafData(rects).get(0));
		//	rects.add(this.right.getLeafData(rects).get(0));
		//}
		return null;
	}
}


