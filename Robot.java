public class Robot extends Monster {
    public Robot () { 
        super("Deathbot"); 
        _health=45;
        _defense=15;
        _strength=(int)(Math.random() * 45) + 24;
        
    }
    
    public int attack(Player a) {
        int damage = (int)(Math.random()*((_strength*_attack)-a._defense)); 
        a.attacked(damage); 
        return damage; 
}

}