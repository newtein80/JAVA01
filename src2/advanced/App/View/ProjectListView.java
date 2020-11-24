package advanced.App.View;

import java.util.HashMap;
import java.util.Scanner;

import advanced.App.dto.Project;

public class ProjectListView extends AbsBaseView {
	public void execute(Scanner scanner, HashMap<String, Object> valueMap) {
		Project[] list = (Project[])valueMap.get("list");
		for(Project p : list) {
			System.out.println(p.id + "," + 
					p.title + "," +
					p.projectManager);
		}
	}
}
