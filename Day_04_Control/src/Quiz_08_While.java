import java.util.Scanner;

public class Quiz_08_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.print("출력 반복 횟수 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		int i = 0; 
		
		while(num > i){
			i++;
			System.out.println(i + " : "  +"Hello Java");
			
		}
	}

	
}
