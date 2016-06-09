package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Ooze extends Monster {

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
		
	}
	
	public static class Gelatin extends Ooze{
		
		boolean isMove = true;
		
		public Gelatin(Player pc){
			super(Assets.creatureTiles.get(30).img, 0, 0, pc);
			
			this.setName("Gelatin");
			this.setMaxHp(80);
			this.setHealth(80);
			this.setDefense(1);
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
		}
	}

}
