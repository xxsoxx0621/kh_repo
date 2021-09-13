import java.util.Scanner;

public class Quiz_04_upNdownAnswer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);
	      int bestScore = 0;
	      
	      int playerWin = 0;
	      int comWin = 0;
	      
	      while(true) {
	         System.out.println("== UP&DOWN Game ==");
	         int menu = 0;
	         
	         while(true) {
	            try {
	               System.out.println("1. Game Start");
	               System.out.println("2. Game Score");
	               System.out.println("3. Exit");
	               System.out.print(">> ");
	               menu = Integer.parseInt(sc.nextLine());

	               if(0 < menu && menu < 4) {break;} // 제대로 된 값이 입력됬을 경우 while 탈출
	               System.out.println("메뉴를 다시 확인해주세요.");
	            }catch(Exception e) {
	               System.out.println("메뉴는 숫자로 입력해야 합니다.");
	            }
	         }

	         if(menu == 1) {
	            int playerScore = 0;
	            int target = (int)(Math.random() * 100 + 1); // 이게 맞추어야 하는 정답
	            System.out.println("정답 : " + target);
	            
	            System.out.println("<< Game Start >>");
	            
	            while(true) {
	            
	            	// ------------------------------------ player turn
	            	
	            	System.out.print("Input Number : ");
	               int input = Integer.parseInt(sc.nextLine()); // 답을 맞추기 위한 플레이어의 시도

	               if(input < target) {
	                  System.out.println("<< UP! >>");
	                  playerScore++;
	               }else if(input > target) {
	                  System.out.println("<< DOWN! >>");
	                  playerScore++;
	               }else {
	                  playerScore++;
	                  System.out.println("<< 사용자가 정답! >>");
	                  // 정답을 맞추는 순간, 플레이어의 점수가 최고 기록과 비교해서 더 좋은 점수인지 확인해야함.
//	                  if(bestScore == 0) {
//	                     bestScore = playerScore;
//	                  }else {
//	                     if(playerScore < bestScore) {
//	                        bestScore = playerScore;
//	                        System.out.println("<축> 최고기록을 갱신하셨습니다. ");
//	                     }
//	                  }
	                  break;
	               }
	            // ---------------------------------------- computer turn
	               
	               System.out.println("<< Computer Trun >> ");
	               int com = (int)(Math.random()*100 + 1);
	               System.out.println("Input Number : " + com);
	               
	               if(com < target) {
	            	   System.out.println("<< UP!! >> ");
	               }else if(com > target) {
	            	   System.out.println("<< DOWN! >> ");
	               }else {
	            	   System.out.println("<< 정 답! >>");
	            	   System.out.println("컴퓨터가 승리했습니다!");
	            	   comWin++;
	            	   break; //컴퓨터 턴에서 끝내기 위해서
	               }
	            }
	         }else if(menu == 2) {
//	            if(bestScore == 0) {
//	               System.out.println("한 번도 플레이한 적이 없습니다.");
//	            }else {
//	               System.out.println("현재까지의 최고 기록은 " + bestScore + " 번 입니다.");
//	            }
	        	 
	        	 System.out.println("Player : " + playerWin + "승"  + comWin + "패");
	        	 System.out.println("Computer : " + comWin + "승"  + playerWin + "패");
	        	 
	         }else if(menu == 3) {
	            System.out.println("게임을 종료합니다.");
	            System.exit(0);
	         }
	      }

	   }
	}