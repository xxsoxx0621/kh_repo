package main;

import java.util.ArrayList;
import java.util.Scanner;


import stduentmanagers.StudentManagers;
import student.Student;


public class Main {

	public static int InputValid(String msg) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			try {
				System.out.print(msg);
				int num = Integer.parseInt(sc.nextLine());
				return num;
			}catch(Exception e ){
				System.out.println(" 숫자만 입력해주세요. ");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Student std = new Student();

		Scanner sc = new Scanner(System.in);
		int index = 0;

		// 1. 생성자를 생성
		Student std = new Student();
		int stdNum = std.getStdNum();

		StudentManagers sm = new StudentManagers();

		while(true) {
			System.out.println("=== 학생 관리 시스템 === ");
			System.out.println("1. 학생 정보 입력 ");
			System.out.println("2. 학생 목록 출력 ");
			System.out.println("3. 학생 정보 검색 ");
			System.out.println("4. 학생 정보 수정 ");
			System.out.println("5. 학생 정보 삭제 ");
			System.out.println("0. 시스템 종료");


			int menu = InputValid(">>");
			if(menu == 1) {

				//학생 정보 입력
				System.out.print("학생 이름을 입력하세요. >> ");
				String stdName = sc.nextLine();
				System.out.print("학생 국어 성적을 입력하세요. >> ");
				int korNum = Integer.parseInt(sc.nextLine());
				System.out.print("학생 영어 성적을 입력하세요. >> ");
				int engNum = Integer.parseInt(sc.nextLine());
				System.out.print("학생 수학 성적을 입력하세요. >> ");
				int mathNum = Integer.parseInt(sc.nextLine());

				// Student의 배열에 학생 정보를 저장
				sm.addMembers(new Student(stdNum++,stdName,korNum,engNum,mathNum));

			}else if(menu ==2 ) {
				//  학생 목록 출력

				ArrayList members = sm.getMembers();
				if(members.size() != 0) {
					System.out.println("=== 학생 정보 출력 ===");
					System.out.print("학번"+"\t"+"이름"+"\t"+"국어"+"\t"+"영어"+"\t"+"수학"+"\t"+"합계"+"\t"+"평균");
					for(int i =0; i < members.size()+1; i++) {
					
						System.out.println();
						System.out.print(
								((Student)members.get(i)).getStdNum()+"\t"+
										((Student)members.get(i)).getStdName()+"\t"+
										((Student)members.get(i)).getKorNum()+"\t"+
										((Student)members.get(i)).getEngNum()+"\t"+
										((Student)members.get(i)).getMathNum()+"\t"+
										((Student)members.get(i)).getSum()+"\t"+
										((Student)members.get(i)).getAvg()+"\t");
					}

					System.out.println();
				}else {

					System.out.println("출력할 정보가 없습니다.");
				}
			}else if (menu ==3 ) {
				// 학생 정보 검색
				int num =0;
				System.out.print("검색할 이름을 입력하세요 : ");
				String searchName = sc.nextLine(); 
				ArrayList members = sm.getMembers();
				if(members.size() == 0) { 	System.out.println("찾는 이름이 없습니다.");}
				for(int i=0; i < members.size(); i++) {
					if(searchName.equals(((Student) members.get(i)).getStdName())) {
						num++;
					}
				}
				System.out.println("총 " + num +"명 있습니다.");	
			}else if(menu ==4 ) {

				System.out.println("아이디를 입력하세요 : ");
				int inputId = Integer.parseInt(sc.nextLine());
				ArrayList members = sm.getMembers();

				for(int i =0; i < members.size(); i++) {
					if(inputId == (((Student)members.get(i)).getStdNum())) {
						System.out.print("수정 할 이름을 입력하세요 :");
						String newName = sc.nextLine();
						System.out.print("수정 할 국어 점수를 입력하세요 :");
						int newKor = Integer.parseInt(sc.nextLine());
						System.out.print("수정 할 영어 점수를 입력하세요 :");
						int newEng = Integer.parseInt(sc.nextLine());
						System.out.print("수정 할 수학 점수를 입력하세요 :");
						int newMath = Integer.parseInt(sc.nextLine());

						sm.addMembers(new Student(inputId, newName,newKor,newEng,newMath));
						members.remove(i);
						break;
					}
					//  ID 기반으로 전체 항목 재입력 

				}

			}else if(menu == 5) {
				//학생 정보 삭제
				System.out.println("아이디를 입력하세요 : ");
				int removeId = Integer.parseInt(sc.nextLine());
				ArrayList members = sm.getMembers();

				for(int i =0; i < members.size(); i++) {
					if(removeId == (((Student)members.get(i)).getStdNum())) {
						members.remove(i);
					}


				}
			}else if(menu == 0 ){
				System.exit(0);
			}
		}

	}	
}
