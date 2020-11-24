package basic.chapter07;

import basic.calculators.Calculator04;

public class Test07 {

	public static void main(String[] args) {
		// c1: 10 + 5 * 3 = ?
		// c2: 10 - 5 % 4 = ?
		
		Calculator04 c1 = new Calculator04();
		Calculator04 c2 = new Calculator04();
		
		c1.plus(10);
		c2.plus(10);
		
		c1.plus(5);
		c2.minus(5);
		
		c1.multiple(3);
		c2.remainder(4);
		
		System.out.println(c1.result);
		System.out.println(c2.result);

	}

}
