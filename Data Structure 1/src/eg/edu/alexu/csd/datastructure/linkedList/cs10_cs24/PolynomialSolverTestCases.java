package eg.edu.alexu.csd.datastructure.linkedList.cs10_cs24;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class PolynomialSolverTestCases {

	@Test
	public void test() {
		PolynomialSolver p = new PolynomialSolver();
		int[][] input1 = {{1,2},{2,1},{5,0}};
		p.setPolynomial('A', input1);
		// setPolynomial and print test and their exception
		assertEquals("X^2+2X+5", p.print('A'));
		assertThrows(IllegalArgumentException.class, () -> p.print('B'));
		assertThrows(IllegalArgumentException.class, () -> p.print('R'));
		int[][] input2 = {{3,2},{1,1},{8,0}};
		p.setPolynomial('B', input2);
		assertEquals("3X^2+X+8", p.print('B'));
		// add test
		p.add('A', 'B');
		assertEquals("4X^2+3X+13", p.print('R'));
		// subtract test
		p.subtract('A', 'B');
		assertEquals("-2X^2+X-3", p.print('R'));
		// multiply test
		p.multiply('B', 'A');
		assertEquals("3X^4+7X^3+25X^2+21X+40", p.print('R'));
		int[][] input3 = {{2,-2}};
		p.setPolynomial('C', input3);
		p.multiply('C', 'A');
		assertEquals("2+4X^-1+10X^-2", p.print('R'));
		// evaluatePolynomial test and its exception
		assertEquals(88.0,p.evaluatePolynomial('B', 5));
		assertThrows(ArithmeticException.class, () -> p.evaluatePolynomial('C', 0));
		assertEquals(0.5,p.evaluatePolynomial('C', 2));
		// clear Polynomial and its exception
		p.clearPolynomial('C');
		assertThrows(IllegalArgumentException.class, () -> p.add('C', 'A'));
	}

}
