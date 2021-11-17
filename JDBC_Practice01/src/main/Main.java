package main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;

import dao.MessageDAO;
import dto.MessageDTO;

import utils.DateUtils;



public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MessageDAO mDao = MessageDAO.getInstance();
		
		// Messages Project - 방명록 시스템
		// DBMS 에 practice 계정 생성
		// connect / resource 권한 부여
		// practice 계정으로 로그인해서
		// Message 테이블 생성
		// seq(숫자 주키), writer 문자 (20 not null), message 문자 (300 not null)

		while (true) {
			System.out.println("=== 방명록 시스템 ===");
			System.out.println("1. 방명록 남기기");

			// == 방명록 시스템 ===
			// 1. 방명록 남기기
			// MessageDTO
			// seq - 1 ~ 무한대까지 1씩 증가하는 값.
			// writer : 글 작성자 이름
			// message : 남길 메세지

			// MessageDAO
			// C(insert) R(select) U(update) D(delete)
			// getConnection - extract



			System.out.println("2. 글 목록 보기 ");
			System.out.println("3. 방명록 삭제");
			System.out.println("4. 방명록 수정");
			System.out.println("5. 방명록 검색"); // ID 로 검색 / 작성자 검색 
			System.out.println("6. 시스템 종료");
			System.out.print(">>");


			int menu = Integer.parseInt(sc.nextLine());
			try {
				if(menu == 1) {

					System.out.print("이름을 입력하세요. >>");
					String writer = sc.nextLine();

					System.out.print("남길 말을 입력하세요. >>");
					String msg = sc.nextLine();
					
					System.out.println("방문 날짜 (yyyy/MM/dd) : ");
					// String visitDate = 	DateUtils.stringToSQLDate(sc.nextLine(), "yyyy/MM/dd");
					Date visit_date = DateUtils.stringToSQLDate(sc.nextLine(), "yyyy/MM/dd");
				
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//					Date date = sdf.parse(visitDate);
//					java.sql.Date sqlDate = new java.sql.Date(date.getTime());

					int result = mDao.insert(writer, msg, visit_date);

					if(result > 0 ) {
						System.out.println("입력 완료.");
					}


				}else if(menu == 2) {
					// 2. 글 목록 보기
					
					ArrayList<MessageDTO> list = mDao.selectAll();
					System.out.println("글번호" +"\t" +"글쓴이" +"\t" + "메세지");
					for(MessageDTO m : list) {

						System.out.println(m.getSeq_num() +"\t"+ m.getWriter()+ "\t" + m.getMessage() + "\t" +m.getReg_date());
					}



				}else if (menu == 3) {
					// 3. 방명록 삭제
					ArrayList<MessageDTO> list = mDao.selectAll();
					System.out.println("글번호" +"\t" +"글쓴이" +"\t" + "메세지");
					for(MessageDTO m : list) {

						System.out.println(m.getSeq_num() +"\t"+ m.getWriter()+ "\t" + m.getMessage()+ "\t" +m.getReg_date());
					}

					System.out.println("삭제 할 글 번호를 입력하세요.");
					System.out.print(">>");
					int delNum = Integer.parseInt(sc.nextLine());

					int result = mDao.delete(delNum);

					if(result > 0) {
						System.out.println("삭제에 성공했습니다.");
					}


				}else if (menu == 4) {
					// 4. 방명록 수정 
					ArrayList<MessageDTO> list = mDao.selectAll();
					System.out.println("글번호" +"\t" +"글쓴이" +"\t" + "메세지" + "\t" + " 방문일자 ");
					for(MessageDTO m : list) {

						System.out.println(m.getSeq_num() +"\t"+ m.getWriter()+ "\t" + m.getMessage()+ "\t" +m.getReg_date());
					}


					System.out.println("수정할 글번호를 입력하세요.");
					System.out.print(">>");
					int upNum = Integer.parseInt(sc.nextLine());

					System.out.println("수정할 글내용을 입력하세요.");
					System.out.print(">>");
					String message = sc.nextLine();
					
					System.out.println("수정할 날짜를 입력하세요. (yyyy/MM/dd) ");
					System.out.print(">>");
					String updateDate = sc.nextLine();
					
					SimpleDateFormat sdf = new SimpleDateFormat ("yyyy/MM/dd");
					Date date = (Date) sdf.parse(updateDate);
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					

					int result = mDao.update(upNum, message, sqlDate);

					if(result > 0 ) {
						System.out.println("수정 완료했습니다.");
					}
				}else if(menu == 5){
					// ID 로 검색 / 작성자 검색 
					while(true) {
						System.out.println("=== 게시글 검색하기 === ");
						System.out.println("1. seq 로 검색 하기 ");
						System.out.println("2. 작성자로 검색 하기 ");
						String pickMenu = sc.nextLine();

						if(pickMenu.equals("1")) {

							// ID = > req  글 번호 
							System.out.println("검색할 seq 를 입력하세요.");
							System.out.print(">>");
							int searchId = Integer.parseInt(sc.nextLine());

							MessageDTO dto =  mDao.searchId(searchId);

							if(dto != null) {
								System.out.println("글번호" +"\t" +"글쓴이" +"\t" + "메세지");

								System.out.println(dto.getSeq_num() +"\t"+ dto.getWriter()+ "\t" + dto.getMessage());
							}else {
								 System.out.println(" 해당 seq를 찾을 수 없습니다.");
							}

							break;

						}else if(pickMenu.equals("2")) {

							System.out.println("검색할 작성자를 입력하세요.");
							System.out.print(">>");
							String searchName = sc.nextLine();

							ArrayList<MessageDTO> list = mDao.searchName(searchName);
							System.out.println("글번호" +"\t" +"글쓴이" +"\t" + "메세지");
							for(MessageDTO m : list) {
								System.out.println(m.getSeq_num() +"\t"+ m.getWriter()+ "\t" + m.getMessage());
							}

							break;
						}

					}

				}else if(menu ==  6) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("오류입니다.");
			}

		}







	}
}
