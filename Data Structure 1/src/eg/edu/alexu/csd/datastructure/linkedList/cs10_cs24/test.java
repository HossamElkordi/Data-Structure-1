package eg.edu.alexu.csd.datastructure.linkedList.cs10_cs24;

public class test {
	public static void main (String[] args) {
		PolynomialSolver p = new PolynomialSolver();
		int[][] i = {{3,5},{4,2}};
		int[][] j = {{4,5},{3,0}};
		p.setPolynomial('A', i);
		p.setPolynomial('B', j);
		p.subtract('A', 'B');
		p.print('R');
		
	}
}
