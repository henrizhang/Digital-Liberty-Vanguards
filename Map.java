public class Map {

    //constant for default map size
    private final static int DEFAULT_SIZE = 5;

    
    public Cell[][] map;
    private int _playerRow;
    private int _playerColumn;
    private String playerLocation;
    private Item item;  
    private Monster grim;
    private Monster zomb; 
    private int stopMap = 0; 

    //default constructor intializes a
   // DEFAULT_SIZE*DEFAULT_SIZE map
    public Map() {
	    map = new Cell[DEFAULT_SIZE][DEFAULT_SIZE];
	     for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Cell k = new Cell(); 
                //MAKE ARRAY WITH REGULAR CONSTRUCTORS AND RANDOMS,
                //THEN STORE THE ONE WITH TRUE FOR HASPLAYER'S CellS IN A VARIABLE
                map[i][j] = k; // idea : make an array of string of diff location names + randomly populate the arrays? 
            }
	     }
	     
	     Cell a = new Cell("O");
	     int rowPlayer=2; // row of player's starting point 
	     int columnPlayer=2; // column of player's starting point
	     map[rowPlayer][columnPlayer] = a; 
	     _playerRow=rowPlayer;
	     _playerColumn=columnPlayer;
	     playerLocation = rowPlayer + "," + columnPlayer; //storing the starting point of the player marked as "0"
         item = new Key();
         grim = new GrimReaper(); 
         zomb = new Zombie(); 
         map[0][0].addItem(item); 
         map[0][1].addMonster(grim); 
         map[3][4].addMonster(zomb);
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
           if (map[_playerRow][_playerColumn].hasItem()) {
               stopMap = 1; 
          System.out.println("You found a " + theItem() + "! It's now in your inventory. You can now..");
        }
        
        else if (map[_playerRow][_playerColumn].hasMonster()) {
            stopMap = 1; 
            System.out.println("A " + theMonster() + " has appeared. Prepare to FIGHT"); 
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
        
    public int getPlayerColumn(){
        return this._playerColumn;
    }
    public int getPlayerRow(){
        return this._playerRow;
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
        System.out.println(a);
        System.out.println(a.playerLocation);
        System.out.println(a.theItem());
        System.out.println(a.getPlayerColumn());
        System.out.println(a.getPlayerRow());
    
 //       System.out.println(a.theItem()); 
 //       System.out.println(a.Where());
       
  
    }
}
