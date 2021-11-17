package main;

import java.util.ArrayList;
import java.util.Scanner;

import classes.Student;
import manager.Manager;

public class Main {
	public static void main(String[] args) {


		int seq = 1001;
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();

		while(true) {
			
		System.out.println("== 학생관리 시스템 ==");
		System.out.println("1. 학생 정보 입력");
		System.out.println("2. 학생 목록 입력");
		System.out.println("3. 종료");
		System.out.println(">>");

		String menu = sc.nextLine();
		
			if(menu.equals("1")) {
				System.out.println("학생 이름 : ");
				String name = sc.nextLine();

				System.out.println("국어 점수 : ");
				int kor = Integer.parseInt(sc.nextLine());
				System.out.println("영어 점수 : ");
				int eng = Integer.parseInt(sc.nextLine());

				Student std = new Student(seq++,name,kor,eng);
				manager.addStudent(std);

			}else if(menu.equals("2")) {

				ArrayList<Student> students = manager.getStudents();
				
				
				//foreach 문 
				// 단점 : 처음값 부터 꺼내야한다.
				for( Student std : students) {
//					String name = std.getName();
//					int kor = std.getKor();
//					int eng = std.getEng();
					System.out.println(std.getName() + "\t" + std.getKor() + "\t" + std.getEng());
					
				}
				
//				for(int i=0; i< students.size(); i++) {	
//					String name = (students.get(i)).getName(); // Student 꺼내진다.
//					int kor = (students.get(i)).getKor(); // 
//					int eng = (students.get(i)).getEng(); // 
//					System.out.println(name + "\t" + kor + "\t" + eng);
//				}
				
				
			}else if(menu.equals("3")) {
				System.out.println("시스템 종료");
			}else {
				System.out.println("메뉴를 다시 확인해주세");
			}
		}
	}
}
