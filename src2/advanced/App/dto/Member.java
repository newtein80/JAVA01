package advanced.App.dto;

import java.util.Date;

/**
 * Data Transfer Object의 줄임말이다. VO(Value Object)라고도 표현하는데, 계층간 데이터 교환을 위한 자바빈즈(Java Beans)다.
 * 이 객체는 데이터베이스 레코드의 데이터를 매핑하기 위한 데이터 객체를 말한다. DTO는 보통 로직을 가지고 있지 않고 data와 그 data에 접근을 위한 getter, setter만 가지고 있다.
 * 정리하면 DTO는 Database에서 Data를 얻어 Service나 Controller 등으로 보낼 때 사용하는 객체를 말한다. 위 코드에서도 DAO가 Database로부터 Data를 얻은 뒤 List에 담아서 보내주고 있다.
 * ! getter, setter 는 현재 만들지 않음.
 */
public class Member {
	public String 	name;
	public String 	email;
	public String 	password;
	public String 	tel;
	public Date		regDate;
}
