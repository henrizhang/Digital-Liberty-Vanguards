public class FinalBoss extends Monster{
    public FinalBoss(){
        super("General Marius");
        _health=200;
        _defense=18;
        _strength=(int)(Math.random() * 36) + 28;
        _attack=1;
        
    }
    //Final Boss Constructor
    public int attack(Player a) {
        int damage = (int)(Math.random()*((_strength*_attack)-a._defense)); 
        a.attacked(damage); 
        return damage; 
    }
}