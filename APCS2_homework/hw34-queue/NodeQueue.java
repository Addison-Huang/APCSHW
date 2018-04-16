/*Addison Huang
APCS2 pd2
HW #34 -- The English Do Not Wait in Line
2018 04 16
*/

public class NodeQueue<T> implements Queue<T> {
    private LLNode <T> front, end;

    public LLQueue() {
	front = end = null;
    }

    public T dequeue() {
	T temp = front.getValue();
	front = front.getNext();
	if (front = null) //if the queue is empty
	    end = null;
	return foo;
    }

    public T enqueue(T x) {
	if (isEmpty()) {
	    front = end = new LLNode<T>(x, null);
	}
	else {
	    end.setNext(new LLNode<T>(x, null));
	    end = end.getNext();
	}
    }

    public boolean isEmpty() {
	return front == null;
    }

    public T peekFront() {
	return front.getValue();
    }

    public static void main(String[] args) {
    }

}
	
	
