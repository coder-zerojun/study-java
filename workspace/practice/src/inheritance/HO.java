package inheritance;

import java.util.Iterator;
import java.util.Scanner;

public class HO {

	// (����������) �뺴 ����
	// ��ȣ �߿��� �ο��� ����ٸ� �� �ο��� ������ ����ش�
	
	// �����ϱ�

	// ���� Ȯ���ϱ�(�ǹ� �Ǽ�)

	public static void main(String[] args) {

		HO ho = new HO();
		Carriage car = new Carriage();
		// �뺴���� ������ ��Ƴ��� DB
		Carriage[][] arrMerc = new Carriage[3][20];
		// �뺴���� ���� � ������ ������ �ִ��� ���� �迭
		Carriage[] mercanary = { new Carriage("JackDaniel", 60, "male", "tanker"),
				new Carriage("Dismas", 40, "male", "dealer"), new Carriage("Dadario", 30, "female", "dealer"),
				 new Carriage("Dormamu", 50, "male", "supporter"), new Carriage("Duna", 40, "female", "tanker"), };
		// �� Ÿ���� �뺴���� �� �� �ִ��� �˱� ����
		int[] mercNum = new int[3];
		// �뺴���� � Ÿ�������� ��Ƴ��� �迭
		Carriage[] whatType = null;
		Carriage mercType = null;
		
		String menuMessage = "[  1. �뺴 �����ϱ� 2. ���� ������ 3. ���� Ȯ���ϱ� 4. �� ��  ]", askMessage = "������ �Ͻðڽ��ϱ�? : ";
		Scanner sc = new Scanner(System.in);

		// �ο� �̱�
		int choice = 0
		// �� �� ��
				, a = 0
				// Ƚ�� Ȯ�ο�
				, count = 0
				// � Ÿ���� ������ ����
				, typeCount = 0;
		// Ż���
		boolean flag = false;

		while (true) {

			System.out.println(menuMessage);
			System.out.print(askMessage);
			choice = sc.nextInt();

			switch (choice) {

			case 1: // �뺴�� �̱� ���� switch��

				// �� ���� ���� ������ ����
				System.out.print("�� ���� ��� �Ͻðڽ��ϱ�? : ");
				choice = sc.nextInt();
				System.out.println(choice + "�� �̰ڽ��ϴ�\n");
				while (choice > count) {
					System.out.println("� Ÿ���� �뺴�� ����Ͻðڽ��ϱ�?");
					System.out.println("[   1.��Ŀ  2.����  3.������   ]");
					typeCount = sc.nextInt();
					
					whatType = new Carriage[] {new Tanker(), new Dealer(), new Supporter()};
					
					switch (typeCount) {
						
					case 1:
						car.mercType(mercanary, arrMerc, mercNum);
						for (int i = 0; i < mercNum[0]; i++) {
							System.out.println(i+1 + ". " + arrMerc[0][i].getName());
						}
						break;
						
					case 2: 
						car.mercType(mercanary, arrMerc, mercNum);
						for (int i = 0; i < mercNum[1]; i++) {
							System.out.println(i+1 + ". " + arrMerc[1][i].getName());
						}
						break;
						
					case 3:
						car.mercType(mercanary, arrMerc, mercNum);
						for (int i = 0; i < mercNum[2]; i++) {
							System.out.println(i+1 + ". " + arrMerc[2][i].getName());
						}
						break;
					}
										
					System.out.println("�� �̾��ּ��� ��\n");

					// � �뺴�� ���� ������ ����
					// �迭���� ��ü ���� �������� �� ��������..?
					a = sc.nextInt();
//					if (mercanary[0].name == "" && mercanary[1].name == "" && mercanary[2].name == ""
//							&& mercanary[3].name == "") {
//						System.out.println("�뺴���� �����ϴ�");
//						break;
//					} else {
//						// ���� 1���� ���� 1�� �ڸ��� �ִ� �뺴�� �������� �ڿ� �濡 �ִ� �뺴���� �̸��� �� �ڸ��� ä���
//						switch (a) {
//
//						case 1:
//							if (stageCoach.nameCheck(mercanary, a) == 1) {
//								System.out.println("�뺴�� �ڸ��� ������ϴ�");
//								break;
//							}
//							System.out.println(mercanary[a - 1].name + "�� �����ϼ̽��ϴ�\n");
//							for (int i = 0; i < mercanary.length - 4; i++) {
//								mercanary[i] = mercanary[i + 1];
//							}
//							count++;
//							break;
//
//						case 2:
//							if (Carriage.nameCheck(mercanary, a) == 2) {
//								System.out.println("�뺴�� �ڸ��� ������ϴ�");
//								break;
//							}
//							System.out.println(mercanary[a - 1].name + "�� �����ϼ̽��ϴ�\n");
//							for (int i = 1; i < mercanary.length - 4; i++) {
//								mercanary[i] = mercanary[i + 1];
//							}
//							count++;
//							break;
//
//						case 3:
//							if (stageCoach.nameCheck(mercanary, a) == 3) {
//								System.out.println("�뺴�� �ڸ��� ������ϴ�");
//								break;
//							}
//							System.out.println(mercanary[a - 1].name + "�� �����ϼ̽��ϴ�\n");
//							for (int i = 2; i < mercanary.length - 4; i++) {
//								mercanary[i] = mercanary[i + 1];
//							}
//							count++;
//							break;
//
//						case 4:
//							if (stageCoach.nameCheck(mercanary, a) == 4) {
//								System.out.println("�뺴�� �ڸ��� ������ϴ�");
//								break;
//							}
//							System.out.println(mercanary[a - 1].name + "�� �����ϼ̽��ϴ�\n");
//							for (int i = 3; i < mercanary.length - 4; i++) {
//								mercanary[i] = mercanary[i + 1];
//							}
//							count++;
//							break;
//						default:
//							System.out.println("�߸��� �����Դϴ�");
//							break;
//						}
					}

				
				count = 0;
				break;

			case 2: // ���� ������
				System.out.println("���� �Բ� ���� �뺴�� ������ �ֽʽÿ�");
				System.out.println(car);
				break;

			case 3:
				break;

			case 4:
				System.out.println("���Ͼ�~");
				flag = true;
				break;
			}

			if (flag) {
				break;
			}
		}
	}
}
