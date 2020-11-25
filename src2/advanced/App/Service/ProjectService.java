package advanced.App.Service;

import java.util.HashMap;
import java.util.Scanner;

import advanced.App.View.ProjectCreateView;
import advanced.App.View.ProjectDeleteView;
import advanced.App.View.ProjectListView;
import advanced.App.View.ProjectReadView;
import advanced.App.View.ProjectUpdateView;
import advanced.App.dao.ProjectDao;
import advanced.App.dto.Project;

/**
 * Controller가 Request를 받으면 적절한 Service에 전달하고, 전달 받은 Service는 비즈니스 로직을 처리한다.
 * DAO로 데이터베이스를 접근하고, DTO로 데이터를 전달받은 다음, 적절한 처리를 해 반환한다. 
 */
public class ProjectService extends AbsBaseService{

	//Scanner scanner = null;
	ProjectDao projectDao;
	
	// 각각의 Action에 맞는 UI 선언
	ProjectCreateView projectCreateView;	
	ProjectReadView projectDetailView;
	ProjectUpdateView projectUpdateView;
	ProjectDeleteView projectDeleteView;
	ProjectListView	projectListView;
	
	/**
	 * 초기 생성할 때 입력받은 prompt를 사용
	 * @param prompt prompt명
	 */
	public ProjectService() {
		super("프로젝트 관리");
	}
	/*
	public void service(Scanner scanner) {
		this.scanner = scanner;
		String command = null;
		while(true) {
			System.out.print("프로젝트관리: ");
			command = scanner.nextLine();
			processCommand(command);
			if ("menu".equals(command)) {
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
		HashMap<String,Object> valueMap = new HashMap<String,Object>();
		
		if (scanner == null || valueMap == null || projectCreateView == null) {
			throw new NullPointerException();
		}
		// https://lovefor-you.tistory.com/113
		// 사용자 명령에 맞는 View 실행
		projectCreateView.execute(scanner, valueMap);
		// view에서 넘어온 member 정보를 Member변수에 할당
		Project project = (Project)valueMap.get("project");
		// view에서 넘어온 member 정보를 Database처리 할 수 있도록 알맞게 Member 객체로 넘겨줌
		projectDao.addProject(project);
		// 각 view에 맞는 메시지를 넘겨줌
		projectCreateView.displayResult("등록성공입니다");
	}

	private void actionRead() {
		HashMap<String,Object> valueMap = 
				new HashMap<String,Object>();

		// 사용자 명령에 맞는 View 실행
		projectDetailView.execute(scanner, valueMap);
		// view에서 넘어온 email(사용자가 입력한 값)을 변수에 담음
		Integer id = (Integer)valueMap.get("projectId");

		// Database에서 Data 처리
		Project project = projectDao.getProject(id);
		// Dbatbase에서 가져온 member 정보를 view에 넘겨주기 위해 valueMap에 담음
		valueMap.put("project", project);
		// member 정보가 담긴 valueMap을 view에 넘겨줌
		projectDetailView.execute(scanner, valueMap);
	}

	private void actionDelete() {
		HashMap<String,Object> valueMap = 
				new HashMap<String,Object>();
		projectDeleteView.execute(scanner, valueMap);
		Integer id = (Integer)valueMap.get("projectId");
		projectDao.deleteProject(id);
		projectDeleteView.displayResult("삭제 성공입니다.");
	}

	private void actionList() {
		HashMap<String,Object> valueMap = 
				new HashMap<String,Object>();
		// Project[] list = projectDao.getProjectList();
		valueMap.put("list", projectDao.getProjectList());
		projectListView.execute(scanner, valueMap);
	}

	private void actionUpdate() {
		HashMap<String,Object> valueMap = 
				new HashMap<String,Object>();

		// 사용자 명령에 맞는 View 실행
		projectUpdateView.execute(scanner, valueMap);
		
		Integer id = (Integer)valueMap.get("projectId");
		Project project = projectDao.getProject(id);
		valueMap.put("project", project);
		projectUpdateView.execute(scanner, valueMap);
		
		Project otherProject = (Project)valueMap.get("otherProject");
		projectDao.updateProject(otherProject);
		
		projectUpdateView.displayResult("변경 성공입니다.");
	}

	/**
	 * @return the projectDao
	 */
	public ProjectDao getProjectDao() {
		return projectDao;
	}

	/**
	 * @param projectDao the projectDao to set
	 */
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	/**
	 * @return the projectFormView
	 */
	public ProjectCreateView getProjectFormView() {
		return projectCreateView;
	}

	/**
	 * @param projectFormView the projectFormView to set
	 */
	public void setProjectFormView(ProjectCreateView projectFormView) {
		this.projectCreateView = projectFormView;
	}

	/**
	 * @return the projectDetailView
	 */
	public ProjectReadView getProjectDetailView() {
		return projectDetailView;
	}

	/**
	 * @param projectDetailView the projectDetailView to set
	 */
	public void setProjectDetailView(ProjectReadView projectDetailView) {
		this.projectDetailView = projectDetailView;
	}

	/**
	 * @return the projectUpdateView
	 */
	public ProjectUpdateView getProjectUpdateView() {
		return projectUpdateView;
	}

	/**
	 * @param projectUpdateView the projectUpdateView to set
	 */
	public void setProjectUpdateView(ProjectUpdateView projectUpdateView) {
		this.projectUpdateView = projectUpdateView;
	}

	/**
	 * @return the projectDeleteView
	 */
	public ProjectDeleteView getProjectDeleteView() {
		return projectDeleteView;
	}

	/**
	 * @param projectDeleteView the projectDeleteView to set
	 */
	public void setProjectDeleteView(ProjectDeleteView projectDeleteView) {
		this.projectDeleteView = projectDeleteView;
	}

	/**
	 * @return the projectListView
	 */
	public ProjectListView getProjectListView() {
		return projectListView;
	}

	/**
	 * @param projectListView the projectListView to set
	 */
	public void setProjectListView(ProjectListView projectListView) {
		this.projectListView = projectListView;
	}
}
