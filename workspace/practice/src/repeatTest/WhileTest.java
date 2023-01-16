package repeatTest;

import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) {
		
		// while = 반복 횟수를 알지 못할 때 사용
		// 4번 상담원 연결을 누르기 전까지 계속 반복
		
		
		String msg = "1. 다시 듣기\n 2. 잔액 조회\n 3. 계좌 이체 \n 4. 상담원 연결", end = "서비스를 종료합니다";
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		System.out.println(msg);
		
		
		while (num != 4) {
		num = sc.nextInt();
		System.out.println(msg);
		}
			
	}
}
