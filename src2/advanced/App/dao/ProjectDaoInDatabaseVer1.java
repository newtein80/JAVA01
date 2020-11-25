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

public class ProjectDaoInDatabaseVer1 implements IProjectDao {
    public ProjectDaoInDatabaseVer1() {
	}
    
	@Override
	public void addProject(Project project) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection( 
					"jdbc:mysql://localhost/studydb", "study", "study");
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
			try{con.close();} catch(Exception e) {}
		}
	}
	
	public void addProject0(Project project) {
		Connection con = null;
		Statement stmt = null;
		
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			/*
			DriverManager.registerDriver(
					(java.sql.Driver) Class.forName(
							"com.mysql.jdbc.Driver").newInstance());
			*/
			
			// com.mysql.jdbc.Connection 인스턴스 리턴
			con = DriverManager.getConnection( 
					"jdbc:mysql://localhost/studydb", "study", "study");
			
			// com.mysql.jdbc.Statement 인스턴스 리턴
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
			try{con.close();} catch(Exception e) {}
		}
	}
    
    @Override
	public Project getProject(int id) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection( 
					"jdbc:mysql://localhost/studydb", "study", "study");
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
			try{con.close();} catch(Exception e) {}
		}
		
		return null;
	}
    
    @Override
	public void updateProject(Project project) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection( 
					"jdbc:mysql://localhost/studydb", "study", "study");
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
			try{con.close();} catch(Exception e) {}
		}		
	}
    
    @Override
	public void deleteProject(int id) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection( 
					"jdbc:mysql://localhost/studydb", "study", "study");
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
			try{con.close();} catch(Exception e) {}
		}		
	}
    
    @Override
	public Collection<Project> getProjectList() {
		ArrayList<Project> list = new ArrayList<Project>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection( 
					"jdbc:mysql://localhost/studydb", "study", "study");
			stmt = con.createStatement();  
			rs = stmt.executeQuery("select * from projects");
			/* executeQuery()는 서버에서 질의결과 전체를 가져오지 않는다.
			 * 단지 질의 결과를 가져오는 일을 하는 객첼를 리턴한다.
			 * 그 객체가 ResultSet 구현체이다.
			 */
			
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
			try{con.close();} catch(Exception e) {}
		}
		
		return list;
	}
	
	@Override
	public void close() {}
}
