public class Weapon extends Item { 
    
    private static String[] NAMES = {"Blade of the Ruined King", "Blade of Terror", "Aegis Shield"} ;
    
    public Weapon () {
        _name = NAMES[(int)(Math.random()*3)];
        _purpose = "" ;  
    }
    
     public String getPurpose() {
         String purpose = ""; 
        if ((_name.equals("Blade of the Ruined King")) || (_name.equals("Blade of Terror"))) {
            purpose = _purpose + "You will now gain some strength!";
        }
        if (_name.equals("Aegis Shield")) { 
            purpose = _purpose + "You will now gain some defense"; 
        }   
        return purpose; 
            
     }
     
     public boolean which() { 
         boolean shield = false; 
         if ((_name.equals("Blade of the Ruined King")) || (_name.equals("Blade of Terror"))) { 
             shield = true; 
         }
         if (_name.equals("Aegis Shield")) { 
             shield = false; 
         }
         return shield; 
     }
     
     public int skillup() { 
         int up = 0;  
        if (which() == true) { 
            up = getStr(); 
        }
        if (which() == false) { 
            up = getDef(); 
        }
        return up;
     }
            
     public int getStr() {
         
         return (int)(Math.random() *4); 
     }
     
     public int getDef() { 
         
         return (int)(Math.random() *4); 
     }
      

}