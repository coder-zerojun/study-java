package controllStatement;

import java.util.Scanner;

public class IfTask {

	public static void main(String[] args) {
		// ����ڿ��� �Ʒ��� �޴��� ����ϰ�
		// ��ȣ�� �Է¹޴´�
		
		// 1. ������
		// 2. ������
		// 3. �����
		// 4. ���
		
		
		
		// ���ڸ� ���� ���� �ۼ�
		int num = 0;
		String title = "�޴��� ���� ���ڸ� �Է����ּ���", menu = "1. ������  2. ������  3. �����  4. ���";
		String result = null;
		
		Scanner sc = new Scanner(System.in);
		
		// ����ڰ� �Է��� ��ȣ�� ������ ����� ����Ѵ�
		
		// ���� ��ȣǥ �����ֱ�
		System.out.println(title);
		System.out.println(menu);
		// ���� �Է¹ޱ�
		num = sc.nextInt();
		
//		System.out.println(num);
		
		if(num == 1) {
			result = "red";
		}
		else if(num == 2) {
			result = "black";
		}
		else if(num == 3) {
			result = "yellow";
		}
		else if(num == 4) {
			result = "white";
		}
		else {
			result = "�޴��ǿ��� ��ȣ�� ����ֽʽÿ�";
		}
		
		System.out.println(result);
	}
}
