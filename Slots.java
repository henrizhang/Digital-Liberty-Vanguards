//class Slots
//simulates a slot machine in your very own terminal
//Slots can be made up of Items ? and you collect another clue / item ? or u could just give a hint 
public class Slots extends Game {
	private static final Item[] ITEMS = {
		new Key(), new Key(), new Key(), 
		new Potion(), new Potion(), new Potion(), 
		new Booster(),new Booster(),new Booster(),
		new Drain(), new Drain(), new Drain() };
  private Item[] _items; //to be init'd by each instance


    /*=====================================
      Slots() -- default constructor
      pre:  constant array ITEMS exists, has been initialized
      post: mutable array _ITEMS contains same elements as ITEMS
      =====================================*/
    public Slots() {
    	_gameName="Slots";
    	

	//allocate memory for _ITEMS based on size of ITEMS
	_items = new Item [ITEMS.length];

	//copy elements of ITEMS into _ITEMS
	for (int i = 0; i < ITEMS.length; i++) {
	    _items[i] = ITEMS[i];
	}
    }
    
    /*=====================================
      String toString() -- overrides inherited toString()
      pre:  
      post: returns String of elements in slots 0 thru 2, separated by tabs
      =====================================*/
    public String toString() {
	return _items[0] + "|" + _items[1] + "|" + _items[2];
 
    }

    /*=====================================
      void swap(int,int) -- array swap util fxn
      pre:  _ITEMS array exists
      post: elements at indices i, j are swapped
      =====================================*/
    private void swap( int i, int j ) {
	Item swap1;
	swap1 = _items[i];
	_items[i] = _items[j];
	_items[j] = swap1; 
    }


    /*=====================================
      void spinOnce() -- simulate a pull of the slot machine lever
      pre:  _ITEMS array exists
      post: randomized order of elements in _ITEMS array
      =====================================*/
    public void spinOnce() {
	int s = 0;
        for (int r = 0; r < 12; r++) {
	    s = (int)(Math.random() * 11); 
	    swap(r,s);
 
	}
    }

    /*=====================================
      boolean jackpot() -- checks for a winning combo
      pre:  _ITEMS is existing array
      post: returns true if first 3 slots represent winning combo,
      false otherwise
   =====================================*/   
    public boolean jackpot() {
	if (_items[0]._name.equals(_items[1]._name) && _items[2]._name.equals(_items[1]._name))
	    return true;
	else return false; 
    }
    
    public Item theWin() {
    		return _items[0];
    }

}