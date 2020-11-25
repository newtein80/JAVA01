package advanced.App.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;

import advanced.App.dto.Project;

public class ProjectDaoInFileVer1 implements IProjectDao {
    int maxNo = 0;
	HashMap<Integer,Project> projectMap = 
			new HashMap<Integer,Project>();
	
	public ProjectDaoInFileVer1() {
		FileInputStream in0 = null;
		ObjectInputStream in = null;
		try {
			in0 = new FileInputStream("project.dat");
			in = new ObjectInputStream(in0);
			
			Project project = null;
			
			while(true) {
				project = (Project)in.readObject();
				projectMap.put(project.id, project);
				maxNo = Math.max(maxNo, project.id);
			}
			
		} catch (EOFException e1) {
			System.out.println("자료 읽기 완료!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {in.close();} catch(Exception e) {}
			try {in0.close();} catch(Exception e) {}
		}
	}
    
    @Override
	public void addProject(Project project) {
		maxNo++;
		project.id = maxNo;
		projectMap.put(maxNo, project);
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
		FileOutputStream out0 = null;
		ObjectOutputStream out = null;
		try {
			out0 = new FileOutputStream("project.dat");
			out = new ObjectOutputStream(out0);
			
			for(Project project : projectMap.values()) {
				out.writeObject(project);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {out.close();} catch(Exception e) {}
			try {out0.close();} catch(Exception e) {}
		}
		
	}
}
