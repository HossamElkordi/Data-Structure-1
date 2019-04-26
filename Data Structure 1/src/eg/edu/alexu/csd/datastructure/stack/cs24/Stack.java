package eg.edu.alexu.csd.datastructure.stack.cs24;

import java.util.EmptyStackException;
 
public class Stack implements IStack{
/**
 * Node head : represent the first node in the stack
 * and initially set to null .<p> 
 * Integer size : represent number of nodes in the stack , 
 * it's incremented with every push and decremented with every pop
 */
	stackNode head = null;
	int size = 0;
	
	public Object pop() {
		if (head == null) {
			throw new EmptyStackException();
		}
		Object o = head.data;
		head = head.prev;
		size--;
		return o;
	}

	public Object peek() {
		if (head == null) {
			throw new EmptyStackException();
		}
		return head.data;
	}
	
	public void push(Object element) {
		if (head == null) {
			stackNode s = new stackNode();
			s.data = element;
			s.prev = null;
			head = s;
			size++;
		}else {
			stackNode s = new stackNode();
			s.data = element;
			s.prev = head;
			head = s;
			size++;
		}
	}
	
	public boolean isEmpty() {
		return (head == null && size == 0);
	}
	
	public int size() {
		return size;
	}
}
