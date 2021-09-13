
public class Exam_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 난수 - Random Number

		//double rand = Math.random();
		//Math.random 으로 발생하는 난수는 0 ~ 1 사이의 double 값으로 발생함.

		// System.out.println((int)(rand*10));

		// Math.random() 으로 발생하라 수 있는 가장 작은 난수
		// 0.000000000000001
		// 가장 큰 난수
		// 0.999999999999999

		// 1 ~ 10
		//		 for(int i=0;i<100;i++) {
		//			 System.out.println((int)(rand * 10) + 1);
		//		 }

//		for(int i=0; i < 100; i++) {
//			double rand = Math.random();
//			// 1 ~ 6 
//
//			System.out.println((int)(rand * 6) + 1);
//		}

		// 16 ~ 34 사이의 난수
		System.out.println((int)(Math.random() * 34 - 16 + 1) + 16);
		// 최대값 : Y, 최소값 : X
		// ((int)(Math.random()* (Y - X + 1)))+ X
		

	}

}
