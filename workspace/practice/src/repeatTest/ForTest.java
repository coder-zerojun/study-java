package repeatTest;

import java.util.Scanner;

public class ForTest {

	public static void main(String[] args) {
		
		
		// 10�� ���� �Ҹ��� ��
		// ����ڷκ��� �г��� �Է��� �޾Ƽ� ����ϱ�
		String word = null, msg = "���� ���� �г����� �Է��ϼ���";
		
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		
		word = sc.nextLine();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i+1 + word);
		}
	}
}
