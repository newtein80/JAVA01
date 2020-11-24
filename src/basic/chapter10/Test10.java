package basic.chapter10;

/**
 * 목표: Wrapper 클래스와 auto-boxing
 * https://growinglastcanyon.tistory.com/8
 * https://growinglastcanyon.tistory.com/6
 * https://meetup.toast.com/posts/185
 * https://velog.io/@nsg1213/2019-08-03-2308-%EC%9E%91%EC%84%B1%EB%90%A8-osjyvmmuo8
 * java는 데이터로서 클래스와 객체 외에 기초(primitive) 타입을 가진다.
 * 그렇기 때문에 기본형 타입(primitive 자료형)과 객체 참조(클래스) 같은 두 가지 타입의 관리 데이터를 가진다.
 * 경우에 따라서 기본형 타입을 객체로 사용하는 경우가 있으며, 이러한 경우 기본형 타입 값을 객체로 표현해야 한다.
 * 이 때, Wrapper 클래스를 사용하는데 특정 기본형 타입으로 나타낸다.
 * 예를 들어 Integer 클래스는 간단한 정수 값을 나타내며 객체는 하나의 int값을 저장할 수 있다.
 */
public class Test10 {

	public static void main(String[] args) {
		test01();
		test02();
		test03();
	}

	private static void test01() {
		// ! Deprecated
		// 이 생성자를 사용하는 것은 거의 적절하지 않습니다. 정적 팩토리 valueOf (int)는 훨씬 더 나은 공간 및 시간 성능을 산출 할 수 있으므로 일반적으로 더 나은 선택입니다.
		// Integer i1 = new Integer(100);
		// Integer i2 = new Integer(200);
		Integer i1 = Integer.valueOf(10);
		Integer i2 = Integer.valueOf(10);
		
		if (i1 == i2) {
			System.out.println("test01 : " + "i1 == i2");
		}
		else {
			System.out.println("test01 : " + "i1 != i2");
		}
		
		if (i1.equals(i2)) {
			System.out.println("test01 : " + "i1 equals i2");
		}
		else {
			System.out.println("test01 : " + "i1 not equals i2");
		}
	}

	private static void test02() {
		Integer i1 = 10; // == new Integer(10) -> boxing
		Integer i2 = 10; 
		
		if (i1 == i2) {
			System.out.println("test02 : " + "i1 == i2");
		}
		else {
			System.out.println("test02 : " + "i1 != i2");
		}
		
		int i = 10;
		Integer i3 = i;
		Integer i4 = i;
		
		if (i3 == i4) {
			System.out.println("test02 : " + "i3 == i4");
		}
		else {
			System.out.println("test02 : " + "i3 != i4");
		}
	}

	private static void test03() {
		// ! Deprecated 이 생성자를 사용하는 것은 거의 적절하지 않습니다. 정적 팩토리 valueOf (int)는 훨씬 더 나은 공간 및 시간 성능을 산출 할 수 있으므로 일반적으로 더 나은 선택입니다.
		// Integer i1 = new Integer(100);
		// Integer i2 = new Integer(200);
		Integer i1 = Integer.valueOf(100);
		Integer i2 = Integer.valueOf(200);
		
		int i3 = i1; // == i1.intValue() -> unboxing 
		int i4 = i2;

		if (i1 == i2) {
			System.out.println("test03 : " + "i1 == i2");
		}
		else {
			System.out.println("test03 : " + "i1 != i2");
		}

		if (i3 == i4) {
			System.out.println("test03 : " + "i3 == i4");
		}
		else {
			System.out.println("test03 : " + "i3 == i4");
		}
	}
}
