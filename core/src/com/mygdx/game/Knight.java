package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Knight extends Player {

	public Knight(String name, TextureRegion img) {
		super(img);
		this.setStrength(14);
		this.setAgility(4);
		this.setIntelligence(6);
		this.setVigor(18);
		
		this.setHealth(this.getVigor()*2);
		this.setMaxHp(this.getVigor()*2);
		this.setArmor(5);
		
		this.setName(name);
	}
	
	public void stab(Creature target) {
		int damage = (int) (0.6*this.getStrength()); //base damage values for ability is calculated first
		damage = this.flagCheckOffense(damage); //call attack flag checker for extra modifiers.
		System.out.println(this.getName() + " stabs " + target.getName() + "!");
		target.getHit(damage);
	}
	
	public void bulwark() {
		System.out.println(this.getName() + " activates Bulwark!");
		this.setBulwarkActive(ENABLED);
		this.setBulwarkDuration(1);
	}
	
	public void shieldBash(Creature target) {
		System.out.println(this.getName() + " bashes " + target.getName() + " with his shield!");
		int damage = (int) (0.3*this.getStrength());
		int healing = (int) (0.5*this.getArmor());
		target.getHit(damage);
		this.heal(healing);
	}

}
