package advanced.App.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 * DataBase Connection Pool Class
 * https://brownbears.tistory.com/289
 * https://www.holaxprogramming.com/2013/01/10/devops-how-to-manage-dbcp/
 * https://linked2ev.github.io/spring/2019/08/14/Spring-3-%EC%BB%A4%EB%84%A5%EC%85%98-%ED%92%80%EC%9D%B4%EB%9E%80/
 * 웹 컨테이너(WAS)가 실행되면서 DB와 미리 connection(연결)을 해놓은 객체들을 pool에 저장해두었다가.
 * 클라이언트 요청이 오면 connection을 빌려주고, 처리가 끝나면 다시 connection을 반납받아 pool에 저장하는 방식을 말합니다.
 * 
 * 1. DB 서버 접속을 위해 JDBC 드라이버를 로드한다.
 * 2. DB 접속 정보와 DriverManager.getConnection() Method를 통해 DB Connection 객체를 얻는다.
 * 3. Connection 객체로 부터 쿼리를 수행하기 위한 PreparedStatement 객체를 받는다.
 * 4. executeQuery를 수행하여 그 결과로 ResultSet 객체를 받아서 데이터를 처리한다.
 * 5. 처리가 완료되면 처리에 사용된 리소스들을 close하여 반환한다.
 */
public class DBConnectionPool {
    ArrayList<Connection> list = new ArrayList<Connection>();
	String driver;
	String url;
	String userName;
	String password;
	
	public DBConnectionPool(
			String driver, String url, String userName, String password) {
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
	}
	
	public Connection getConnection() throws Exception {
		if (list.size() > 0) {
			System.out.println("기존 커넥션 리턴");
			return list.remove(0);
		} else {
			System.out.println("신규 커넥션 생성");
			Class.forName(driver);
			return DriverManager.getConnection(
							url, userName, password);
		}
	}
	
	public void returnConnection(Connection con) {
		list.add(con);
	}

	public void close() {
		for(Connection con : list) {
			try{con.close();} catch(Exception e) {}
		}
	}
}
