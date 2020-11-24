package basic.chapter11;

/**
 * 목표: 다형성 -> 다형적 변수(polymorphic variables)
 */
public class Test11 {

	public static void main(String[] args) {

		test01();

		class CallA {
			public void m() {
				System.out.println("Class CallA -> m method call !");
			}
			
			public void ok() {
				System.out.println("Class CallA -> ok method call !");
			}
		}
		
		class CallB extends CallA {
			public void m() {
				System.out.println("class CallB (extends CallA) -> m method call Start...!");
				super.m();
				System.out.println("class CallB (extends CallA) -> m method call End...!");
			}
		}
		
		class CallC extends CallB {
			public void ok() {
				super.ok();
				System.out.println("class CallC (extends CallB) -> ok method call !");
			}
		}
		
		CallA p = new CallB();
		p.m(); // ! 실제 객체에서 호출하려는 메서드를 재정의 했다면, 재정의된 메서드가 호출된다.

		CallB p2 = new CallC();
		p2.ok();
	}

	private static void test01() {
		class A {
			public void mA() { System.out.println("test01 -> mA"); }
		}
		
		class BA extends A {
			public void mB() { System.out.println("test01 -> mB"); }
		}

		class CA extends A {
			public void mC() { System.out.println("test01 -> mC"); }
		}
		
		class DBA extends BA {
			public void mD() { System.out.println("test01 -> mD"); }
		}

		class ECA extends CA {
			public void mE() { System.out.println("test01 -> mE"); }
		}

		A p = new A();
		p = new BA();	// ! A 클래스 변수에 'A클래스를 상속받은' BA 클래스를 지정할 수 있지만 <-- 이부분!
		p.mA();			// ! 접근할 수 있는 함수는 A클래스의 함수만 접근 가능하다.
		
		BA p2 = new BA();
		p2 = new DBA();
		p2.mA();
		p2.mB();

		CA p3 = new ECA();
		p3 = new CA();
		p3.mA();
		p3.mC();

		DBA p4 = new DBA();
		p4.mA();
		p4.mB();
		p4.mD();

		CA p6 = new ECA();
		p6.mA();
		p6.mC();

		ECA p7 = new ECA();
		p7.mA();
		p7.mC();
		p7.mE();
	}

}
