package methodTest;

import java.util.Scanner;

public class MethodTask {

	// 1~10까지 println()으로 출력하는 메소드
	void popOut() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
		}
	}

	// "홍길동"을 n번 println()으로 출력하는 메소드
	void popOut2(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println("홍길동");
		}
	}

	// 이름을 n번 println()으로 출력하는 메소드
	void popOut3(String name, int num) {
//			Scanner sc = new Scanner(System.in);
//			name = sc.nextLine();
		for (int i = 0; i < num; i++) {
			System.out.println(name);
		}
	}

	// 세 정수의 뺄셈을 해주는 메소드
	int subtract(int num1, int num2, int num3) {
		int result = num1 - num2 - num3;
		return result;
	}

	// 두 정수의 나눗셈 후 몫과 나머지 두 개를 구하는 메소드
//		 String division(int num1, int num2){
//			// 두 정수를 입력하면 두 정수를 나누고 몫과 나머지를 내놓음
//			 // 몫을 구하면 담을 변수
//			 int c = num1 / num2;
//			 // 나머지를 구하면 담을 변수
//			 int d = num1 % num2;
//			 
//			 String result = "몫    :" + c + "\n나머지 : " +  d;
//			 return result;
//		}

	int[] divid(int num1, int num2) {
		int[] result = null;

		if (num2 != 0) {
			result = new int[2];
			result[0] = num1 / num2;
			result[1] = num1 % num2;
		}
		return result;
	}

	// 1~n 까지의 합을 구해주는 메소드
//	int result = 0;
//
//	int plus(int num) {
//		for (int i = 0; i < num; i++) {
//			result = result + i + 1;
//		}
//		return result;
//	}

	// 홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
//	int change(int num) {
//		if (num % 2 == 0) {
//			num = num + 1;
//		} else {
//			num = num - 1;
//		}
//		return num;
//	}

	// 문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
//		String result = "";
//	 	String alpha(String word){
//				for (int i = 0; i < word.length(); i++) {
//					char c = word.charAt(i);
//				
//				if(c >= 65 && c <= 90) {
//					result += (char)(c + 32);
//				} else if(c >= 97 && c <= 122) {
//					result += (char)(c - 32);
//				} else {
//					result += c;
//				}
//			}
//				return result;
//		}

	// 문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
	int count(String words, char word) {
		int count = 0;
		for (int i = 0; i < words.length(); i++) {
			char c1 = words.charAt(i);

			if (word == c1) {
				count++;
			}
		}
		return count;
	}

	// 5개의 정수를 입력받은 후 원하는 인덱스의 값을 구해주는 메소드
		int whereNum(int[] arNum, int index){
			return arNum[index];
		}
		
	// 한글을 정수로 바꿔주는 메소드 (일공이사 -> 1024)
//		changeWord(String word){
//			String hangle = "공일이삼사오육칠팔구"
//					, c = "";
//			for (int i = 0; i < word.length(); i++) {
//				if(word.charAt(i)== hangle); {
//					c += i;
//				}
//			}
//		}
		
	// 5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드
