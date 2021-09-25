package exams;

import classes.Contact;

public class Exam_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Contact c1 = new Contact(1001,"Susan","01012341234");
		Contact c2 = new Contact(1002,"Tom", "01091233219");
		Contact c3 = new Contact(1003,"Jack","01015242314");

		Contact[] contacts = new Contact[] {c1,c2,c3};
		for(int i=0; i< contacts.length; i++) {
			System.out.println(contacts[i].getId() + " : " + contacts[i].getName() +" : " + contacts[i].getTel());
		}

		// 이름이 Tom 인 사람의 연락처를 검색해서 출력
		for(int i=0; i< contacts.length; i++) {
			if(contacts[i].getName().equals("Tom")) {
				System.out.println(contacts[i].getTel());
			}
		}

		// 아이디가 1003번 사람을 찾아서 전화번호를 01011112222로 수정해보세요.
		
		System.out.println(contacts[2].getTel());
		
		for(int i=0; i < contacts.length; i++) {
			if(contacts[i].getId() == 1003) {
				contacts[i].setTel("01011112222");
			}
		}
		
		System.out.println(contacts[2].getTel());

	}
}
