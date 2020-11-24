package basic.chapter01;

/**
 * 목표: 자료형 (숫자)
 */
public class Test01 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte b = -128;
		byte b2 = 127;
		// byte b3 = 128;

		short s1 = -32768;
		short s2 = 32767;
		// short s3 = 32768;
		int i1 = Integer.MAX_VALUE;
		System.out.println(i1);
		// int i2 = 2147483648;
		// int i3 = 2147483648L;

		float f1 = 987654321f;
		System.out.println(f1);

		double d1 = 987654321;
		System.out.println(d1);

		boolean bl1 = true;
		boolean bl2 = false;

		char c1 = 0xAC00;
		char c2 = '가';
		char c3 = '\uAC00';

		System.out.println(c1 + "," + c2 + "," + c3);
	}

}
