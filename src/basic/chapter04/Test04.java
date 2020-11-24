package basic.chapter04;

import basic.calculators.Calculator01;

public class Test04 {

	public static void main(String[] args) {
		int result = 0;
		
		// (10 + 20) * 15 / 2 % 30 = ?
		result = Calculator01.plus(10, 20);
		result = Calculator01.multiple(result, 15);
		result = Calculator01.divide(result, 2);
		result = Calculator01.remainder(result, 30);
		
		System.out.println(result);
	}

}
