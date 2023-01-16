package repeatTest;

public class EtcTest {

	public static void main(String[] args) {
		
		// break 문 사용
		// 이름을 10번 출력하는데 7번째에서 멈춰보게 하기
		// if 문에서 break를 쓰는 것은 if문이 아닌 if문을 감싸고 있는 중괄호를 탈출하는 것이라는 것 확인해보기
//		for (int i = 0; i < 10; i++) {
//			if (i == 7) {
//				System.out.println(i);
//				break;
//			}
//			System.out.println(i+1 + ".ㅇㅇㅇ");
//		}
		
		// 5번 이후 그만나오게 만들기
//		int count = 0;
//		while(true) {
//			System.out.println(count + 1 + "번째");
//			count++;
//			
//			if(count == 5) {
//				break;
//			}
//		}
		
		
		// continue 문 사용해보기
		// 8번째 숫자 넘기고 계속 출력하기
		for (int i = 0; i < 10; i++) {
			if (i == 7) {continue;}
			System.out.println(i + 1 + " 번째 수");
		
		}
		
		
	}
}
