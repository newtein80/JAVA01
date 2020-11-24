package advanced.App.View;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import advanced.App.dto.Member;

public class MemberUpdateView {
	public void execute(Scanner scanner, HashMap<String, Object> valueMap) {
		if (valueMap.get("member") == null) {
			System.out.print("변경할 회원 이메일: ");
			String email = scanner.nextLine();
			valueMap.put("email", email);
		
		} else {
			Member other = new Member();
			Member member = (Member)valueMap.get("member");
			System.out.println("이름: " + member.name);
			System.out.print("변경>");
			other.name = scanner.nextLine();
			if (other.name.length() == 0)
				other.name = member.name;
			
			System.out.println("암호: " + member.password);
			System.out.print("변경>");
			other.password = scanner.nextLine();
			if (other.password.length() == 0)
				other.password = member.password;
			
			System.out.println("전화: " + member.tel);
			System.out.print("변경>");
			other.tel = scanner.nextLine();
			if (other.tel.length() == 0)
				other.tel = member.tel;
			
			other.regDate = new Date();
			other.email = member.email;
			
			valueMap.put("otherMember", other);
		}
	}

	public void displayResult(String message) {
		System.out.println(message);
	}
}
