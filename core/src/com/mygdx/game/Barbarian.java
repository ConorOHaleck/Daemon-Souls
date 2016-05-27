package com.mygdx.game;

public class Barbarian extends Player{
	
	public Barbarian(String name) {
		this.setStrength(18);
		this.setAgility(6);
		this.setIntelligence(6);
		this.setVigor(15);
		
		this.setHealth(this.getVigor()*2);
		this.setMaxHp(this.getVigor()*2);
		this.setArmor(0);
		
		this.setName(name);
		this.setBerserkerBloodActive(ENABLED);
	}
	
	public void chop(Creature target) {
		int damage = (int) (0.7*this.getStrength());
		damage = this.flagCheckOffense(damage);
		System.out.println(this.getName() + " attacks " + target.getName() + " with a mighty chop!");
		target.getHit(damage);
	}
	
	public void cleave() {
		// This is the method that will be called first when cleave is used. 
		//It will determine which spaces are filled and call the appropriate overload.
	}
	
	public void cleave(Creature target) {
		int damage = (int) (0.5*this.getStrength());
		damage = this.flagCheckOffense(damage);
		System.out.println(this.getName() + " cleaves to  " + target.getName() + " !");
		target.getHit(damage);
	}
	
	public void cleave(Creature target1, Creature target2) {
		int damage = (int) (0.5*this.getStrength());
		damage = this.flagCheckOffense(damage);
		System.out.println(this.getName() + " cleaves to  " + target1.getName() + " and " + target2.getName() + " !");
		target1.getHit(damage);
		target2.getHit(damage);
	}
	public void cleave(Creature target1, Creature target2, Creature target3) {
		int damage = (int) (0.5*this.getStrength());
		damage = this.flagCheckOffense(damage);
		System.out.println(this.getName() + " cleaves to " + target1.getName() + ", " + target2.getName() + ", and "+ target3.getName() + "!");
		target1.getHit(damage);
		target2.getHit(damage);
		target3.getHit(damage);
	}
	

}
