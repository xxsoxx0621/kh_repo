import java.util.Scanner;

public class Quiz_02 {


	public static int validInt(String msg) {
		 
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			try {
				// 첫 번째 수 입력 , 두 번째 수 입력			
				System.out.print(msg);
				int num = Integer.parseInt(sc.nextLine());	
				return num;

			}catch(Exception e) {
				System.out.println("숫자를 입력해주세요.");

			}
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		//int num1 = 0;
		//int num2 = 0;
		int min = 0;
		double div = 0;

		while(true) {

			System.out.println("===계산기프로그램===");
			System.out.println("프로그램 종료는 q를 입력하세요");
			System.out.print("연산자 입력 (+,-,*,/) : ");
			String op = sc.nextLine();

			if(op.equals("q")) {
				System.out.println("==종료합니다.==");
				break;

				//switch문 및 종료하는 법
				//System.exit(0); -> 프로그램 바로 종료
				//return;
				//break wh; => wh : while(true)

			}

			//다른 방법
			//if(!op.equals("+") && !op.equals("-")&& !op.equals("*") && !op.equals("/") ){
			//System.out.println("연산자를 다시 확인해주세요.");
			//continue;}

			if((op.equals("+")) || (op.equals("-")) || (op.equals("*")) ||(op.equals("/")) ||(op.equals("q")) )

			{	

				int num1 = validInt("첫 번째 수 입력 : ");
				int num2 = validInt("두 번째 수 입력 : ");


				//
				//				while (true) {
				//					try {
				//						System.out.print("첫 번째 숫자 입력 : ");
				//						num1 = Integer.parseInt(sc.nextLine());
				//						break;
				//					}catch(Exception e) {
				//						System.out.println("숫자를 입력해주세요.");
				//
				//					}
				//				}



//				while(true) {
//					try {
//
//						System.out.print("두 번째 숫자 입력 : ");
//						num2 = Integer.parseInt(sc.nextLine());
//						break;
//					}catch(Exception e) {
//						System.out.println("숫자를 입력해주세요.");
//
//					}
//				}
				System.out.println("=====결과=====");
				System.out.println("숫자를 입력해주세요.");


				if(op.equals("+")) {
					int sum = num1 + num2;
					System.out.println(num1 + "+" + num2 +"=" + sum);

				}else if(op.equals("-")) {

					if(num1 > num2) {
						min = num1 - num2;
						System.out.println(num1 + "-" + num2 +"=" + min);

					}	else if(num1 < num2) {
						min = num2 - num1;
						System.out.println(num2 + "-" + num1 +"=" + min);

					}	else if (num1 == num2) {
						min = num1 - num2;
						System.out.println(num1 + "-" + num2 +"=" + min);
					}
				}else if(op.equals("*")){
					int mul = num1 * num2;
					System.out.println(num1 + "*" + num2 + "=" + mul);

				}else if(op.equals("/")) {

					if(num1 > num2) {
						div = num1 / num2;
						System.out.printf("%d / %d = %2.f\n",num1,num2,div);

					}	else if(num1 < num2) {
						div = num2 / num1;
						System.out.printf("%d / %d = %2.f\n",num2,num1, div);

					}	else if (num1 == num2) {
						div = num1 / num2;
						System.out.println(num1+ "/" + num2 + "=" + (int)div);
					}
				}

			}else {
				System.out.println("연산자를 다시 입력해 주세요.");


			}
		}
		//continue; //써도 안써도 상관없다.
	}
}


