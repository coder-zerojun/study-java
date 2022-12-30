package controllStatement;

import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		
		int num = 0;
		String title = "메뉴를 보고 숫자를 입력해주세요", 
				menu = "1. 빨간색  2. 검은색  3. 노란색  4. 흰색";
		String result = null;
		
		Scanner sc = new Scanner(System.in);
		
		// 사용자가 입력한 번호의 색상을 영어로 출력한다
		
		// 먼저 번호표 보여주기
		System.out.println(title);
		System.out.println(menu);
		// 숫자 입력받기
		num = sc.nextInt();
		
		
		
		
	}
}
