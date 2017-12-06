import cs1.keyboard;
public class GuessNumber {
    //instance vars
    private int upperBound = 100; //stores the upperBound of guesses
    private int lowerBound = 1; //stores the lowerBound of gueeses
    private int numberGuess = (int)(Math.random()*100) +1 ; //stores the numberToGuess
    private int guesses = 0; //stores the # of guesses

    public static void guess(int guess) {

	if (guess > upperBound) {
	    System.out.println("Oops! Too high. Try again!");
	    
	
    }

    
