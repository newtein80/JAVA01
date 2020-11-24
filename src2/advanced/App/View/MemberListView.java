package advanced.App.View;

import java.util.HashMap;
import java.util.Scanner;

import advanced.App.dto.Member;

public class MemberListView {
	public void execute(Scanner scanner, HashMap<String, Object> valueMap) {
		Member[] list = (Member[])valueMap.get("list");
		for(Member m : list) {
			System.out.println(m.name + "," + 
					m.email + "," +
					m.tel);
		}
	}
}
