package lambdaTest;

import java.util.Scanner;

public class GetIntArrayTest {

	public static void main(String[] args) {

		int[] intAr = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� � �Է��Ͻðڽ��ϱ�?");
		int choice = 0;
		choice = sc.nextInt();
		intAr = new int[choice];

		// �迭�� ���� ��� ����
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
		// ���� ���� ���ϱ�
		GetIntArray getIntArray = (check) -> { 
			System.out.println(check);
		};
		getIntArray.getIntArray(num);
	}
}

