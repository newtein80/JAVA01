package advanced.App.View;

import java.util.HashMap;
import java.util.Scanner;

import advanced.App.dto.Member;

public class MemberReadView {
	public void execute(Scanner scanner, HashMap<String, Object> valueMap) {
		if (valueMap.get("member") == null) { // 조회하고자 하는 member의 email을 넘겨받기 위한 view
			System.out.print("회원 이메일: ");
			String email = scanner.nextLine();
			valueMap.put("email", email);	  // 사용자로부터 입력받은 email을 valueMap에 넣음
			
		} else {							  // Management 안에서 Database처리(조회) 된 데이터를 view에서 알맞게 보여줌
			Member member = (Member)valueMap.get("member");
			System.out.println("이름: " + member.name);
			System.out.println("이메일: " + member.email);
			System.out.println("암호: " + member.password);
			System.out.println("전화: " + member.tel);
			System.out.println("등록일: " + member.regDate);
		}
	}
}
