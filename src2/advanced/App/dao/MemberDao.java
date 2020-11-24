package advanced.App.dao;

import java.util.HashMap;

import advanced.App.dto.Member;

/**
 * Data Access Object의 줄임말이다.
 * DB를 사용해 데이터를 조회하거나 조작하는 기능을 담당하는 것들을 DAO라고 부른다.
 * domain logic (비즈니스 로직이나 DB와 관련없는 코드들)을 persistence mechanism과 분리하기 위해 사용한다.
 * persistence layer: Database에 data를 CRUD(Create, Read, Update, Drop)하는 계층
 * ! Database 처리(in Memory)
 */
public class MemberDao {
	HashMap<String,Member> memberMap = 
			new HashMap<String,Member>();
	
	public void addMember(Member member) {
		memberMap.put(member.email, member);
	}
	
	public Member getMember(String email) {
		return memberMap.get(email);
	}
	
	public void updateMember(Member member) {
		memberMap.put(member.email, member);
	}
	
	public void deleteMember(String email) {
		memberMap.remove(email);
	}
	
	public Member[] getMemberList() {
		Member[] list = new Member[memberMap.size()];
		memberMap.values().toArray(list);
		return list;
	}
}
