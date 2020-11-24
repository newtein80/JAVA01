package basic.chapter13;

/**
 * 목표: Reference Count, Garbage, finalize()
 */
public class Test13 {

	public static void main(String[] args) {
		class MyObject {
			String name;
			int age;
			
			@Override
			protected void finalize() throws Throwable {
				System.out.println("test..ok");
			}
		}
		
		MyObject p1 = new MyObject();
		MyObject p2 = new MyObject();
		MyObject p3 = p1;
		p1 = p2;
		p3 = p2;
		
		System.gc();
	}

}
