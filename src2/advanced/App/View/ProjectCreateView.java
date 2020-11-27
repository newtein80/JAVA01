/*
 목표: 예외 처리
 1) 예외 상황 리턴
	int divide(int a, int b) {
		if (b == 0) {
			throw new Throwable("예외 정보");
		}
		return a / b;
	}
 2) 예외 처리
 	try {
 		divide(10, 0);
 	} catch (Throwable e) {
 		// 예외처리 코드
 	}
 	
 3) 문법의 존재의의
 	- 예외 발생시 시스템을 멈추지 않고 계속 수행하도록 하기 위함
 	- 실행 코드와 예외처리 코드를 구분 -> 코드 가독성을 높임
*/
package advanced.App.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import advanced.App.CustomAnnotation.CustomAnnotation;
import advanced.App.dto.Project;

@Component
@CustomAnnotation(name="projectCreateView")
public class ProjectCreateView extends AbsBaseView {
	public void execute(Scanner scanner, HashMap<String,Object> valueMap) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Project project = new Project();
		
		System.out.print("프로젝트명: ");
		project.title = scanner.nextLine();
		
		System.out.print("설명: ");
		project.description = scanner.nextLine();
		
		System.out.print("시작일: ");
		// "2013-02-13" -> new Date()
		try {
			project.startDate = df.parse(scanner.nextLine());
		} catch (ParseException e) {
			project.startDate = null;
		} 
		
		System.out.print("종료일: ");
		try {
			project.endDate = df.parse(scanner.nextLine());
		} catch (ParseException e) {
			project.endDate = null;
		}
		
		System.out.print("관리자: ");
		project.projectManager = scanner.nextLine();
		
		System.out.print("저장하시겠습니까?(y/n) ");
		if ("y".equals(scanner.nextLine().toLowerCase())) {
			valueMap.put("project", project);
		} 
	}
}
