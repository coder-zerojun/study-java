package arTest;

import java.util.Iterator;
import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {

		// ���ڸ� �Է¹ް� �� �Է¹��� ���ڴ�� �迭�� ���̸� ������ ��
		// �Է¹��� ���ڵ� �� �ִ񰪰� �ּڰ� ���ϱ�

//		int[] arData = null;
//		int max = 0, min = 0;
//		String msg = "�� ���� �迭�� ����ڽ��ϱ�?";
		Scanner sc = new Scanner(System.in);
//		
//		System.out.println(msg);
//		arData = new int[sc.nextInt()]; /* <- �߿� (�迭�� ���̸� �Է� �޴� ���ڴ�� �����ϴ� ��)*/
//		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(i+1 + " ��° ��");
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
//		System.out.println("�ִ� : " + max);
//		System.out.println("�ּڰ� : " + min);

		
		
		// �迭�� ���� ����
		// 1. int[] arData = {1, 4, 5, 8}; <- �迭�� ���� ���� �� ��
		// 2. int[] arData = new int[4]; <- �迭�� ���� ���� �𸣳� �� ĭ������ �� ��
		// 3. int[] arData = null; <- �迭�� ���� ���� ĭ �� �� �� ��

		// 1��° �迭
//		int[] arData1 = {1, 5, 8, 11, 7};
//		System.out.println(arData1[3]);	//<- �迭 ������ �� �̾ƺ���

		// 2��° �迭
//		double[] arData2 = new double[5];
//		for (int i = 0; i < arData2.length; i++) {
//			arData2[i] = 2 - i * 0.3; 
//			System.out.println(arData2[i]);
//		}

		// 3��° �迭
		// ���ڸ� �˻��ϱ�
		String word = "��������������հ�Ż���ڿ��Ż��ǵ������", msg = "ã�� �ܾ��� �ڸ����� ����ּ��� :"
		// �� ã�� �ܾ ���ĳ��� ����
				, result = "";
		// ã�� �ܾ��� �ڸ����� �����ϴ� �迭
		int[] arData = null;
		// ������ �ܾ ������ ����
		char c = 0;

		System.out.println(word);
		System.out.print(msg);

		// ã�� �ܾ��� �ڸ����� ���ϴ� ��
		arData = new int[sc.nextInt()];

		// ����ڰ� ã�� �ܾ��� �ڸ��� ��ŭ �ݺ���
		for (int i = 0; i < arData.length; i++) {
			System.out.println(i + 1 + " ��° �ܾ ����ּ���");
			arData[i] = sc.nextInt();

			// ������ ���ڸ� ����
			c = word.charAt(arData[i]);

			// ã�� ���ڸ� ��ġ��
			result += c;
		}

		System.out.println("ã�� �ܾ� : " + result);

		
		// �迭�� ����
		// �������� Ÿ������ ������
		boolean[] blData = {false, true};
		char[] crData = {'a', 0, '��', 'A'};
		String[] stData = {"abcd", "�����Ű�", "1347"};
		double[] dbData = {1.22, 4.323112, 8.128};
		
		

	}
}
