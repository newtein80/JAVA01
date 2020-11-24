package basic.chapter03;

/**
 * 목표: String 클래스 사용과 메모리 영역
 */
public class Test03 {
	public static void main(String[] args) {
		String s1 = new String("Hello");
		
		test1(s1);
		System.out.println("main(): " + s1);
		
		test1(s1);
		System.out.println("main(): " + s1);
		
		test1(s1);
		System.out.println("main(): " + s1);
	}

	private static void test1(String s2) {
		System.out.println("test1(): " + s2);
		s2 = new String("Hello2");
	}
}
