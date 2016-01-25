public class Monster extends Char{  
    
    public Monster(String name) {
        _name = name; 
        _health=30;
        _defense=10;
        _strength = 5;
        _attack=1;
        
    }
    public String toString() { 
        return _name; 
}

 public int attack(Player a) {
        int damage = (int)(Math.random()*((_strength*_attack)-a._defense)); 
        a.attacked(damage); 
        return damage; 
 }
/***
    public boolean isAlive() {
        return (this._health>0); 
    }    
    public void attacked(int dmg){
        this._health-=dmg;
    }
    ***/ 

}