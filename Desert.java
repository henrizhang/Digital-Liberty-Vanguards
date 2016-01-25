public class Desert extends Monster { 
    private static String[] NAMES = {"Giant Scorpion", "Sphinx", "Blue Dragon", "Phoenix", "Snake"};
    
    public Desert() { 
        super(NAMES[(int)(Math.random()*5)]); 
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
