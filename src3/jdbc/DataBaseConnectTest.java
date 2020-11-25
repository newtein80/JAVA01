package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * https://corekms.tistory.com/entry/JDBC-테스트-소스
 * https://jdbc.postgresql.org/documentation/head/connect.html
 * https://jdbc.postgresql.org/download.html
 */
public class DataBaseConnectTest {
    public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		// connection 속성 설정
		String url = "jdbc:postgresql://localhost:5433/postgres";
		String user = "postgres";
		String password = "#skdlf12";
		String query = "select version()";

		System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");

		try {
			// postgresql 드라이버 클래스를 JDBC드라이버 메니저에 로드
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Download Site: https://jdbc.postgresql.org/download.html");
			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path! 프로젝트 > (마우스 우클릭) properties > ");
			System.out.println("프로젝트 > (마우스 우클릭) properties > Java Build Path > Libraries > Add External JARs > (Jar 파일선택) > [APPLY] 클릭");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		// Connection conn = null;

		try {
			// conncetion establish 하기
			conn = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (conn != null) {
			System.out.println("Connection established!");
		} else {
			System.out.println("Failed to make conn!");
		}

		// 실행할 쿼리 statement 입력
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				String ver = rs.getString("version");
				System.out.println("Your version : " + ver);
			}
		} catch (SQLException e) {
			System.out.println("query execution failed...");
			e.printStackTrace();
			return;
		}

		// statement / connection close 하기
		try {
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("failed to close statement or connection");
			e.printStackTrace();
			return;
		}

	}
}
