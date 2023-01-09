package collectionTest;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class PracticeStream {
	public static void main(String[] args) {
		
		
		ArrayList<Integer> datas = new ArrayList<Integer>();
		ArrayList<String> StDatas = new ArrayList<String>();
//		10~1까지 ArraList에 담고 출력
//		IntStream.range(0, 10).forEach(c -> datas.add(10 - c));
		
//		1~10까지 ArrayList에 담고 출력
//		IntStream.rangeClosed(1, 10).forEach(datas::add);
		
		
//		ABCDEF를 각 문자별로 출력
//		IntStream.rangeClosed('A', 'F').forEach(c -> System.out.print((char)c));
		
//      1~100까지 중 홀수만 ArrayList에 담고 출력
		IntStream.range(1, 51).map(c -> c * 2 - 1).forEach(datas::add);
//      A~F까지 중 D제외하고 ArrayList에 담고 출력
		
//		5개의 문자열을 모두 소문자로 변경(Black, WHITE, reD, yeLLow, PINk), toLowerCase()
		
		
//		1~100까지 중 홀수만 ArrayList에 담고 출력
//		Apple, banana, Melon 중 첫번째 문자가 대문자인 문자열 출력

		
		
		System.out.println(datas);
	}
}
