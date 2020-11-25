package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws Exception {
		test01();
		test02();
		test03();
		test04();
	}

	private static void test01() throws FileNotFoundException, IOException {
		File file = new File("test.txt");
		FileInputStream in = new FileInputStream(file);
		
		int b = 0;
		while( (b = in.read()) != -1 ) {
			System.out.println( Integer.toHexString(b) );
		}
		
		in.close();
	}
	
	private static void test02() throws FileNotFoundException, IOException {
		File file = new File("test.txt");
		FileReader in = new FileReader(file);
		
		int b = 0;
		while( (b = in.read()) != -1 ) {
			System.out.println( Integer.toHexString(b) );
		}
		
		in.close();
	}
	
	private static void test03() throws FileNotFoundException, IOException {
		File file = new File("test2.txt");
		FileOutputStream out = new FileOutputStream(file);
		byte[] list = new byte[]{0x41,0x42,0x43,0x44}; // ABCD
		
		for(byte b : list) {
			out.write(b);
		}
		
		out.close();
	}
	
	private static void test04() throws IOException {
		File file = new File("test3.txt");
		FileWriter out = new FileWriter(file);
		char[] list = new char[]{'가','각','간','갇'};
		
		for(char c : list) {
			out.write(c);
		}
		
		out.close();
	}
}
