package repeatTest;

import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) {
		
		// while = �ݺ� Ƚ���� ���� ���� �� ���
		// 4�� ���� ������ ������ ������ ��� �ݺ�
		
		
		String msg = "1. �ٽ� ���\n 2. �ܾ� ��ȸ\n 3. ���� ��ü \n 4. ���� ����", end = "���񽺸� �����մϴ�";
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		System.out.println(msg);
		
		
		while (num != 4) {
		num = sc.nextInt();
		System.out.println(msg);
		}
			
	}
}
