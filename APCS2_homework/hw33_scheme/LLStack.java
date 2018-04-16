/* Addison Huang
APCS2 pd2
HW 32 -- Leon Leonwood Stack
2018 04 12
*/

import java.util.LinkedList;

public class LLStack <PANCAKE> implements Stack <PANCAKE> {

    private LinkedList<PANCAKE> stack;

    public LLStack() {
	stack = new LinkedList<PANCAKE>();
    }

    public boolean isEmpty() {
	return (stack.size() == 0);
    }

    public PANCAKE peek() {
	PANCAKE retVal = null;
	if (isEmpty())
	    return null;
	retVal = stack.get(stack.size()-1);
	return retVal;
    }

    public PANCAKE pop() {
        PANCAKE retVal = null;
	if (isEmpty())
	    return null;
	retVal = stack.remove(stack.size()-1);
	return retVal;
    }

    public void push (PANCAKE x) {
	stack.add(x);
    }

    public static void main(String[] args) {
    }
}
