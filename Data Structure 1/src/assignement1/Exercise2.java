package assignement1;

import java.math.BigInteger;

public class Exercise2 {
	
	public static BigInteger fibbonacci (int n) {
		BigInteger fib[] = new BigInteger[n];
		fib[0] = BigInteger.ZERO;
		fib[1] = BigInteger.ONE;
		for (int i = 2; i<n; i++) {
			fib[i] = fib[i-1].add(fib[i-2]);
		}
		return fib [n-1];
	}

}
