package basic.chapter06;

import basic.calculators.Calculator03;

public class Test06 {

	public static void main(String[] args) {
		// c1: 10 + 5 * 3 = ?
		// c2: 10 - 5 % 4 = ?
		
		Calculator03 c1 = new Calculator03();
		Calculator03 c2 = new Calculator03();
		
		Calculator03.plus(c1, 10);
		Calculator03.plus(c2, 10);
		
		Calculator03.plus(c1, 5);
		Calculator03.minus(c2, 5);
		
		Calculator03.multiple(c1, 3);
		Calculator03.remainder(c2, 4);
		
		System.out.println(c1.result);
		System.out.println(c2.result);

	}

}
