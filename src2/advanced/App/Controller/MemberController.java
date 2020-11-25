package advanced.App.Controller;

import java.util.Scanner;

import advanced.App.Service.MemberService;

public class MemberController implements IBaseController {
	Scanner scanner;
	MemberService mm;
	
	/**
	 * 사용자 입력도구 연결과 비지니스로직의 이름을 초기화
	 * @param scanner 사용자 입력도구 (Request)
	 */
	public MemberController() {
		this.scanner = new Scanner(System.in);
	}

	public void setMemeberController(MemberService memberService) {
		this.mm = memberService;
	}

	/**
	 * Member 서비스 시작: 사용자 입력도구와 연결하여 해당 호출 명령에 해당하는 비지니스로직 서비스 시작
	 */
	@Override
	public void service() throws Exception {
		mm.service(scanner);
	}

	/**
	 * Member 명령을 호출하기 위한 이름
	 */
	@Override
	public String getName() {
		return "m";
	}

	@Override
	public void destroy() {
		
	}
}
