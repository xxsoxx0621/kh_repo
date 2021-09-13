import java.util.Scanner;

public class Quiz_03_upNdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		// int bestScore = 100; 최고기록설정 또는 0으로 설정 가능

		int menu = 0;
		int nextScore = 0;
		int score = 0;


		while(true) {


			System.out.println("== Up & Down Game ==");
			try {
				while(true){


					System.out.println("1. Game Start");
					System.out.println("2. Game Score");
					System.out.println("3. End Game");
					System.out.print(">> ");

					menu = Integer.parseInt(sc.nextLine());
					if(0 < menu && menu < 4) {break;}
					System.out.println("정확히 입력해주세요");


				}
			}catch(Exception e){
				System.out.println("다시 입력해 주세요.");
			}
			// 1 부터 99 까지의 범위




			switch (menu) {

			//int playScore = 1;

			case 1:
				int num = (int)((Math.random()*(99 - 1+1)+1));
				System.out.println("Game start");

				while(true) {
					int com = (int)((Math.random()*(99 - 1+1)+1));
					System.out.print("Ipnut Numer : ");
					int inNum = Integer.parseInt(sc.nextLine());
					//System.out.println("정답 : " + num);
					score++;
					int up = (int)((Math.random()*(com-1 + 1)+1));
					// 범위 줄이기 
					// ex) com 30 나오고 그게 down이면 그 이하의 값으로 출력

					System.out.println("나 : " + inNum);
					if(num > inNum ) {
						System.out.println("<< UP >>");
					}else if(num < inNum) {
						System.out.println("<< DOWN >> ");
					}else  {
						System.out.println("사람의 승리! ");
						break;
					}
						System.out.println("컴퓨터 : " + com);
						 
						if(num == com) {
							System.out.println("로봇의 승리!");
							break;
						}else if(num > com){
						
						}else if(num < com) {
							int range = (int)((Math.random()*(com-1 + 1)+1));
						}
					}
					//					System.out.println("컴퓨터 : " + com);
					//					
					//					// 컴퓨터의 값이 클 때
					//					if (num > inNum  && num > com) {
					//						//playScore++;
					//						System.out.println("<< UP >>");
					//
					//					}else if(num < inNum && com < inNum) { // 컴퓨터의 값이 작을 때
					//						//playScore++;
					//						System.out.println("<< DOWN >> ");
					//						System.out.println(com);
					//
					//					}else if(com == num ){
					//						System.out.println("컴퓨터의 승리");
					//						break;
					//
					//					}else if (num == inNum){
					//						//playScore++;
					//						System.out.println("<<  나의 승리  >> ");
					//						// 정답을 맞추는 순간, 플레이어의 점수가 최고 기록과 비교해서 더 좋은 점수인지 확인해야함.
					//
					//						//						if(bestScore == 0) {
					//						//							bsetScore == score;
					//						//						}else {
					//						//							if(score < bestScore) {
					//						//								bestScore = playScore;
					//						//								System.out.println("<축> 최고기록을 갱신하셨습니다.");
					//						//								
					//						//							}else {
					//						//								System.out.println("정답입니다.");
					//						//							}
					//						//							
					//						//						}
					//						//						
					//
					//					}


//					System.out.println("스코어 : " + score);
//					System.out.println("비교 스코어: " + nextScore);

				

				break;

			case 2:

				// 1 - 99 번 맞추는건데 최악의 수는 100
				// System.out.println("현재까지의 최고 기록은 " + bestScore + "입니다.");
				// 0으로 할 떄
				//					if( bestScore == 0) {
				//						System.out.println("한 번도 플레이 한 적이 없습니다.");
				//					}else {
				//						System.out.println("현재까지의 최고 기록은 : " + bestScore + "입니다.");
				//					}

				if(nextScore < score && nextScore > 1 ) {
					System.out.println("현재까지의 최고 기록은  : "  + nextScore + "번 입니다.");



				}else if(nextScore  >  score){
					nextScore = score; 
					System.out.println("현재까지의 최고 기록은  : "  + score + "번 입니다.");


				}else {
					System.out.println("현재까지의 최고 기록은  : "  + score + "번 입니다.");
					nextScore = score; 
					score -= score; 
				}

				break;

			case 3:
				System.exit(0);

			}

		}

	}
}

