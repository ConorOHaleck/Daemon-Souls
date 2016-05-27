package com.mygdx.game;

public class Wizard extends Player{
	
	public Wizard(String name) {
		this.setStrength(4);
		this.setAgility(6);
		this.setIntelligence(18);
		this.setVigor(8);
		
		this.setHealth(this.getVigor()*2);
		this.setMaxHp(this.getVigor()*2);
		this.setArmor(0);
		
		this.setName(name);
		this.setMageArmor(ENABLED);
	}
	
	public void iceLance(Creature target) {
		int damage = (int) (1.5*this.getIntelligence());
		System.out.println(this.getName() + " fires a lance of ice!");
		target.getHit(damage);
	}
	
	public void fireball() {
		// same procedure as cleave
	}
	
	public void fireball(Creature target) {
		int damage = (int) (0.8*this.getIntelligence());
		System.out.println(this.getName() + "tosses out a huge fireball!");
		target.getHit(damage);
	}
	
	public void fireball(Creature target1, Creature target2) {
		int damage = (int) (0.8*this.getIntelligence());
		System.out.println(this.getName() + "tosses out a huge fireball!");
		target1.getHit(damage);
		target2.getHit(damage);
	}
	
	public void fireball(Creature target1, Creature target2, Creature target3) {
		int damage = (int) (0.8*this.getIntelligence());
		System.out.println(this.getName() + " tosses out a huge fireball!");
		target1.getHit(damage);
		target2.getHit(damage);
		target3.getHit(damage);
	}
	
	public void fireball(Creature target1, Creature target2, Creature target3, Creature target4) {
		int damage = (int) (0.8*this.getIntelligence());
		System.out.println(this.getName() + "tosses out a huge fireball!");
		target1.getHit(damage);
		target2.getHit(damage);
		target3.getHit(damage);
		target4.getHit(damage);
	}

}
