import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Server {
	public static void main(String[] args) throws Exception {

		/*
		 * Socket -> 네트워크 프로그램에서 통신을 수행하기 위한 논리적 단말기(실체가 없음) 
		 * */

		ServerSocket server = new ServerSocket(22000);
		Socket sock = server.accept();

		System.out.println(sock.getInetAddress() + "로 부터 연결되었습니다.");

		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
	
		while (true) {
			String msg = dis.readUTF();
			System.out.println("클라이언트가 보낸 메세지 : " + msg);
			
			dos.writeUTF(JOptionPane.showInputDialog("메세지를 입력하세요."));
			dos.flush();
			
			
		}
	}
}
