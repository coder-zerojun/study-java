package collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;


public class StreamTask {
	public static void main(String[] args) {
				

		
//		10~1���� ArraList�� ��� ���
//		1~10���� ArrayList�� ��� ���
		
		ArrayList<Integer> datas = new ArrayList<Integer>();
//		IntStream.range(0, 10).forEach(v -> datas.add(10-v));
//		System.out.println(datas);
		
//		IntStream.rangeClosed(1, 10).forEach(datas::add);
//		System.out.println(datas);
		
		
//		ABCDEF�� �� ���ں��� ���
//		IntStream.rangeClosed(65, 70).forEach(c -> System.out.print((char)c));
		
		
//      1~100���� �� Ȧ���� ArrayList�� ��� ���
//      IntStream.range(1, 51).map(v -> v * 2 - 1).forEach(datas::add);
//      System.out.println(datas);
      
//      A~F���� �� D�����ϰ� ArrayList�� ��� ���
//      IntStream.range('A', 'F').map(c -> c > 67 ? c + 1 : c).forEach(c -> System.out.print((char)c));
		
//		5���� ���ڿ��� ��� �ҹ��ڷ� ����(Black, WHITE, reD, yeLLow, PINk), toLowerCase()
		ArrayList<String> color = new ArrayList<String>(Arrays.asList("Black", "WHITE", "reD", "yeLLow", "PINk"));
		color.stream().map(String::toLowerCase).forEach(System.out::println);
		
//		1~100���� �� Ȧ���� ArrayList�� ��� ���
//		IntStream.rangeClosed(1, 100).filter(c -> c % 2 == 1).forEach(datas::add);
//		System.out.println(datas);
		
//		Apple, banana, Melon �� ù��° ���ڰ� �빮���� ���ڿ� ���
		ArrayList<String> fruit = new ArrayList<String>(Arrays.asList("Apple", "banana", "Melon"));
		fruit.stream()
        .filter(data -> data.charAt(0) >= 'A')
           .filter(data -> data.charAt(0) <= 'Z')
              .forEach(System.out::println);
     
//     �ѱ��� ������ ����
//		String hangle = "�����̻�����ĥ�ȱ�";
//		String data = "�ϰ��̻�";
//		data.chars().map(hangle::indexOf).forEach(System.out::print);
		
//     ������ �ѱ۷� ����
		String hangle = "�����̻�����ĥ�ȱ�";
		String data = "1024";
		

	}
}
