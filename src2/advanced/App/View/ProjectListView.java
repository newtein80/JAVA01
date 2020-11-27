package advanced.App.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import advanced.App.CustomAnnotation.CustomAnnotation;
import advanced.App.dto.Project;

@Component
@CustomAnnotation(name="projectListView")
public class ProjectListView extends AbsBaseView {
	public void execute(Scanner scanner, HashMap<String, Object> valueMap) {
		// Project[] list = (Project[])valueMap.get("list");
		ArrayList<Project> list = (ArrayList<Project>) valueMap.get("list");
		for(Project p : list) {
			System.out.println(p.id + "," + 
					p.title + "," +
					p.projectManager);
		}
	}
}
