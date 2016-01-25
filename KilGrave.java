public class KilGrave extends Monster { 
    
     public KilGrave () { 
        super("KilGrave"); 
        _health=38;
        _defense=10;
        _strength=(int)(Math.random() * 45) + 21;
        _attack=1;
    }
    
    public int attack(Player a) {
        int damage = (int)(Math.random()*((_strength*_attack)-a._defense)); 
        a.attacked(damage); 
        return damage; 
}
}