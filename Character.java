public abstract class Character { 
    protected String _name; 
    protected int _health; 
    protected int _defense; 
    protected int _attack;
    public Character(String name){
        _name=name;
        _health=10;
        _defense=10;
        _attack=10;
    }
    public Character(String name, int health, int defense, int attack) {
        _name = name; //input name 
        _health=health;
        _defense=defense;
        _attack=attack;
    }
    
    
    /**
    public int setHealth(int new )
}
    **/
}