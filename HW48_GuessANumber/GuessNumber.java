/*==================================================
  class GuessNumber -- fun fun fun!
  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/
/*Addison Huang
  APCS1 pd1
  HW48 keep Guessing
  2017 12 06
*/

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
	_lo = a;
	_hi = b;
	_guessCtr = 0;
	_target = (int)(Math.random()*(_hi - _lo +1)) + _lo;
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() 
    {
	System.out.print("Guess a number from " + _lo + " to " + _hi + ": ");
	int guess1 = Keyboard.readInt();
	_guessCtr += 1;
	if (guess1 == _target) {
	    System.out.println("WOOO YOU GUESSED THE CORRECT NUMBER");
	    System.out.println("It took " + _guessCtr + " tries");
	}
	else if  ((guess1 > _target) && (guess1 <= _hi)) {
	    System.out.println("Your guess was too high");
	    _hi = guess1 - 1;
	    playRec();
	} else if ((guess1 < _target) && (guess1 >= _lo))  {
	    System.out.println("Your guess was too low");
	    _lo = guess1 + 1;
	    playRec();
	}
	else {
	    System.out.println("Your guess was out of the range! Guess again!");
	    playRec();
	}
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
	System.out.print("Guess a number from " + _lo + " to " + _hi + ": ");
	int guess1 = Keyboard.readInt();
	while (guess1 != _target) {
	    _guessCtr += 1;
	    if ((guess1 > _target) && (guess1 <= _hi))  {
		System.out.println("Your guess was too high");
		_hi = guess1 - 1;
	    } else if ((guess1 < _target) && (guess1 >= _lo)) {
		System.out.println("Your guess was too low");
		_lo = guess1 + 1;
	    }
	    else {
		System.out.println("Your guess was out of the range! Guess again!");
	    }
	    
	    System.out.print("Guess a number from " + _lo + " to " + _hi + ": ");
	    guess1 = Keyboard.readInt();
	}
	_guessCtr += 1;
	System.out.println("");
	System.out.println("WOOO YOU GUESSED THE CORRECT NUMBER!!!!!!");
	System.out.println("!!!~~~~~~~~~ CONGRATULATIONS ~~~~~~~~~!!!");
	System.out.println("It took " + _guessCtr + " tries");	
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() 
    {
	System.out.println("~~~Welcome to Guess Number!~~~");
	System.out.println("");
	//use one or the other below:
	//playRec();
	playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {
	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);
	//start the game
	g.play();
    }//end main

}//end classimport cs1.keyboard;

