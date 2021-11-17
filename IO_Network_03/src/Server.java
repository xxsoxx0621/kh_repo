import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception{
		/*
		 * Server 
		 * 
		 * 1. 여러 파일이 모여있는 파일의 폴더에서 파일 목록을 생성해서 클라이언트에게 전달한다.
		 * */
		// 파일 전송
		
		ServerSocket server = new ServerSocket(30000);
		
		System.out.println("연결을 대기 중입니다..");
		Socket sock = server.accept();
		
		System.out.println(sock.getInetAddress()+ "로 부터 연결");
		
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		
		
		
		// 1.HDD 파일을 RAM으로 꺼내오기.
		
		File target  = new File("Users/baesohyeon/Documents/2021hyeon/Documents/2021_09_웹응용과정/lips/jlayer-1.0.1.jar");
		System.out.println("파일 존재 :" + target.exists());
		System.out.println("파일 사이즈 : " + target.length());
		System.out.println("파일 경로 : " + target.getAbsolutePath());
		System.out.println("파일 이름 : " + target.getName());
		
		FileInputStream fis = new FileInputStream(target);
		DataInputStream dis = new DataInputStream(fis);
		
		byte[] fileContents = new byte[(int)target.length()];
		dis.readFully(fileContents);
		
		
		// 2. Server RAM에 있는 파일 내용을클라이언트 RAM 으로 전달 
		dos.writeInt(fileContents.length);
		dos.write(fileContents);
		dos.flush();
	}
}
