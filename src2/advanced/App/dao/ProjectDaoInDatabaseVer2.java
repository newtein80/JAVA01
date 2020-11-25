package advanced.App.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import advanced.App.dto.Project;

public class ProjectDaoInDatabaseVer2 implements IProjectDao {
    Connection con = null;
	
	public ProjectDaoInDatabaseVer2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection( 
					"jdbc:mysql://localhost/studydb", "study", "study");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    @Override
	public void addProject(Project project) {
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(
				"insert into PROJECTS(TITLE,DECPT,START_DATE,END_DATE)" +
				" values(?,?,?,?)");  // ? -> in parameter 
			
			stmt.setString(1, project.title);
			stmt.setString(2, project.description);
			stmt.setDate(3, new java.sql.Date(
								project.startDate.getTime()));
			stmt.setDate(4, new java.sql.Date(
								project.endDate.getTime()));
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try{stmt.close();} catch(Exception e) {}
		}
	}
	
	public void addProject0(Project project) {
		Statement stmt = null;
		
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			stmt = con.createStatement(); 
			
			stmt.executeUpdate(
				"insert into PROJECTS(TITLE,DECPT,START_DATE,END_DATE)" +
				" values('" + project.title + "','" +
				project.description + "','" +
				df.format(project.startDate)	+ "','" +
				df.format(project.endDate) + "')");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try{stmt.close();} catch(Exception e) {}
		}
	}
    
    @Override
	public Project getProject(int id) {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();  
			rs = stmt.executeQuery(
					"select * from projects" +
					" where prj_no=" + id);
			
			
			if (rs.next()) { 
				Project project = null;
				project = new Project();
				project.id = rs.getInt("prj_no");
				project.title = rs.getString("title");
				project.description = rs.getString("decpt");
				project.startDate = rs.getDate("start_date");
				project.endDate = rs.getDate("end_date");
				project.projectManager = "";
				
				return project;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try{stmt.close();} catch(Exception e) {}
		}
		
		return null;
	}
    
    @Override
	public void updateProject(Project project) {
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(
				"update PROJECTS set" +
				" TITLE=?," +
				" DECPT=?," +
				" START_DATE=?," +
				" END_DATE=?" +
				" where prj_no=?");  // ? -> in parameter 
			
			stmt.setString(1, project.title);
			stmt.setString(2, project.description);
			stmt.setDate(3, new java.sql.Date(
								project.startDate.getTime()));
			stmt.setDate(4, new java.sql.Date(
								project.endDate.getTime()));
			stmt.setInt(5, project.id);
			if (stmt.executeUpdate() == 0) {
				throw new Exception("해당 프로젝트를 찾을 수 없습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try{stmt.close();} catch(Exception e) {}
		}		
	}
    
    @Override
	public void deleteProject(int id) {
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(
				"delete from projects" +
				" where prj_no=?"); 
			
			stmt.setInt(1, id);
			
			if (stmt.executeUpdate() <= 0) {
				throw new Exception("해당 프로젝트를 찾을 수 없습니다!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try{stmt.close();} catch(Exception e) {}
		}		
	}
    
    @Override
	public Collection<Project> getProjectList() {
		ArrayList<Project> list = new ArrayList<Project>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();  
			rs = stmt.executeQuery("select * from projects");
			
			Project project = null;
			while(rs.next()) { // 서버의 결과물에서 레코드 하나를 가져오라.
				project = new Project();
				project.id = rs.getInt("prj_no");
				project.title = rs.getString("title");
				project.description = rs.getString("decpt");
				project.startDate = rs.getDate("start_date");
				project.endDate = rs.getDate("end_date");
				project.projectManager = "";
				
				list.add(project);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try{stmt.close();} catch(Exception e) {}
		}
		
		return list;
	}
	
	@Override
	public void close() {
		try{con.close();} catch(Exception e) {}
	}
}
