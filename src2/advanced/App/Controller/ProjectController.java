package advanced.App.Controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import advanced.App.CustomAnnotation.CustomAnnotation;
import advanced.App.Service.ProjectService;

@Component("p")
@CustomAnnotation(name="p", type="controller")
public class ProjectController implements IBaseController {
	Scanner scanner;

	@Autowired
	ProjectService projectService;
	
	/**
	 * 사용자 입력도구 연결과 신규(new) 비지니스로직을 생성
	 * @param scanner 사용자 입력도구 (Request)
	 */
	public ProjectController() {
		this.scanner = new Scanner(System.in);
	}

	public void setProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	/**
	 * Project 서비스 시작: 사용자 입력도구와 연결하여 해당 호출 명령에 해당하는 비지니스로직 서비스 시작
	 */
	@Override
	public void service() throws Exception {
		projectService.service(scanner);
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

	/**
	 * @return the projectService
	 */
	// public ProjectService getProjectService() {
	// 	return projectService;
	// }

	/**
	 * @param projectService the projectService to set
	 */
	// public void setProjectService(ProjectService projectService) {
	// 	this.projectService = projectService;
	// }

}
