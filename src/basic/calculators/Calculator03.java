package basic.calculators;

public class Calculator03 {
	public int result; // 인스턴스 변수

	public static int plus(Calculator03 instance, int a) {
		return instance.result += a; // result = result + a
	}
	
	public static int minus(Calculator03 instance, int a) {
		return instance.result -= a; // result = result - a
	}
	
	public static int multiple(Calculator03 instance, int a) {
		return instance.result *= a;
	}

	public static int divide(Calculator03 instance, int a) {
		return instance.result /= a;
	}
	
	public static int remainder(Calculator03 instance, int a) {
		return instance.result %= a;
	}
}
