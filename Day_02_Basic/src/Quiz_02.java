
public class Quiz_02 {
	public static void main(String[] args) {
		
		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000L;
		
		b = (byte)i;
		ch = (char)b;
		short s = (short)ch;
		float f = l;
		i = ch; // i = (int) ch -> 프로모션
		
		
		System.out.println(b);
		System.out.println(ch);
		System.out.println(s);
		System.out.println(f);
		System.out.println(i);
	}

}
