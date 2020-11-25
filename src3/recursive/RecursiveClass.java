package recursive;

public class RecursiveClass {
    public static void main(String[] args) {
        System.out.println(recuresiveMethod(100, 0));
    }

    private static int recuresiveMethod(int value, int depth) {
        printSpace(depth);
		System.out.println("----------------------------");
		
		printSpace(depth);
		System.out.println("value=" + value);
		
		int result = 0;
		if (value != 0)
			result = value + recuresiveMethod(value - 1, depth + 1);
		
		printSpace(depth);
		System.out.println("result=" + result);
		return result;
    }

    public static void printSpace(int count) {
		for(int i = 0; i < count; i++) 
			System.out.print(" ");
	}
}
