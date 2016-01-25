import java.util.*;
//http://stackoverflow.com/questions/3543771/best-practice-concerning-private-arraylist-and-other-such-constructions
public class Player extends Char {
    private ArrayList <Item> _inventory; 
    private boolean hasAccess;
    public Player() {
        super("Player");
        _inventory = new ArrayList <Item> ();  
        _health = 250; 
        _defense = 15;
        _strength = (int)(Math.random() * 45) + 25;
        hasAccess=false;

    }

    public boolean getHasAccess(){
        return hasAccess;
    }
    
    public void setHasAccess(boolean tf){
        hasAccess=tf;
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
    public void add(Item m){
        _inventory.add(m);
    }
    
    public void remove(Object n){
        _inventory.remove(n); 
    }
    public boolean contains(Item n){
        return _inventory.contains(n); 
    }
    
    public String stringifyInventory(){
        String stringInventory="";
        //output, string representation of the items in the inventory
        if (_inventory.size()==0){
            return "There's nothing in your Inventory!";
        }
        for(int x=0; x<_inventory.size(); x++){
            stringInventory+=", "+_inventory.get(x);
        }
        return stringInventory;
    }
    
    public int attack(Monster mon) { 
        int damage = (int) (Math.random() * ((_strength*_attack) - mon._defense));
        mon.attacked(damage); 
        return damage; 
}

public int getHealth() {
    return _health;
} 
    public void addHealth(int p) { 
        _health += p; 
}
    public void addStr(int p) { 
        _strength += p; 
    }
    public void addDef(int p ) {
        _defense += p;
    }
    
    public void decBoth(int p) {
        _strength -= p;
        _defense -= p;
    }
        
    public String printStats(){
        return ("Health:"+this._health+" Defense:"+this._defense+" Strength:"+this._strength+" Attack:"+this._attack);
    }
}
