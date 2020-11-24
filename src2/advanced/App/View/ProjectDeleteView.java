package advanced.App.View;

import java.util.HashMap;
import java.util.Scanner;

public class ProjectDeleteView extends AbsBaseView {
	public void execute(Scanner scanner, HashMap<String, Object> valueMap) {
		System.out.print("삭제할 프로젝트 번호: ");
		// Integer id = new Integer(scanner.nextLine());
		Integer id = Integer.valueOf(scanner.nextLine());
		valueMap.put("projectId", id);
	}
}
