import java.io.File;

public class Temp {
	public static void main(String[] args) {
		
		File f = new File("/Users/baesohyeon/Documents/2021_09_웹응용과정/libs");
		
		File[] list = f.listFiles();
		
		for(File tmp : list) {
			System.out.println(tmp.getName() + " : " + tmp.length());
		}
//		System.out.println(f.isFile());
//		System.out.println(f.isDirectory());
	}

}
