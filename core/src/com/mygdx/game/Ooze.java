package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Ooze extends Monster {
	
	static final int CHASE_TETHER = 3;
	
	int growCheck = 0;
	int childLimit;

	public Ooze() {
		// TODO Auto-generated constructor stub
	}

	public Ooze(TextureRegion img, int x, int y) {
		super(img, x, y);
		// TODO Auto-generated constructor stub
	}

	public Ooze(TextureRegion img, int x, int y, Player pc) {
		super(img, x, y, pc);
		// TODO Auto-generated constructor stub
	}
	
	public void attack(Player pc){
		pc.getHit(10);
	}
	
	public void grow(Ooze newJelly){
		
		MyGdxGame.enemyList.add(newJelly);
		MyGdxGame.testDungeon.populants.add(newJelly);
		
		Tile growthTile = MyGdxGame.testDungeon.getTileAt(this.xPos/32, this.yPos/32);
		int tempX = this.xPos;
		int tempY = this.yPos;
		wander();
		
		growthTile.setOccupant(newJelly);
		growthTile.setCanCollide(true);
		newJelly.xPos = tempX;
		newJelly.yPos = tempY;
	}
	
	public static class Gelatin extends Ooze{
		

		boolean isMove = true;
		
		public Gelatin(Player pc){
			super(Assets.creatureTiles.get(0).img, 0, 0, pc);
			
			this.setName("Gelatin");
			this.setMaxHp(60);
			this.setHealth(60);
			this.setDefense(1);
			this.childLimit = 1;
		}
		
		public void turn(){
			
			isMove=!isMove;
			updateProx();
			
			if(isMove){
				if(xProx<=32&&yProx<=32){
					attack(pCharacter);
				}
				else if(xProx<=(CHASE_TETHER*32)&&yProx<=(CHASE_TETHER*32)){
					chase();
				}
				else{
					wander();
				}
			}
			
			if(growCheck>=12&&childLimit>0){
				grow(new Gelatin(pCharacter));
				growCheck = 0;
				childLimit--;
			}
			else if(xProx<=180&&yProx<=180){
				growCheck++;
			}
		}
		

	}
	
	public static class Skuzz extends Ooze{
		
		boolean isMove = true;
		
		public Skuzz(Player pc){
			super(Assets.creatureTiles.get(99).img, 0, 0, pc);
			
			this.setName("Skuzz");
			this.setMaxHp(5);
			this.setHealth(5);
			this.setDefense(1);
			childLimit = 2;
		}
		
		public void turn(){
			
			isMove=!isMove;
			updateProx();
			
			if(isMove){
				if(xProx<=32&&yProx<=32){
					attack(pCharacter);
				}
				else if(xProx<=(CHASE_TETHER*32)&&yProx<=(CHASE_TETHER*32)){
					chase();
				}
				else{
					wander();
				}
			}
			
			if(growCheck>=6&&childLimit>0){
				grow(new Skuzz(pCharacter));
				growCheck = 0;
				childLimit--;

			}
			else if(xProx<=180&&yProx<=180){
				growCheck++;
			}
		}
		

	}
	
	public static class Creep extends Ooze{
		
		int childLimit = 2;
		
		public Creep(Player pc){
			super(Assets.creatureTiles.get(108).img, 0, 0, pc);
			
			this.setName("Creep");
			this.setMaxHp(80);
			this.setHealth(80);
			this.setDefense(10);
			childLimit = 4;
		}
		
		public void attack(Player pc){
			pc.getHit(20);
		}
		
		public void turn(){

			updateProx();
			
				if(xProx<=32&&yProx<=32){
					attack(pCharacter);
				}
			
			if(growCheck>=10&&childLimit>0){
				grow(new Creep(pCharacter));
				growCheck = 0;
				childLimit--;

			}
			else if(xProx<=180&&yProx<=180){
				growCheck++;
			}
		}
		

	}
	
	

}
