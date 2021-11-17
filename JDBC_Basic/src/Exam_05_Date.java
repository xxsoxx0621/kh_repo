import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exam_05_Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println(" 날짜를 입력하세요 (yyyy/mm/dd) : ");
//		
		// Timestamp 값을 원하는 형식으로 변경하여 출력하는 방
		long timestamp = System.currentTimeMillis(); // 현재 시간 값을 long형으로 변환
		System.out.println(timestamp); //time stamp : 1970년 1월 1일부터 현재까지 흐른 시간을 초값으로 표현.
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String dateString = sdf.format(timestamp);
		
		System.out.println("현재 날짜 : " + dateString);
		//-------------------------------------------------
		
		System.out.println("-----------------------------");
		
		// 형식이 정해진 날짜 문자열을 Timestamp로 변경하는 방법
		try {
			
			String str ="2008년 4월 20일";
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 M월 dd");
			Date d = sdf2.parse(str);
			
			String dateString2 = sdf.format(d.getTime());
			System.out.println(" 분석할 날짜 : " + dateString2);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}

}
