package arrayTest;

import java.util.Scanner;

//import jdk.internal.misc.FileSystemOption;

public class ArTask2 {

	public static void main(String[] args) {

		// 각 버튼을 눌렀을 때, 이동하는 페이지는 다음과 같다
		// btn1 : 회원가입 페이지
		// btn2 : 로그인 페이지
		// btn3 : 마이 페이지

		// 회원가입 -> 로그인 -> 마이페이지
		// 위 순서대로 입력해야 하며, 만약 이전단계를 진행하기 전에 다음 단계 버튼을 누르면,
		// 이전단계에 대한 메세지를 출력해준다
		// ex) 로그인 클릭 시 -> 회원가입을 먼저 진행해주세요

		// 알맞은 단계의 버튼을 누르면, 해당 단계에 대한 메세지를 출력
		// ex) 회원가입 클릭 시, 회원가입 성공
		// 마이 페이지 클릭 시, 본인 이름과 나이 출력

//		String msg1 = "버튼을 눌러주세요", msg2 = "btn1: 회원가입 페이지 \nbtn2: 로그인 페이지 \nbtn3: 마이 페이지 \nbtn4: 종료";
//
//		int btn = 0, check = 0;
//
//		String[] arBtn = { "btn1", "btn2", "btn3" }, btMsg = { "회원가입 성공", "로그인 성공", "이름 : ㅇㅇㅇ \n나이 : 00살" },
//				erMsg = { "회원가입을 먼저 진행해 주세요", "로그인을 먼저 진행해주세요" };
//		String psMsg = "4번을 누르면 나가집니다", result = null;
//		Scanner sc = new Scanner(System.in);
//
////		// 반복 횟수를 모르기 때문에 해당 조건을 만족할 때까지 반복해야 함
//		while (btn != 4) {
//			System.out.println(msg1);
//			System.out.println(msg2);
//			btn = sc.nextInt();
//
//			// 각 번호에 맞는 메세지 출력
//			switch (btn) {
//
//			case 1:
//				result = btMsg[0];
//				System.out.println(result);
//				check = btn;
//				break;
//
//			case 2:
//				result = btMsg[1];
//				if (check != 1) {
//					result = erMsg[0];
//					System.out.println(result);
//				} else {
//					System.out.println(result);
//				}
//				check = btn;
//				break;
//
//			case 3:
//				result = btMsg[2];
//				if (check != 2) {
//					result = erMsg[1];
//					System.out.println(result);
//				} else {
//					System.out.println(result);
//				}
//				check = btn;
//				break;
//			}
//		}

		String[] arButton = { "btn1", "btn2", "btn3", "btn4" };
		String[] arMessage = { "회원가입 성공", "로그인 성공", "한동석(20)", "로그아웃 성공" };
		String[] arError = { "회원가입을 먼저 진행해주세요.", "로그인을 먼저 진행해주세요" };
		String errorMessage = "다시 시도해주세요", result = null;

		Scanner sc = new Scanner(System.in);
		int choice = 0, temp = 0;
		boolean condition = false;

		while (true) {
			for (int i = 0; i < arButton.length; i++) {
				System.out.println(i + 1 + "." + arButton[i]);
			}
			temp = choice;
			choice = sc.nextInt();
			condition = choice - 1 == temp;

			switch (choice) {
			case 1:
			case 4:
				result = arMessage[choice - 1];
				break;
			case 2:
			case 3:
				result = condition ? arMessage[choice - 1] : arError[choice - 2];
				if (!condition) {
					choice = 0;
				}
				break;
			default:
				result = errorMessage;
				break;
			}

			System.out.println(result);
			if (choice == 4) {
				break;
			}
		}

		
		
		
		
////      버튼 배열
//		String[] arButton = { "btn1", "btn2", "btn3", "btn4" };
////      성공 메세지 배열
//		String[] arMessage = { "회원가입 성공", "로그인 성공", "한동석(20)", "로그아웃 성공" };
////      오류 메세지 배열
//		String[] arError = { "회원가입을 먼저 진행해주세요.", "로그인을 먼저 진행해주세요" };
////      오류 메세지
//		String errorMessage = "다시 시도해주세요";
//
////      Scanner sc = new Scanner(System.in);
////      choice : 사용자가 입력한 번호, temp : 사용자가 이전에 입력한 번호
//		int choice = 0, temp = 0;
//		boolean condition = false;
//
//		while (true) {
////         메뉴 출력
//			for (int i = 0; i < arButton.length; i++) {
//				System.out.println(i + 1 + "." + arButton[i]);
//			}
//
////         만약 temp에 0이 담겨있다면, 0을 유지해야 한다.
//			temp = temp == 0 ? 0 : choice;
////         사용자가 선택한 버튼 번호
//			choice = sc.nextInt();
////         버튼 번호 이외의 번호를 입력했을 경우 오류 메세지 출력
//			if (choice < 1 || choice > 4) {
//				System.out.println(errorMessage);
//				continue;
//			}
////         로그아웃 시 프로그램 종료
//			if (choice == 4) {
//				System.out.println(arMessage[choice - 1]);
//				break;
//			}
//
////         사용자가 선택한 버튼의 번호 - 1과 이전에 사용자가 입력한 번호가 같은 지 비교
////         전 단계를 진행 했는 지 검사
//			condition = choice - 1 == temp;
//
//			if (!condition) { // 전 단계를 안했을 경우
//				temp = 0; // 회원가입부터 진행하라는 뜻.
//				System.out.println(arError[choice - 2]);
//				continue;
//			}
//			// 전 단계를 진행했을 경우
//			System.out.println(arMessage[choice - 1]);
//			if (choice == 3) { // 마이 페이지를 선택했을 때에는
//				temp = 0; // 회원가입부터 진행하라는 뜻.
//				continue;
//			}
////         마이 페이지 이외의 서비스를 이용했을 경우 입력했던 번호를 temp에 저장한다.
//			temp = choice;
//
//		}

	}
}
