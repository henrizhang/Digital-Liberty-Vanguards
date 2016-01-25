public class Map {

    //constant for default map size
    private final static int DEFAULT_SIZE = 9;
    private final static String[] ENTERTEXT_LIST = {
    "You have reached the end of the desert. Beyond this, a raging sandstorm blocks your path.", "You have reached the end of the desert. Beyond this, a raging sandstorm blocks your path.", "You have reached the end of the desert. Beyond this, a raging sandstorm blocks your path.",
    "The enormous steepness of the slope of the mountain to the north prevents you from going further up.","The enormous steepness of the slope of the mountain to the north prevents you from going further up.", "The enormous steepness of the slope of the mountain to the north prevents you from going further up.",
    "Empty vials and broken machinery are scattered across the end of this room.","Inactive automatons line across the room. ","This appears to be where the owner of the facility stays.", 
    "You have reached the Western end of the desert. Beyond this, a raging sandstorm blocks your path.", "The Great Sand Dunes stretch on.", "The temperature is hot. The sun is scorching. You seem to be near a desert.", 
    "The area becomes rocky. You seem to be near a mountain", "You are clearly in the ranges now. The jagged path of rock seems overwhelming to climb.","You near the Eastern end of the mountain ranges. The long hills serve almost as a barrier of some sort...", 
    "The facility has a machine for... robot manufacturing? But why?", "You have opened the security door with the Skeleton Key. Inside it is a strange factory.","A library of research documents and notes can be seen here.",
    "", "", "", "", "", "","", "", "","","", "", "", "", "", "","", "", "","","", "", "", "", "", "","", "", "","","", "", "", "", "", "","", "", "","","", "", "", "", "", "","", "", "","","", "", "", "", "", "","", "", "","","", "", "", "", "", "","", "", "","","", "", "", "", "", "","", "", "",""};
   
    public Cell[][] map;
    private int _playerRow;
    private int _playerColumn;
    private String playerLocation;
    private Item item, pot, weapon, weapon2, boost;  
    private Monster grim, zomb, joke, kil;
    private Slots slot; 
    private int stopMap = 0; 
    

    //default constructor intializes a
   // DEFAULT_SIZE*DEFAULT_SIZE map
    public Map() {
	    map = new Cell[DEFAULT_SIZE][DEFAULT_SIZE];
	    int x=0;
	    //counter for populating map with entertext'd cells
	     for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Cell k = new Cell(ENTERTEXT_LIST[x]);
                x++;
                //MAKE ARRAY WITH REGULAR CONSTRUCTORS AND RANDOMS,
                //THEN STORE THE ONE WITH TRUE FOR HASPLAYER'S CellS IN A VARIABLE
                map[i][j] = k; // idea : make an array of string of diff location names + randomly populate the arrays? 
            }
	     }
            
	     
	     Cell a = new Cell("O");
	     
	     int rowPlayer=4; // row of player's starting point 
	     int columnPlayer=4; // column of player's starting point
	     map[rowPlayer][columnPlayer] = a; 
	     
	     _playerRow=rowPlayer;
	     _playerColumn=columnPlayer;
	     playerLocation = rowPlayer + "," + columnPlayer; //storing the starting point of the player marked as "0"
	     
	     
         item = new Key();
         grim = new GrimReaper(); 
         zomb = new Zombie(); 
         joke = new Joker(); 
         pot = new Potion();
         slot = new Slots(); 
         kil = new KilGrave();
         weapon = new Weapon(); 
         weapon2 = new Weapon(); 
         boost = new Booster(); 
         map[0][0].addItem(item); 
         map[0][1].addMonster(grim); 
         map[3][4].addMonster(zomb);
         map[2][2].addMonster(joke);
         map[1][3].addItem(pot);
         map[4][2].addGame(slot); 
         map[6][6].addMonster(kil);
         map[5][7].addItem(weapon); 
         map[6][5].addItem(weapon2);
         map[8][8].addItem(boost); 
         }

         
    
    
    //return String representation of this map
    // (make it look like a map)
    public String toString() {
	    String str = "";
            for(int rows = 0; rows < map.length ; rows++) {
                for (int column = 0; column < map[rows].length ; column++) {
                    if (rows==(Integer.parseInt(playerLocation.substring(0,1)))){
                        if (column==(Integer.parseInt(playerLocation.substring(2)))){
                            str+="O"+"\t";
                        }
                        else{
                            str+="X"+"\t";
                        }
                    }
                    else{
                        str+="X"+"\t";
                    }
                    
                }
                str += "\n";
            }
        return str; 
    }
    
    public int getStopMap(){
        return stopMap;
    }
    
    ///need to add the null and out of bounds cases 
    ///if incorrect directions >> output some correcting words 
       public void movePlayer (String direction) { 

        
           if (direction.equals("w")) {
              
              _playerRow = (Integer.parseInt(playerLocation.substring(0,1)));
              _playerRow -= 1;
              _playerColumn = (Integer.parseInt(playerLocation.substring(2))); 
              playerLocation = _playerRow + "," + _playerColumn; 
           }
           
           if (direction.equals("s")) {
               _playerRow = (Integer.parseInt(playerLocation.substring(0,1)));
               _playerRow+=1;
               _playerColumn = (Integer.parseInt(playerLocation.substring(2))); 
              playerLocation = _playerRow + "," + _playerColumn; 
           }
           
           if (direction.equals("a")) { 
               _playerRow = (Integer.parseInt(playerLocation.substring(0,1)));
               _playerColumn = (Integer.parseInt(playerLocation.substring(2))); 
               _playerColumn -= 1; 
              playerLocation = _playerRow + "," + _playerColumn; 
           }
           
           if (direction.equals("d")) { 
               _playerRow = (Integer.parseInt(playerLocation.substring(0,1)));
               _playerColumn = (Integer.parseInt(playerLocation.substring(2))); 
               _playerColumn+=1;
              playerLocation = _playerRow + "," + _playerColumn; 
           }
        
           if (((map[_playerRow][_playerColumn].hasItem()) && (map[_playerRow][_playerColumn].hasPotion())) ||
                ((map[_playerRow][_playerColumn].hasItem()) && (map[_playerRow][_playerColumn].hasWeapon())) || 
                 ((map[_playerRow][_playerColumn].hasItem()) && (map[_playerRow][_playerColumn].hasBooster()))) { 
                   System.out.println("You found a " + theItem() + " ! " + theItem().getPurpose()); 
                   stopMap = 1; 
                   }
               else if (map[_playerRow][_playerColumn].hasItem()) {
          System.out.println("You found a " + theItem() + " ! It's now in your inventory. You can now..");
          stopMap = 1; 
        }
        
        else if (map[_playerRow][_playerColumn].hasMonster()) {
            stopMap = 1; 
        
        }
        
        else if (map[_playerRow][_playerColumn].hasGame()) {
            System.out.println("Woah. A weird looking slot machine.");

             stopMap = 1; 
        }
        else stopMap = 0; 
       }
       
       
      
    
               
               

 /******
    public String theItem() { 
        String foo = "";
        if (map[_playerRow][_playerColumn].hasItem())  {
        Cell a = new Cell();
        foo += map[_playerRow][_playerColumn]._item.toString(); }
        return foo;
    }
*****/ 

    public Item theItem() { 
            return map[_playerRow][_playerColumn].getItem(); 
    }
    public Monster theMonster() { 
        return map[_playerRow][_playerColumn].getMonster(); 
    }
    public Slots theGame() {
        return map[_playerRow][_playerColumn].getGame(); 
    }
        
    public int getPlayerColumn(){
        return this._playerColumn;
    }
    public int getPlayerRow(){
        return this._playerRow;
    }
    public String getPlayerLocation(){
        return this.playerLocation;
    }
    public void changeStop(int c) { 
        stopMap = c; 
    }
        
    
/*** add mutator to Cell so u can change the Cells appearance (whats strung and seen on the map)
        when the player enters that Cell. 
        
        ****/

/**move player 
    -- idea : if we keep the store Cell aka (String where) >> then take the substrings parse to integer 
    and then do like map[whatever the substring is][whatever substring is that player is at] and do like +1 at the row 
    for when its  right arrow, left arrow or maybe even letters ? like JIKL instead. 
    ** will need to implement out of bounds , and nulls, empties. 
    
 
    
    
**/// 
        

    public static void main(String[] args) {
        Map a = new Map(); 
    //    Key key = new Key("Key", "Open"); 
        System.out.println(a.map[0][0].getEnterText());
    
 //       System.out.println(a.theItem()); 
 //       System.out.println(a.Where());
       
  
    }
}
