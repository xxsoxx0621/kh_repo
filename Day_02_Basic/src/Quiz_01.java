
public class Quiz_01 {
	public static void main(String[] args) {
		
		byte b = 10;
		short s = 20;
		char c = 'A';
		int i;
		float f;
		long l = 100L;
		
		s = b;
		c = (char) b; 
		// char 0~60000, byte -128 ~ 127 대소 판단이 불가하여 프로모션 대상이 되지 못
		// 데이터 손실을 감소하고 프로모션
		s = (short) c;
		c = (char) s;
		i = (int) 100L; // 100으로 바꿔도 된다.
		l = 500;
		f = l; // 실수형은 정수형보다 크다. 
		f = 5.11f; // 기본값이 더블이기때문에 f가 없으면 에러
		
		System.out.println(s);
		System.out.println(c);
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
	}

}
