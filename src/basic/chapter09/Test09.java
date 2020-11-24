package basic.chapter09;

/**
 * 목표: Object로부터 상속 받는 주요 메서드
 * toString()
 * equals()
 * 
 * Wrapper 클래스: 기본 데이터타입을 클래스로 정의한 것.
 * hashCode()
 * finalize()
 * 
 * 다형적 변수(polymorphic variables)
 */
public class Test09 {

	public static void main(String[] args) {
		test01();
		test02();
		test03();
		test04();
	}

	private static void test01() {
		/**
		 * extends Object
		 */
		class MyObject {
			String 	name;
			int 	age;
		}
		
		MyObject o1 = new MyObject();
		o1.name = "홍길동";
		o1.age = 20;
		
		System.out.println("test01: " + o1.toString()); // 리턴값: (기본) 클래스명@해쉬코드 
	}

	// toString() 메서드
	private static void test02() {
		/**
		 * extends Object
		 */
		class MyObject {
			String 	name;
			int 	age;
			
			/**
			 * 리턴값: override된 toString 함수의 return 값
			 */
			@Override
			public String toString() {
				return name + "," + age;
			}
		}
		MyObject o1 = new MyObject();
		o1.name = "홍길동";
		o1.age = 20;
		
		System.out.println("test02: " + o1.toString()); // 리턴값: override된 toString 함수의 return 값
	}
	
	private static void test03() {
		/**
		 * extends Object
		 */
		class MyObject {
			String	name;
			int 	age;
		}
		
		MyObject o1 = new MyObject();
		o1.name = "홍길동";
		o1.age = 20;
		
		MyObject o2 = new MyObject();
		o2.name = "홍길동";
		o2.age = 20;
		
		// * 생성자로 서로 다른 객체를 생성하였으므로 다르다.
		if (o1 == o2) {
			System.out.println("test03: " + "o1 == o2");
		}
		else {
			System.out.println("test03: " + "o1 != o2");
		}
		
		// * 상속받은 equals()는 주소가 같은지를 비교한다. 생성자로 서로 다른 객체를 생성하였으므로 다르다.
		if (o1.equals(o2)) {
			System.out.println("test03: " + "o1 equals o2");
		}
		else {
			System.out.println("test03: " + "o1 not equals o2");
		}
	}

	private static void test04() {
		/**
		 * extends Object
		 */
		class MyObject {
			String 	name;
			int 	age;

			/**
			 * Object 클래스의 equals 함수를 override 한다.
			 * ! ValueObject의 형태를 갖는다???
			 */
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;

				MyObject other = (MyObject) obj;

				if (age != other.age)
					return false;

				if (name == null) {
					if (other.name != null)
						return false;
				} else if (!name.equals(other.name))
					return false;

				return true;
			}

			/*
			@Override
			public boolean equals(Object obj) {
				if (obj == null) return false;
				if (!(obj instanceof MyObject)) return false;
				MyObject other = (MyObject) obj;
				if (!name.equals(other.name)) return false;
				if (age != other.age) return false;
				return true;
			}*/
		}

		MyObject o1 = new MyObject();
		o1.name = "홍길동";
		o1.age = 20;
		
		MyObject o2 = new MyObject();
		o2.name = "홍길동";
		o2.age = 20;
		
		if (o1 == o2) {
			System.out.println("test04: " + "o1 == o2");
		}
		else {
			System.out.println("test04: " + "o1 != o2");
		}
		
		// * 재정의(override)된 equals()가 호출된다.
		if (o1.equals(o2)) {
			System.out.println("test04: " + "o1.equals(o2)");
		}
		else {
			System.out.println("test04: " + "o1 not equals o2");
		}
	}
}
