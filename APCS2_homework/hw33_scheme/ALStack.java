import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE>{

    private ArrayList<PANCAKE> stack;

    public ALStack() {
	stack = new ArrayList<PANCAKE>();
    }

    public ALStack(int size) {
	_stack = new ArrayList<PANCAKE>(size);
    
    public boolean isEmpty() {
	return (stack.size() == 0);
    }

    public PANCAKE peek() {
	PANCAKE retVal = null;
	if ( isEmpty())
	    return retVal;
	retVal = stack.get(stack.size()-1);
	return retval;
    }

    public PANCAKE pop() {
	PANCAKE retVal = null;
	if ( isEmpty())
	    return retVal;
	retVal = stack.remove(stack.size()-1);
	return retval;
    }

    public void push(PANCAKE x) {
	stack.add(x);
    }

    public static void main(String[] args) {
    }
}
