package eg.edu.alexu.csd.datastructure.stack.cs24;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
/**
 * This is a JUnit test case class for the expression evaluator class 
 * @author Hossam Elkordi
 *
 */
public class ExpressionEvaluatorTest {
/**
 * This method calls assertEquals and assertThrows methods<P>
 * to test some cases and compares it with the expected result and <p>
 * checks for exceptions throwns
 */
	@Test
	public void test() {
		ExpressionEvaluator p = new ExpressionEvaluator();
		assertEquals("34 52 + 657 0 -6687 / -",p.infixToPostfix("34 + 52 - 657 / 0 -6687"));
		assertThrows(IllegalArgumentException.class, () -> p.evaluate("34 + 52 - 657 / 0 -6687"));
		assertThrows(ArithmeticException.class, () -> p.evaluate("34 52 + 657 0 / - -6687 +"));
		
		assertEquals("34 52 + 657 -649783856666 / - 6687 +",p.infixToPostfix("34 + 52 - 657 / -649783856666 + 6687"));
		assertEquals(6773,p.evaluate(p.infixToPostfix("34 + 52 - 657 / -649783856666 + 6687")));
		
		assertEquals("a b c - d + / e a - * c *",p.infixToPostfix("(a / (b - c + d)) * (e - a) * c"));
		assertEquals("a b / c - d e * + a c * -",p.infixToPostfix("a / b - c + d * e - a * c"));
		
		assertEquals("2 3 4 * +",p.infixToPostfix("2 + 3 * 4"));
		assertEquals(14,p.evaluate("2 3 4 * +"));
		assertThrows(IllegalArgumentException.class, () -> p.evaluate("2 3 4 * "));
		
		assertEquals("1 2 + -7 *",p.infixToPostfix("(1 + 2) * -7"));
		assertEquals(-21,p.evaluate("1 2 + -7 *"));
	}

}
