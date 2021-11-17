
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.print(" 날짜를 입력하세요 (yyyy/mm/dd) : ");
		 String writeDate = sc.nextLine();
		// 1.입력받은 날짜의 timestamp를 출력하세요.

	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date d = sdf.parse(writeDate);
			System.out.println(d.getTime());
			
			// parse는  문자열을 숫자로 바꿀 때, 
			// format은 날짜를 문자열로 바꿀때

		// 2.입력받은 날짜를 dd일 mm월 yyyy년 형식으로 출력해주세요.
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd일MM월yyyy년");
			String dateString2 = sdf2.format(d.getTime()); // format은 오버로딩 
			System.out.println(dateString2);
	
	}
}