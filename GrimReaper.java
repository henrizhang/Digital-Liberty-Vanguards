public class GrimReaper extends Monster { 
    
     public GrimReaper () { 
        super("Grim Reaper"); 
        _health=30;
        _defense=10;
        _strength=(int)(Math.random() * 45) + 18;
    }
    
    public int attack(Player a) {
        int damage = (int)(Math.random()*((_strength*_attack)-a._defense)); 
        a.attacked(damage); 
        return damage; 
}
}