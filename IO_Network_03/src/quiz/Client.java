package quiz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {

		try (
				Scanner sc = new Scanner(System.in);
				Socket client = new Socket("222.109.252.199",22000);
				DataInputStream dis = new DataInputStream(client.getInputStream());
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());)
		{

			//2. 서버가 보내오는 파일 명단을 받아서 화면에 출력한다.

			int size = dis.read();
			byte[] fileContents = new byte[size];		

			System.out.println("===== 파일의 목록 =====");
			for(int i=0; i < fileContents.length; i++) {
				System.out.print(dis.readUTF());
				System.out.println();
			}
			// 3. 서버가 보내온 명단 중에, 한개 파일을 선택하여 이름을 입력하고 입력한 이름을 서버에 전송한다.

			System.out.print("원하는 파일의 이름을 입력하세요 >> ");
			String fileName = sc.nextLine();

			dos.writeUTF(fileName);
			dos.flush();



			System.out.println(dis.readUTF());

			//7. 서버로부터 전송된 내용을 전달 받아 메모리에 적재한다.
			int fileSize = dis.readInt();
			byte[] file = new byte[fileSize];

			dis.readFully(file);

			//8. 3번에서 선택한 파일 이름으로 클라이언트 경로에 저장한다.
			String name = dis.readUTF();
			File f = new File("/Users/baesohyeon/Documents/dest/"+name);
			try(
					FileOutputStream fos = new FileOutputStream(f);
					DataOutputStream dos2 = new DataOutputStream(fos);
				)
			{
				dos2.write(file);
				dos2.flush();
				dos2.close();
			}

		}


	}

}