//		int[] maxAndMin(){
//			int[] arData = {3, 8, 11, 7, 5};
//			int max = 0, min = 0;
//			int[] result = new int[2];
//
//			for (int i = 0; i < arData.length; i++) {
//
//				if(max < arData[i]) {max = arData[i];}
//				if(min < arData[i]) {min = arData[i];}
//				
//				max = arData[0];
//				min = arData[0];
//			}
//			
//			for (int i = 0; i < result.length; i++) {
//				result[0] = max;
//				result[1] = min;
//			}
//			return result;
//		}
	// 5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드(void)

	
		
		
		
		
		
		
		
		
		
	// 1~10까지 println()으로 출력하는 메소드
	void printFrom1To10() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
		}
	}

	// "홍길동"을 n번 println()으로 출력하는 메소드
	void printHong(int count) {
		for (int i = 0; i < count; i++) {
			System.out.println("홍길동");
		}
	}

	// 이름을 n번 println()으로 출력하는 메소드
	void printName(String name, int count) {
		for (int i = 0; i < count; i++) {
			System.out.println(name);
		}
	}

	// 세 정수의 뺄셈을 해주는 메소드
	int sub(int number1, int number2, int number3) {
		int result = number1 - number2 - number3;
		return result;
	}

	// 두 정수의 나눗셈 후 몫과 나머지 두 개를 구하는 메소드
	// 두 정수를 입력해야 하니 매개변수를 2개 설정
	int[] div(int number1, int number2) {
		// 몫과 나머지라는 2개의 값을 받기 위해 배열로 변수 설정
		// 분모에 0 이들어가게 되면 null 값을 내보내서 점검한다
		int[] result = null;

		// number2는 분모에 해당하니 분모가 0이 되면 안되기 때문에
		// 조건식에 분모가 0이 아닌 경우를 설정해 놓고 조건식을 돌림
		if (number2 != 0) {
			// 몫과 나머지라는 2개의 값만 필요하기 때문에 
			// 배열 내부는 2개의 값만 있으면 돼서 2개 자릿수 설정
			result = new int[2];
			// 배열의 첫번째 방에는 몫의 값 
			result[0] = number1 / number2;
			// 두번째 방에는 나머지의 값 입력
			result[1] = number1 % number2;
		}
		// 배열로 선정된 변수를 리턴하여 2개의 값 담음
		return result;
	}

	// 1~n까지의 합을 구해주는 메소드
	// n까지의 수이기 때문에 설정을 해줘야 해서 매개변수 설정
	int getTotalFrom1(int end) {
		// 합을 구해야 하기 때문에 합을 집어넣을 변수 설정
		int total = 0;
		// n번까지의 수를 더해야 하기 때문에 for문을 통해 n번까지 반복을 진행
		for (int i = 0; i < end; i++) {
			// total은 수의 합이기 때문에 total의 값과 i의 값을 더해 주는데
			// i는 0부터 시작했기 때문에 1을 더해준다
			total += i + 1;
		}
		// 합을 담은 값을 리턴해주면 합을 구할 수 있다
		return total;
	}

	// 홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
	// 수 하나를 지정해주고 그 수를 짝수나 홀수로 
	// 바꿔주면 되기 때문에 1개를 int값으로 매개변수 지정
	int change(int number) {
		// 홀수이던 짝수이던 각 수에 +1의 값만 되면 
		// 홀수는 짝수로, 짝수는 홀수로 바뀌게 됨
		return ++number;
	}

	// 문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
	// 문자열을 입력받는 것이기 때문에 String 타입으로 매개변수 지정
	String changeToUpperOrLower(String str) {
		// 값을 담아놓을 result 변수 설정
		// 대신 각 값을 계속 지속적으로 연결 하기 위해
		// null 대신 빈 문자열 값을 넣어줌
		String result = "";
		// 문자열의 길이만큼 반복적으로 진행할 예정이기 때문에
		// for문을 통해 반복 횟수 지정
		for (int i = 0; i < str.length(); i++) {
			// c라는 변수에 매개변수에 담은 문자열 값에 있는 
			// 각 문자들을 하나씩 따로 추출함
			char c = str.charAt(i);
			// 추출한 문자마다 대문자라면( 65 <= 아스키 코드 값 <= 90)
			// (대신 JAVA문법에서 가운데에 등호를 둘 수 없기 때문에 논리 연산자를 통해 범위 지정) 
			if (c >= 65 && c <= 90) {
				// 대문자를 소문자의 아스키코드 값으로 맞춰주고 형변환을 통해 다시 문자값으로 바꿔준 뒤
				// result에 집어넣는다
				result += (char)(c + 32);

				// 대문자가 아니라면 조건중에 소문자가 될 수 있기 때문에
				// 마찬가지로 소문자라면 대문자로 바뀔 수 있도록 각 아스키코드 값을 변환 후
			} else if (c >= 97 && c <= 122) {
				// 그 결과값을 c라는 변수에 담는다
				result += (char) (c - 32);

				// 또 예외로 대문자나 소문자에 포함되지 않는 값들은
			} else {
				// 그냥 c에다 담는다
				result += c;
			}
		}
		// 반복이 종료 되었다면 c가 담긴 result를 리턴한다
		return result;
	}

	// 문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
	// 문자열도 입력받고, 원하는 문자도 골라야 하기 때문에 
	// 매개변수가 2개 필요하나, 하나는 문자열, 나머지 하나는 문자 이기 때문에
	// 하나는 String 타입, 나머지 하나는 char 타입으로 지정한다
	int getCount(String str, char c) {
		// 만약 문자열 값 중 내가 찾는 문자가 있다면 그 횟수를 저장할 변수를 설정한다
		int count = 0;
		// 문자열의 길이만큼 문자열 속에서 문자를 찾아봐야 하므로
		// for문을 통해 문자열 길이만큼 반복을 진행한다
		for (int i = 0; i < str.length(); i++) {
			// 만약 반복을 진행하는 중에 i번째 자리에 있는 문자열의 값이
			// 문자값과 일치한다면 count에 횟수를 1씩 증가시킨다
			if (str.charAt(i) == c) {
				count++;
			}
		}
		// count의 수가 곧 같은 문자가 있는 횟수이니 count를 리턴한다
		return count;
	}

	
	// 5개의 정수를 입력받은 후 원하는 인덱스의 값을 구해주는 메소드
	// 5개의 정수를 입력받을때 변수로 선언하면 너무 많아지기 때문에 배열로 선언하며
	// 배열로 선언하며 그 인덱스 값도 또한 받아서 사용할 수 있다
	int getValue(int[] arData, int index) {
		// 배열[인덱스값] > 그 인덱스 번호에서의 배열 속 방의 값
		return arData[index];
	}

	// 한글을 정수로 바꿔주는 메소드(일공이사 -> 1024)
	// 한글을 입력받기 위해 String 타입으로 문자열을 받는다
	int changeToInteger(String hangle) {
		// 문자열을 검사했을때 각 인덱스 번호에 있는 수가 어느 것인지를 체크하기
		String hangleOriginal = "공일이삼사오육칠팔구";
		// 값들을 연결 하기 위해 값을 null이 아닌 빈문자열로 집어넣음
		String result = "";
		// 문자를 입력 받았을때 문자열의 자릿수 만큼 반복을 진행하기 위해 for문 사용
		for (int i = 0; i < hangle.length(); i++) {
			// 결과값에는 그 문자열의 i번째 값에 있는 문자가 어느 위치에 있는지 확인하고
			// 그 값을 받는데 일단 그 숫자들이 어떤 것인지를 계속 누적해야하기 때문에
			// 문자값으로 형변환을 받아서 연결 해나간다
			result += hangleOriginal.indexOf(hangle.charAt(i));
		}
//		result에는 문자열로 값이 들어가 있으니 int타입으로 형변환을 시켜 숫자가 나오게 한다
		return Integer.parseInt(result);
	}

	// 5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드
	// 5개의 정수를 배열 방식으로 입력받기 위해 배열로 선언
	int[] getMaxAndMin(int[] arData) {
		// 최대값과 최소값이 없을 수 없기 때문에 배열을 선언해준다
		int[] result = { arData[0], arData[0] };

		// 배열의 길이 만큼 반복을 진행해야 하기 때문에 for문을 통한 반복
		for (int i = 0; i < arData.length; i++) {
			// 만약 0번째 방에 있는 값이 i번째에 나오는 값보다 작으면
			// 더 큰 값을 0번에 넣어준다
			if (result[0] < arData[i]) {
				result[0] = arData[i];
			}
			// 0번에는 최댓값이 들어있기 때문에 1번 값에 최소값이 들어가는데
			// 1번 값보다 더 작은 값이 있다면 그 값을 1번 방에 넣는다
			if (result[1] > arData[i]) {
				result[1] = arData[i];
			}
		}
		// 배열의 길이가 2개인 배열을 선언했기 때문에 최댓값과 최솟값이 둘 다 들어가 있으며
		// 값이 들어가 있는 result를 리턴해준다
		return result;
	}

	// 5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드(void)
	// 이 영역에서 선언을 하지 않고 다른쪽에서 선언된 배열의 주소값을 가져온다
	void getMaxAndMin(int[] arData, int[] result) {
		
		// 최대 최소값을 result 배열 안에 넣는 작업
		// 값을 받아오기 때문에 받아오면서 이미 적용됨
		result[0] = arData[0];
		result[1] = arData[0];

		// 선언된 배열의 길이만큼 반복해서 진행
		for (int i = 0; i < arData.length; i++) {
			if (result[0] < arData[i]) {
				result[0] = arData[i];
			}
			if (result[1] > arData[i]) {
				result[1] = arData[i];
			}
		}
	}
	
	// indexOf() 만들기
	// 문자열과 문자를 입력받은 뒤 해당 문자가 몇 번 째 인덱스에 있는지 검사하고
	// 만약 해당 문자가 없다면 -1을 리턴한다
		int search(String words, char word){
			// 인덱스 번호를 받을 변수
			int c = 0;
			
			// 문자열의 길이 만큼 반복을 진행해야 전체 문자열에서 그 문자값을 찾음
			for (int i = 0; i < words.length(); i++) {
				
				// 문자열의 i번째에 있는 문자가 검색하고자 하는 word와 같다면
				// c라는 변수에 i라는 인덱스 번호를 받는다
				if(words.charAt(i) == word) {
					c = i;
					break;
				} // 다른 조건 (해당 문자가 전체를 돌았는데 없다면 -1을 반환)
				else {
					c = -1;
				}
			}
			return c;
		}
		
		
		
		
	
	

	public static void main(String[] args) {

		MethodTask methodTask = new MethodTask();
		Scanner sc = new Scanner(System.in);
		
//		methodTask.printFrom1To10();								// 1번째 (1~10까지 합)
//		methodTask.printHong(7);									// 2번째 (홍길동 출력)
//		methodTask.printName("강냉이", 5);							// 3번째 (이름 출력)
//		System.out.println(methodTask.sub(10, 7, 9));				// 4번째 (뺄셈)
		
//		int[] result = methodTask.div(13, 5);						// 5번째 (몫, 나머지)
//		if (result == null) {
//			System.out.println("0으로 나눌 수 없습니다");
//		} else {
//		System.out.println("몫 : " + result[0]);
//		System.out.println("나머지 : " + result[1]);
//		}
		
//		System.out.println(methodTask.getTotalFrom1(100));			// 6번째 (1~n까지 합)
//		System.out.println(methodTask.change(10));					// 7번째 (홀수, 짝수 변환)
//		System.out.println(methodTask.changeToUpperOrLower("aBc"));	// 8번째 (대소문자 변환)
//		System.out.println(methodTask.getCount("HandMade", 'e'));	// 9번째 (문자 찾기)
		
//		int[] arData = {1, 3, 5, 4, 9};								// 10번째 (배열내 인덱스 번호의 값 찾기)
//		System.out.println(methodTask.getValue(arData, 3));			
		
//		System.out.println(methodTask.changeToInteger("팔일공삼칠구"));	// 11번째 (한글로 받은 수를 진짜 수로 바꾸기)
		
//		int[] arData = {0, 11, 3, 8, 4, 7};							// 12번째 (최대값, 최소값)
//		int[] result = methodTask.getMaxAndMin(arData);
//		
//		System.out.println("최대값 : " + result[0]);
//		System.out.println("최소값 : " + result[1]);
		
//		int[] result = new int[2];									// 13번째 (최대값, 최소값 void)
//		int[] arData = {5, 11, 1, 8, 4, 7};			
//		
//		methodTask.getMaxAndMin(arData, result);
//		System.out.println("최대값 : " + result[0]);
//		System.out.println("최소값 : " + result[1]);
		
		int result1 = methodTask.search("Hello", 'l');
		System.out.println(result1);
		
		
		// 질문거리. 주소값을 받아왔다는 것은 이것이 배열이기 때문에 가능한 것인가?
		
		
	}

}
