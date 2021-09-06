
public class Quiz_01 {
	public static void main(String[] args) {
	
		int a  = 10;
		int b  = 20;
		System.out.println(++ a == 10 && b++ == 20);
		System.out.println(a + " : " + b);
		
		// and는 좌항 우항이 모두 참일때만 실행되기 때문에 
		//shortcut 때문에 앞쪽이 f이기때문에 뒤에가 무시가 되어
		//뒤의 연산이 진행되지 않음 
	}
}
