package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Undead extends Monster {
	
	static final int CHASE_TETHER = 5;
	static final int HIT_DAMAGE = 10;

	public Undead() {
		// TODO Auto-generated constructor stub
	}
	
	public Undead(TextureRegion img, int x, int y){
		super(img, x, y);
	}
	
	public Undead(TextureRegion img, int x, int y, Player pc){
		super(img, x, y);
		pCharacter = pc;
		
		this.setDefense(5);
		this.setHealth(5);
		this.setMaxHp(5);
		this.setName("" + this.getClass());
	}
	
	public void attack(Creature target){	
		target.getHit(HIT_DAMAGE);
	}
	
	public static class Zombie extends Undead{
		
		public Zombie(TextureRegion img, int x, int y, Player pc){
			super(img, x, y, pc);
		}
		
		boolean isMove;
		
		public void turn(){
			
			isMove = !isMove;
			
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
		}
	}
	
	public static class Wight extends Undead{
		
		public Wight(TextureRegion img, int x, int y, Player pc){
			super(img, x, y, pc);
		}
		
		public void turn(){
			
			updateProx();
			
			wander();
			
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
	}
	
	public static class Banshee extends Undead{
		
		public Banshee(TextureRegion img, int x, int y, Player pc){
			super(img, x, y, pc);
		}
		
		static final int CHASE_TETHER = 5;
		static final int AURA_TETHER = 2;
		
		public void turn(){
			
			updateProx();
			
			if(xProx>=(CHASE_TETHER*32)&&yProx>=(CHASE_TETHER*32)){
				wander();
			}
			
			else if(xProx<=(CHASE_TETHER*32)&&yProx<=(CHASE_TETHER*32)){
				if(xProx<(AURA_TETHER*32)||yProx<(AURA_TETHER*32)){
					spook(pCharacter);
					flee();
				}
				if(xProx>(AURA_TETHER*32)&&yProx>(AURA_TETHER*32)){
					chase();
				}
			}
			else{
				wander();
			}
		}
		
		public void spook(Player pc){
			
			if (this.xPos < pCharacter.xPos) {
				pCharacter.move(1, 0);
			
			} else if (this.xPos > pCharacter.xPos) {
				pCharacter.move(-1, 0);
				
			} else if (this.yPos > pCharacter.yPos) {
				pCharacter.move(0, -1);
				
			} else if (this.yPos < pCharacter.yPos) {
				pCharacter.move(0, 1);
			}
		}
	}

}
