import cs1.Keyboard;

public class GamePlay { 
    private Map array; 
    private boolean gameOver; 
    private int numMoves; //number of times player has moved in the game
    
    
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
// is there a way to just move just J L K I without pressing enter everytime
// OKAY CAN WE MAKE THE NULL AND OUT OF BOUNDS CASES i think we have to speed it up; a lil behind 
/**ok so i started trying out random stuff with Item -- pretty much works its just that 
we need to come up with a mechanism of how we're going to add certain items in coords and what not 
rn in map and coord i just hard-coded an ADD ITEMS at the Cell [0][0] . so check that out !!
**/ 

public static void main (String [] args) { 
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
        
            String direction=Keyboard.readString();
        try{
        game.array.movePlayer(direction); 
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("You cannot go here");
            System.out.println(game.array);
            direction=Keyboard.readString();
       
        }
        game.numMoves++;
        
    }
    System.out.println("");
    
}

}
    
        
    
    
