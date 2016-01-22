import cs1.Keyboard;

public class GamePlay { 
    private Map array; 
    private boolean gameOver; 
    private int numMoves; //number of times player has moved in the game
    private Game Gameswag;
    //game or string that represents a game
public GamePlay() { 
    gameOver = false; 
    numMoves=0;
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
    while (!(game.gameOver)){
        if (game.numMoves==0){
            System.out.println("You have began a new game.");
        }
        //Initial message upon starting a new game
        if (!(game.array.stopMap == 1)){
        System.out.println(game.array);
        System.out.println("This is the map. Your location is marked by O. Where would you like to go?");
        } 
        
        String userCommand=Keyboard.readString();
        if (userCommand.equals("inventory")){
            player1.inventory.add("Key");
            System.out.println(player1.getInventory());        
        }
        try{
        game.array.movePlayer(userCommand); 
        
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("You cannot go here");
            System.out.println(game.array);
            userCommand=Keyboard.readString();
       
        }
        game.numMoves++;
        
    }
    System.out.println("");
    
}

}
    
        
    
    
