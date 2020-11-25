package advanced.App.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;

import advanced.App.dto.Project;

public class ProjectDaoInFileVer2 implements IProjectDao {
    int seqNo = 0;
	HashMap<Integer,Project> projectMap = 
			new HashMap<Integer,Project>();
	
	public ProjectDaoInFileVer2() {
		FileReader in = null;
		BufferedReader in2 = null;
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			in = new FileReader("project.csv");
			in2 = new BufferedReader(in);
			
			String line = null;
			String[] columns = null;
			Project project = null;
			
			while((line = in2.readLine()) != null) {
				project = new Project();
				columns = line.split(",");
				project.id = Integer.parseInt( columns[0] );
				project.title = columns[1];
				project.description = columns[2];
				project.startDate = df.parse(columns[3]);
				project.endDate = df.parse(columns[4]);
				project.projectManager = columns[5];
				
				projectMap.put(project.id, project);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {in2.close();} catch(Exception e) {}
			try {in.close();} catch(Exception e) {}
		}
	}
    
    @Override
	public void addProject(Project project) {
		seqNo++;
		project.id = seqNo;
		projectMap.put(seqNo, project);
	}
    
    @Override
	public Project getProject(int id) {
		return projectMap.get(id);
	}
    
    @Override
	public void updateProject(Project project) {
		projectMap.put(project.id, project);
	}
    
    @Override
	public void deleteProject(int id) {
		projectMap.remove(id);
	}
    
    @Override
	public Collection<Project> getProjectList() {
		return projectMap.values();
	}
	
	@Override
	public void close() {
		FileWriter out = null;
		PrintWriter out2 = null;
		try {
			out = new FileWriter("project.csv");
			out2 = new PrintWriter(out);
			
			for(Project project : projectMap.values()) {
				out2.println( project.toString() );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {out2.close();} catch(Exception e) {}
			try {out.close();} catch(Exception e) {}
		}
		
	}
}
