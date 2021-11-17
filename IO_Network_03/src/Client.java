import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;


public class Client {
	
	public static void main(String[] args) throws Exception {
		
		/* Client 
		 * 
		 * 1. 서버가 보내오는 파일 명단을 받아서 화면에 출력한다. 
		 * 
		 * */
		Socket client = new Socket("127.0.0.1",30000);
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		
		int size = dis.readInt();
		byte[]  fileContents = new byte[size];
		
		dis.readFully(fileContents);
		
//		System.out.println(fileContents[0]);
//		System.out.println(fileContents[1]);
//		System.out.println(fileContents[2]);
		
		File f = new File("/Usersbaesohyeon/Documents/dest");
		FileOutputStream fos = new FileOutputStream(f);
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.write(fileContents);
		dos.flush();
		dos.close();
	}

}
