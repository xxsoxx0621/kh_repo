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
		System.out.println("연결을 대기하는 중 입니다.");
		Socket sock = server.accept();

		System.out.println(sock.getInetAddress() + "로 부터 연결되었습니다.");

		DataInputStream dis = new DataInputStream(sock.getInputStream());

		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
	
	
			String msg = dis.readUTF();
			if(msg.equals("time")) {
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
				String dateString = sdf.format(System.currentTimeMillis());
				dos.writeUTF(dateString);
				dos.flush();
			}
			
		}
	}

