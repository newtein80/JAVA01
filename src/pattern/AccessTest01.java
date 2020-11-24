package pattern;

class Patient01 {
	String 	name;
	int		age;
	int		weight;
	int		height;
}

public class AccessTest01 {

	public static void main(String[] args) {
		Patient01 p = new Patient01();
		p.name = "홍길동";
		p.age = 300;
		p.weight = 1000;
		p.height = -30;
	}
}
