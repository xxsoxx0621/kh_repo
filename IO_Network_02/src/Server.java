import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {
	public static void main(String[] args) throws Exception{

		/*서버에 접속하는 모든 사용자에게  Good Morning 메세지를 보내는 프로그램 작성 
		 * 클라이언트는 전송된 메세지를 받아서 화면에 출력하는 프로그램 작성 */

		/* 3단어 번역 서버 
		 * 
		 * 클라이언트가 사과 ->  apple 응답
		 * 			 포도 -> Grape 응답
		 * 			 딸기 -> Strawberry 응답
		 * 			 그외 -> None 응답 
		 * */
		ServerSocket sso = new ServerSocket(22000);
		Socket s = sso.accept();


		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		DataInputStream dis = new DataInputStream(s.getInputStream());

		dos.writeUTF(("Good Morning"));
		dos.flush();
		
		while(true) {
			String msg = dis.readUTF();

			if(msg.equals("사과")) {
				dos.writeUTF("Apple");
				dos.flush();
			}else if(msg.equals("포도")) {
				dos.writeUTF("Grape");
				dos.flush();
			}else if(msg.equals("딸기")) {
				dos.writeUTF("Strawberry");
				dos.flush();
			}else {
				dos.writeUTF("None");
				dos.flush();
			}
		}

	}


}
