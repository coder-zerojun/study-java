package collectionTask;

import java.util.Scanner;

public class Page {

	public static void main(String[] args) {
		
		
		User user = new User();
		User user2 = new User();
		UserField using = new UserField();
		// ���Ϸ� ���� ������ȣ
		String mailNum = ""
				// ���� �޾Ƽ� ���� ������ȣ
				, checkNum = "";
		Scanner sc = new Scanner(System.in);
		
		
		user.setName("�׽�Ʈ");
		user.setId("test");
		user.setPw("test1");
		user.setPhoneNum("01012341234");
		
		user2.setName("ȫ�浿");
		user2.setId("ȫ�浿");
		user2.setPw("ȫ�浿1");
		user2.setPhoneNum("01012341233");
		
		// ȸ������
		
		
		// �α���

		// ��ȣȭ ����
		
		// ���� �߼�
//		mailNum = using.sendMail("01012341234");
//		checkNum = sc.nextLine();
//		if(mailNum.equals(checkNum)) {
//			System.out.println("������ȣ�� Ȯ�εǾ����ϴ�");
//		} else {
//			System.out.println("������ȣ�� �ٸ��ϴ�");
//		}
		
		// ��й�ȣ ����
		
		
	}
}
