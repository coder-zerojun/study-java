package lambdaTest;

import java.util.Scanner;

public class GetIntArrayTest {

	public static void main(String[] args) {

		int[] intAr = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 몇개 입력하시겠습니까?");
		int choice = 0;
		choice = sc.nextInt();
		intAr = new int[choice];

		// 배열에 숫자 담아 놓기
		int i = 0;
		for (i = 0; i < intAr.length; i++) {
			intAr[i] = sc.nextInt();
		}
//		
		i = 0; int num = 0;
		while (i < intAr.length) {
			num += intAr[i];
			i++;
		} 
		// 담은 숫자 더하기
		GetIntArray getIntArray = (check) -> { 
			System.out.println(check);
		};
		getIntArray.getIntArray(num);
	}
}

