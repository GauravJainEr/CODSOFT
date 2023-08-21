import java.util.*;

class NumGame{
    private int num;
    private int inputNumber;
    private int noOfGuesses = 0;
    public String decision = null ;
    
    NumGame() 
    {
        Random random = new Random();
        this.num = random.nextInt(100);
        this.num = this.num + 1;
    }
    void takeUserInput()
    {
        System.out.println("Guess the number between 1 to 100");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
			inputNumber = sc.nextInt();
	}
    
    boolean isCorrectNumber(){
        noOfGuesses++;
        if (inputNumber==num)
        {
            System.out.println("Yes you guessed it right, it was " +num );
            System.out.println(" You guessed in attempts " + noOfGuesses);
            return true;       
            
        }
        else if(inputNumber<num){
            System.out.println("Too low... ");
        }
        else if(inputNumber>num){
            System.out.println("Too high... ");
        }
        return false;
    }
    

}
public class NumG {
	public static String decision ;
	public static void main(String[] args) 
    {
        NumGame g = new NumGame();
        boolean b= false;
        while(!b){
        g.takeUserInput();
        b = g.isCorrectNumber();        
        }
        System.out.println("Would you like to play again yes or no" );    
        Scanner sc = new Scanner(System.in);
        String decision = sc.next();
		switch(decision){
        case "yes":
        	NumG.main(args);        	
        	System.out.println("Thank You" );
            break;
        case "no": 
            b = true;
            System.out.println("Thank You" );
            break;
		}
		sc.close();
    }
    
}
