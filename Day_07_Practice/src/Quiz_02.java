import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//가위 바위 보 중 하나를 선택 승패를 결정하는 게임
		// 승패를 결정하는 if문은 중첩 if문 금지. (||, && 연산자를 적절히 활용)

		Scanner sc = new Scanner(System.in);
		// 1 - 3
		
		
		while(true) {
		int com = (int)(Math.random()*(3-1+1)+1);
		
		System.out.println("=== 가위 바위 보 게임 ===");
		System.out.print("숫자를 선택하세요 (1. 가위 / 2. 바위 / 3. 보) : ") ;
		int me = Integer.parseInt(sc.nextLine());
		
		
		
		System.out.println("=======결과=======");
		
		if( me == 1) {
			System.out.println("당신은 가위를 냈습니다.");
		}else if( me == 2) {
			System.out.println("당신은 바위를 냈습니다.");
		}else if( me == 3) {
			System.out.println("당신은 보를 냈습니다.");
		}
		
		if(com == 1) {
			System.out.println("컴퓨터는 가위를 냈습니다.");
		}else if( com == 2) {
			System.out.println("컴퓨터는 바위를 냈습니다.");
		}else if( com == 3) {
			System.out.println("컴퓨터는 보를 냈습니다.");
		}
		
		
		System.out.println("====================");
		// 컴퓨터가 지는 경우
		if( (me == 1 && com ==3 ) || (me == 2 && com ==1 ) || (me == 3 && com ==2)) {
			System.out.println("플레이어가 이겼습니다!");
		}else if((com == 1 && me == 3) || (com == 2 && me ==1) || (com ==3 && me ==2)){
			System.out.println("컴퓨터가 이겼습니다!");
		}else {
			System.out.println("비겼습니다.");
		}
		
//		if(com == 1 && me  == 1  ) {
//			System.out.println("당신은 가위를 냈습니다.");
//			System.out.println("컴퓨터는가위를 냈습니다.");
//			System.out.println("==================");
//			System.out.println("컴퓨터와 플레이어는 비겼습니다.");
//		}else if(com == 2 && me == 2) {
//			System.out.println("당신은 바위를 냈습니다.");
//			System.out.println("컴퓨터는 바위를 냈습니다.");
//			System.out.println("==================");
//			System.out.println("컴퓨터와 플레이어는 비겼습니다.");
//		}else if(com == 3 && me == 3) {
//			System.out.println("당신은 보를 냈습니다.");
//			System.out.println("컴퓨터는 보를 냈습니다.");
//			System.out.println("==================");
//			System.out.println("컴퓨터와 플레이어는 비겼습니다.");
//		}else if ( com > 2 && me < 2 ) { // 컴 - 보 , 플 = 가
//			System.out.println("당신은 가위를 냈습니다.");
//			System.out.println("컴퓨터는 보자기를 냈습니다.");
//			System.out.println("==================");
//			System.out.println("플레이어가 이겼습니다.");
//		}else if (com == 2 && me == 1 ) { // 컴 - 바위, 플 - 가 
//			System.out.println("당신은 가위를 냈습니다.");
//			System.out.println("컴퓨터는 바위를 냈습니다.");
//			System.out.println("==================");
//			System.out.println("컴퓨터가 이겼습니다.");
//		}else if(com == 1 && me == 2 ){ // 컴 - 가위 , 플 - 바위 
//			System.out.println("당신은 바위를 냈습니다.");
//			System.out.println("컴퓨터는 가위를 냈습니다.");
//			System.out.println("==================");
//			System.out.println("플레이어가 이겼습니다.");
//		}else if(com == 1 && me == 2) { // 컴 - 보, 폴- 바위
//			System.out.println("당신은 바위를 냈습니다.");
//			System.out.println("컴퓨터는 보자기를 냈습니다.");
//			System.out.println("==================");
//			System.out.println("컴퓨터가 이겼습니다.");
//			
//		}else if (com == 2 && me == 3 ) { // 컴 - 바위, 폴 - 보
//			System.out.println("당신은 보자기를 냈습니다.");
//			System.out.println("컴퓨터는 바위를 냈습니다.");
//			System.out.println("==================");
//			System.out.println("플레이어가 이겼습니다.");
//			
//		}else if (com == 1 && me == 3 ) { // 컴 - 가, 폴 - 보
//			System.out.println("당신은 보자기를 냈습니다.");
//			System.out.println("컴퓨터는 가위 를 냈습니다.");
//			System.out.println("==================");
//			System.out.println("컴퓨터가 이겼습니다.");
//		}
//
//		

		}
	}

}
