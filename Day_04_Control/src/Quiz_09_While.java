
public class Quiz_09_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 0;
		while(i < 100) {
			i++;
			System.out.print(i + " ");
			
			if(i% 10 == 0) {
				System.out.println();
			}
			
		}
	}

}
