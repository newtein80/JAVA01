package advanced.App.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import advanced.App.dto.Project;
import advanced.App.infra.DBConnectionPool;

/**
 * Data Access Object의 줄임말이다.
 * DB를 사용해 데이터를 조회하거나 조작하는 기능을 담당하는 것들을 DAO라고 부른다.
 * domain logic (비즈니스 로직이나 DB와 관련없는 코드들)을 persistence mechanism과 분리하기 위해 사용한다.
 * persistence layer: Database에 data를 CRUD(Create, Read, Update, Drop)하는 계층
 * ! Database 처리(in Memory)
 */
public class ProjectDaoVerLast implements IProjectDao {

	DBConnectionPool dbConnectionPool;
	
	public void setDbConnectionPool(DBConnectionPool dbConnectionPool) {
		this.dbConnectionPool = dbConnectionPool;
	}

	public ProjectDaoVerLast() {}
	
	@Override
	public void addProject(Project project) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = dbConnectionPool.getConnection();
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
			dbConnectionPool.returnConnection(con);
		}
	}
	
	public void addProject0(Project project) {
		Connection con = null;
		Statement stmt = null;
		
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			con = dbConnectionPool.getConnection();
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
			dbConnectionPool.returnConnection(con);
		}
	}
	
	@Override
	public Project getProject(int id) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = dbConnectionPool.getConnection();
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
			dbConnectionPool.returnConnection(con);
		}
		
		return null;
	}
	
	@Override
	public void updateProject(Project project) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = dbConnectionPool.getConnection();
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
			dbConnectionPool.returnConnection(con);
		}		
	}
	
	@Override
	public void deleteProject(int id) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = dbConnectionPool.getConnection();
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
			dbConnectionPool.returnConnection(con);
		}		
	}
	
	@Override
	public Collection<Project> getProjectList() {
		ArrayList<Project> list = new ArrayList<Project>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = dbConnectionPool.getConnection();
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
			dbConnectionPool.returnConnection(con);
		}
		
		return list;
	}
	
	@Override
	public void close() {}
}
