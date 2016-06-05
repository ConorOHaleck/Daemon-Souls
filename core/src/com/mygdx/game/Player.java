package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class Player extends Creature {
	Class<Knight> KnightClass = Knight.class;
	Class<Barbarian> BarbClass = Barbarian.class;
	Class<Monk> MonkClass = Monk.class;
	Class<Wizard> WizClass = Wizard.class;
	
	public static final int RIGHT = 0;
	public static final int UP = 1;
	public static final int LEFT = 2;
	public static final int DOWN = 3;
	
	private int facing;
	
	Item[] inventory = new Item[6];

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//where we are in world space
	float mapX = 0;
	float mapY = 0;

	public void move(float x, float y)
	{
		Tile oldTile;
		Tile newTile;
		
		int x2 = xPos;
		int y2 = yPos;	
		int newX = x2 += Tile.WIDTH * x;
		int newY = y2 += Tile.WIDTH * y;
		
		newTile = MyGdxGame.testDungeon.getTileAt((newX/Tile.WIDTH), (newY/Tile.WIDTH));
		
		if (newTile.isCanCollide() == false) {
			
			oldTile = MyGdxGame.testDungeon.getTileAt((this.xPos/Tile.WIDTH), (this.yPos/Tile.WIDTH));
			oldTile.setOccupant(null);
		
		xPos += Tile.WIDTH * x;
		yPos += Tile.HEIGHT * y;
		
		newTile = MyGdxGame.testDungeon.getTileAt((this.xPos/Tile.WIDTH), (this.yPos/Tile.WIDTH));
		
		if(newTile.getOccupant().getClass()==Item.class){
			Item itemGet = (Item) newTile.getOccupant();
			itemGet.pickUp(this);
		}
		
		newTile.setOccupant(MyGdxGame.testPlayer);
		
		//System.out.println("PlayerX: " + (this.xPos/Tile.WIDTH));
		//System.out.println("PlayerY: " + (this.yPos/Tile.HEIGHT));
			
			mapX +=x;
			mapY +=y;
					
			xPos += Tile.WIDTH * x;
			yPos += Tile.HEIGHT * y;
			
			newTile = MyGdxGame.testDungeon.getTileAt((this.xPos/Tile.WIDTH), (this.yPos/Tile.WIDTH));
			newTile.setOccupant(MyGdxGame.testPlayer);
			
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
		}	
	}
	
	public void ability1(Player player) {
		int targetX;
		int targetY;
		Creature target = null;
		
		if (this.getFacing() == RIGHT) {
			targetX = (this.xPos/Tile.WIDTH) + 1;
			targetY = (this.yPos/Tile.HEIGHT);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			
		} else if (MyGdxGame.testPlayer.getFacing() == UP) {
			targetX = (this.xPos/Tile.WIDTH);
			targetY = (this.yPos/Tile.HEIGHT) + 1;
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			
		} else if (MyGdxGame.testPlayer.getFacing() == LEFT) {
			targetX = (this.xPos/Tile.WIDTH) - 1;
			targetY = (this.yPos/Tile.HEIGHT);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			
			
		} else if (MyGdxGame.testPlayer.getFacing() == DOWN) {
			targetX = (this.xPos/Tile.WIDTH);
			targetY = (this.yPos/Tile.HEIGHT) - 1;
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
		}
		
		if (KnightClass.isInstance(MyGdxGame.testPlayer)) {         
			System.out.println("Stab");
			
			try {
				((Knight) player).stab(target);
				
			} catch (NullPointerException e) {
				System.out.println("The attack missed!");
			}
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
		} else if (BarbClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Chop");
			
			try {
				((Barbarian) player).chop(target);
				
			} catch (NullPointerException e) {
				System.out.println("The attack missed!");
			}
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
			
		} else if (MonkClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Jab");
			
			try {
				((Monk) player).jab(target);
				
			} catch (NullPointerException e) {
				
			}
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
			
		} else if (WizClass.isInstance(MyGdxGame.testPlayer)) {       //To finish when I do ranged combat
			System.out.println("Fireball");
			
			if (MyGdxGame.testPlayer.getFireballCD() <= 0) {
				MyGdxGame.setControlState(MyGdxGame.TARGETING_RANGED);
				MyGdxGame.setReticleType(MyGdxGame.FIREBALL);
			
			} else {
				System.out.println("That ability is on cooldown.");
			}
			
			
		} else {
			System.out.println("Error");
		}
	}
	
	public void ability2(Player player) {
		//System.out.println("Two");
		
		int targetX;
		int targetY;
		Creature target = null;
		
		if (this.getFacing() == RIGHT) {
			targetX = (this.xPos/Tile.WIDTH) + 1;
			targetY = (this.yPos/Tile.HEIGHT);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			
		} else if (MyGdxGame.testPlayer.getFacing() == UP) {
			targetX = (this.xPos/Tile.WIDTH);
			targetY = (this.yPos/Tile.HEIGHT) + 1;
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			
		} else if (MyGdxGame.testPlayer.getFacing() == LEFT) {
			targetX = (this.xPos/Tile.WIDTH) - 1;
			targetY = (this.yPos/Tile.HEIGHT);
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
			
		} else if (MyGdxGame.testPlayer.getFacing() == DOWN) {
			targetX = (this.xPos/Tile.WIDTH);
			targetY = (this.yPos/Tile.HEIGHT) - 1;
			target = (Creature) MyGdxGame.testDungeon.getTileAt(targetX, targetY).getOccupant();
		}
		
		if (KnightClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Shield Bash");
			
			if (MyGdxGame.testPlayer.getBashCd() <= 0) {
				try {
					((Knight) player).shieldBash(target);
					MyGdxGame.testPlayer.setBashCd(2);
					
				} catch (NullPointerException e) {
					System.out.println("The attack missed!");
				}
			
			} else {
				System.out.println("That ability is on cooldown.");
			}
			
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
		} else if (BarbClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Cleave");
			
			if (MyGdxGame.testPlayer.getCleaveCD() <= 0) {
				((Barbarian) player).cleave(); 
				MyGdxGame.testPlayer.setCleaveCD(1);
			
			} else {
				System.out.println("That ability is on cooldown.");
			}
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN); //This looks different because target acquisition for cleave is handled differently.
			
		} else if (MonkClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Flurry");
			
			if (MyGdxGame.testPlayer.getFlurryCD() <= 0) {
				try {
					((Monk) player).flurry(target);
					MyGdxGame.testPlayer.setFlurryCD(2);
					
				} catch (NullPointerException e) {
					System.out.println("The attack missed!");
				}
			
			} else {
				System.out.println("That ability is on cooldown.");
			}
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
		} else if (WizClass.isInstance(MyGdxGame.testPlayer)) {        //To finish when I do ranged combat
			System.out.println("Ice Lance");
			MyGdxGame.setControlState(MyGdxGame.TARGETING_RANGED);
			MyGdxGame.setReticleType(MyGdxGame.ICE_LANCE);
			
		} else {
			System.out.println("Error");
		}
	}
	
	public void ability3(Player player) {
		//System.out.println("Three");
		
		if (KnightClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Bulwark");
			
			if (MyGdxGame.testPlayer.getBulwarkCD() <= 0) {
				((Knight) player).bulwark();
				MyGdxGame.testPlayer.setBulwarkCD(3);
			
			} else {
				System.out.println("That ability is on cooldown.");
			}
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
		} else if (BarbClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("RAAAAAAAAAGGGGEEEE!!!!!");
			((Barbarian) player).rage();
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
		} else if (MonkClass.isInstance(MyGdxGame.testPlayer)) {
			System.out.println("Serenity");
			
			if (MyGdxGame.testPlayer.getSerenityCD() <= 0) {
				((Monk) player).serenity();
				MyGdxGame.testPlayer.setSerenityCD(3);
			
			} else {
				System.out.println("That ability is on cooldown.");
			}
			MyGdxGame.setGameState(MyGdxGame.ENEMY_TURN);
			
		} else if (WizClass.isInstance(MyGdxGame.testPlayer)) {            //I'll deal with this later
			System.out.println("Teleport");
			//MyGdxGame.testPlayer.Teleport();
			
		} else {
			System.out.println("Error");
		}
	}

	public Player(TextureRegion img) {
		// TODO Auto-generated constructor stub
		this.mapX = 0;
		this.mapY = 0;
		this.img = img;
	}

	public int getFacing() {
		return facing;
	}

	public void setFacing(int facing) {
		this.facing = facing;
	}
}
