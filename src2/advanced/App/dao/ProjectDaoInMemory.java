package advanced.App.dao;

import java.util.HashMap;

import advanced.App.dto.Project;

/**
 * Data Access Object의 줄임말이다.
 * DB를 사용해 데이터를 조회하거나 조작하는 기능을 담당하는 것들을 DAO라고 부른다.
 * domain logic (비즈니스 로직이나 DB와 관련없는 코드들)을 persistence mechanism과 분리하기 위해 사용한다.
 * persistence layer: Database에 data를 CRUD(Create, Read, Update, Drop)하는 계층
 * ! Database 처리(in Memory)
 */
public class ProjectDaoInMemory {
	int seqNo = 0;
	HashMap<Integer,Project> projectMap = 
			new HashMap<Integer,Project>();
	
	public void addProject(Project project) {
		seqNo++;
		project.id = seqNo;
		projectMap.put(seqNo, project);
	}
	
	public Project getProject(int id) {
		return projectMap.get(id);
	}
	
	public void updateProject(Project project) {
		projectMap.put(project.id, project);
	}
	
	public void deleteProject(int id) {
		projectMap.remove(id);
	}
	
	public Project[] getProjectList() {
		Project[] list = new Project[projectMap.size()];
		projectMap.values().toArray(list);
		return list;
	}
}
