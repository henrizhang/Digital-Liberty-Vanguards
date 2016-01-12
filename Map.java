public class Map {

    //constant for default matrix size
    private final static int DEFAULT_SIZE = 6;

    private Object[][] matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Map() {
	matrix = new Object[DEFAULT_SIZE][];
	for (int a = 0 ; a < DEFAULT_SIZE; a ++ ) {
	    matrix[a] = new Object [(int)(Math.random() * 10)];
	}
	
	for (int i = 0; i < matrix.length; i++){
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = i + j ;
      }
    }
}
    
    public String toString() {
	String str = "";
       for(int i = 0; i < matrix.length ; i++) {
          for (int j = 0; j < matrix[i].length ; j++) {
             str += (matrix[i][j]) + "\t";
          }
          str += "\n";
       }
       return str; 
    }

    public static void main( String[] args ) {
       Map a = new Map(); 
       System.out.println(a);
    }
}


    
