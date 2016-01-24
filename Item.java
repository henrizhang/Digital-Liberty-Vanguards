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
}



        