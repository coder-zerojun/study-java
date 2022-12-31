package arrayTest;

public class ArTest1 {

	public static void main(String[] args) {
		
		int[] arData = {2, 4, 5, 6, 8};
		
		System.out.println(arData);
		System.out.println(arData.length);
		
		for (int i = 0; i < 5; i++) {
			System.out.println(arData[i]);
		}
		
		// 5, 4, 3, 2, 1을 넣고 출력
		int[] data = {5, 4, 3, 2, 1};
		
		for (int i = 0; i < 5; i++) {
			System.out.println(data[i]);
		}
		
		for (int i = 0; i < 5; i++) {
			arData[i] = 5 - i;
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println(arData[i]);
		}
		
		
		
		
	}
}
