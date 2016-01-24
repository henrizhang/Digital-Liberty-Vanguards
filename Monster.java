public class Monster extends Character { 
    
    public Monster () { 
        super("Goblin");
        _health=10;
        _defense=10;
        _strength=10;
    } 
    
    public String toString() { 
        return _name; 
}

    public int attack(Player a) {
        int damage = 5;
        a.attacked(damage); 
        return damage; 
}

}