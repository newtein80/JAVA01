package basic.chapter12;

import java.util.HashMap;

/**
 * https://nesoy.github.io/articles/2018-06/Java-equals-hashcode
 * https://m.blog.naver.com/travelmaps/220836526277
 * https://m.blog.naver.com/travelmaps/220930144030
 * https://m.blog.naver.com/travelmaps/220931531769
 * Hash를 사용한 Collection(HashMap, HashTable, HashSet, LinkedHashSet등등)은 key를 결정할때 hashCode()를 사용
 */
public class Test12 {

	public static void main(String[] args) {
		test01();
		test02();
	}

	private static void test01() {
		class KeyObj {
			int no;
			String message;
		}
		
		// HashMap<Object,String> repository = new HashMap<Object,String>();
		HashMap<KeyObj,String> repository = new HashMap<KeyObj,String>();
		
		KeyObj k1 = new KeyObj();
		k1.no = 1234;
		k1.message = "abcd";
		
		repository.put(k1, "parkjongsoo");
		
		KeyObj k2 = new KeyObj();
		k2.no = 1234;
		k2.message = "abcd";
		
		String value = repository.get(k2);
		
		System.out.println(value);
		System.out.println(k1.hashCode());
		System.out.println(k2.hashCode());
	}

	private static void test02() {
		class KeyObj {
			int no;
			String message;
			
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result
						+ ((message == null) ? 0 : message.hashCode());
				result = prime * result + no;
				return result;
			}
			
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;

				if (obj == null)
					return false;

				if (getClass() != obj.getClass())
					return false;

				KeyObj other = (KeyObj) obj;

				if (message == null) {
					if (other.message != null)
						return false;
				} else if (!message.equals(other.message)) {
					return false;
				}

				if (no != other.no)
					return false;

				return true;
			}
			
			/*
			@Override
			public int hashCode() {
				String temp = message + no;
				return temp.hashCode();
			}
			
			@Override
			public boolean equals(Object obj) {
				return true;
			}
			*/
		}
		
		HashMap<KeyObj,String> repository = new HashMap<KeyObj,String>();
		
		KeyObj k1 = new KeyObj();
		k1.no = 1234;
		k1.message = "abcd";
		
		repository.put(k1, "parkjongsoo");
		
		KeyObj k2 = new KeyObj();
		k2.no = 1234;
		k2.message = "abcd";
		
		String value = repository.get(k2);
		
		System.out.println(value);
		System.out.println(k1.hashCode());
		System.out.println(k2.hashCode());
	}
}
