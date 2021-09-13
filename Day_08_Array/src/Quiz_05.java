
public class Quiz_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 로또 만들기
		// 중복되지 않는 6개의 1 ~ 45 사이의 숫자 + 보너스 번호 ( 7개의 숫자 )
		// 오늘의 로또 번호 추천 프로그램


		int []lotto = new int[45];


		System.out.println("오늘의 로또 당첨 번호는? :");

		// 1 부터 45까지 순서대로
		for(int i=0;i < lotto.length; i++ ) {
			lotto[i] =i+1;		
		}
		
		
		// 모든 로또 번호 카드 섞기 
		

		for(int i =0; i < lotto.length *100; i++) {
			int x = (int)(Math.random()*45);
			int y = (int)(Math.random()*45);

			int tmp = lotto[x];
			lotto[x] = lotto[y];
			lotto[y] = tmp;
		}
		
		// 추첨번호를 추첨번호 배열에 복사 
		int[] rcmd = new int[6];
		for(int i=0; i<6; i++) {
			rcmd[i] = lotto[i];
		}
		
		// 추첨 번호 배열 점검
		for(int i =0; i < rcmd.length-1; i++) {
			for(int j =0; j < rcmd.length-1; j++) {
				if(rcmd[j]> rcmd[j+1]) {
					int tmp = rcmd[j];
					rcmd[j] = rcmd[j+1];
					rcmd[j+1] =tmp;
				}
			}
		}
		for(int i=0; i< rcmd.length; i++) {
			System.out.print(rcmd[i] + " ");
		}
		System.out.println();
		System.out.println("보너스 번호  : " + lotto[6] );



		//로또 숫자 보여주기




	}

}
