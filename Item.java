public abstract class Item {
    
    protected String _name;
    protected String _purpose; 
    public Item () {
        _name = "Item";  
    }
   
    public String toString() {
    return _name; 
    }
    
    public String getPurpose() {
        return _purpose; 
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
     
     public int random() { 
         return (int)(Math.random() * 6);
    
}
}


        