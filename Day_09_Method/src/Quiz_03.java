
public class Quiz_03 {

	public static int countA(String msg) {
		int i = msg.length();
		int count = 0;
	
		char [] a = msg.toCharArray();
		
		for(int j=0; j < i; j++) {
			if(a[j] == 'A') {
				count += 1;
			}
		}
		return count;
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "AQOQOKDKASDLKASLKLQELPQEFLALFALSDL";
		
		int count = countA(str); // 전달받은 str 내의 문자열에서 알파벳 A의 개수를 카운팅 해서 return하는 메서드
		System.out.println("알파벳 A의 개수는 : " + count);
	}

}
