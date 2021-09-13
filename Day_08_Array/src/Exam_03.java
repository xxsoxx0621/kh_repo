
public class Exam_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// SWAP 기법
		
		int a = 10;
		int b = 20;
		int tmp;
		
		tmp = a;
		a = b;
		b = tmp;
		
		// -----------------------
		
		int [] arr = new int[] {10,20};
		
		System.out.println(arr[0] + ": " + arr[1]); //10 : 20
		
		//swap code
		tmp = arr[0]; //tmp = 10
		arr[0] = arr[1]; // arr[0] = 20
		arr[1] = tmp; // arr[1] = 10
		
		System.out.println(arr[0] + ": " + arr[1]); //20 : 10

	}

}
