package arTest;

import java.util.Iterator;
import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {

		// 숫자를 입력받고 그 입력받은 숫자대로 배열의 길이를 정했을 때
		// 입력받은 숫자들 중 최댓값과 최솟값 구하기

//		int[] arData = null;
//		int max = 0, min = 0;
//		String msg = "몇 개의 배열을 만들겠습니까?";
		Scanner sc = new Scanner(System.in);
//		
//		System.out.println(msg);
//		arData = new int[sc.nextInt()]; /* <- 중요 (배열의 길이를 입력 받는 숫자대로 선정하는 것)*/
//		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(i+1 + " 번째 수");
//			arData[i] = sc.nextInt();
//		
//			max = arData[0];
//			min = arData[0];
//		}
//		
//		for (int i = 0; i < arData.length; i++) {
//			if(max < arData[i]) {max = arData[i];}
//			if(min > arData[i]) {min = arData[i];}
//		}
//		
//		System.out.println("최댓값 : " + max);
//		System.out.println("최솟값 : " + min);

		
		
		// 배열의 선언 종류
		// 1. int[] arData = {1, 4, 5, 8}; <- 배열에 들어가는 값을 알 때
		// 2. int[] arData = new int[4]; <- 배열에 들어가는 값은 모르나 몇 칸인지는 알 때
		// 3. int[] arData = null; <- 배열에 들어가는 값과 칸 둘 다 모를 때

		// 1번째 배열
//		int[] arData1 = {1, 5, 8, 11, 7};
//		System.out.println(arData1[3]);	//<- 배열 내에서 값 뽑아보기

		// 2번째 배열
//		double[] arData2 = new double[5];
//		for (int i = 0; i < arData2.length; i++) {
//			arData2[i] = 2 - i * 0.3; 
//			System.out.println(arData2[i]);
//		}

		// 3번째 배열
		// 문자를 검색하기
		String word = "군보운감동모인지손고탈빔자영매산판돈김순이", msg = "찾을 단어의 자릿수를 골라주세요 :"
		// 각 찾은 단어를 합쳐놓을 공간
				, result = "";
		// 찾을 단어의 자릿수를 결정하는 배열
		int[] arData = null;
		// 추출한 단어를 저장할 공간
		char c = 0;

		System.out.println(word);
		System.out.print(msg);

		// 찾을 단어의 자릿수를 정하는 것
		arData = new int[sc.nextInt()];

		// 사용자가 찾을 단어의 자릿수 만큼 반복함
		for (int i = 0; i < arData.length; i++) {
			System.out.println(i + 1 + " 번째 단어를 골라주세요");
			arData[i] = sc.nextInt();

			// 추출한 문자를 저장
			c = word.charAt(arData[i]);

			// 찾은 문자를 합치기
			result += c;
		}

		System.out.println("찾은 단어 : " + result);

		
		// 배열의 종류
		// 여러가지 타입으로 만들어보기
		boolean[] blData = {false, true};
		char[] crData = {'a', 0, 'ㄱ', 'A'};
		String[] stData = {"abcd", "가갸거겨", "1347"};
		double[] dbData = {1.22, 4.323112, 8.128};
		
		

	}
}
