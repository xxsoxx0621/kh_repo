import java.util.Scanner;

public class Quiz_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 값을 세개 한번에 입력받아 넣어주기
		
		Scanner sc = new Scanner(System.in);
		
		//int x,y,z;
		
		int []arr = new int[3];
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(i+1 +"번 째 수  :" );
			arr[i] = sc.nextInt();
		}
		
//		System.out.println("1 번째 수 : "  );
//		x = sc.nextInt();
//		System.out.println("2 번째 수 : "  );
//		y = sc.nextInt();
//		System.out.println("3 번째 수  : "  );
//		z = sc.nextInt();
		
		for(int i = 0; i< arr.length;i++) {
			System.out.println(i+1 +"번 째 수  :"  + arr[i]);
		}
		
//		System.out.println("1 번째 수 : " + x);
//		System.out.println("2 번째 수 : " + y);
//		System.out.println("3 번째 수 : " + z);
//		
	}
}
