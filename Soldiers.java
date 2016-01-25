public class Soldiers extends Monster {    
     public Soldiers () { 
        super("Soldier"); 
        _health=45;
        _defense=15;
        _strength=(int)(Math.random() * 45) + 20;
        
    }
    
    public int attack(Player a) {
        int damage = (int)(Math.random()*((_strength*_attack)-a._defense)); 
        a.attacked(damage); 
        return damage; 
}
}