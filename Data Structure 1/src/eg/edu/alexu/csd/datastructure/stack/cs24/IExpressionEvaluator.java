package eg.edu.alexu.csd.datastructure.stack.cs24;

public interface IExpressionEvaluator {
/**
 * This method convert an infix mathematical expression to postfix expression		
 * @param expression is a string representing the infix expression to be converted
 * @return a string representing the postfix expression of the input expression
 */	
	public String infixToPostfix(String expression);
/**
 * This method calculate the value of a postfix expressin , <p>
 * and throws IllegalArgumentException if the input expression has caracters instead of numbers
 * or has a missing operator or ,<p> at the end , the stack contains more than one number ,<p>
 * and throws AritmeticException if a division operation is executed and the denominator is zero	
 * @param expression a sting representing the postfix expression to be enaluated
 * @return an integer value of the result of the input expression 
 */
	public int evaluate(String expression);
	
}
