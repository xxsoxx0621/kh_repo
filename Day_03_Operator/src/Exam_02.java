
public class Exam_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 20;
		boolean result;
		int result2;
		result2 = x + y;
		
		System.out.println(x + " + " + y + " = " + result2);
		x = y = 2;
		System.out.println("x  = " + x++ + ", y = "  + ++y);
		System.out.println("x  = " + x + ", y = "  + y);
		y = 10;
		result = !( ((x>y) || (y==x) || (x!=y) && (x<y) ));
		System.out.println(result);
		
	}

}
