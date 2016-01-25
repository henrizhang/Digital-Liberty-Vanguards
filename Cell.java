public class Cell { 
    private String _name; 
    private String _enterText;
    private boolean hasPlayer; 
    private Item _item;
    private Monster _monsta; 
    private Slots _slot; 
    //instance variables of Cell
    

    
   // private Enemy _enemy; //whether or not there is someone in the Cell, 
    
   // private String _gameName; //what game is in it (if it's there at all?)
    
   // private Item _item; //what item lies in this Cell?
    
    public Cell() { 
        _name = "X"; 
    //    _item = null; 
      //default Cell constructor
    }
    
    public Cell(String enterText) {
        _enterText = enterText; 
        //constructor with name
    }
    
    public String getName(){
        return _name;
    }
    //accessor for name
    
    public String getEnterText(){
        return _enterText;
    }
    //accessor for enterText
    
    public void addItem(Item name) { 
        _item = name ;
    
    }
    
    public void removeItem(Item name) { 
        _item = null; 
    }
        
    public boolean hasItem() { 
        return (!(_item==null));
        }
        
    public boolean hasPotion() {
        boolean poo = false; 
        if (_item instanceof Potion) {
            poo = true; 
        }
         return poo;
    }
    
    
    public boolean hasWeapon() { 
        boolean too = false; 
        if (_item instanceof Weapon) { 
            too = true; 
        }
        return too;
    }
    
    public boolean hasBooster() {
        boolean moo = false; 
        if (_item instanceof Booster) { 
            moo = true; 
        }
        return moo; 
    }
       
    public boolean hasPlayer() {
        boolean foo = false; 
        if (_name == "O") 
        foo = true; 
        return foo; 
    
    }
    
    public String toString() { 
        String str = _name; 
        return str; 
        }
        
    public Item getItem(){
        return _item;
    }
  
    public void addMonster(Monster mon) { 
        _monsta = mon; 
    } 

    public void removeMonster(Monster mon) { 
        _monsta = null; 
    }
    
    public boolean hasMonster() { 
        return (!(_monsta==null)); 
    }
    
    public Monster getMonster() { 
        return _monsta; 
    } 
    public Slots getGame() {
        return _slot;
    }
    
    public void addGame(Slots slot) { 
        _slot = slot; 
    }
    
    public boolean hasGame() { 
        return (!(_slot==null));
    }
    
    public void removeGame(Slots slot) {
        _slot = null; 
    }

    /***
    public void setEnemy(Enemy enemy) { 
      //  _enemy = enemy;
    }

    public void setItem(Item item, String gm) { 
        _enterText = enterText;
        _enemy = enemy; 
        _item = item; 
        _gameName = gm;
    }
    
    public void change(String enterText, Enemy enemy, Item item, String gm) { 
        _enterText = enterText;
        _enemy = enemy; 
        _item = item; 
        _gameName = gm;
    }
    */
   //dont use null, use string 
}


        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        