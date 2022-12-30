package operTest;

import java.util.Scanner;

public class Oper2 {

	public static void main(String[] args) {
		
		// 두 정수 대소비교
		// 정수를 받을 공간 생성
		int num1 = 0, num2 = 0;
		String msg = "정수를 입력하세요", result = null;
		// 입력받기 위한 클래스 지정
		Scanner sc = new Scanner(System.in);
		
		// 정수를 입력받기 위한 출력
		System.out.println(msg);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
	    result = num1 > num2 ? "큰 값: " + num1
	    		: num1 == num2 ? "두 수는 같습니다." : "큰 값: " + num2;
	    System.out.println(result);

		
		
		
		
		
		
		
		
		
	} 
	
}
