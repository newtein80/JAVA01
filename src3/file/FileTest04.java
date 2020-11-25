package file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest04 {
    public static void main(String[] args) throws Exception {
		test01();
		test02();
		test03();
		FileInputStream in0 = new FileInputStream("test04_2.dat");
		DataInputStream in = new DataInputStream(in0);
		
		int value = in.readInt();
		
		in.close();
		in0.close();
		
		System.out.println( Integer.toHexString(value) );

	}

	private static void test03() throws FileNotFoundException, IOException {
		FileOutputStream out0 = 
				new FileOutputStream("test04_2.dat");
		DataOutputStream out = 
				new DataOutputStream(out0);
		
		out.writeInt(0x1a2b3c4d);
		
		out.close();
		out0.close();
	}

	private static void test02() throws FileNotFoundException, IOException {
		FileInputStream in = new FileInputStream("test04.dat");

		int value = 0;
		value |= (in.read() << 24); 
		value |= (in.read() << 16);
		value |= (in.read() << 8);
		value |= (in.read());
		
		in.close();
		
		System.out.println( Integer.toHexString(value) );
	}

	private static void test01() throws FileNotFoundException, IOException {
		FileOutputStream out = 
				new FileOutputStream("test04.dat");
		
		int  value = 0x1a2b3c4d;
		out.write(value >> 24);
		out.write(value >> 16);
		out.write(value >> 8);
		out.write(value);
		
		out.close();
	}
}
