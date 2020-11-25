package file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest03 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
		test01();
		test02();
		
		FileInputStream in = new FileInputStream("JavaWebDevelop.pdf");
		
		long startMillis = System.currentTimeMillis();
		
		byte[] b = new byte[10000];
		int size = 0;
		while( (size = in.read(b)) != -1) {
			System.out.print(".");
		}
		
		long endMillis = System.currentTimeMillis();
		System.out.println("\n걸린시간:" + (endMillis - startMillis));
		
		in.close();

	}
	
	private static void test01() throws FileNotFoundException, IOException {
		FileInputStream in = new FileInputStream("JavaWebDevelop.pdf");
		
		long startMillis = System.currentTimeMillis();
		
		int b = 0, count = 0;
		while( (b = in.read()) != -1) {
			count++;
			if (count > 10000) {
				System.out.print(".");
				count = 0;
			}
		}
		long endMillis = System.currentTimeMillis();
		System.out.println("\n걸린시간:" + (endMillis - startMillis));
		
		in.close();
	}
	
	private static void test02() throws FileNotFoundException, IOException {
		FileInputStream in0 = new FileInputStream("JavaWebDevelop.pdf");
		BufferedInputStream in = new BufferedInputStream(in0);
		
		long startMillis = System.currentTimeMillis();
		
		int b = 0, count = 0;
		while( (b = in.read()) != -1) {
			count++;
			if (count > 10000) {
				System.out.print(".");
				count = 0;
			}
		}
		long endMillis = System.currentTimeMillis();
		System.out.println("\n걸린시간:" + (endMillis - startMillis));
		
		in.close();
		in0.close();
	}
}
