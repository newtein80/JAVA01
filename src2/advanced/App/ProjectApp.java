package advanced.App;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.reflections.Reflections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import advanced.App.Controller.IBaseController;
import advanced.App.Controller.MemberController;
import advanced.App.Controller.ProjectController;
import advanced.App.CustomAnnotation.CustomAnnotation;
import advanced.App.infra.DBConnectionPool;

/**
 * Application Main Start Class
 */
public class ProjectApp {

	/**
	 * 사용자 명령에 맞는 Controller 호출 목록 ! RequestMapping, Controller
	 */
	ApplicationContext applicationContext;

	/**
	 * 사용자 입력 도구 ! View, Request
	 */
	Scanner scanner;

	/**
	 * Application Ready ! Application 구동에 필요한 객체 생성 준비
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	public ProjectApp() throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException {
		// 사용자 입력 도구 생성
		// ! 화면 생성
		scanner = new Scanner(System.in);

		// ! 관련 jar 파일: mybatis-spring-x.x.x.jar, spring-aop-x.x.x.RELEASE.jar, spring-jdbc-x.x.x.RELEASE.jar, spring-tx-x.x.x.RELEASE.jar
		applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {

		// 시스템 시작 시 App 초기화 및 생성
		ProjectApp app = new ProjectApp();

		// App 서비스 시작
		app.service();
	}
	
	/**
	 * 서비스 시작
	 */
	public void service() {
		String request = null;
		
		while(true) {
			System.out.print(">");
			// 사용자로부터 Action 탐지
			// ! 사용자 request 탐지
			request = scanner.nextLine().toLowerCase();
			// 사용자 Action에 맞는 해당 호출 명령 객체의 서비스 시작
			// ! requestmapping
			processMappingController(request);
			
			if ("exit".equals(request)) {
				break;
			}
		}
	}

	/**
	 * 사용자 Action에 맞는 해당 호출 명령 객체의 서비스 시작
	 * ! requestmapping
	 */
	protected void processMappingController(String request) {
		// 사용자 Action에 맞는 비지니스로직 호출 명령 객체 꺼내옴
		// IBaseController controller = controllerMap.get(request); 
		IBaseController controller = (IBaseController) applicationContext.getBean(request);
		if (controller != null) {
			try {
				// 해당 호출 명령 객체의 서비스 시작
				controller.service();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
