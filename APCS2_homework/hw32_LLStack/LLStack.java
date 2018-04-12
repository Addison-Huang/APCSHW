/* Addison Huang
APCS2 pd2
HW 32 -- Leon Leonwood Stack
2018 04 12
*/

import java.util.LinkedList;

public class LLStack <PANCAKE> implements Stack <PANCAKE> {

    private LinkedList<PANCAKE> stack;

    public LLStack() {
	stack = new LinkedList();
    }

    public boolean isEmpty() {
	return (stack.size() == 0);
    }

    public PANCAKE peek() {
	return stack.getFirst();
    }

    public PANCAKE pop() {
	return stack.removeFirst();
    }

    public void push (PANCAKE x) {
	stack.addFirst(x);
    }

    public static void main(String[] args) {
    }
}
