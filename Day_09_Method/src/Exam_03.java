
public class Exam_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "hello world";
		int len = str.length();

		char a = str.charAt(0);

		// 문자열을 char형 배열로 바꾸어준다.
		char[] b = str.toCharArray();
		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);
		System.out.println(b[3]);
		System.out.println(b[4]);

		//특정 문자 또는 문자열로 시작되는지 체크하는 함수
		boolean result = str.startsWith("HE");
		System.out.println(result);
		//특정 문자 또는 문자열로 끝나는지 체크하는 함수
		str.endsWith("d");

		// CharSequence = String 
		boolean result1 =str.contains("o");
		System.out.println(result1);

		str.equals("hello");
		//regex = regular experession

		String str2 = "Apple:Orange:Mango";
		String[] fruits = str2.split(":");

		System.out.println(fruits[0]);
		System.out.println(fruits[1]);
		System.out.println(fruits[2]);

		//똑같은 문자가 두개 있을 때, 두개의 중복값을 제외시켜줌.
		String str3 = "BOO:AND:FOO:AND";
		String [] arr = str3.split("O");
		System.out.println(arr.length);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		//str3.split()



	}

}
