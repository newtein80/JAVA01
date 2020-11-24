package pattern;

/**
 * 목표: 다형성 > 오버로딩(Overloading)
 * 같은 기능을 하는 메서드에 대해 같은 이름을 부여함으로써 프로그래밍의 일관성을 확보하는 문법
 */
public class OverloadingTest {

	static public int plus(int a, int b) {
		return a + b;
	}
	
	static public float plus(float a, float b) {
		return a + b;
	}
	
	static public int plus(int a) {
		return a + a;
	}
	
	public static void main(String[] args) {
		System.out.println(OverloadingTest.plus(10));
		System.out.println(OverloadingTest.plus(10.5f, 20.6f));
		System.out.println(OverloadingTest.plus(10, 20));
		//System.out.println(OverloadingTest.plus(10, 20, 30));
	}
}
