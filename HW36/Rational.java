/*Addison Huang
APCS pd1
HW36 -- Be Rational
2017 11 17*/

public class Rational {
    //instance vars
    private int numerator;
    private int denominator;

    //default constructor, default is 0/1
    public Rational() {
	numerator = 0;
	denominator = 1;
    }
    //overloaded constructor takes in 2 ints
    //sets Rational to x/y unless y is 0
    //if y is 0 it becomes 0/1
    public Rational(int num, int den) {
	this();
	if (den != 0) {
	    numerator = num;
	    denominator = den;
	}
	else {
	    System.out.println("Denominator can't be 0");
	}
    }
    
    //overwritten toString that returns x/y
    public String toString() {
	return numerator + "/" + denominator;
    }
    
    //returns the float of the #
    public double floatValue() {
	return (double)numerator/denominator;
    }

    //multiplies rational 1 by rational 2 and rational 1 changes
    public void multiply(Rational x) {
	this.numerator = this.numerator * x.numerator;
	this.denominator = this.denominator *  x.denominator;
    }
    
    //same as multiplies but with dividing
    public void divide(Rational x) {
	this.numerator /= x.numerator;
	this.denominator /= x.denominator;
    }

    //main method
    public static void main(String[] args) {
	Rational r = new Rational(2,3);
	Rational s = new Rational(1,2);
	r.multiply(s); 
	System.out.println(r);
    }
}