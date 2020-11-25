package advanced.App.Controller;

import java.util.Scanner;

import advanced.App.Service.ProjectService;

public class ProjectController implements IBaseController {
	Scanner scanner;
	ProjectService pm;
	
	/**
	 * 사용자 입력도구 연결과 신규(new) 비지니스로직을 생성
	 * @param scanner 사용자 입력도구 (Request)
	 */
	public ProjectController() {
		this.scanner = new Scanner(System.in);
	}

	public void setProjectController(ProjectService projectService) {
		this.pm = projectService;
	}

	/**
	 * Project 서비스 시작: 사용자 입력도구와 연결하여 해당 호출 명령에 해당하는 비지니스로직 서비스 시작
	 */
	@Override
	public void service() throws Exception {
		pm.service(scanner);
	}

	/**
	 * Project 명령을 호출하기 위한 이름
	 */
	@Override
	public String getName() {
		return "p";
	}

	@Override
	public void destroy() {

	}

}
