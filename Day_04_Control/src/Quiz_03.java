import java.util.Scanner;

public class Quiz_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==================");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.println("==================");
		System.out.print("국 어 : ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("영 어 : ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("수 학 : ");
		int math = Integer.parseInt(sc.nextLine());
		System.out.println("==================");
		int sum = kor + eng + math;
		double avg = sum / 3.0;
		System.out.println("합 계 : " + sum);
		//System.out.println("평 균 : " + avg);
		System.out.printf("평 균 : %.2f\n" , avg); 
		if(avg >= 95) {
			System.out.println("성적 : A+ ");
		}else if (avg >= 90 ) {
			System.out.println("성적 : A ");
		}else if (avg >= 80 ) {
			System.out.println("성적 : B ");
		}else if (avg >= 70) {
			System.out.println("성적 : C ");
		}else if (avg >= 0 && avg < 70) {
			System.out.println("성적 : D ");
		}
		

	}

}
