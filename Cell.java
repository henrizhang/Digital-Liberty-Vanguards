public class Cell { 
    public String _name; 
    private String _enterText;
    private boolean hasPlayer; 
    public Item _item; 
    //instance variables of Cell
    

    
   // private Enemy _enemy; //whether or not there is someone in the Cell, 
    
   // private String _gameName; //what game is in it (if it's there at all?)
    
   // private Item _item; //what item lies in this Cell?
    
    public Cell() { 
        _name = "X"; 
        _item = null; 
        
        
      //default Cell constructor
    }
    
    public Cell(String name) {
        _name = name; 
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
    
    public void addItem(String name) { 
        Item a = new Item(name); 
        _item = a;
    
    }
        
    public boolean hasItem() { 
        return (!(_item==null));
        }
    
    
//    public Cell(String enterText) {
    
        
  //      _enterText = enterText;
       /**
        _enemy = enemy; 
        _item = item; 
        _gameName = gm; 
        */
        
        
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


        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        