import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JPanel;

public class Server {

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(22000);
		System.out.println("연결을 대기하는 중입니다.");
		Socket sock =  server.accept();

		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		DataInputStream dis = new DataInputStream(sock.getInputStream());


		while(true) {
			String msg = dis.readUTF();

			if(msg.equals("lotto") || msg.equals("Lotto")) {
				int [] lotto = new int [45];

				for(int i = 0; i< lotto.length; i++) {
					lotto[i] = i+1;
				}

				for(int i=0; i < lotto.length* 10; i++) {

					int x = (int)(Math.random()*45);
					int y = (int)(Math.random()*45);


					int tmp = lotto[x];
					lotto[x] = lotto[y];
					lotto[y] = tmp;	
				}

				String result ="";

				for(int i =0; i< 6; i++) {
					result+=lotto[i]+" ";
				}

				dos.writeUTF(result);
				dos.flush();

			}		
		                       	

		}

	}
}