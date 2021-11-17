package quiz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {
	public static void main(String[] args) throws Exception {

		while(true) {

			try(
					ServerSocket server = new ServerSocket(30000);
					Socket sock = server.accept();
					DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
					DataInputStream dis = new DataInputStream(sock.getInputStream());
					){

				System.out.println("연결을 대기 중입니다.");
				System.out.println(sock.getInetAddress() + "로 연결되었습니다.");


				// 1. 전송할 수 있는 파일 목록을 생성해서 클라이언트에게 전달한다.

				File f = new File("/Users/baesohyeon/Documents/2021_09_웹응용과정/libs");
				File [] list = f.listFiles(); 
				dos.write(list.length);
				for(File tmp : list) {
					dos.writeUTF(tmp.getName());
				}
				dos.flush();

				// 4. 클라이언트가 입력해서 전송한 파일이름을 화면에 출력한다.

				String fileName = dis.readUTF();
				System.out.println(fileName);
				dos.writeUTF("파일을 전송합니다.");

				// 5. 클라이언트가 전송한 이름의 파일을 메모리에 로딩한다.

				String address = "/Users/baesohyeon/Documents/2021_09_웹응용과정/libs/"+fileName;
				File target = new File(address);
				try(
						FileInputStream fis = new FileInputStream(target);
						DataInputStream dis2 = new DataInputStream(fis);)
				{
					byte[] fileContents = new byte[(int)target.length()];
					dis2.readFully(fileContents);

					// 6. 로딩된 파일의 내용을 클라이언트에게 전송한다.


					dos.writeInt(fileContents.length);
					dos.write(fileContents);
					dos.writeUTF(target.getName());
					dos.flush();

				}



			}


		}
	}
}
