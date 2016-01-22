import java.util.*;
//http://stackoverflow.com/questions/3543771/best-practice-concerning-private-arraylist-and-other-such-constructions
public class Player extends Character{
    public ArrayList<Object> inventory;
    public Player(){
        super("Player");
    }
    
    public String getInventory(){
        String out  =  "p";
        return out; 
    }
        
        /**
        int x=0; 
        String output= "";
        while (x<inventory.size()){
            output+=inventory.get(x);
        }
        return output;
    }
    ***/

    
}