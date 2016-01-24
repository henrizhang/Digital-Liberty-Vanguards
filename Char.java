public abstract class Char { 
    protected String _name; 
    protected int _health; 
    protected int _defense; 
    protected int _strength;
    protected int _attack; 
    
    public Char() {
    }
    
    public Char(String name){
        _name=name;
        _health=50;
        _defense=20;
        _strength = (int)(Math.random() * 45) + 20;;
        _attack=1;
    }
    
    public Char(String name, int health, int defense, int str,int attack) {
        _name = name; //input name 
        _health=health;
        _defense=defense;
        _strength=str;
        _attack=attack;
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