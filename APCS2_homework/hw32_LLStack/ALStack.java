import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE>{

    private ArrayList<PANCAKE> stack;

    public ALStack() {
	stack = new ArrayList<PANCAKE>();
    }
    
    public boolean isEmpty() {
	return (stack.size() == 0);
    }

    public PANCAKE peek() {
	return stack.get(0);
    }

    public PANCAKE pop() {
	return stack.remove(0);
    }

    public void push(PANCAKE x) {
	stack.add(0,x);
    }

    public static void main(String[] args) {
    }
}
