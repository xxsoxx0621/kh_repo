import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import dao.GuestDAO;
import dao.MemberDAO;



public class Client {
	public static void main(String[] args)  throws Exception {

		try(	
				Socket client = new Socket("127.0.0.1",22000);
				DataInputStream dis = new DataInputStream(client.getInputStream());
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());

				){
			Scanner sc = new Scanner(System.in);
			MemberDAO mDao = MemberDAO.getInstance();


			while(true) {

				System.out.println("== 관리 시스템 ==");
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("3. 종료");
				System.out.print(">>");
				String menu = sc.nextLine();
				dos.writeUTF(menu);
				dos.flush();

				if(menu.equals("1")) {

					System.out.print("아이디를 입력하세요 >>");
					String id = sc.nextLine();

					System.out.print("비밀번호를 입력하세요 >>");
					String passWord = sc.nextLine();

					dos.writeUTF(id);
					dos.writeUTF(passWord);
					dos.flush();


					boolean result = dis.readBoolean();

					try {
						if(result) {
							System.out.println("로그인에 성공했습니다.");
							try {

								while(true) {
									System.out.println("== 방명록 시스템 ==");
									System.out.println("1. 새 글 등록");
									System.out.println("2. 방명록 보기");
									System.out.println("3. 방명록 삭제");
									System.out.println("4. 방명록 검색");
									System.out.println("5. 종료");
									System.out.print(">>");
									String subMenu = sc.nextLine(); 
									dos.writeUTF(subMenu);
									dos.flush();

									if(subMenu.equals("1")) {

										System.out.print("작성자 : ");
										String name = sc.nextLine();

										System.out.print("메세지 : ");
										String msg = sc.nextLine();

										// 두 값을 서버에 전달하여 데이터베이스에 저장하세요.

										dos.writeUTF(name);
										dos.writeUTF(msg);
										dos.flush();

										int chkResult = dis.readInt();

										if(chkResult > 0) {
											System.out.println("등록에 성공했습니다.");
										}else {
											System.out.println("등록에 실패했습니다.");
										}	

									}else if(subMenu.equals("2")) {


										System.out.println("== 방명록 목록 ==");

										int size = dis.readInt();

										for(int i =0; i < size; i++) {
											System.out.println(dis.readUTF());
										}

									}else if(subMenu.equals("3")) {

										//방명록 목록 한 번 더 출력
										System.out.println("== 방명록 목록 ==");

										int size = dis.readInt();

										for(int i =0; i < size; i++) {
											System.out.println(dis.readUTF());
										}

										// 방명록 삭제

										System.out.print("삭제 할 방명록의 ID를 입력하세요. >> ");
										int seq = Integer.parseInt(sc.nextLine());
										dos.writeInt(seq);
										dos.flush();

										int idResult = dis.readInt();

										if(idResult > 0) {
											System.out.println(seq + "번의 방명록 삭제 완료 했습니다.");
										}else if(idResult == 0 ) {
											System.out.println("삭제에 실패했습니다.");
										}else {
											System.out.println("오류가 발생했습니다.");
										}
									}else if(subMenu.equals("4")) {
										//방명록 검색
										
										System.out.print(" 검색할 번호를 입력하세요 >> " );
										
										int seq = Integer.parseInt(sc.nextLine());
										dos.writeInt(seq);
										dos.flush();
										
										int size = dis.readInt();

										for(int i =0; i < size; i++) {
											System.out.println(dis.readUTF());
										}
										
									}else if(subMenu.equals("5")) {
										System.out.println("로그아웃");
										break;

									}else {
										System.out.println("다시 입력하세요.");
									}

								}
							}catch(Exception e) {
								e.printStackTrace();
							}
						}
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("로그인에 실패했습니다.");
					}



				}else if(menu.equals("2") ) {

					System.out.println("사용할 ID를 입력하세요 : ");
					String id = sc.nextLine();


					System.out.println("사용할 PW를 입력하세요 : ");
					String pw = sc.nextLine();	

					System.out.println("사용할 이름을 입력하세요 : ");													
					String name = sc.nextLine();


					dos.writeUTF(id);
					dos.writeUTF(pw);											
					dos.writeUTF(name);
					dos.flush();

					// 중복검사 결과 확인
					boolean isIdExist = dis.readBoolean();
					if(isIdExist) {
						System.out.println("이미 사용중인 ID 입니다.");
						continue;
					}

					int result = dis.readInt();

					try { 
						if(result >0) {
							System.out.println("등록 완료 하였습니다.");
						}
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("등록 불가합니다.");
					}



				}else if(menu.equals("3")) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				}else{
					System.out.println("다시 입력하세요.");
				}


			}


		}


	}
}
