package stringTest;

public class StringTest {

	public static void main(String[] args) {
		
		String data = "ABCCD";
		
		// ���ڿ��� ����
		System.out.println(data.length());
		// ���ϴ� �ε����� ���� ����
		System.out.println(data.charAt(1));
		// ���ϴ� ������ ��ġ ��ȸ
		System.out.println(data.indexOf('C'));
		
		System.out.println(data.charAt(1) == 'B');
	}
}
