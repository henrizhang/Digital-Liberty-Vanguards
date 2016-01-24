public class Monster extends Character { 
    public Monster () { 
        super("Goblin");
        _health=10;
        _defense=10;
        _attack=10;
    } 
    public String toString() { 
        return _name; 
}
}