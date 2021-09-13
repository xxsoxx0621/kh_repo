
public class Exam_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Bubble Sort

		int [] arr = new int[] {38, 22, 19, 5, 14, 53, 21};

		int temp;

		System.out.println("정렬하기 전 : ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		for(int j=0; j< arr.length-1; j++) {
			for(int i=0; i< arr.length-1; i++) {
				if(arr[i] > arr[i+1]) {
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;

				}
			} 
		}
		// 정렬 코드 - Bubble sort

		//		if(arr[0] > arr[1]) {
		//			temp = arr[0];
		//			arr[0] = arr[1];
		//			arr[1] = temp;
		//		}
		//		if(arr[1] > arr[2]){
		//			temp = arr[1];
		//			arr[1] = arr[2];
		//			arr[2] = temp;
		//
		//		}
		//		if(arr[2] > arr[3]){
		//			temp = arr[2];
		//			arr[2] = arr[3];
		//			arr[3] = temp;
		//
		//		}
		//
		//		if(arr[0] > arr[1]) {
		//			temp = arr[0];
		//			arr[0] = arr[1];
		//			arr[1] = temp;
		//		}
		//		if(arr[1] > arr[2]){
		//			temp = arr[1];
		//			arr[1] = arr[2];
		//			arr[2] = temp;
		//
		//		}
		//		if(arr[2] > arr[3]){
		//			temp = arr[2];
		//			arr[2] = arr[3];
		//			arr[3] = temp;
		//
		//		}
		//
		//		if(arr[0] > arr[1]) {
		//			temp = arr[0];
		//			arr[0] = arr[1];
		//			arr[1] = temp;
		//		}
		//		if(arr[1] > arr[2]){
		//			temp = arr[1];
		//			arr[1] = arr[2];
		//			arr[2] = temp;
		//
		//		}
		//		if(arr[2] > arr[3]){
		//			temp = arr[2];
		//			arr[2] = arr[3];
		//			arr[3] = temp;
		//
		//		}




		// 정렬 코드


		System.out.println("정렬 후: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();


	}

}
