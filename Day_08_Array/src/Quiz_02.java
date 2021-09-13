
public class Quiz_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// int 형 배열 100칸 짜리 arr1을 만들고, 1 부터 100까지 저장해보세요.
		// 잘 저장했는지 확인하는 방법
	
		
		int []arr1 = new int [100];
		
		for(int i=0;i < arr1.length; i++) {
			arr1[i]= i+1;
			
			// 0 = 1;
			// 1 = 2;
			// 2 = 3;
			
		}
		

		System.out.println(arr1[0]); // 1
		System.out.println(arr1[99]); //100
		
		//int 형 배열 100칸 짜리 arr2 를 만들고, 100부터 1까지 저장해보세요.
		
		int [] arr2 = new int[100];
		
		for(int i=0; i < arr2.length ; i++) {
				arr2[i] = 100-i;
			}
					
			// 0 = 100
			// 1 = 99
			// 2 = 98
		System.out.println(arr2[99]); // 1
		System.out.println(arr2[0]); //100
	
	
		//char형 배열 26칸짜리를 arr3로 만들고, Z-A까지 저장해보세요.
		
		char []arr3 = new char[26];
		
		//아스키코드 이용하기 
		for(int i= 0; i<arr3.length; i++) {
			arr3[i] = (char)(90 - i);
//			arr3[i] = (char)('Z' - i);
		}
		System.out.println(arr3[0]); //Z
		System.out.println(arr3[25]); //A
	
	}

}
