
public class Exam_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 변수의 종류
		// -- 지역변수 : 특정 지역 내에서 생성된 변수로, 지역 바깥에서 사용할 수 없음.
		//			자신의 지역을 포함하는 더 큰 지역의 변수는, 내부 지역에서 사용할 수 있음.
		
		// -- 매개변수
		// -- 멤버변수
		// -- 정적변수
		
		int a = 20;
		System.out.println("a의 값은 " + a);
		
		// 가 - 지역 
		{
			// int a  = 10;
			System.out.println(a); // 자신보다 더 큰 지역의 a를 호출
		}
		
		// 나 - 지역
		{
			//int a = 30;
		}
		
		

	}

}
