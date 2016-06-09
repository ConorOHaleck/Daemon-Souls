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
	}

	public Undead(AtlasRegion image, int x, int y) {
		super(image, x, y);
		// TODO Auto-generated constructor stub
	}
	
	public Undead(AtlasRegion img, int x, int y, Player pc) {
		super(img, x, y, pc);
		// TODO Auto-generated constructor stub
	}
	
	public void attack(Creature target){	
		target.getHit(HIT_DAMAGE);
	}
	
	public class Zombie extends Undead{
		
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
	
	public class Wight extends Undead{
		
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
	
	public class Banshee extends Undead{
		
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
