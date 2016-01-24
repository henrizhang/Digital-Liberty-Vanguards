public abstract class Character { 
    protected String _name; 
    protected int _health; 
    protected int _defense; 
    protected int _strength;
    
    public Character(String name){
        _name=name;
        _health=10;
        _defense=10;
        _strength=10;
    }
    
    public Character(String name, int health, int defense, int str) {
        _name = name; //input name 
        _health=health;
        _defense=defense;
        _strength=str;
    }
    
    public boolean isAlive() {
        return (this._health>0); 
    }    

    public void attacked(int dmg){
        this._health-=dmg;
    }

    
    
    /**
    public int setHealth(int new )
}
    **/
}