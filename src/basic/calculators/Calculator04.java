package basic.calculators;

public class Calculator04 {
	public int result; // 인스턴스 변수

	public int plus(/*Calculator04 this,*/ int a) {
		return /*basic.Calculator04.this.*/result += a; // result = result + a
	}
	
	public int minus(/*Calculator04 this,*/ int a) {
		return /*basic.Calculator04.this.*/result -= a; // result = result - a
	}
	
	public int multiple(/*Calculator04 this,*/ int a) {
		return /*basic.Calculator04.this.*/result *= a;
	}

	public int divide(/*Calculator04 this,*/ int a) {
		return /*basic.Calculator04.this.*/result /= a;
	}
	
	public int remainder(/*Calculator04 this,*/ int a) {
		return /*basic.Calculator04.this.*/result %= a;
	}
	
	public static void intro() {
		System.out.println("계산기야...");
	}
}
