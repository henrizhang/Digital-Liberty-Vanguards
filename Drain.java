public class Drain extends Item{ 
     public Drain () { 
        _name = "Drain"; 
        _purpose = "A ghost appears around you and you knock out for a couple of seconds  -Strength and defense decreased- "; 
    }
     public String getPurpose() {
        return _purpose; 
    }
     public int random() {
         int a = 0; 
         a = (int)(Math.random() * 5);
         return a;
}
}