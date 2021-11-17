package main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import movieDAO.MovieDAO;
import movieDTO.MovieDTO;
import utils.DateUtils;

public class Main {

	public static int selectResult (int result){
		if(result > 0) {
			System.out.println("성공하였습니다 ! ");
		}else {
			System.out.println("실패 하였습니다.");
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		/*
		 * 
		 * # 오라클 계정은 만들어 놓았던 practice를 사용하세요.
		 * 
		 * # 테이블 생성 : movies
		 * # 컬럼
		 * id 숫자 주키 (1001번 부터 무한대까지 1씩 증가)
		 * title 문자(300) not null
		 * description 문자(1200) not null
		 * rel_date 날짜 기본값 sysdate not null
		 * 
		 * # 시퀀스 생성 : movies_seq
		 *  
		 * */

		/*
		 * 
		 * #DTO 생성 
		 * 
		 * */


		/* # User Interface  & DAO 구성
		 * NetFilx  관리 시스템 
		 * 1. 영화 등록 (title, description, rel_date 입력)
		 * 2. 영화 목록 (id,title,description, 날짜(dd/MM/yyyy))
		 * 3. 영화 삭제 ( id를 기반으로 삭제)
		 * 4. 영화 정보 수정 (id를 기반으로 모든 정보를 일괄 수정) 
		 * 5. 영화 검색 ( id로 검색 / 제목으로 검색) 
		 * 6. 종료
		 * */


		Scanner sc = new Scanner(System.in);
		MovieDAO mDao = new MovieDAO();


		while(true) {

			System.out.println("===NetFilx 관리 시스템===");
			System.out.println("1. 영화 등록 ");
			System.out.println("2. 영화 목록 ");
			System.out.println("3. 영화 삭제 ");
			System.out.println("4. 영화 정보 수정 ");
			System.out.println("5. 영화 검색 ");
			System.out.println("6. 종료 ");
			System.out.print(">>");

			String menu = sc.nextLine();
			try {
				if(menu.equals("1")) {


					System.out.print("등록 할 영화 이름을 입력하세요  >> ");
					String mTitle = sc.nextLine();
					System.out.print("등록 할 영화 설명을 입력하세요  >> ");
					String mDec = sc.nextLine();
					System.out.print("등록 할 영화 개봉일을 입력하세요 (dd/MM/yyyy) >> ");
					Date relDate = DateUtils.dateSQLUtil(sc.nextLine(), "dd/MM/yyyy");


					int result = mDao.insert(mTitle,mDec,relDate);

					selectResult(result);



				}else if(menu.equals("2")) {

					//영화 목록 보여주기
					List<MovieDTO> list = mDao.selectAll();
					System.out.println("영화번호" + "\t" +"영화제목"+"\t"+"영화설명"+"\t" +"영화개봉일자");
					for(MovieDTO m: list) {
						System.out.println(m.getId()+"\t"+m.getTitle()+"\t"+m.getDescription()+"\t"+m.getRel_date());
					}


				}else if(menu.equals("3")) {

					//영화 목록 보여주기
					List<MovieDTO> list = mDao.selectAll();
					System.out.println("영화번호" + "\t" +"영화제목"+"\t"+"영화설명"+"\t" +"영화개봉일자");
					for(MovieDTO m: list) {
						System.out.println(m.getId()+"\t"+m.getTitle()+"\t"+m.getDescription()+"\t"+m.getRel_date());
					}

					//영화 삭제 

					System.out.print("삭제 할 아이디를 입력하세요 >> ");
					String delId = sc.nextLine();

					int result = mDao.delete(delId);

					selectResult(result);

				}else if(menu.equals("4")) {


					//영화 목록 보여주기
					List<MovieDTO> list = mDao.selectAll();
					System.out.println("영화번호" + "\t" +"영화제목"+"\t"+"영화설명"+"\t" +"영화개봉일자");
					for(MovieDTO m: list) {
						System.out.println(m.getId()+"\t"+m.getTitle()+"\t"+m.getDescription()+"\t"+m.getRel_date());
					}


					//영화 정보 수정 
					System.out.print("수정 할 영화의 id를 입력하세요. >>");
					String Id = sc.nextLine();

					System.out.print("수정 할 영화의 제목을 입력하세요. >>");
					String Title = sc.nextLine();

					System.out.print("수정 할 영화의 내용을 입력하세요. >>");
					String Dec = sc.nextLine();

					System.out.print("수정 할 영화의 날짜를 입력하세요 (dd/MM/yyyy). >>");
					Date d = DateUtils.dateSQLUtil(sc.nextLine(), "dd/MM/yyyy");


					int result = mDao.update(Id,Title,Dec,d);

					selectResult(result);

				}else if(menu.equals("5")) {

					while (true) {

						System.out.println("1. 아이디로 검색");
						System.out.println("2. 영화명으로 검색");
						System.out.print(">>");
						String chMenu = sc.nextLine();

						if(chMenu.equals("1")) {

							System.out.print("검색할 아이디를 입력하세요 >> ");
							int id = Integer.parseInt(sc.nextLine());
							
							MovieDTO mDto = mDao.selectById(id);
							
							if(mDto != null) {
								System.out.println("영화번호" + "\t" +"영화제목"+"\t"+"영화설명"+"\t" +"영화개봉일자");

								System.out.println(mDto.getId()+"\t"+mDto.getTitle()+"\t"+mDto.getDescription()+"\t"+mDto.getRel_date());
							}else {
								System.out.println("해당 Id를 찾을 수 없습니다.");
							}
							break;
						}else if(chMenu.equals("2")) {

							System.out.print("검색할 영화 제목을 입력하세요 >> ");
							String title = sc.nextLine();


							List<MovieDTO> list = mDao.selectAll();
							
							System.out.println("영화번호" + "\t" +"영화제목"+"\t"+"영화설명"+"\t" +"영화개봉일자");
							for(MovieDTO m: list) {
								System.out.println(m.getId()+"\t"+m.getTitle()+"\t"+m.getDescription()+"\t"+m.getRel_date());
							}

							break;
						}else {
							System.out.println("다시 선택해 주세요.");
						}
					}

				}else if(menu.equals("6")) {
					System.out.println("종료합니다.");
					System.exit(0);

				}else {
					System.out.println("숫자를 다시 입력하세요.");
				}

			}catch(Exception e) {
				e.printStackTrace();
				System.exit(0);

			}

		}

	}
}