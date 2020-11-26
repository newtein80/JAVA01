package customspring;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:beans.xml"); // 
        // 복수의 xml 파일 가능
        // ApplicationContext context = new ClassPathXmlApplicationContext("ctx.xml", "ctx2.xml");

		test01(context);
		test02(context);
		test03(context);
		test04(context);
		test05(context);
		test06(context);
		test07(context);
		test08(context);
		test09(context);
		test10(context);
        test11(context);
    }

    /**
     * 스프링 빈 컨테이너로부터 객체 꺼내기
     * @param context
     */
	private static void test01(ApplicationContext context) {
		Car p = (Car) context.getBean("car", Car.class);
		
		System.out.println(p.model);
		System.out.println(p.cc);
    }

    /**
     * 빈의 생성 개수 : 기본 1개를 생성하여 공유
     * @param context
     */
	private static void test02(ApplicationContext context) {
		Car p = (Car) context.getBean("car");
		p.model = "Bean create";
		p.cc    = 2222;
		// p에 새로 p.model에 "Bean create"를 넣고 p.cc에 2222를 넣어 p는 바뀐 상태에서 car라는 객체를 불러 p2를 생성하면 p2는 기존의 p를 
		// 공유하여 p2.model에 새롭게 넣어진 "Bean create"를 갖게 되고  p2.cc에도 새롭게 넣어진 2222를 갖게 되어 
		// 출력창에는 기존의 1개를 생성해서 공유하게 되었지만 새롭게  update된 "Bean create"와 2222가 출력되게 된다.
		Car p2 = (Car) context.getBean("car");
		System.out.println(p2.model);
		System.out.println(p2.cc);
    }

    /**
     * 빈의 Scope을 prototype으로 설정하면, 빈 요청시 새로 객체를 만들어서 리턴한다.
     * @param context
     */
	private static void test03(ApplicationContext context) {
		Car p = (Car) context.getBean("car2");
		p.model = "New Bean create";
		p.cc    = 2223;
		
		Car p2 = (Car) context.getBean("car2"); // 기존의 Car의 "Original"을 보여줌(?)
		System.out.println(p2.model);
		System.out.println(p2.cc);
    }

    /**
     * setter 메소드의 호출 설정. (-car 3, car4, car5)
     * @param context
     */
	private static void test04(ApplicationContext context) {
		Car p = (Car) context.getBean("car3");
		
		System.out.println(p.model);
		System.out.println(p.cc);
    }

    /**
     * Collection Parameter를 갖는 setter 메소드 호출
     * @param context
     */
	private static void test05(ApplicationContext context) {
		Car p = (Car) context.getBean("car6");
		
		System.out.println(p.model);
		System.out.println(p.cc);
		
		for(Object obj : p.options){
			if(obj instanceof String){ //obj가 String이라면
				System.out.println(obj);
			}else{
				Trunk t = (Trunk) obj;
				System.out.println(t.getCapacity());
			}
		}
    }

    /**
     * 객체의 setter method의 객체 넘김 : <ref bean="빈의 아이디">
     * @param context
     */
	private static void test06(ApplicationContext context) {
		Car p = (Car) context.getBean("car8");
		Trunk t = (Trunk) p.getOptions().get(2);
		t.capacity = 777;
		System.out.println(t.capacity);
		
		Car p2 = (Car) context.getBean("car9");
		Trunk t2 = (Trunk) p2.getOptions().get(2);
		System.out.println(t2.capacity);
    }

    /**
     * parameter를 갖는 생성자 호출
     * @param context
     */
	private static void test07(ApplicationContext context) {
		Engine engine = (Engine) context.getBean("engine1");
		System.out.println(engine.getVendor());
		System.out.println(engine.getValve());
    }

    /**
     * Properties's parameter 값 전달
     * @param context
     */
	private static void test08(ApplicationContext context) {
		Car p = (Car) context.getBean("car10");
		
		Properties props = p.getProperties();
		System.out.println(props.get("oil"));
		System.out.println(props.get("sunroof"));
    }

    /**
     * 명시적으로 호출할 생성자 지정
     * @param context
     */
	private static void test09(ApplicationContext context) {
		Engine engine = (Engine) context.getBean("engine2");
		System.out.println(engine.getVendor());
		System.out.println(engine.getValve());
    }

    /**
     * Factory method pattern's bean using
     * @param context
     */
	private static void test10(ApplicationContext context) {
		Object obj = context.getBean("car11");
		System.out.println(obj.getClass().getName());
    }

    /**
     * Factory method pattern's bean using
     * @param context
     */
    private static void test11(ApplicationContext context) {
		Object obj = context.getBean("car12");
		System.out.println(obj.getClass().getName());
	}
}
