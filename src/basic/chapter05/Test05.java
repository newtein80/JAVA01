package basic.chapter05;

import basic.calculators.Calculator02;

public class Test05 {

	public static void main(String[] args) {
		// (10 + 20) * 15 / 2 % 30 = ?
		Calculator02.plus(10);
		Calculator02.plus(20);
		Calculator02.multiple(15);
		Calculator02.divide(2);
		Calculator02.remainder(30);
		
		System.out.println(Calculator02.result);
	}

}
