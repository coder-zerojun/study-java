package lambdaTest;

import java.util.Scanner;

public class GetNumTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ 2�� �Է��ϼ���");
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		GetNumber getNumber = (a, b) -> num1 - num2;
		System.out.println(getNumber.getNum(num1, num2));
	}
}
