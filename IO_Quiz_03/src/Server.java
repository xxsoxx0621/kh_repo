import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import dao.GuestDAO;
import dao.MemberDAO;
import dto.GuestDTO;
import dto.MemberDTO;

public class Server {
	public static void main(String[] args) throws Exception {

		MemberDAO mDao = new MemberDAO().getInstance();
		GuestDAO gDao = new GuestDAO().getInstance();
		GuestDTO gDto = new GuestDTO();

		ServerSocket server = new ServerSocket(22000);
		System.out.println("서버 연결 대기 중입니다.");

		Socket socket = server.accept();

		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());


		//클라이언트가 로그인을 시도하면 
		// 로그인에 사용된 ID/PW를 화면에 출력

		//반면 클라이언트가 회원가입을 시도하면
		// 회원가입에 사용된 ID/PW/NAMe을 화면에 출력
		while(true) {

			String menu = dis.readUTF();

			if(menu.equals("1")) {

				String id = dis.readUTF();
				String passWord =  EncryptUtils.getSHA512(dis.readUTF());	

				MemberDTO dto = mDao.login(id, passWord);

				if(dto != null) {
					dos.writeBoolean(true); //성공

					while(true) {
						String guestMenu = dis.readUTF();
						if(guestMenu.equals("1")) {

							String name = dis.readUTF();
							String msg = dis.readUTF();
							int result  = gDao.insert(name,msg);
							dos.writeInt(result);

						}else if(guestMenu.equals("2")) {


							List<GuestDTO> list = gDao.selectAll();

							dos.writeInt(list.size());

							for(GuestDTO g : list) {

								dos.writeUTF(g.getSeq()+"\t" + g.getWriter() +"\t" + g.getMessage() +"\t"
										+ g.getWrite_date());
								dos.flush();

							}

						}else if(guestMenu.equals("3")) {
							
							//목록 출력
							
							List<GuestDTO> list = gDao.selectAll();

							dos.writeInt(list.size());

							for(GuestDTO g : list) {

								dos.writeUTF(g.getSeq()+"\t" + g.getWriter() +"\t" + g.getMessage() +"\t"
										+ g.getWrite_date());
								dos.flush();

							}
							
							// 삭제
							try {
								int seq = dis.readInt();
								int result = gDao.delete(seq);

								dos.writeInt(result);
								dos.flush();
							}catch(Exception e) {
								e.printStackTrace();
								dos.writeInt(-1);
								dos.flush();
							}
							


						}else if(guestMenu.equals("4")) {
							
							int seq = dis.readInt();
							List <GuestDTO> list =  gDao.searchSeq(seq);
							
							dos.writeInt(list.size());
						
							for(GuestDTO g : list) {

								dos.writeUTF(g.getSeq()+"\t" + g.getWriter() +"\t" + g.getMessage() +"\t"
										+ g.getWrite_date());
								dos.flush();

							}
						}
					}

				}else {
					dos.writeBoolean(false);
				}

				dos.flush();

				//				System.out.println("id : " +  id);
				//				System.out.println("pass : " +  passWord);

			}else if(menu.equals("2")) {

				String id = dis.readUTF();
				System.out.println("id : " +  id);

				String pw = EncryptUtils.getSHA512(dis.readUTF());
				System.out.println("pass : " +  pw);
				String name = dis.readUTF();
				System.out.println("name : " + name);


				//중복검사 
				boolean isIdAvailable = mDao.isIdExist(id);
				dos.writeBoolean(isIdAvailable);
				dos.flush();

				try {
					int result = mDao.insert(id,pw,name);
					dos.write(result);
					dos.flush();
				}catch(Exception e) {
					e.printStackTrace();
					dos.writeInt(-1);
				}
				dos.flush();


			}

		}



	}

}
