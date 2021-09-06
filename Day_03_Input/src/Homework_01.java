import java.util.Scanner;

public class Homework_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//학생 성적을 입력한 뒤 합꼐와 평균을 구해보시오.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===================");
		System.out.printf("이 름 : ");
		String name = sc.nextLine();
		System.out.println("===================");
		System.out.printf("국 어  : ");
		int kor = sc.nextInt();
		System.out.printf("영 어  : ");
		int eng = sc.nextInt();
		System.out.printf("수 학  : ");
		int math = sc.nextInt();
		System.out.println("===================");
		int sum = kor + eng + math;
		double avg = (kor+ eng + math)/3;
		System.out.println("합 계  : " + sum);
		System.out.println("평 균 : " + avg);
		System.out.println("===================");
		
		
		
	}

}
