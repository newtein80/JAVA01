package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable{
	// 클래스 버전을 구분하기 위한 번호
	// - 명시적으로 지정하기 않으면, 컴파일러가 자동으로 추가함.
	// - 인스턴스 변수의 타입이나 개수가 다르면 다른 시리얼번호가 발급된다.
	// - 단, 인스턴스 변수의 타입과 개수가 동일하다면 같은 시리얼번호가 발급됨.
	// - 인스턴스 변수 선언의 순서가 달라도 같은 시리얼번호가 발급 된다.
	
	private static final long serialVersionUID = 1L;	
	
	String 	name;
	int		age;
	float	weight;
	float	height;
	String 	tel;
	String 	email;
	String 	address;

}

public class FileTest05 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		test01();
		test02();
	}
	
	private static void test02() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream in0 = new FileInputStream("test05.dat");
		ObjectInputStream in = new ObjectInputStream(in0);
		
		Student s1 = (Student) in.readObject();
		
		in.close();
		in0.close();
		
		System.out.println(s1.name);
		System.out.println(s1.age);
		System.out.println(s1.weight);
		System.out.println(s1.height);
		System.out.println(s1.tel);
	}
	
	private static void test01() throws FileNotFoundException, IOException {
		FileOutputStream out0 = new FileOutputStream("test05.dat");
		ObjectOutputStream out = new ObjectOutputStream(out0);
		
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.age = 20;
		s1.weight = 97.8f;
		s1.height = 177.8f;
		s1.tel = "111-1111";
		s1.email = "test@test.com";
		
		out.writeObject(s1);
		
		out.close();
		out0.close();
	}

}