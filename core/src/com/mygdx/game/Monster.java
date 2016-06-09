package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.mygdx.game.Creature.Movement;

public class Monster extends Creature {
	
	//TODO CHANGE THIS TO WHATEVER THE PLAYER ENDS UP BEING!!!!
	public Player pCharacter;
	
	public int xProx;
	public int yProx;
	
	public Player getpCharacter() {
		return pCharacter;
	}

	public void setpCharacter(Player pCharacter) {
		this.pCharacter = pCharacter;
	}

	public int getxProx() {
		return xProx;
	}

	public void setxProx(int xProx) {
		this.xProx = xProx;
	}

	public int getyProx() {
		return yProx;
	}

	public void setyProx(int yProx) {
		this.yProx = yProx;
	}



	public Monster() {
		// TODO Auto-generated constructor stub
	}
	
	public Monster(TextureRegion img, int x, int y){
		super(img, x, y);
	}
	
	public Monster(TextureRegion img, int x, int y, Player pc){
		super(img, x, y);
		pCharacter = pc;
	}

	public Monster(AtlasRegion image, int x, int y) {
		super(image, x, y);
		// TODO Auto-generated constructor stub
	}
	
	public Monster(AtlasRegion image, int x, int y, Player pc) {
		super(image, x, y);
		pCharacter = pc;
		// TODO Auto-generated constructor stub
	}
	


	public void turn(){
		//All monsters have a turn() method. Its the iterating call when its ENEMY_TURN. This is just to cover my ass in default
		wander();
	}
	
	public void move(Movement command){
		
		Tile oldTile;
		oldTile = MyGdxGame.testDungeon.getTileAt((this.xPos/Tile.WIDTH), (this.yPos/Tile.HEIGHT));
		Tile newTile;
		newTile = MyGdxGame.testDungeon.getTileAt(((this.xPos/Tile.WIDTH)+(command.x*32)), ((this.yPos/Tile.HEIGHT))+(command.y*32));
		
		if(!newTile.isCanCollide()){
			oldTile.setOccupant(null);
			oldTile.setCanCollide(false);
			
			xPos += Tile.WIDTH * command.x;
			yPos += Tile.HEIGHT * command.y;
			
	
			newTile.setOccupant(this);
			newTile.setCanCollide(true);
		}
		else{
			//Something upon bumping into something else?
		}
	}
	
	//These next methods are all for the most basic of movements
	
	public void chase(){
		
		float pX = pCharacter.xPos;
		float pY = pCharacter.yPos;
		
		if(pX>this.xPos){
			if(pY>this.yPos){
				move(D_R_UP);
			}
			else if(pY<this.yPos){
				move(D_R_DOWN);
			}
			else if(pY==this.yPos){
				move(RIGHT);
			}
		}
		else if(pX<this.xPos){
			if(pY>this.yPos){
				move(D_L_UP);
			}
			else if(pY<this.yPos){
				move(D_L_DOWN);
			}
			else if(pY==this.yPos){
				move(LEFT);
			}
		}
		else if(pX==this.xPos){
			if(pY>this.yPos){
				move(UP);
			}
			else if(pY<this.yPos){
				move(DOWN);
			}
			else if(pY==this.yPos){
				//Not gonna lie, if you got here, something's VERY wrong
				System.out.println("Error in movement processing.");
			}
		}
		
	}
	
	public void flee(){
		float pX = pCharacter.xPos;
		float pY = pCharacter.yPos;
		
		if(pX>this.xPos){
			if(pY>this.yPos){
				move(D_L_DOWN);
			}
			else if(pY<this.yPos){
				move(D_L_UP);
			}
			else if(pY==this.yPos){
				move(LEFT);
			}
		}
		else if(pX<this.xPos){
			if(pY>this.yPos){
				move(D_R_DOWN);
			}
			else if(pY<this.yPos){
				move(D_R_UP);
			}
			else if(pY==this.yPos){
				move(RIGHT);
			}
		}
		else if(pX==this.xPos){
			if(pY>this.yPos){
				move(DOWN);
			}
			else if(pY<this.yPos){
				move(UP);
			}
			else if(pY==this.yPos){
				//Not gonna lie, if you got here, something's VERY wrong
				System.out.println("Error in movement processing.");
			}
		}
	}
	
	public void wander(){
		
		Random rand = new Random();
		
		//Note: random range does not correspond with number of options because there is a chance for the monster to do nothing.
		int direction = rand.nextInt(10);
		
		switch(direction){
		
		case 0:
			move(UP);
			break;
		case 1:
			move(DOWN);
			break;
		case 2:
			move(RIGHT);
			break;
		case 3:
			move(LEFT);
			break;
		case 4:
			move(D_R_UP);
			break;
		case 5:
			move(D_R_DOWN);
			break;
		case 6:
			move(D_L_UP);
			break;
		case 7:
			move(D_L_DOWN);
			break;
		}
	}
	
	public void updateProx(){
		
		xProx = (int) Math.abs(pCharacter.xPos - this.xPos);
		System.out.println("pCharacter map X = " + pCharacter.xPos);
		System.out.println("this map X" + this.xPos);
		yProx = (int) Math.abs(pCharacter.yPos - this.yPos);
		
	}
	

}
