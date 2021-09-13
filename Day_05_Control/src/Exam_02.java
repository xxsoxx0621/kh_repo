
public class Exam_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		// 1 부터 10까지 출력하는 for문
//		
//		for(int i=1;i<=10;i++) {
//			if(i == 5) {continue;}
//			System.out.println("i = " + i);
//			
//			
//			

		int i;
		
		for(i=1;i<=10;i++) {
			if(i == 2 || i ==5 ) { continue; }
			System.out.println("i = " + i);
			if(i == 8 ) { break; }
			
		}
	}

}
