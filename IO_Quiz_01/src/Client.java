import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Client {
	public static void main(String[] args) throws Exception{

		// roopback address == localhost
		Socket client = new Socket("127.0.0.1",22000);
		//Socket client = new Socket("175.116.210.24",22000);

		DataOutputStream dos = new DataOutputStream( client.getOutputStream()); // 업그레이드 공사

		DataInputStream dis = new DataInputStream(client.getInputStream());

	
			String msg = JOptionPane.showInputDialog("메세지를 입력하세요");
			dos.writeUTF(msg);
			dos.flush();
			
			String dateString = dis.readUTF();
			System.out.println("현재 시간 :" + dateString);
			
			
		}
	}
