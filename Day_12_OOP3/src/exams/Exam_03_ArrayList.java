package exams;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam_03_ArrayList {
	public static void main(String[] args) {
		
		
		// Object :  자바에 존 모든 존재하는 클래스의 최고 조상
		
		Object o = new Scanner(System.in);
		o = 123;
		o = 3.14;
		o = "Hello";
		o = new Exam_03_ArrayList();
		
//		Object[] objArr;
		
		// 입력 
		ArrayList arr = new ArrayList(); // 사이즈 명세 필요 없음, 갯수 제한이 없기 때문
		arr.add("Hello");
		arr.add("Java");
		arr.add("Wolrd");
		
		//출력
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println("---------------------");
		
		//삭제
		arr.remove(0); // 기본동작이 앞칸이비워지면 앞칸을 채운다.
		
		//출력
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println("---------------------");
		
		//삽입
		arr.add(0,"Good");
		
		
		//출력
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println("---------------------");
		
		
		//데이터 개수에 제한 없음 ( 메모리가 허가 하는 한...)
	}

}
