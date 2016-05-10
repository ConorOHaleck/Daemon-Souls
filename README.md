# Daemon-Souls

Proposed Polymorphic Structure (for the game itself):
  
  ENTITY - top dog. Contains all else. Comes in three flavors
    - Graphic - each ENTITY has a single square image that represents it.
    
   TILE - Extends Entity. Comes in two flavors
      WALL - Extends Tile. canCollide set to yes
       **All sorts of Wall-tiles go here
     FLOOR - Extends Tile. canCollide set to no
        **All sorts of Floor-tiles go here
    
   ITEM - Extends Entity. Can be placed in an Inventory
     - Item stuff
    
  CREATURE - Extends Entity. Can move about and has Skillset
    SKILL - Internal class for Creature. Fireballs, claw swipes, chug alcohol, you know
   - Stats - vital statistics and whatnot
   - Skillset - Array of Skills that can be used.
   - Base movement code - unlesss overridden, moves like a chess king
   - getHit - checks if you are the dead
    MONSTER - Extends Creature.
    - Monster ability flags
    PLAYER - Extends Creature.
    - Player ability flags
    - Inventory - Array of ITEMs
    
      
