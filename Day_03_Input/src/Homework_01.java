import java.util.Scanner;

public class Homework_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//학생 성적을 입력한 뒤 합와 평균을 구해보시오.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===================");
		System.out.printf("이 름 : ");
		String name = sc.nextLine();
		
		System.out.println("===================");
		System.out.printf("국 어  : ");
		//int kor = sc.nextInt();

		int kor = Integer.parseInt(sc.nextLine());
		
		System.out.printf("영 어  : ");
		int eng = sc.nextInt();
		
		System.out.printf("수 학  : ");
		int math = sc.nextInt();
		
		System.out.println("===================");
		
		int sum = kor + eng + math;
		double avg = sum/ 3;
		//double avg = sum / 3.0
		// double avg = (float) total/ 3
		
		System.out.println("합 계  : " + sum);
		
		// 서식문자를 이용한 출력
		//System.out.printf("합 계: %d\n 평균 : %2f\n", total, avg);
		
		System.out.println("평 균 : " + avg);
		System.out.println("===================");
		
		
		
	}

}
