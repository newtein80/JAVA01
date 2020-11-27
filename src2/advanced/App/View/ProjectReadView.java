package advanced.App.View;

import java.util.HashMap;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import advanced.App.CustomAnnotation.CustomAnnotation;
import advanced.App.dto.Project;

@Component
@CustomAnnotation(name="projectReadView")
public class ProjectReadView extends AbsBaseView {
	public void execute(Scanner scanner, HashMap<String, Object> valueMap) {
		if (valueMap.get("project") == null) {
			System.out.print("프로젝트 번호: ");
			// Integer id = new Integer(scanner.nextLine());
			Integer id = Integer.valueOf(scanner.nextLine());
			valueMap.put("projectId", id);
			
		} else {
			Project project = (Project)valueMap.get("project");
			System.out.println("프로젝트명: " + project.title);
			System.out.println("설명: " + project.description);
			System.out.println("시작일: " + project.startDate);
			System.out.println("종료일: " + project.endDate);
			System.out.println("관리자: " + project.projectManager);
		}
	}
}
