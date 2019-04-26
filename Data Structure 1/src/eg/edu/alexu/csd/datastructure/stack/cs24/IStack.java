package eg.edu.alexu.csd.datastructure.stack.cs24;

public interface IStack {
/**
 * This method returns the object of the last node and remove it  	
 * @return object stored in the last node in the stack
 */
	public Object pop();
/**
 * 	This method returns the object of the last node and keep it
 * @return object stored in the last node in the stack without removing it
 */
	public Object peek();
/**
 * This method create a new node in the stack and store element in it	
 * @param element is the Object to be stored in the new node
 */
	public void push(Object element);
/**
 * 
 * @return true if the stack is empty ,
 *         false if the stack isn't empty
 */
	public boolean isEmpty();
/**
 * 	This method get the size of the stack
 * @return the size of the stack
 */
	public int size();
}
