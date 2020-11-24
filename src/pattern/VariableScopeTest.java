package pattern;

/**
 * 변수의 Scope 영역 다루기
 */
public class VariableScopeTest {

	public static void main(String[] args) {
		int i = 200;
		{
			int j = 300;
			//int i = 400; //error
		}
		System.out.println(i);
		// System.out.println(j); // ! Error : int j 의 scope는 brace(중괄호)안에서만 유효
	}

}