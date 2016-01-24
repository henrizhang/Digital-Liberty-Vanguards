import java.util.*;
//http://stackoverflow.com/questions/3543771/best-practice-concerning-private-arraylist-and-other-such-constructions
public class Player extends Character {
    private ArrayList <Object> _inventory; 
    public Player() {
        super("Player");
        _inventory = new ArrayList <Object> ();  
    }

    
    public String toString() {
        String items = "["; 
        for (int x = 0; x < _inventory.size(); x ++) { 
            items += _inventory.get(x) + ","; }
            if (items.length() > 1) 
            items = items.substring(0,items.length()-1); 
            items += "]";
    return items; 
    }
    
    // adds Item to the Player's inventory using ArrayList method made public (mutator)
    public void add(Object m){
        _inventory.add(m);
    }
    
    
    public String stringifyInventory(){
        String stringInventory="";
        //output, string representation of the items in the inventory
        if (_inventory.size()==0){
            return "There's nothing in your Inventory!";
        }
        for(int x=0; x<_inventory.size(); x++){
            stringInventory+=" "+_inventory.get(x);
        }
        return stringInventory;
    }
}
    
    /**
    
    public static void main (String[] args) {
        Player a = new Player(); 
        System.out.println(a.inventory);
        a.inventory._inventory.add("key");
        System.out.println(a.inventory); 
       ***/ 



        /**
        int x=0; 
        String output= "";
        while (x<inventory.size()){
            output+=inventory.get(x);
        }
        return output;
    }
    ***/

    
