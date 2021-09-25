package stduentmanagers;

import java.util.ArrayList;
import java.util.Scanner;

import student.Student;

public  class StudentManagers {
	// 데이터를 다루는 저장소는 ArrayList를 사용하세요.
	// 데이터 관련 처리 클래스 ( 입력/ 출력 / 검색 / 수정 / 삭제)

	private ArrayList members = new ArrayList();
	
	//입력
	public void addMembers(Student s) {	
		this.members.add(s);
	}
	
	public ArrayList getMembers() {
		return members;
	}
}
