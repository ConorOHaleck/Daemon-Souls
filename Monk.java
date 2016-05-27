
public class Monk extends Player {
	
	public Monk(String name) {
		this.setStrength(14);
		this.setAgility(18);
		this.setIntelligence(6);
		this.setVigor(13);
		
		this.setHealth(this.getVigor()*2);
		this.setMaxHp(this.getVigor()*2);
		this.setArmor(0);
		
		this.setName(name);
		this.setMonkDefense(ENABLED);
	}
	
	public void jab(Creature target) {
		int damage = (int) ((0.4*this.getStrength()) + (0.3*this.getAgility()));
		damage = this.flagCheckOffense(damage);
		System.out.println(this.getName() + " attacks " + target.getName() + " with a quick jab!");
		target.getHit(damage);
	}
	
	public void flurry(Creature target) {
		System.out.println(this.getName() + " attacks " + target.getName() + " with a flurry of blows!");
		this.jab(target);
		this.jab(target);
		this.jab(target);
		this.jab(target);
	}

}
