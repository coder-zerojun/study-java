package repeatTest;

import java.util.Scanner;

public class ForTest {

	public static void main(String[] args) {
		
		
		// 10번 내로 할만한 것
		// 사용자로부터 닉네임 입력을 받아서 출력하기
		String word = null, msg = "쓰고 싶은 닉네임을 입력하세요";
		
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		
		word = sc.nextLine();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i+1 + word);
		}
	}
}
