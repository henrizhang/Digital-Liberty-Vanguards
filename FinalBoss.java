public class FinalBoss extends Monster{
    public FinalBoss(){
        super("General Marius");
        _health=300;
        _defense=20;
        _strength=(int)(Math.random() * 45) + 30;
        _attack=2;
        
    }
    //Final Boss Constructor
    public int attack(Player a) {
        int damage = (int)(Math.random()*((_strength*_attack)-a._defense)); 
        a.attacked(damage); 
        return damage; 
    }
}