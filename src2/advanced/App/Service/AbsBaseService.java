package advanced.App.Service;

import java.util.Scanner;

/**
 * Controller가 Request를 받으면 적절한 Service에 전달하고, 전달 받은 Service는 비즈니스 로직을 처리한다.
 * DAO로 데이터베이스를 접근하고, DTO로 데이터를 전달받은 다음, 적절한 처리를 해 반환한다. 
 */
abstract public class AbsBaseService {
	protected Scanner scanner;
	protected String requestString;
	
	/*
	public BaseManagement() {
		super();
	} // default 생성자
	*/
	
	/**
	 * 초기 생성할 때 입력받은 request를 사용
	 * @param request 초기 생성할 때 입력받은 request를 사용
	 */
	public AbsBaseService(String request) {
		this.requestString = request;
	}

	/**
	 * 사용자로부터 정보를 입력받음
	 * @param scanner 정보를 입력받을 입력 도구
	 */
	public void service(Scanner scanner) {
		this.scanner = scanner;
		String m_request = null;
		// 사용자로부터 계속 입력을 받음
		while(true) {
			System.out.print(requestString + ": ");
			m_request = scanner.nextLine();
			requestMappingService(m_request);
			if ("menu".equals(m_request)) {
				break;
			}
		}
		
	}
	
	/**
	 * 사용자 입력값에 따른 각각의 로직 수행하기 위한 기능
	 * @param request 사용자 입력값
	 */
	abstract protected void requestMappingService(String request);
}
