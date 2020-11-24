package advanced.App.Controller;

/**
 * [비지니스로직 매칭 도구]: IBaseContoller를 구현한 모든 Controller는 공통으로 service()와 getName()를 상세 구현해야 한다.
 * 인터페이스
 * - caller와 callee 사이의 규칙
 * - 호출하는 메서드의 형식을 정의(추상메서드)
 * - 규칙이기 때문에 반드시 공개되어야 한다.(public)
 * @author nile
 */
public interface IBaseController {
	
	/**
	 * 비지니스로직 서비스 실행
	 * @throws Exception
	 */
	/*public abstract*/ void service() throws Exception;

	/**
	 * 비지니스 로직 서비스 이름 확인
	 * @return Command명
	 */
	String getName();
}
