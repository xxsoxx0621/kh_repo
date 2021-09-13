import java.util.Scanner;

public class Challenge_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 만약에 내가 로또를 산다면 몇 번만에 당첨될까?
		// 1등에 당첨되면 끝남
		// 당첨번호를 고정으로 할지, 일주일 마다 변경될지

		Scanner sc = new Scanner(System.in);
		// 초기화 


		int [] winNum = new int[] {13, 15, 29, 32, 45, 21};

		// 받은 값을 버블 정렬 해줘야함
		for(int j=0; j < 5; j++) {
			for(int i=0; i < winNum.length-1; i++) {
				if(winNum[i] > winNum[i+1]) {
					int temp  = winNum[i];
					winNum[i] = winNum[i+1];
					winNum[i+1] = temp;
				}
			}
		}

		int num = 1;
		System.out.print("당첨번호 : ");
		for(int i=0; i < winNum.length; i++) {
			System.out.print(winNum[i] +" ");

		}

		System.out.println();

		int five = 0;
		int four = 0;
		int three = 0;
		int two = 0;
		int one = 0;
		
		while(true) {

			int score = 0;
			


			int []lotto = new int[45];


			// 로또 번호 넣기
			for(int i=0; i< lotto.length; i++) {
				lotto[i] = i+1;
			}

			// 로또 번호 무작위로 섞기
			for(int i=0; i < lotto.length *100; i++) {
				int x = (int)(Math.random()*45);
				int y = (int)(Math.random()*45);

				int temp = lotto[x];
				lotto[x] = lotto[y];
				lotto[y]= temp;
			}


			//로또 번호 무한 생성 / // Bubble Sort

			System.out.print( num + "번째 로또 번호 수 : ");
			num++;

			int [] oneByone = new int [6];
			for(int i=0; i < 6; i++) {
				oneByone [i] = lotto[i];

			}


			// 버블정렬
			for(int j =0; j < 5; j++) {
				for(int i=0; i < oneByone.length-1; i++) {
					if(oneByone[i]> oneByone[i+1]) {
						int temp = oneByone[i];
						oneByone[i] = oneByone[i+1];
						oneByone[i+1] = temp;
					}

				}
			}

			for(int i=0; i < 6; i++) {
				System.out.print(oneByone[i] + " ");

			}

			// 로또 당첨  5등이면 당첨번호 3개 숫자 일치
			// 로또 당첨  4등이면 당첨번호 4개 숫자 일치
			// 로또 당첨  3등이면 당첨번호 5개 숫자 일치
			// 로또 당첨  2등이면 당첨번호 5개 숫자 일치 + 보너스 숫자
			// 로또 당첨  1등이면 당첨번호 6개 숫자 일치 

			// 정렬은 했으니까 이제 한타임 돌때마다 비교를 해야함

			for(int i = 0; i < winNum.length; i++ ) { // 0 0, 0 1 , 0 2, 0 3, 0 4 0,5

				for(int j =0 ; j < winNum.length ; j++) {
					if(winNum[i] == oneByone[j]) {
						score += 1;
					}

				}

			}

			if( score == 3) {
				System.out.print(" 5등 당첨");
				five += 1;
				

			}
			if( score == 4) {
				System.out.print(" 4등 당첨");
				four += 1;

			}
			if( score == 5) {
				System.out.print(" 3등 당첨");
				three += 1;

			}
			
			if( score == 5 && winNum[5] == oneByone[5]) {
				System.out.println(" 2등 당첨");
				two += 1;
			}
			if( score == 6) {
				System.out.println(" 1등 당첨");
				one += 1;
				System.out.println("=================================");
				System.out.println("1등에 당첨되기 까지 "+ num +"회 도전" );
				System.out.println("1등 당첨 : "  + one +"회");
				System.out.println("2등 당첨 : "  + two +"회" );
				System.out.println("3등 당첨 : "  + three + "회");
				System.out.println("4등 당첨 : " + four + "회");
				System.out.println("5등 당첨 : " +five + "회");
				break;


			}else {
				System.out.println("");

			}


		}
	}
}
