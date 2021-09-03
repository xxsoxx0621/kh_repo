
public class Exam_05 {
	
	public static void main(String[] args) {
		byte b = 10;
		short s = 20;
		int i = 30;
		long l = 40L;
		float f = 3.14f;
		double d = 5.11;
		
		s = b; // b = s? x
		i = s; // s = i? x
		l = i; // i = l? x
		d = f; // f = d? x
		
		
		System.out.println(s); 
		System.out.println(i); 
		System.out.println(l); 
		System.out.println(d); 
	}

}
