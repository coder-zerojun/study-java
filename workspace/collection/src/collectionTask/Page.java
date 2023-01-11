package collectionTask;

import java.util.Scanner;

public class Page {

	public static void main(String[] args) {
		
		
		User user = new User();
		User user2 = new User();
		UserField using = new UserField();
		// 메일로 받은 인증번호
		String mailNum = ""
				// 내가 받아서 적는 인증번호
				, checkNum = "";
		Scanner sc = new Scanner(System.in);
		
		
		user.setName("테스트");
		user.setId("test");
		user.setPw("test1");
		user.setPhoneNum("01012341234");
		
		user2.setName("홍길동");
		user2.setId("홍길동");
		user2.setPw("홍길동1");
		user2.setPhoneNum("01012341233");
		
		// 회원가입
		
		
		// 로그인

		// 암호화 진행
		
		// 문자 발송
//		mailNum = using.sendMail("01012341234");
//		checkNum = sc.nextLine();
//		if(mailNum.equals(checkNum)) {
//			System.out.println("인증번호가 확인되었습니다");
//		} else {
//			System.out.println("인증번호가 다릅니다");
//		}
		
		// 비밀번호 변경
		
		
	}
}
