package collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;


public class StreamTask {
	public static void main(String[] args) {
				

		
//		10~1까지 ArraList에 담고 출력
//		1~10까지 ArrayList에 담고 출력
		
		ArrayList<Integer> datas = new ArrayList<Integer>();
//		IntStream.range(0, 10).forEach(v -> datas.add(10-v));
//		System.out.println(datas);
		
//		IntStream.rangeClosed(1, 10).forEach(datas::add);
//		System.out.println(datas);
		
		
//		ABCDEF를 각 문자별로 출력
//		IntStream.rangeClosed(65, 70).forEach(c -> System.out.print((char)c));
		
		
//      1~100까지 중 홀수만 ArrayList에 담고 출력
//      IntStream.range(1, 51).map(v -> v * 2 - 1).forEach(datas::add);
//      System.out.println(datas);
      
//      A~F까지 중 D제외하고 ArrayList에 담고 출력
//      IntStream.range('A', 'F').map(c -> c > 67 ? c + 1 : c).forEach(c -> System.out.print((char)c));
		
//		5개의 문자열을 모두 소문자로 변경(Black, WHITE, reD, yeLLow, PINk), toLowerCase()
		ArrayList<String> color = new ArrayList<String>(Arrays.asList("Black", "WHITE", "reD", "yeLLow", "PINk"));
		color.stream().map(String::toLowerCase).forEach(System.out::println);
		
//		1~100까지 중 홀수만 ArrayList에 담고 출력
//		IntStream.rangeClosed(1, 100).filter(c -> c % 2 == 1).forEach(datas::add);
//		System.out.println(datas);
		
//		Apple, banana, Melon 중 첫번째 문자가 대문자인 문자열 출력
		ArrayList<String> fruit = new ArrayList<String>(Arrays.asList("Apple", "banana", "Melon"));
		fruit.stream()
        .filter(data -> data.charAt(0) >= 'A')
           .filter(data -> data.charAt(0) <= 'Z')
              .forEach(System.out::println);
     
//     한글을 정수로 변경
//		String hangle = "공일이삼사오육칠팔구";
//		String data = "일공이사";
//		data.chars().map(hangle::indexOf).forEach(System.out::print);
		
//     정수를 한글로 변경
		String hangle = "공일이삼사오육칠팔구";
		String data = "1024";
		

	}
}
