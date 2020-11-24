package advanced.App.Service;

import java.util.HashMap;
import java.util.Scanner;

import advanced.App.View.MemberCreateView;
import advanced.App.View.MemberDeleteView;
import advanced.App.View.MemberListView;
import advanced.App.View.MemberReadView;
import advanced.App.View.MemberUpdateView;
import advanced.App.dao.MemberDao;
import advanced.App.dto.Member;

/**
 * Controller가 Request를 받으면 적절한 Service에 전달하고, 전달 받은 Service는 비즈니스 로직을 처리한다.
 * DAO로 데이터베이스를 접근하고, DTO로 데이터를 전달받은 다음, 적절한 처리를 해 반환한다. 
 */
public class MemberService extends AbsBaseService {

	/**
	 * Member DataBase Role
	 */
	MemberDao memberDao = new MemberDao();
	
	// 각각의 Action에 맞는 UI 선언
	MemberCreateView memberCreateView = new MemberCreateView();
	MemberReadView memberReadView = new MemberReadView();
	MemberUpdateView memberUpdateView = new MemberUpdateView();
	MemberDeleteView memberDeleteView = new MemberDeleteView();
	MemberListView memberListView = new MemberListView();

	/**
	 * 초기 생성할 때 입력받은 request를 사용
	 * @param request request명
	 */
	public MemberService(String request) {
		super(request); // 부모클래스의 생성자를 사용
	}
	
	/*
	public void service(Scanner scanner) {
		this.scanner = scanner;
		String command = null;
		
		while (true) {
			System.out.println("Member Manage: ");
			command = scanner.nextLine();
			processCommand(command);
			if("menu".equals(command)) {
				break;
			}
		}
	}
	*/

	/**
	 * 사용자 명령에 맞는 Service 처리
	 * @param request 사용자 명령
	 */
	protected void requestMappingService(String request) {
		if ("add".equals(request)) {
			actionCreate();
		} else if ("list".equals(request)) {
			actionList();
		} else if ("delete".equals(request)) {
			actionDelete();
		} else if ("detail".equals(request)) {
			actionRead();
		} else if ("update".equals(request)) {
			actionUpdate();
		}
	}

	private void actionCreate() {
		HashMap<String,Object> valueMap = 
				new HashMap<String,Object>();
		
		// 사용자 명령에 맞는 View 실행
		memberCreateView.execute(scanner, valueMap);
		// view에서 넘어온 member 정보를 Member변수에 할당
		Member member = (Member)valueMap.get("member");
		// view에서 넘어온 member 정보를 Database처리 할 수 있도록 알맞게 Member 객체로 넘겨줌
		memberDao.addMember(member);
		// 각 view에 맞는 메시지를 넘겨줌
		memberCreateView.displayResult("등록 성공입니다");
	}

	private void actionRead() {
		HashMap<String,Object> valueMap = 
				new HashMap<String,Object>();

		// 사용자 명령에 맞는 View 실행
		memberReadView.execute(scanner, valueMap);
		// view에서 넘어온 email(사용자가 입력한 값)을 변수에 담음
		String email = (String)valueMap.get("email");

		// Database에서 Data 처리
		Member member = memberDao.getMember(email);
		// Dbatbase에서 가져온 member 정보를 view에 넘겨주기 위해 valueMap에 담음
		valueMap.put("member", member);
		// member 정보가 담긴 valueMap을 view에 넘겨줌
		memberReadView.execute(scanner, valueMap);
	}

	private void actionDelete() {
		HashMap<String,Object> valueMap = 
				new HashMap<String,Object>();
		memberDeleteView.execute(scanner, valueMap);
		String email = (String)valueMap.get("email");
		memberDao.deleteMember(email);
		memberDeleteView.displayResult("삭제 성공입니다.");
	}

	private void actionList() {
		HashMap<String,Object> valueMap = 
				new HashMap<String,Object>();
		Member[] list = memberDao.getMemberList();
		valueMap.put("list", list);
		memberListView.execute(scanner, valueMap);
	}

	private void actionUpdate() {
		HashMap<String,Object> valueMap = 
				new HashMap<String,Object>();
		
		memberUpdateView.execute(scanner, valueMap);
		
		String email = (String)valueMap.get("email");
		Member member = memberDao.getMember(email);
		valueMap.put("member", member);
		memberUpdateView.execute(scanner, valueMap);
		
		Member otherMember = (Member)valueMap.get("otherMember");
		memberDao.updateMember(otherMember);
		
		memberUpdateView.displayResult("변경 성공입니다.");
	}
}
