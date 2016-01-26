public class Mountain extends Monster {    
    private static String[] NAMES = {"frost giant", "ice linnorm", "troll", "yeti", "white dragon"};
     public Mountain () { 
        super(NAMES[(int)(Math.random()*5)]); 
        _health=30;
        _defense=10;
        _strength=(int)(Math.random() * 40) + 20;
        
    }
    
    public int attack(Player a) {
        int damage = (int)(Math.random()*((_strength*_attack)-a._defense)); 
        a.attacked(damage); 
        return damage; 
}
}