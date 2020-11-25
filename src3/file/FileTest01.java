package file;

import java.io.File;
import java.io.IOException;

public class FileTest01 {

	public static void main(String[] args) throws Exception {
		test01();
		test02();
		test03();
		File file = new File("./");
		test04(file, 0);
	}
	
	private static void test01() throws IOException {
		File file = new File("test.txt");
		if (file.createNewFile()) {
			System.out.println("test.txt 파일을 생성했습니다.");
		}
	}
	
	private static void test02() {
		File file = new File("test.txt");
		if (file.delete()) {
			System.out.println("삭제되었습니다.");
		}
	}
	
	private static void test03() throws IOException {
		File file = new File("./project.csv");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getCanonicalPath());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getPath());
	}
	
	private static void test04(File file, int depth) throws IOException {
		String[] list = file.list();
		File fileItem = null;
		for (String name : list) {
			fileItem = new File(file.getPath() + "/" + name);
			
			for (int i = 0; i < depth; i++) System.out.print(" ");
			System.out.println(fileItem.getName());
			
			if (fileItem.isDirectory()) {
				test04(fileItem, depth + 1);
			}
		}
	}
}
