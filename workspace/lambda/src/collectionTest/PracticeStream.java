package collectionTest;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class PracticeStream {
	public static void main(String[] args) {
		
		
		ArrayList<Integer> datas = new ArrayList<Integer>();
		ArrayList<String> StDatas = new ArrayList<String>();
//		10~1���� ArraList�� ��� ���
//		IntStream.range(0, 10).forEach(c -> datas.add(10 - c));
		
//		1~10���� ArrayList�� ��� ���
//		IntStream.rangeClosed(1, 10).forEach(datas::add);
		
		
//		ABCDEF�� �� ���ں��� ���
//		IntStream.rangeClosed('A', 'F').forEach(c -> System.out.print((char)c));
		
//      1~100���� �� Ȧ���� ArrayList�� ��� ���
		IntStream.range(1, 51).map(c -> c * 2 - 1).forEach(datas::add);
//      A~F���� �� D�����ϰ� ArrayList�� ��� ���
		
//		5���� ���ڿ��� ��� �ҹ��ڷ� ����(Black, WHITE, reD, yeLLow, PINk), toLowerCase()
		
		
//		1~100���� �� Ȧ���� ArrayList�� ��� ���
//		Apple, banana, Melon �� ù��° ���ڰ� �빮���� ���ڿ� ���

		
		
		System.out.println(datas);
	}
}
