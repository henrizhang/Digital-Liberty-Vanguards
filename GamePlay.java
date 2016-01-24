import cs1.Keyboard;

public class GamePlay { 
    private Map array; 
    private boolean gameOver; 
    private int numMoves; //number of times player has moved in the game
    private Game Gameswag;
    //game or string that represents a game
    private boolean canContinue;
    //if a player has entered the right string to continue the game
    
public GamePlay() { 
    gameOver = false; 
    numMoves=-1;
    array=new Map();
}

public String newGame() {
    String start = "";
    start += "Who U";
    array=new Map();
    return start; 
}
    

public static void main (String [] args) { 
    
    Player player1 = new Player();
    GamePlay game = new GamePlay(); 
    while (!(game.gameOver)) {
        //FIRST ITERATION OF THE LOOP IS BEFORE THE INITIAL MOVEMENT OF THE PLAYER
        if (game.numMoves==-1) {
            System.out.println("You have began a new game. (Press Space+enter to continue...)");
            String input="sike";
            while (!(input.equals(" "))){ 
                input=Keyboard.readString();
                //need to enter space to continue
            }
            
            System.out.println("You wake up in a strange shack. Your head aches. There is a smell of burning bacon somewhere. (Press Space+enter to continue...)");
            input= "sike";//resetting input
            
            while (!(input.equals(" "))) {
                input=Keyboard.readString();
                //need to enter space to continue
            }
            System.out.println("type 'help' for further aid. w, a, s, d to move. type inventory to open inventory. (Press Space+enter to continue)");
            input="sike";//resetting input
            while (!(input.equals(" "))) {
                input=Keyboard.readString();
                //need to enter space to continue
            }
            game.numMoves+=1;
            continue;
                // FIRST ITERATION ENDS HERE
               
            }
      
        //Initial message upon starting a new game
        if (!(game.array.getStopMap() == 1)) {
        System.out.println(game.array);
        System.out.println("This is the map. Your location is marked by O. Where would you like to go?");
        } 
        //ORDER OF THE COMMAND/RESULT MATTERS!!!
        String userCommand=Keyboard.readString(); 
        
        if (userCommand.equals("inventory")) {
         //   player1._inventory.add("Key");
            System.out.println(player1.stringifyInventory());     
      //      game.array.stopMap = 1;  [private access] 
            System.out.println("(Press Space+enter to continue)");
            String input2="sike";
            while(!(input2.equals(" "))){
                input2=Keyboard.readString();    
            }
        }
    //    else if (userCommand.equals)
        
        try {
            game.array.movePlayer(userCommand); 
                if (game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].hasItem()) {
                     if (game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].hasPotion()) { 
                    player1.addHealth(15);
                    System.out.println("Your health is now " + player1.getHealth());
                    game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].removeItem(game.array.theItem());
                    System.out.println("Press space+enter to return to the map");
                }
                else { 
                player1.add(game.array.theItem());
                game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].removeItem(game.array.theItem());
                
                System.out.println("Press space+enter to return to the map"); 
            }
                }
            
        else if (game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].hasMonster()) { 
         //       System.out.println("Open inventory to see what you can use to fight");  //inventory doesn't open up -- what if we don't use weapons? 
                System.out.println("Press b+enter to attack"); 
                while (player1.isAlive() && game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].getMonster().isAlive()) {   
                String command = Keyboard.readString(); 
                if (command.equals("b")) { 
                 int a1 = player1.attack(game.array.theMonster()); 
                 int a2 = game.array.theMonster().attack(player1); 
                System.out.println("You attacked " + game.array.theMonster() + " and dealt " + a1 + " damage."); 
                System.out.println("You were attacked and lost " + a2 + " HP ");   
                }
            }
              if (!player1.isAlive() && (!game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].getMonster().isAlive())) { 
                System.out.println("You have both been killed"); 
                game.gameOver = true; 
            }
            else if (!game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].getMonster().isAlive()) { 
                System.out.println("Somehow even with your limited memory, you slained the " + game.array.theMonster()); 
                game.array.map[game.array.getPlayerRow()][game.array.getPlayerColumn()].removeMonster(game.array.theMonster());
                System.out.println("Press space+enter to return to the map"); 
                
            } 
            else if (!player1.isAlive()) { 
                System.out.println("You failed. " + game.array.theMonster() + " has killed you."); 
                game.gameOver = true; 
                }
        }
                
        }
           
        
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("You cannot go here");
            System.out.println(game.array);
            userCommand=Keyboard.readString();
        }
        game.numMoves++;
        
    
    if (game.gameOver == true) {
        System.out.println("Game ends"); 
        break;
    }
        
    System.out.println();
}
    
}
}


    
        
    
    
