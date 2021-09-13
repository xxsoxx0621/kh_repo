import java.util.Scanner;

public class Exam_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		int a;
//		int b;
//		int c;
//		int d; // 변수를 대량으로 생성할 떄는 하나하나 다 선언 해주어야 한다.
		
		//int [] arr; // 1. 배열 사용을 위한 첫 번째 문법 : Heap 메모리에 생성되는 배열의 주소를 저장할 "참조변수" 생성
		// 배열을 위한 스택에 있는 참조변수 생성 
		// hip에 저장되어야 한다.
		
		//new int[4]; //2. 배열 사용을 위한 두 번째 문법 : 실질적인 배열을 Heap 에다가 생성하는 문법
		
		int[] arr = new int[]{10,20,30,40}; 
		// arr : 포인터로 불린다.
		
		//offset : 기준점으로 부터 얼마나 떨어졌는가?
		
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
//		
		Scanner sc = new Scanner(System.in);
		
		int a = 2;
		
		for(int i=0; i < 4; i++) {
			System.out.println(arr[i]);
		}
		
		//System.out.println(arr[sc.nextInt()]);
		System.out.println(arr[(int)(Math.random()*4)+1]);
		//System.out.println(arr[0] + " : " +  arr[1] + " : " + arr[2] + " : " + arr[3]);
		
		
		
		

	}

}
