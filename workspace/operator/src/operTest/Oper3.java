package operTest;

import java.util.Scanner;

public class Oper3 {

	public static void main(String[] args) {
		
		// ����ڿ��� Ű�� �Է¹ް�
		// ������� ������ ���
		// �Ǽ���� �Ǽ��� ���
		// ex) 183 -> 183 ���
		// 183.5 -> 183.5 ���
		// ���� �����ڸ� ���
		
//		�Է� �ޱ� ���� ���� ����
		double num = 0;
		String msg = "Ű�� �Է����ּ���", result = null;
		
		// �Է��� ���� Ŭ���� ����
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		num = sc.nextDouble();
		
		// �Է� �ޱ�
		// �Է��� �ް� ���� �� ���� ���� ����
		// �Ǽ��� ����???  00.00 - 00
//		System.out.println(num);
		result = num-(int)num != 0 ? num + " cm" : (int)num + " cm";
		System.out.println(result);
		
		
		
		// ����� Ǯ��
//		 double height = 0.0;
//	      String message = "Ű: ";
//	      boolean check = false;
//	      String format = null;
//	      String forLength = "";
//	      int length = 0;
//	      
//	      System.out.print(message);
//	      height = sc.nextDouble();
//	      check = height - (int)height == 0;
//	      forLength = height - (int)height + "";
//	      
//	      length = forLength.length() > 6 ? 8 : forLength.length();
//	      
//	      format = check ? "%.0fcm" : "%." + (length - 2) + "fcm";
//	      System.out.printf(format, height); 

		
		
	}
}
