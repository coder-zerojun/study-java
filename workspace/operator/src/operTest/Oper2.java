package operTest;

import java.util.Scanner;

public class Oper2 {

	public static void main(String[] args) {
		
		// �� ���� ��Һ�
		// ������ ���� ���� ����
		int num1 = 0, num2 = 0;
		String msg = "������ �Է��ϼ���", result = null;
		// �Է¹ޱ� ���� Ŭ���� ����
		Scanner sc = new Scanner(System.in);
		
		// ������ �Է¹ޱ� ���� ���
		System.out.println(msg);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
	    result = num1 > num2 ? "ū ��: " + num1
	    		: num1 == num2 ? "�� ���� �����ϴ�." : "ū ��: " + num2;
	    System.out.println(result);

		
		
		
		
		
		
		
		
		
	} 
	
}
