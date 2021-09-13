
public class Quiz_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double math = Math.random();
		
		// 0 ~ 9 까지의 랜덤 수  
		System.out.println((int)(Math.random() * (9-0)));
		// 1 ~ 10 까지의 랜덤 수
		System.out.println((int)(Math.random() * (10-1))+1);
		// 20 ~ 35 까지의 랜덤 수 
		System.out.println((int)(Math.random() * (35-20))+20);
		// 0 또는 1 
		System.out.println((int)(Math.random() * (1-0)));
	

	}

}
