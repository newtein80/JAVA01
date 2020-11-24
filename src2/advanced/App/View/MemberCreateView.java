package advanced.App.View;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import advanced.App.dto.Member;

public class MemberCreateView {
	public void execute(Scanner scanner, HashMap<String,Object> valueMap) {
		Member member = new Member();
		
		System.out.print("이름: ");
		member.name = scanner.nextLine();
		
		System.out.print("이메일: ");
		member.email = scanner.nextLine();
		
		System.out.print("암호: ");
		member.password = scanner.nextLine();
		
		System.out.print("전화: ");
		member.tel = scanner.nextLine();
		
		member.regDate = new Date();
		
		System.out.print("저장하시겠습니까?(y/n) ");
		if ("y".equals(scanner.nextLine().toLowerCase())) {
			valueMap.put("member", member);
		} 
	}
	
	public void displayResult(String message) {
		System.out.println(message);
	}
}
