package arrayTest;

import java.util.Scanner;

//import jdk.internal.misc.FileSystemOption;

public class ArTask2 {

	public static void main(String[] args) {

		// �� ��ư�� ������ ��, �̵��ϴ� �������� ������ ����
		// btn1 : ȸ������ ������
		// btn2 : �α��� ������
		// btn3 : ���� ������

		// ȸ������ -> �α��� -> ����������
		// �� ������� �Է��ؾ� �ϸ�, ���� �����ܰ踦 �����ϱ� ���� ���� �ܰ� ��ư�� ������,
		// �����ܰ迡 ���� �޼����� ������ش�
		// ex) �α��� Ŭ�� �� -> ȸ�������� ���� �������ּ���

		// �˸��� �ܰ��� ��ư�� ������, �ش� �ܰ迡 ���� �޼����� ���
		// ex) ȸ������ Ŭ�� ��, ȸ������ ����
		// ���� ������ Ŭ�� ��, ���� �̸��� ���� ���

//		String msg1 = "��ư�� �����ּ���", msg2 = "btn1: ȸ������ ������ \nbtn2: �α��� ������ \nbtn3: ���� ������ \nbtn4: ����";
//
//		int btn = 0, check = 0;
//
//		String[] arBtn = { "btn1", "btn2", "btn3" }, btMsg = { "ȸ������ ����", "�α��� ����", "�̸� : ������ \n���� : 00��" },
//				erMsg = { "ȸ�������� ���� ������ �ּ���", "�α����� ���� �������ּ���" };
//		String psMsg = "4���� ������ �������ϴ�", result = null;
//		Scanner sc = new Scanner(System.in);
//
////		// �ݺ� Ƚ���� �𸣱� ������ �ش� ������ ������ ������ �ݺ��ؾ� ��
//		while (btn != 4) {
//			System.out.println(msg1);
//			System.out.println(msg2);
//			btn = sc.nextInt();
//
//			// �� ��ȣ�� �´� �޼��� ���
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
		String[] arMessage = { "ȸ������ ����", "�α��� ����", "�ѵ���(20)", "�α׾ƿ� ����" };
		String[] arError = { "ȸ�������� ���� �������ּ���.", "�α����� ���� �������ּ���" };
		String errorMessage = "�ٽ� �õ����ּ���", result = null;

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

		
		
		
		
////      ��ư �迭
//		String[] arButton = { "btn1", "btn2", "btn3", "btn4" };
////      ���� �޼��� �迭
//		String[] arMessage = { "ȸ������ ����", "�α��� ����", "�ѵ���(20)", "�α׾ƿ� ����" };
////      ���� �޼��� �迭
//		String[] arError = { "ȸ�������� ���� �������ּ���.", "�α����� ���� �������ּ���" };
////      ���� �޼���
//		String errorMessage = "�ٽ� �õ����ּ���";
//
////      Scanner sc = new Scanner(System.in);
////      choice : ����ڰ� �Է��� ��ȣ, temp : ����ڰ� ������ �Է��� ��ȣ
//		int choice = 0, temp = 0;
//		boolean condition = false;
//
//		while (true) {
////         �޴� ���
//			for (int i = 0; i < arButton.length; i++) {
//				System.out.println(i + 1 + "." + arButton[i]);
//			}
//
////         ���� temp�� 0�� ����ִٸ�, 0�� �����ؾ� �Ѵ�.
//			temp = temp == 0 ? 0 : choice;
////         ����ڰ� ������ ��ư ��ȣ
//			choice = sc.nextInt();
////         ��ư ��ȣ �̿��� ��ȣ�� �Է����� ��� ���� �޼��� ���
//			if (choice < 1 || choice > 4) {
//				System.out.println(errorMessage);
//				continue;
//			}
////         �α׾ƿ� �� ���α׷� ����
//			if (choice == 4) {
//				System.out.println(arMessage[choice - 1]);
//				break;
//			}
//
////         ����ڰ� ������ ��ư�� ��ȣ - 1�� ������ ����ڰ� �Է��� ��ȣ�� ���� �� ��
////         �� �ܰ踦 ���� �ߴ� �� �˻�
//			condition = choice - 1 == temp;
//
//			if (!condition) { // �� �ܰ踦 ������ ���
//				temp = 0; // ȸ�����Ժ��� �����϶�� ��.
//				System.out.println(arError[choice - 2]);
//				continue;
//			}
//			// �� �ܰ踦 �������� ���
//			System.out.println(arMessage[choice - 1]);
//			if (choice == 3) { // ���� �������� �������� ������
//				temp = 0; // ȸ�����Ժ��� �����϶�� ��.
//				continue;
//			}
////         ���� ������ �̿��� ���񽺸� �̿����� ��� �Է��ߴ� ��ȣ�� temp�� �����Ѵ�.
//			temp = choice;
//
//		}

	}
}
