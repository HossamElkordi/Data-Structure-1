package eg.edu.alexu.csd.datastructure.stack.cs24;

import java.util.Scanner;
/**
 * This class is a user interface for different operations on Stack ,<p>
 * where the user is asked to enter an number from 1 to 5 , each number<p>
 * representing an operation , and it stops only if an exception is thrown .
 * @author Hossam Elkordi
 *
 */
public class StackUI {
/**
 * This is the main method for the stack user interface
 * @param args
 */
	public static void main(String[] args) {
		Stack s = new Stack();
		while (true) {
			int operation;
			System.out.print("Please choose an operation\n" +
							"------------------------------\n"+
							"1- Push\n"+
							"2- Pop\n"+
							"3- Peek\n"+
							"4- Get Size\n"+
							"5- Check if empty\n"+
							"===============================\n");
			Scanner scan = new Scanner(System.in);
			operation = scan.nextInt();
			switch (operation) {
				case 1 : System.out.println("Enter an element :");
						s.push(scan.next());
						break;
				case 2 : System.out.println(s.pop());
						 break;
				case 3 : System.out.println(s.peek());
				         break;
				case 4 : System.out.println(s.size());
						 break;      
				case 5 : if (s.isEmpty()) {
							System.out.println("Stack is Empty");
						 }else {
							 System.out.println("Stack isn't Empty");
						 }
						 break;
			    default : System.out.println("Enter a valid operation");
			}
		}
	}

}
