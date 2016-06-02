package com.mygdx.game;

public class Rogue extends Player {
	
	public Rogue(String name) {
		this.setStrength(8);
		this.setAgility(16);
		this.setIntelligence(12);
		this.setVigor(12);
		
		this.setHealth(this.getVigor()*2);
		this.setMaxHp(this.getVigor()*2);
		this.setArmor(2);
		
		this.setName(name);
	}

}
