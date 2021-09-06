import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//작성자를 입력해주세요 남길 메세지를 입력해주세요.
		
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("작성자를 입력해주세요.");
		String writer = sc.nextLine();
		
		System.out.println("남길 메세지를 입력해주세요.");
		String msg = sc.nextLine();
		
		System.out.println("===============================");
		System.out.println(writer + "님이 남긴 메세지");
		System.out.println(msg);
		
	}

}
