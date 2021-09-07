import java.util.Scanner;

public class Quiz_10_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
		System.out.println("===구구단 출력 프로그램===");
		System.out.printf("1 ~ 9 단 중 선택 : ");
		int dan = Integer.parseInt(sc.nextLine());
		
		if(2 <= dan && dan <= 9 ) {
			int i = 0;
			while (i < 9) {
				i++;
				int result = dan * i;
				System.out.println(dan + "*" + i + "=" + result);
			}
		}else {
			System.out.println("구구단 범위를 다시 확인하세요.");
		
			}
		}
	}
}
