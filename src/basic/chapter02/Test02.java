package basic.chapter02;

class Box {
	public static float PI = 3.14159f;

	static {
		System.out.println("Box02 static...");
	}

	public static void test() {
		System.out.println("Box02.test() excute...");
	}

}

/**
 * 목표: 클래스 로딩 과정
 */
public class Test02 {
	static {
		System.out.println("static...");
	}

	public static void main(String[] args) {
		System.out.println("main...");

		float pi = Box.PI;
		System.out.println(Float.toString(pi));

		// The static method test() from the type Box02 should be accessed
		// Box p = new Box();
		// p.test(); 

		// in a static way
		Box.test();

	}
}
