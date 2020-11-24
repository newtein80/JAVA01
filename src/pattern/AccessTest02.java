package pattern;

class Patient {
	private String 	name;
	private int		age;
	private int		weight;
	private int		height;
	
	// setter method && getter method
	public void setName(String n) {	this.name = n; }
	public void setAge(int a) {
		if (a > 0 && a < 130)
			this.age = a;
		else 
			this.age = 20;
	}
	public void setWeight(int w) {
		if (w > 0 && w < 500) 
			this.weight = w;
		else
			this.weight = 60;
	}
	public void setHeight(int h) {
		if (h > 0 && h < 300)
			this.height = h;
		else
			this.height = 165;
	}
	public String getName() { return this.name; }
	public int getAge() { return this.age; }
	public int getWeight() { return this.weight; }
	public int getHeight() { return this.height; }
	
}

public class AccessTest02 {

	public static void main(String[] args) {
		Patient p = new Patient();
		p.setName( "홍길동" );
		p.setAge( 300 );
		p.setWeight( 1000 );
		p.setHeight( -30 );
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getWeight());
		System.out.println(p.getHeight());
	}
}
