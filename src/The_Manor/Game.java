package The_Manor;

public class Game {
	
	public Game(){
		System.out.println("Vous avez cree un objet de type Game");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameTest g = new GameTest();
	}
	
	// metode qui marche
	public static int calculer(int a, int b) {
		    int res = a + b;
		    
		    if (a == 0){
		      res = b * 2;
		    } 
		    
		    if (b == 0) {
		      res = a * a;     
		    }
		    return res; 
		  }
	
	
	
	
}