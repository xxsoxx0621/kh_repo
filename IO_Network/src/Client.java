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
		Socket client = new Socket("211.196.82.82",22000);
		//Socket client = new Socket("175.116.210.24",22000);

		OutputStream os = client.getOutputStream();

		DataOutputStream dos = new DataOutputStream(os); // 업그레이드 공사

		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		while(true) {
			dos.writeUTF(JOptionPane.showInputDialog("메세지를 입력하세요"));
			dos.flush();

			String msg = dis.readUTF();
			System.out.println("서버로 부터의 메세지 : " + msg);

			if(msg.equals("time")) {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = sdf.parse(msg);
				System.out.println("현재 서버 시간은 : " + date.getTime());
				
			}
		
			dos.flush();
		}
	}
}
