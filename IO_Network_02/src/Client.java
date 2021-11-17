import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String[] args) throws Exception{

		Socket client = new Socket("127.0.0.1",22000);

		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());

		while(true) {
			String msg = dis.readUTF();
			System.out.println("서버로 부터의 메세지 : " + msg);

			dos.writeUTF(JOptionPane.showInputDialog("번역할 단어를 입력하세요 : "));
			dos.flush();
		}



	}

}
