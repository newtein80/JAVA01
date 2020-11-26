package advanced.App.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import advanced.App.CustomAnnotation.CustomAnnotation;
import advanced.App.dto.Project;
import advanced.App.infra.DBConnectionPool;

/**
 * Data Access Object의 줄임말이다.
 * DB를 사용해 데이터를 조회하거나 조작하는 기능을 담당하는 것들을 DAO라고 부른다.
 * domain logic (비즈니스 로직이나 DB와 관련없는 코드들)을 persistence mechanism과 분리하기 위해 사용한다.
 * persistence layer: Database에 data를 CRUD(Create, Read, Update, Drop)하는 계층
 */
@CustomAnnotation(name="projectDao")
public class ProjectDao implements IProjectDao {

	SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public ProjectDao() {}

	public void addProject(Project project) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.insert("advanced.App.dao.IProjectDao.addProject", project);
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			sqlSession.close();
		}
	}
	
	public Project getProject(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectOne(
					"advanced.App.dao.IProjectDao.getProject", id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}
	}
	
	public void updateProject(Project project) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.update("advanced.App.dao.IProjectDao.updateProject", project);
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			sqlSession.close();
		}
	}
	
	public void deleteProject(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.delete("advanced.App.dao.IProjectDao.deleteProject", id);
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			sqlSession.close();
		}
	}
	
	@Override
	public Collection<Project> getProjectList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectList(
					"advanced.App.dao.IProjectDao.getProjectList");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void close() {

	}
}
