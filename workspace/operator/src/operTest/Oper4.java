package operTest;

import java.util.Scanner;

public class Oper4 {

	public static void main(String[] args) {
		
//      심리 테스트
      /*
       * Q. 당신이 좋아하는 색을 선택하세요.
       * 1. 빨간색
       * 2. 노란색
       * 3. 검은색
       * 4. 흰색
       * 
       * 빨간색 : 불같고 열정적이고 적극적이다.
       * 노란색 : 발랄하고 밝고 귀엽고 개성있고 착하다.
       * 검은색 : 묵묵하고 든든하고 냉철하고 멋지다.
       * 흰색 : 천사같고 깔끔하고 정리를 좋아하고 배려심이 많다.
       * 
       */
		
		// 숫자를 받을 공간 작성
//		int num = 0;
//		String que = "당신이 좋아하는 색을 선택하세요", 
//				menu = "1. 빨간색 \n 2. 노란색\n 3. 검은색 \n 4. 흰색",
//				result = null;
//		
//		// 입력받기 위한 클래스 선언
//		Scanner sc = new Scanner(System.in);
//		
//		// 메뉴에 있는 내용 출력해주기
//		System.out.println(que);
//		System.out.println(menu);
//		// 숫자 입력
//		num = sc.nextInt();
//		
//		// 입력받은 숫자 점검 및 조건에 맞는 형식의 값 출력
//		result = num == 1 ? "빨간색 : 불같고 열정적이고 적극적이다" 
//				: num == 2 ? "노란색 : 발랄하고 밝고 귀엽고 개성있고 착하다"
//						: num == 3 ? "검은색 : 묵묵하고 든든하고 냉철하고 멋있다" 
//								: num == 4 ? "흰색 : 천사같고 깔끔하고 정리를 좋아하고 배려심이 많다" : "메뉴에 있는 번호에서 골라주세요";
//		System.out.println(result);
		
		
		
		// 강사님 풀이
		
		 String message = "Q. 당신이 좋아하는 색을 선택하세요.";
	      String choiceMessage = "1.빨간색\n2.노란색\n3.검은색\n4.흰색";
	      String redMessage = "불같고 열정적이고 적극적이다."; 
	      String yellowMessage = "발랄하고 밝고 귀엽고 개성있고 착하다."; 
	      String blackMessage = "묵묵하고 든든하고 냉철하고 멋지다."; 
	      String whiteMessage = "천사같고 깔끔하고 정리를 좋아하고 배려심이 많다.";
	      String errorMessage = "다시 입력해주세요.";
	      String result = null;
	      Scanner sc = new Scanner(System.in);
	      int choice = 0;
	      
	      System.out.println(message + "\n" + choiceMessage);
	      choice = sc.nextInt();
	      
//	      result = choice == 1 ? redMessage :
//	         choice == 2 ? yellowMessage :
//	            choice == 3 ? blackMessage :
//	               choice == 4 ? whiteMessage :
//	                  errorMessage;
//	      if(choice == 1) {
//	         result = redMessage;
//	         
//	      }else if(choice == 2) {
//	         result = yellowMessage;
//	         
//	      }else if(choice == 3) {
//	         result = blackMessage;
//	         
//	      }else if(choice == 4) {
//	         result = whiteMessage;
//	         
//	      }else {
//	         result = errorMessage;
//	         
//	      }
	      
	      switch(choice) {
	      case 1:
	         result = redMessage;
	         break;
	      case 2:
	         result = yellowMessage;
	         break;
	      case 3:
	         result = blackMessage;
	         break;
	      case 4:
	         result = whiteMessage;
	         break;
	      default:
	         result = errorMessage;
	         break;
	      }
	      
	      System.out.println(result);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
