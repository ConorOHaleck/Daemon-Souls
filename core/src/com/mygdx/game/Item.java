package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Item extends Entity {
	
	String itemName;
	Player equippedOn;
	int invLocation;
	

	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(Player hasIt) {
		equippedOn = hasIt;
	}

	public Item(TextureRegion img, int x, int y) {
		super(img, x, y);
		// TODO Auto-generated constructor stub
	}

	public Item(AtlasRegion img, int x, int y) {
		super(img, x, y);
		// TODO Auto-generated constructor stub
	}
	
	
	public void pickUp(Player adventurer){
		int i = 0;
		while(i < adventurer.inventory.length){
			if(adventurer.inventory[i]==null){
				adventurer.inventory[i] = this;
				invLocation = i;
				
				//TODO undraw goes here.
				this.xPos = -50000;
				this.yPos = -50000;
				
				this.equip();
			}
		}

	}
	
	public void drop(){
		equippedOn.inventory[invLocation] = null;
		this.deEquip();
		
		//TODO Everything below here will work with the collection thing, just a few tweaks
		
		int dropDecider = equippedOn.getFacing();
		int xLoc = equippedOn.xPos;
		int yLoc = equippedOn.yPos;
		
		switch (dropDecider){
			case 0: xLoc+=Tile.WIDTH;
			break;
			
			case 1: yLoc+=Tile.HEIGHT;
			break;
			
			case 2: xLoc-=Tile.WIDTH;
			break;
			
			case 3: yLoc-=Tile.HEIGHT;
			break;
		}
		
		this.xPos = xLoc;
		this.yPos = yLoc;
	}
	
	public void equip(){
		//This exists to be overridden with what the thing actually does
	}
	
	public void deEquip(){
		//Same as equip
	}
	
	private class Gloves extends Item{
		String itemName = "Ogre's Mittens";
		
		 public void equip(){
			 equippedOn.statStr=+10;
		 }
		 
		 public void deEquip(){
			 equippedOn.statStr-=10;
		 }
	 }
	
	private class Hat extends Item{
		String itemName = "Hat of Smartness";
		
		 public void equip(){
			 equippedOn.statInt=+10;
		 }
		 
		 public void deEquip(){
			 equippedOn.statInt-=10;
		 }
	 }
	
	private class Armband extends Item{
		String itemName = "Armband of Incredible Hurry";
		
		 public void equip(){
			 equippedOn.statAgi=+10;
		 }
		 
		 public void deEquip(){
			 equippedOn.statAgi-=10;
		 }
	 }
	
	private class Belt extends Item{
		String itemName = "Belt of Iron Abs";
		
		 public void equip(){
			 equippedOn.statVig=+10;
		 }
		 
		 public void deEquip(){
			 equippedOn.statVig-=10;
		 }
	 }

}


