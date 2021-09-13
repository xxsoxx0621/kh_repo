import java.util.Scanner;

public class Quiz_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String []name = new String [3];
		int []kor = new int [3];
		int []eng = new int [3];
	

		for(int i=0; i < 3 ; i++) {
			
			System.out.print(i+1 + "번째 학생 이름 : ");
			name[i] = sc.nextLine();
			
			System.out.print(name[i] + "학생 국어 점수 : ");
			kor[i] = Integer.parseInt(sc.nextLine());
			
			System.out.print(name[i] + "학생 영어 점수: ");
			eng[i] =  Integer.parseInt(sc.nextLine());
	
		}
		
		// \t : 띄어쓰기 8번 
		
		System.out.print("이름	");
		System.out.print("국어	");
		System.out.print("영어	");
		System.out.print("합계	");
		System.out.print("평균	");
		System.out.println("");

//		System.out.println("이름\t국어\t영어\t합계\t평균");
		
		for(int i=0; i<3; i++) {
			System.out.print(name[i]+"	");
			System.out.print(kor[i] +"	");
			System.out.print(eng[i]+ "	");
			System.out.print((kor[i]+eng[i])+ "	");
			System.out.print((kor[i]+eng[i])/2.0+ "	");			
			//System.out.printf("%2f",((kor[i]+eng[i])/2));
			System.out.println("");
			

		}
	}

}
