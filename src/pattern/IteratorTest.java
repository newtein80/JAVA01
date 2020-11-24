package pattern;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

interface Iterator {
	boolean hasNext();
	Object next();
}

/**
 * Iterator 다루기
 */
class AscendentIterator implements Iterator {
	String[] dataList;
	int cursor = -1;
	
	public AscendentIterator(String[] dataList) {
		this.dataList = dataList;
	}
	
	@Override
	public boolean hasNext() {
		if ((cursor + 1) < dataList.length)
			return true;
		else
			return false;
	}

	@Override
	public Object next() {
		cursor++;
		return dataList[cursor];
	}
	
}

class DescendentIterator implements Iterator {
	String[] dataList;
	int cursor = -1;
	
	public DescendentIterator(String[] dataList) {
		this.dataList = dataList;
		this.cursor = dataList.length;
	}
	
	@Override
	public boolean hasNext() {
		if ((cursor - 1) >= 0)
			return true;
		else
			return false;
	}

	@Override
	public Object next() {
		cursor--;
		return dataList[cursor];
	}
	
}

public class IteratorTest {
	
	static String[] nameList = {
		"One", "Two", "Three", "Four", "Five", "Six"
	};

	public static void main(String[] args) throws Exception {
		test01();
		test02();
		test03();
		test04();
		test05();

		ArrayList<String> nameList2 = new ArrayList<String>();
		nameList2.add("One");
		nameList2.add("Two");
		nameList2.add("Three");
		nameList2.add("Four");
		nameList2.add("Five");
		nameList2.add("Six");
		
		Stack<String> nameList3 = new Stack<String>();
		nameList3.push("One");
		nameList3.push("Two");
		nameList3.push("Three");
		nameList3.push("Four");
		nameList3.push("Five");
		nameList3.push("Six");
		
		LinkedBlockingQueue<String> nameList4 = new LinkedBlockingQueue<String>();
		nameList4.put("One");
		nameList4.put("Two");
		nameList4.put("Three");
		nameList4.put("Four");
		nameList4.put("Five");
		nameList4.put("Six");
		
		System.out.println("스택:" + nameList3.pop());
		System.out.println("스택:" + nameList3.pop());
		System.out.println("스택:" + nameList3.pop());
		System.out.println("스택:" + nameList3.pop());
		System.out.println("스택:" + nameList3.pop());
		System.out.println("스택:" + nameList3.pop());
		
		System.out.println("큐:" + nameList4.poll());
		System.out.println("큐:" + nameList4.poll());
		System.out.println("큐:" + nameList4.poll());
		System.out.println("큐:" + nameList4.poll());
		System.out.println("큐:" + nameList4.poll());
		System.out.println("큐:" + nameList4.poll());
		
		java.util.Iterator<String> iterator4 = nameList4.iterator();
		java.util.Iterator<String> iterator3 = nameList3.iterator();
		
		while(iterator3.hasNext()) {
			System.out.println(iterator3.next());
		}

		while(iterator4.hasNext()) {
			System.out.println(iterator4.next());
		}
	}
	
	private static void test05() {
		//Iterator iterator = new AscendentIterator(nameList);
		Iterator iterator = new DescendentIterator(nameList);
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	/* 뒤에서부터 꺼내기 */
	private static void test04() {
		for(int i = nameList.length - 1; i >= 0; i--) {
			System.out.println(nameList[i]);
		}
	}
	
	/* 홀수번째 꺼내기 */
	private static void test03() {
		for(int i = 1; i < nameList.length; i += 2) {
			System.out.println(nameList[i]);
		}
	}
	
	/* 짝수번째 꺼내기 */
	private static void test02() {
		for(int i = 0; i < nameList.length; i += 2) {
			System.out.println(nameList[i]);
		}
	}

	/* 앞에서부터 순차적으로 꺼내기 */
	private static void test01() {
		for(int i = 0; i < nameList.length; i++) {
			System.out.println(nameList[i]);
		}
	}

}
