package advanced.App.View;

import java.util.HashMap;
import java.util.Scanner;

public class MemberDeleteView extends AbsBaseView {
	public void execute(Scanner scanner, HashMap<String, Object> valueMap) {
		System.out.print("삭제할 회원 이메일: ");
		String email = scanner.nextLine();
		valueMap.put("email", email);
	}
}
