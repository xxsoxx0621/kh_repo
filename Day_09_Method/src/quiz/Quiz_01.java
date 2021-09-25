package quiz;
import java.util.Scanner;

public class Quiz_01 {

	public static void test(String fruits){

		if(fruits.equals("사과")) {
			System.out.println("Apple"); 

		}else if(fruits.equals("포도")) {
			System.out.println("Grape"); 
		}else {
			System.out.println("None"); 
		}

	}

	public static int myRand(int num1, int num2) {

		return (int)(((Math.random()*num2+1)+num1)); 

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 난수를 구하고 싶은데, 10 - 20 사이의 난수
		System.out.print(myRand(10,20));
		System.out.println();

		// "사과"를 전달하면, "Apple"를 return 하고
		// "포도" 를 전달하면, "Grape"를 return 하는 메서드 test를 만드세요.
		// 사과나 포도가 아니면 아니면  "None"을 return!

		while(true) {
			System.out.print("입력하세요 : ");
			Scanner sc = new Scanner(System.in);
			String fruits = sc.nextLine();
			test(fruits);
		}




	}

}
