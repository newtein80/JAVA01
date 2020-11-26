package advanced.App;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

import advanced.App.Controller.IBaseController;
import advanced.App.Controller.MemberController;
import advanced.App.Controller.ProjectController;
import advanced.App.infra.DBConnectionPool;

/**
 * Application Main Start Class
 */
public class ProjectApp {

	/**
	 * 사용자 명령에 맞는 Controller 호출 목록 ! RequestMapping, Controller
	 */
	HashMap<String, IBaseController> controllerMap = new HashMap<String, IBaseController>();
	HashMap<String, Object> applicationContext = new HashMap<String, Object>();

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

		prepareDBConnectionPool();

		prepareObject();
		injectDependency();

		destroy();
	}

	/**
	 * Prepare DataBase Connection Pool
	 */
	private void prepareDBConnectionPool() {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5433/postgres";
		String user = "postgres";
		String password = "#skdlf12";

		DBConnectionPool dbcp = new DBConnectionPool(driver, url, user, password);
		applicationContext.put("dbConnectionPool", dbcp);
	}

	/**
	 * Prepare Required object
	 * 필요한 객체를 properties 파일에서 읽어와 HashMap(applicationContext)에 담아둠
	 */
	private void prepareObject() throws FileNotFoundException, IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {

		Properties props = new Properties();
		props.load(new FileReader("controllermap.properties"));
		/*
			p=advanced.App.Controller.ProjectController
			m=advanced.App.Controller.MemberController
		*/
		Collection<Object> keyList = props.keySet();

		Class<?> clazz = null;

		for(Object keyName : keyList) {
			clazz = Class.forName(props.getProperty(((String) keyName).trim()));

			// applicationContext.put("p", ProjectController);
			// applicationContext.put("m", MemberController);
			// ! 중요: .properties 파일에 작성된 클래스 명을 생성자(constructor)를 통해 생성. 즉, 각 클래스는 생성자를 통해 이미 생성되어있음!!
			applicationContext.put(((String) keyName).trim(), clazz.getDeclaredConstructor().newInstance());
		}
	}

	private void injectDependency() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Collection<Object> objList = applicationContext.values(); // ProjectController, MemberController
		Class<?> clazz = null;
		Method[] methodList = null;
		Object dependency = null;

		// https://jdm.kr/blog/68
		// https://12bme.tistory.com/129
		for(Object obj: objList) {
			clazz = obj.getClass();
			// 해당 클래스의 메소드목록을 가져옴(public 메소드, 상속받은 public 메소드 가져옴)
			methodList = clazz.getMethods();

			for(Method method: methodList) {
				// ! 미리 정의되어 있다.
				// ! Rule 1. prepareObject 메소드를 통해 이미 생성된 각 클래스에 "set"으로 시작하는 메소드를 작성. service 클래스에 각 view에 대한 setter 메소드 존재함
				// ! Rule 2. 각 클래스의 "set"으로 시작하는 메소드의 parameter는 prepareObject 메소드를 통해 생성된 클래스들 중하나
				// ! * 미리 준비된 Object(현재는 view클래스도 포함)들을 생성자를 통해 생성하고 해당 클래스의 setter를 통해서 생성된 클래스를 할당(?)
				// ! controller -> service -> view, dao 각 setter 메소드 존재함
				// ! class를 생성하고 각 클래스의 set메소드를 통해 각 클래스에 필요한 object를 주입(?)해준다.
				if(method.getName().startsWith("set")) {
					// 해당 메소드의 parameter 목록을 가져와서 그중 첫번째 파라미터가 applicationConext의 해당 클래스의 instance 인지 판별
					dependency = searchDependency(method.getParameterTypes()[0]);
					if(dependency != null) {
						// 해당 메소드를 실행
						// 첫번째 parameter: 메소드를 호출할 객체, 두번째 parameter: 메소드에 전달할 parameter
						method.invoke(obj, dependency);
					}
				}
			}
		}
	}

	private Object searchDependency(Class<?> clazz) {
		Collection<Object> objList = applicationContext.values();
		for(Object obj: objList) {
			if(clazz.isInstance(obj)) {
				return obj;
			}
		}
		return null;
	}

	private void destroy() {
		for(Object obj : applicationContext.values()) {
			if (obj instanceof IBaseController)
				((IBaseController)obj).destroy();
			
			if (obj instanceof DBConnectionPool)
				((DBConnectionPool)obj).close();
		}
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
		IBaseController controller = (IBaseController) applicationContext.get(request);
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
