package exams;

import java.util.Scanner;

import classes.Student;


public class Exam_02 {

	// 에러 났을 경우 방지
	public static int inputValidInt(String msg) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.print(msg);
				int num = Integer.parseInt(sc.nextLine());
				return num;
			}catch(Exception e) {
				System.out.println("숫자를 입력해야 합니다.");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. Student 클래스 생성
		// - id , name, kor, eng, math 필드 생성
		// - getters /setter / default constructor / getSum(국영수 총점) / getAvg(평균)


		Scanner sc = new Scanner(System.in);
		int id = 1001; // 학생들에게 순차적으로 부여될 고유 ID 값
		int index = 0;
		int ifNull =0;
		Student[] stds = new Student[10];

		while(true) {

			System.out.println("=== 학생 관리 시스템 === ");
			System.out.println("1. 학생 정보 입력");
			System.out.println("2. 학생 목록 출력");
			System.out.println("3. 학생 정보 검색");
			System.out.println("4. 학생 정보 수정"); 
			System.out.println("5. 학생 성적 순위");

			System.out.println("0. 시스템 종료");
			int menu = inputValidInt(">> ");


			if(menu == 1) {

				System.out.print("이 름 : ");
				String name = sc.nextLine();

				int kor = inputValidInt("국 어 : ");
				int	eng = inputValidInt("영 어 : ");
				int math= inputValidInt("수 학 : ");

				//2. 입력받은 모든 값과 ID를 Student 인스턴스에 저장하는 코드를 작성하세요.

				Student std = new Student(id++, name, kor, eng, math);

				//3. 작성된 Student 인스턴스가 프로그램 전체에서 소멸하지 않고 언제든 사용될 수 있게끔,
				// Student 형 배열에 순차적으로 저장하는 코드를 작성하세요.

				stds[index++] = std;


			}else if(menu == 2 ) {


				// 4. 저장된 모든 학생의 정보를 화면에 출력하세요.

				if(stds[ifNull] == null ) {
					System.out.println("아직 출력할 정보가 없습니다.");
				}else {
					for(int i=0; i<index; i++ ) {
						System.out.println(stds[i].getId()+"\t"+stds[i].getName()+"\t"+ stds[i].getKor() + "\t" + stds[i].getEng() +
								"\t" + stds[i].getMath() + "\t"+stds[i].getSum()+"\t" +stds[i].getAvg());


					}
				}

			}else if(menu == 3) {
				// 이름으로 검색

				System.out.print("검색할 학생의 이름을 입력해주세요 : ");
				String searchName = sc.nextLine(); 

				int num = 0;
				// 검색 할 내용이 없을 경우를 방지 하는 또다른 방법
				boolean existFlag = false;

				//				if(stds[index] == null) {
				//					System.out.println("검색할 이름이 없습니다.");
				//
				//				}else {

				System.out.println("검색한 결과는?");
				for(int i=0; i < index; i++) {

					if (stds[i].getName().equals(searchName)) {
						num++;
						System.out.println("학생번호 : " + (stds[i].getId())+" 의 " + searchName);
						existFlag = true;

					}
				}
				if(!existFlag) {System.out.print("해당 이름이 존재하지 않습니다.");}

				System.out.println("총 " + num + " 명의" + searchName + " 이 검색되었습니다.");
				//				}
			}else if(menu == 4 ){
				// 선택과제 - 아이디와 새로운 정보를 입력받아서 대상 정보를 수정

				System.out.print("수정 할 아이디를 입력하세요 : ");
				int getId = Integer.parseInt(sc.nextLine());


				for(int i=0; i < index; i++) {
					if(stds[i].getId() == getId) {

						System.out.println("변경 전 : ");
						System.out.println(stds[i].getId()+"\t"+stds[i].getName()+"\t"+ stds[i].getKor() + "\t" + stds[i].getEng() +
								"\t" + stds[i].getMath() + "\t"+stds[i].getSum()+"\t" +stds[i].getAvg());

						System.out.println("====================");

						int updateKor = inputValidInt("수정할 국어 점수 : ");
						int updateEng = inputValidInt("수정할 영어 점수 : ");
						int updateMath = inputValidInt("수정할 수학 점수 : ");

						// 이름 값 불러오기
						String name = stds[i].getName();

						// 점수를 수정해서 배열에 재저장
						Student std = new Student(getId,name,updateKor,updateEng,updateMath);
						stds[i] = std;

						System.out.println("변경 후  : ");

						System.out.println(stds[i].getId()+"\t"+stds[i].getName()+"\t"+ stds[i].getKor() + "\t" + stds[i].getEng() +
								"\t" + stds[i].getMath() + "\t"+stds[i].getSum()+"\t" +stds[i].getAvg());

					}
				}

			}else if(menu == 5) {
				// 선택과제 - 성적순으로 정렬하여 출력하는 기능
				// 평균 값이 더 큰 순서대로 정렬하기 

				int	rank = 1;
				// 성적순위대로 보여 줄 수 있는 새로운 배열 필요
				Student std1 [] = new Student[10];

				// stds 배열의 모든 값들을 std1에 넣어주기
				// 이유는 2번 학생 목록 출력에서 값이 변경 되기 때문에
				for(int i=0; i < index; i++) {
					std1[i] = stds[i];
				}

				System.out.println("=======성적 순위======");

				// getAvg()가 높은 순서대로 내림차순 정렬

				for(int i =0; i < index-1; i++){
					for(int j=0; j <index-1; j++) {

						// 큰 값을 골라서 
						if(std1[j].getAvg() > std1[j+1].getAvg()) {


							// swap
							Student tmp = std1[j];
							std1[j] = std1[j+1];
							std1[j+1] = tmp;
						}
					}
				}
					// 역순으로 출력
					for(int i = index-1; i >=0 ; i--) {
						System.out.println(rank++ + " 위"+"\t"+std1[i].getName()+"\t"+ std1[i].getKor() + "\t" + std1[i].getEng() +
								"\t" + std1[i].getMath() + "\t"+std1[i].getSum()+"\t" +std1[i].getAvg());

					}
			}else if(menu == 0) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);

			}else {
				System.out.println("메뉴를 다시 확인하고 입력해주세요.");
			}
		}
	}

}
