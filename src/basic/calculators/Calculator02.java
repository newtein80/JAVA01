package basic.calculators;

public class Calculator02 {
	public static int result;

	public static int plus(int a) {
		return result += a; // result = result + a
	}
	
	public static int minus(int a) {
		return result -= a; // result = result - a
	}
	
	public static int multiple(int a) {
		return result *= a;
	}

	public static int divide(int a) {
		return result /= a;
	}
	
	public static int remainder(int a) {
		return result %= a;
	}
}
