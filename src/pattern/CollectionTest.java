package pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Collection 다루기
 */
public class CollectionTest {
	public static void main(String[] args) {
		test01();
		test02();
		test03();
		test04();
		test05();
		test06();
	}

	/**
	 * 배열의 사용
	 * 배열 특징
	 * 1. 중간에 값 삽입/삭제가 번거롭다.
	 * 2. 값의 검색: 최대 n번 반복 
	 * 3. 값의 중복 허용
	 * 4. 실행 중 배열크기 변경 불가
	 */
	private static void test01() {
		String[] nameList = new String[4];
		nameList[0] = "홍길동";
		nameList[1] = "임꺽정";
		nameList[2] = "일지매";
		nameList[3] = "홍길동";
		//nameList[4] = "오류.."; // ArrayIndexOutOfBoundsException
		
		for(String name : nameList) {
			System.out.println(name);
		}
	}
	
	/**
	 * ArrayList 사용
	 * ArrayList 특징
	 * 1. 중간에 값 삽입/삭제가 쉽다.
	 * 2. 값의 중복 허용
	 * 3. 실행 중 목록의 크기를 변경할 수 있다.
	 * 4. 값의 검색: 최대 n번
	 */
	private static void test02() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("임꺽정");
		list.add("일지매");
		list.add("홍길동");
		list.add(2, "오호라");
		//list.remove(1);
		String name;
		for (int i = 0; i < list.size(); i++) {
			name = (String) list.get(i);
			if (name.equals("임꺽정"))
				list.remove(i);
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println( (String)list.get(i) );
		}
	}

	/*  */
	/**
	 * HashSet의 사용
	 * 1. Hash 값을 인덱스로 사용하여 저장하기 때문에 값이 중복되지 않는다.
	 * 2. 순서가 없다.
	 * 3. 조회 속도가 빠르다.
	 */
	private static void test03() {
		HashSet<Object> nameSet = new HashSet<Object>();
		nameSet.add("홍길동");
		nameSet.add("임꺽정");
		nameSet.add("일지매");
		nameSet.add("홍길동"); // 이미 같은 해쉬 값의 객체가 있기 때문에 저장되지 않음.
		nameSet.remove("임꺽정");
		
		String name = null;
		for(Object obj : nameSet.toArray()) {
			System.out.println(obj);
		}
	}

	/**
	 * HashMap의 사용
	 * HashMap 특징
	 * 1. key 객체의 hash 값을 인덱스로 사용하여 value 객체를 저장한다.
	 * 2. 저장하고 꺼내는 속도가 빠르다. 
	 * 3. ArrayList는 저장된 값이 많을 수록 조회 속도가 느려지지만 HashSet, HashMap은 저장된 값의 크기에 상관없이 일정한 조회 속도를 유지한다.
	 * 4. key 객체는 반드시 hashCode()와 equals() 메서드를 오버라이딩 해야한다.
	 * 5. key나 value는 반드시 객체여야 한다.
	 */
	private static void test04() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("aaa", "홍길동");
		map.put("bbb", "임꺽정");
		map.put("ccc", "일지매");
		map.put("ccc", "홍길동"); // 키는 중복되지 않는다. 값은 중복될 수 있다.
		
		System.out.println( map.get("aaa") );
		System.out.println( map.get("ccc") );
	}

	/**
	 * auto-boxing
	 */
	private static void test05() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("aaa", "홍길동");
		map.put(1, "임꺽정");	// auto-boxing: 1 -> new Integer(1)
		map.put("ccc", 300); // auto-boxing: 300 -> new Integer(300)
		map.put('가', "홍길동"); // auto-boxing: '가' -> new Character('가')
		
		System.out.println( map.get(1) );
		System.out.println( map.get('가') );
	}

	/**
	 * Generic의 사용
	 * Generic 문법의 특징
	 * - 파라미터의 타입을 임의의 클래스로 지정할 수 있다.
	 * - 컴파일할 때 값 검사가 쉽다. -> 잘못된 값이 파라미터로 넘어가는 것을 방지.
	 */
	private static void test06() {
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(100, "홍길동");
		map.put(200, "임꺽정");
		//map.put('가', "오호라"); // 오류 발생
	}
}
