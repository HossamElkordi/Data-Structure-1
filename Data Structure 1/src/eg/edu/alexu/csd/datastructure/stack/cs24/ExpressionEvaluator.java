package eg.edu.alexu.csd.datastructure.stack.cs24;
/**
 * This class contains methods to deal with mathematical expressions
 * like convert from infix to postfix <p>and evaluating a postfix expression
 * @author Hossam Elkordi
 * @version 1.0
 */

public class ExpressionEvaluator implements IExpressionEvaluator{

	public String infixToPostfix(String expression) {
		StringBuilder str = new StringBuilder();
		Stack t = new Stack();
		int len = expression.length();
		for (int i = 0; i<len; i++) {
			char ch = expression.charAt(i);
			if (ch == ' ') { continue; }
			if (ch == '(') { t.push(ch); continue; }
			if (ch == ')') {
				while (!t.isEmpty() && (char)t.peek() != '(') {
					str.append((char)t.pop()); str.append(' ');
				}
				if (!t.isEmpty()) { t.pop(); }
				continue;
			}
			if (ch == '*' || ch == '/') {
				while (!t.isEmpty() && (char)t.peek() != '(' && (char)t.peek() != '+' && (char)t.peek() != '-') {
					str.append((char)t.pop()); str.append(' ');
				}
				t.push((char)ch);
				continue;
			}
			if (ch == '+' || (ch == '-') && expression.charAt(i+1) == ' ') {
				while (!t.isEmpty() && (char)t.peek() != '(') {
					str.append((char)t.pop()); str.append(' ');
				}
				t.push((char)ch);
				continue;
			}
			int j = i;
			while (expression.charAt(j) != ' ' && expression.charAt(j) != ')'
					&& expression.charAt(j) != '+'&& expression.charAt(j) != '*'&& expression.charAt(j) != '/') {
				j++;
				if (j == len) { break; }
			}
			String s = expression.substring(i, j);
			str.append(s); str.append(' ');
			if (s.length() > 1) { i = j-1; }
		}
		while (!t.isEmpty()) {
			str.append((char)t.pop()); str.append(' ');
		}
		String s = (String)str.substring(0, str.length()-1);
		return s;
	}

	public int evaluate(String expression) {
		Stack t = new Stack();
		int len = expression.length();
		
		for (int i = 0; i<len; i++) {
			char ch = expression.charAt(i);
			if ((ch >= '0' && ch <= '9')  || (ch == '-' && i+1 != len && expression.charAt(i+1) != ' ')) {
				int j = i;
				while (j < len) {
					if (expression.charAt(j) == ' ') { break; }
					j++;
				}
				String s = expression.substring(i, j);
				t.push(Float.parseFloat(s));
				if (s.length() > 1) { i = j; }
			}else {
				if (ch == ' ') {
					continue;
				}
				if (ch >= 'a' && ch <= 'z') {
					throw new IllegalArgumentException("Invalid Expression");
				}
				if (t.size() < 2) {
					throw new IllegalArgumentException("Invalid Expression");
				}
				float x = (float)t.pop();
				float y = (float)t.pop();
				switch (expression.charAt(i)) {
				 case '+' : t.push((float)y+x);
				 			break;
				 case '-' : t.push((float)y-x);
							break;
				 case '*' : t.push((float)y*x);
				 			break;		 					
				 case '/' : if (x == 0.0) {
		 						throw new ArithmeticException("The denominator is zero");
		 					}
							t.push((float)y/x);
							break;
				}
			}
		}
		if (t.size() > 1) {
			throw new IllegalArgumentException("Invalid Expression");
		}
		return Math.round((float)t.pop());
	}

}
