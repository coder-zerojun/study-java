package stringTest;

public class StringTest {

	public static void main(String[] args) {
		
		String data = "ABCCD";
		
		// 문자열의 길이
		System.out.println(data.length());
		// 원하는 인덱스의 문자 추출
		System.out.println(data.charAt(1));
		// 원하는 문자의 위치 조회
		System.out.println(data.indexOf('C'));
		
		System.out.println(data.charAt(1) == 'B');
	}
}
