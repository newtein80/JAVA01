package basic.chapter08;

/**
 * 목표: String 클래스 다루기
 */
public class Test08 {

	public static void main(String[] args) {
		test01();
		test02();
		test03();
		test04();
		test05();
	}

	private static void test01() {
		String s1 = new String("Hello");
		String s2 = new String("Hello");

		// * String 클래스를 new 하였기때문에 s1, s2 각각의 참조 주소는 다르다.
		if (s1 == s2) {
			System.out.println("test01 : s1 == s2");
		} else {
			System.out.println("test01 : s1 != s2");
		}
	}

	// 상수 String 객체
	private static void test02() {
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		
		// * 동일한 상수 스트링 객체이므로 같다.
		if (s1 == s2) {
			System.out.println("test02 : s1 == s2");
		}
		else {
			System.out.println("test02 : s1 != s2");
		}
		
		// * String 값은 같지만 주소가 다르다.
		if (s1 == s3) {
			System.out.println("test02 : s1 == s3");
		}
		else {
			System.out.println("test02 : s1 != s3");
		}

		// * 참조주소가 아닌 값에 대한 비교는 같다.
		if (s1.equals(s3)) {
			System.out.println("test02 : s1 equals s3");
		}
		else {
			System.out.println("test02 : s1 not equals s3");
		}
	}

	// intern() 메서드의 활용
	private static void test03() {
		String s1 = new String("Hello");
		String s2 = s1.intern(); // 힙에 있는 값과 동일한 값을 가지는 상수 스트링 객체 생성
		String s3 = "Hello";

		// * 값이 같은 새로운 상수 스트링 객체를 생성하였으므로 다르다.
		if (s1 == s2) {
			System.out.println("test03 : s1 == s2");
		}
		else {
			System.out.println("test03 : s1 != s2");
		}
		
		// * 동일한 상수 스트링 객체이므로 같다.
		if (s2 == s3) {
			System.out.println("test03 : s2 == s3");
		}
		else {
			System.out.println("test03 : s2 != s3");
		}
	}

	// ! String 클래스는 immutable이다.
	private static void test04() {
		String s1 = new String("Hello");
		String s2 = s1.replace('l', 'x');
		String s3 = s1.replace('l', 'x');

		// * String 객체를 변형하였으므로 다르다.
		if (s1 == s2) {
			System.out.println("test04 : s1 == s2");
		}
		else {
			System.out.println("test04 : s1 != s2");
		}
		
		// * 동일하게 변형하였다고 하여도 변형되었으므로 서로 다른 String 객체이다.
		if (s2 == s3) {
			System.out.println("test04 : s2 == s3");
		}
		else {
			System.out.println("test04 : s2 != s3");
		}
	}
	
	// ! StringBuffer는 mutable 객체이다.
	private static void test05() {
		StringBuffer sb1 = new StringBuffer("Hello");
		StringBuffer sb2 = sb1.replace(2, 3, "-okok-");

		// * StringBuffer는 변형이되어도 동일한 참조주소를 갖는다.
		if (sb1 == sb2) {
			System.out.println("test05 : sb1 == sb2");
		}
		else {
			System.out.println("test05 : sb1 != sb2");
		}

		// * StringBuffer는 변형이되어도 동일한 참조주소를 같는다.
		System.out.println("test05 : " + sb1.toString());
	}
}
