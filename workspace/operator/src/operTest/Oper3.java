package operTest;

import java.util.Scanner;

public class Oper3 {

	public static void main(String[] args) {
		
		// 사용자에게 키를 입력받고
		// 정수라면 정수로 출력
		// 실수라면 실수로 출력
		// ex) 183 -> 183 출력
		// 183.5 -> 183.5 출력
		// 삼항 연산자를 사용
		
//		입력 받기 위한 공간 설정
		double num = 0;
		String msg = "키를 입력해주세요", result = null;
		
		// 입력을 위한 클래스 설정
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		num = sc.nextDouble();
		
		// 입력 받기
		// 입력을 받고 나서 그 받은 수를 검증
		// 실수의 검증???  00.00 - 00
//		System.out.println(num);
		result = num-(int)num != 0 ? num + " cm" : (int)num + " cm";
		System.out.println(result);
		
		
		
		// 강사님 풀이
//		 double height = 0.0;
//	      String message = "키: ";
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
