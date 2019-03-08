package assignement1;

public class MySpecialArrayUtils {

	public static void reverse(int[] arr) {
		int temp;
		for (int i = 0; i<arr.length/2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}
	
	public static int[] sumEvenOdd(int[] arr) {
		int sumEven = 0;
		int sumOdd = 0;
		for (int i = 0; i<arr.length; i++) {
			if (arr[i] % 2 == 0) {
				sumEven += arr[i];
			}else {
				sumOdd += arr[i];
			}
		}
		int sum[] = {sumEven,sumOdd};
		return sum;
	}
	
	public static double average(int[] arr) {
		double average = 0.0;
		int size = arr.length;
		for (int x : arr) {
			average += (1/(double)size)*x;
		}
		return average;
	}

	public static void moveValue(int[] arr, int val) {
		int size = arr.length;
		for (int i = 0; i<size; i++) {
			if (arr[i] == val) {
				for (int j = i; j<arr.length-1; j++) {
					arr[j] = arr[j+1];
				}
				arr[arr.length-1] = val;
				i--;
				size--;
			}
		}
	}
	
	public static void transpose(int[][] arr) {
		if (arr[0].length == 0 && arr.length == 0) {
			return;
		}
		int x[][] = new int[arr[0].length][arr.length];
		for (int i = 0; i<arr[0].length; i++) {
			for (int j = 0; j<arr.length; j++) {
				x[i][j] = arr[j][i];
			}
		}
		arr = x;
	}
}
