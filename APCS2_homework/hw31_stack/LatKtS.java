/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/
/* Addison Huang
APCS2 pd2
HW31 -- Stack: What is it Good For?
2018 04 11
*/

public class LatKtS
{
    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s )
    {
	Latkes reverse = new Latkes(s.length());
	for (int x = 0; x < s.length(); x++) {
	    reverse.push(s.substring(x,x+1));
	}
	String ret = "";
	while (! reverse.isEmpty()) {
	    ret += reverse.pop();
	}
	return ret;
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s )
    {
	if(s.length() % 2 != 0){
	    return false;
	}
	Latkes temp = new Latkes(s.length());
	for(int x = 0; x < s.length(); x ++){
	    String currVal = s.substring(x, x + 1);
	    if(currVal.equals("{") ||
	       currVal.equals("[") ||
	       currVal.equals("("))
		temp.push(currVal);
	    else{
		String isMatch = temp.pop();
		if((currVal.equals("}") && (! isMatch.equals("{")))||
		   (currVal.equals(")") && (! isMatch.equals("(")))||
		   (currVal.equals("]") && (! isMatch.equals("[")))){
		    return false;
		}
	    }
	}
	return true;
    }//end allMatched()


    //main method to test
    public static void main( String[] args )
    {
	System.out.println(flip("stressed"));
	System.out.println(allMatched( "({}[()])" )); //true
	System.out.println(allMatched( "([)]" ) ); //false
	System.out.println(allMatched( "(){([])}" ) ); //true
	System.out.println(allMatched( "](){([])}" ) ); //false
	System.out.println(allMatched( "(){([])}(" ) ); //false
	System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    }

}//end class LatKtS
