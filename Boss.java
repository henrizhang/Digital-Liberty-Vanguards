public class Boss extends Character {
    public Boss() { 
        super("The Destroyer"); 
        _health = 120; 
        _defense = 20; 
        _strength = (int)(Math.random() * 45) + 30;
        _attack = 1;
        
     public int attack(Player a) {
        int damage = (int)(Math.random()*((_strength*_attack)-a._defense)); 
        a.attacked(damage); 
        return damage; 
}
        
}