package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

//A note to anyone changing this, the print statements are all for reference only, feel free to remove them if they become intrusive.
public class Creature extends Entity{
	// base stats
	private int strength;
	private int agility;
	private int intelligence;
	private int vigor;
	
	//secondary stats
	private int defense; //plan is to have multiple things contribute to defense, armor, agility, etc.
	private int health;
	private int maxHp;
	private int armor;
	
	private String name;
	
	//skills
	private int bulwarkActive = DISABLED;
	private int berserkerBloodActive= DISABLED;
	private int rageActive = DISABLED;
	private int monkDefense = DISABLED;
	private int mageArmor = DISABLED;
	private int rageDuration = 0;
	private int bulwarkDuration = 0;
	
	//cooldowns
	private int cleaveCD = 0;
	private int fireballCD = 0;
	private int bulwarkCD = 0;
	private int bashCd = 0;
	private int flurryCD = 0;
	private int serenityCD = 0;
	
	//flags
	public static final int JUST_ACTIVATED = 4;
	public static final int TO_REMOVE = 3;
	public static final int ENABLED = 1;
	public static final int DISABLED = 0;
	
	//remember old stats for temp buffs
	public int statStr;
	public int statAgi;
	public int statInt;
	public int statVig;
	
	public Creature() {
	}
	
	public Creature(AtlasRegion image, int x, int y) {
		super(image, x, y);
	}

	//general methods
	public void getHit(int damage) {
		this.defenseUpdate();
		damage = this.flagCheckDefense(damage);
		int hit = damage - this.defense;
		if (this.checkDeath(hit)) {
			die();
			System.out.println(this.getName() + " takes " + hit + " damage!");
			//Set gui hp to zero
		} else if (hit < 0) {
			//might do something here, this block only exists to prevent negative damage from healing you.
			//System.out.println(this.getName() + " hp: " + health);
			System.out.println(this.getName() + " takes " + 0 + " damage!");
		} else {
			this.health -= hit;
			//System.out.println(this.getName() + " hp: " + health);
			System.out.println(this.getName() + " takes " + hit + " damage!");
			//update gui hp normally
		}
	}
	
	public void heal(int healing) {
		int health = this.getHealth();
		health += healing;
		if (health >= this.getMaxHp()) {
			this.setHealth(maxHp);
			System.out.println(this.getName() + " hp: " + this.getHealth());
		} else {
			this.setHealth(health);
			System.out.println(this.getName() + " hp: " + this.getHealth());
		}
	}
	
	public int flagCheckDefense(int damage) {
		if (isBulwarkActive() == ENABLED) {
			damage = bulwarkActivate(damage);
			return damage;
		}
		
		if (getMonkDefense() == ENABLED) {
			return monkDefense(damage);
		}
		
		if (getMageArmor() == ENABLED) {
			int arm = this.mageArmor();
			this.armor = arm;
			this.defenseUpdate();
		}
		
		if (getRageActive() == ENABLED) {
			double damg = damage;
			damage = (int) (damage *2);
			return damage;
		}
		return damage;
		
	}
	
	public int flagCheckOffense(int damage) {
		if (getBerserkerBloodActive() == ENABLED) {
			damage = this.berserkerBlood(damage);
			return damage;
		} else {
			return damage;
		}
	}
	
	public void clearBuffs() {
		if (isBulwarkActive() == ENABLED) setBulwarkActive(DISABLED);
	}
	
	public boolean checkDeath(int damage) {
		return (this.health - damage) <= 0;
	}
	
	public void die() {
		System.out.println(this.getName() + " dies.");
	}
	
	public void defenseUpdate() {
		int def = (int) (this.armor + (this.agility*0.5));
		this.defense = def;
	}
	
	//skill methods
	public int bulwarkActivate(int damage) {
		damage = 0;
		return damage;
	}
	
	public int berserkerBlood(int damage) {
		double max = this.getMaxHp();
		double hp = this.getHealth();
		double hpDiff = max-hp;
		double mod = (hpDiff/max);
		damage = (int) (damage*(1+mod));
		return damage;
	}
	
	public int monkDefense(int damage) {
		if ((damage - defense) > 10) {
			damage = 10;
			System.out.println(this.getName() + " softens the blow!"); // I'm not sure if monks should benefit from defense or how that works with monk defense
			this.setDefense(0);
			return damage;
		} else {
			return damage;
		}
	}
	
	public int mageArmor() {
		return (int) (0.3*this.intelligence);
	}
	
	public void rageActive() {
		this.setRageActive(ENABLED);
		this.statStr = this.getStrength();
		double str = this.statStr;
		int newStr = (int) (str*1.5);
		this.setStrength(newStr);
	}
	
	public void rageDeactive() {
		this.setRageActive(DISABLED);
		this.setStrength(this.statStr);
	}
	
	
	
	//getters and setters
	public int getBerserkerBloodActive() {
		return berserkerBloodActive;
	}
	public void setBerserkerBloodActive(int berserkerBloodActive) {
		this.berserkerBloodActive = berserkerBloodActive;
	}
	
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getVigor() {
		return vigor;
	}
	public void setVigor(int vigor) {
		this.vigor = vigor;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defence) {
		this.defense = defence;
	}	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int isBulwarkActive() {
		return bulwarkActive;
	}
	public void setBulwarkActive(int bulwark_active) {
		this.bulwarkActive = bulwark_active;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int max_hp) {
		this.maxHp = max_hp;
	}
	
	public int getMonkDefense() {
		return monkDefense;
	}
	public void setMonkDefense(int monkDefense) {
		this.monkDefense = monkDefense;
	}

	public int getMageArmor() {
		return mageArmor;
	}

	public void setMageArmor(int mageArmor) {
		this.mageArmor = mageArmor;
	}

	public int getRageDuration() {
		return rageDuration;
	}

	public void setRageDuration(int rageDuration) {
		this.rageDuration = rageDuration;
	}

	public int getBulwarkDuration() {
		return bulwarkDuration;
	}

	public void setBulwarkDuration(int bulwarkDuration) {
		this.bulwarkDuration = bulwarkDuration;
	}

	public int getRageActive() {
		return rageActive;
	}

	public void setRageActive(int rageActive) {
		this.rageActive = rageActive;
	}

	public int getCleaveCD() {
		return cleaveCD;
	}

	public void setCleaveCD(int cleaveCD) {
		this.cleaveCD = cleaveCD;
	}

	public int getFireballCD() {
		return fireballCD;
	}

	public void setFireballCD(int fireballCD) {
		this.fireballCD = fireballCD;
	}

	public int getBulwarkCD() {
		return bulwarkCD;
	}

	public void setBulwarkCD(int bulwarkCD) {
		this.bulwarkCD = bulwarkCD;
	}

	public int getBashCd() {
		return bashCd;
	}

	public void setBashCd(int bashCd) {
		this.bashCd = bashCd;
	}

	public int getFlurryCD() {
		return flurryCD;
	}

	public void setFlurryCD(int flurryCD) {
		this.flurryCD = flurryCD;
	}

	public int getSerenityCD() {
		return serenityCD;
	}

	public void setSerenityCD(int serenityCD) {
		this.serenityCD = serenityCD;
	}
}
