public class Zombie extends Monster { 
    public Zombie () { 
        super("Zombie"); 
        _health=35;
        _defense=13;
        _strength=(int)(Math.random() * 45) + 20;
    }
    
    public int attack(Player a) {
        int damage = (int)(Math.random()*((_strength*_attack)-a._defense)); 
        a.attacked(damage); 
        return damage; 
}
}
