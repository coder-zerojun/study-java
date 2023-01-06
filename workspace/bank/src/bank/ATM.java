package bank;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {

		// ����� ���� ������ ������� ��
		Bank[][] arrBank = new Bank[3][100];
		// ����� ���� ��
		int[] arCount = new int[3];
		// � ������ ������ ������ ������ ��� ���� �迭
		Bank[] arBank = null;

		final int ACCOUNT_LENGTH = 6;

		String message = "1. ��������\n2. ��������\n3. īī����ũ\n4.������";
//		���°���, �Ա��ϱ�, ����ϱ�, �ܾ���ȸ, ���¹�ȣ ã��(���ο� ���¹߱�, �ڵ��� ��ȣ�� ���� �̿밡��), ������
		String menu = "1. ���°���\n2. �Ա��ϱ�\n3. ����ϱ�\n4. �ܾ���ȸ\n5. ���¹�ȣ ã��\n6. ���� �ٽ� ����";
		Scanner sc = new Scanner(System.in);
		// index ���� �������� ����(�� �� ° ��������), choice = �� �������� �����ϴ� ��
		int index = 0, choice = 0, money = 0;
		String account = "", phoneNumber = null, password = null;
		// ������ ����ϱ� ���ؼ�
		Random random = new Random();
		// user : �������� ������ ����ִ� ���� , userCheck : ���� �������� �ߺ����� Ȯ���ϱ� ���� ����ϴ� ����, bankChk : 
		Bank user = null, userCheck = null;
		boolean flag = true;

		while (true) {
//			� ������ �� ������ ������ �����Ѵ�.
			System.out.println(message);
//			�ε��� ���� �Է¹޴´�
			index = sc.nextInt();
			// 4���� ����� �� ������ ����� ���� ������ ������ �����ϸ� �ٷ� ������ �ȴ�
			if (index == 4) {
				break;
			} // ������ ������ ������ while�� ��� Ż��!
			index--; // �� ��° �������� �ε��� ��ȣ�� �� �Ŷ� 1�� ���ش�.

			// �޴��߿��� ����� �� �޴��� �����ϱ� ������ ��� �ݺ�
			while (true) {
				System.out.println(menu);
//				System.out.println(arrBank[0][0]);
//				System.out.println(arrBank[0]);
				System.out.println(arCount[0]);
				System.out.println(arCount[1]);
				// ������� ������ ���� choice�� ��� ���´�
				choice = sc.nextInt();
				// 6�� �޴�(�ٸ� ���� ����)�� ������ �Ǹ� while���� Ż���Ѵ�
				if (choice == 6) {
					break;
				}
				// �޴��߿��� 1���� ������ ��
				if (choice == 1) { // ���� ����

					// � ���¸� ������ �������� �޾Ƴ��� ��, ���� ���� ���� �� ���� (���¸� ������ ������ ������)
					arBank = new Bank[] { new Shinhan(), new Kookmin(), new KaKao() };
//					account = "";
					// ���¸� ������ ���࿡���� �Ա� ���� '���¹�ȣ�� ���� �������� ǥ��'

					// while���� ���� ���� ��� �ݺ��ؼ� ����
					while (true) {
						// ���¹�ȣ�� 6�ڸ��� ������ �ֱ� ������ Ȥ�ó� �������� ���� 6�̶�� �ڸ����� ��Ƴ��� ����Ѵ�
						for (int i = 0; i < ACCOUNT_LENGTH; i++) {
							// ���¹�ȣ�� �������� ��ȣ �ο��ϱ� (������ ��ȣ�� 0~9����)
							account += random.nextInt(10);
						}
//						if (index == 0) {
//							account += "a";
//						} else if (index == 1) {
//							account += "b";
//						} else if (index == 2) {
//							account += "c";
//						}

						// ���¹�ȣ �ߺ�üũ
						userCheck = Bank.checkAccount(arrBank, arCount, account);
						// �ߺ��� ���� ��� while�� Ż��
						if (userCheck == null) {
							break;
						}
					}
					// arBank�� index�� ���࿡
					user = arBank[index];
					
					account = index + account;

					
					// �����ְ� �ް� �� ���� ��ȣ�� ����ִ´�
					user.setAccount(account);
					// ���¹�ȣ �ʱ�ȭ
					account = "";
//					System.out.println(account);

					System.out.print("������: ");
					user.setName(sc.next());
					arBank[index] = user;

					while (true) {
						System.out.print("�ڵ��� ��ȣ['-' ����]: ");
						// �ڵ��� ��ȣ�� �Է¹޴´�
						phoneNumber = sc.next();

						// ��ȭ��ȣ�� �޾��� �� �� �ȿ� - �� ������ �� ������ �ٲ��ֱ�
						// replaceAll �� �ϰ� �ٷ� �� ���� ����ϴ°� �ƴ϶� �� ���� �ٽ� �־��ش�
						phoneNumber = phoneNumber.replaceAll("-", "");
						// ��ȭ��ȣ�� ���̰� 11�̶��
						if (phoneNumber.length() == 11) {
							// ��ȭ��ȣ�� 010���� �����ؾ߸� �ϴ� ����
							if (phoneNumber.startsWith("010")) {
								// ��ȭ��ȣ �ߺ� üũ
								userCheck = Bank.checkPhoneNumber(arrBank, arCount, phoneNumber);
								// �ߺ��� ���ٸ� while�� Ż��
								if (userCheck == null) {
									break;
								}
							}
						}
						System.out.println("�߸��� �ڵ��� ��ȣ�Դϴ�.");
					}
					// �ߺ��� ���ٸ� �ڵ��� ��ȣ�� �ٽ� ���� �ִ´�
					user.setPhoneNumber(phoneNumber);

					// ��й�ȣ ����
					while (true) {
						System.out.print("��й�ȣ[4�ڸ�]: ");
						// ��й�ȣ �Է¹ޱ�
						password = sc.next();
						// ��й�ȣ�� 4�ڸ��� �ǵ��� ���ǹ� �ۼ�
						if (password.length() == 4) {
							break;
						}
						System.out.println("��й�ȣ�� 4�ڸ��� �������ּ���.");
					}
					// while�� ������ ���������� ��й�ȣ�� ����ִ´�
					user.setPassword(password);

					// ���� DB�� index��°�� ���࿡ ������ �ִ� arCount�� index��°�� �濡 ȸ���� ������ ����ִ´�
					arrBank[index][arCount[index]] = user;
					// �����࿡ ���� ������ �ϰ� ������ arCount�� index�� ���࿡ �ִ� ���� ���� ������Ų��
					arCount[index]++;
					System.out.println("ȯ���մϴ� " + user.getName() + " ����, ���°����� �Ϸ�Ǿ����ϴ�.");
					System.out.println("���¹�ȣ: " + user.getAccount());
//					System.out.println(arBank[0].getName());
//					System.out.println(arBank[1].getName());

					continue;

				}

				else if (choice == 5) { // ���¹�ȣ ã��
					System.out.print("�ڵ��� ��ȣ: ");
					// ��ȭ��ȣ �Է¹ޱ�
					phoneNumber = sc.next();
					// ���࿡�� �ڵ��� ��ȣ�� ���� �˻��ϴ� ��
					user = Bank.checkPhoneNumber(arrBank, arCount, phoneNumber);
					// �����ְ� �����Ѵٸ�
					if (user != null) {
						System.out.print("��й�ȣ: ");
						// ��й�ȣ �Է¹ޱ�
						password = sc.next();

						// ���� ���� ��, �� �ڵ尡 ������ �ٽ� ���¹�ȣ�� ����� ���� �ִ� ���¹�ȣ�� ���¹�ȣ�� ������
						account = "";
						// ������ ������ ����� �ִ� ��й�ȣ�� �Է��� ��й�ȣ�� ���ٸ�
						if (user.getPassword().equals(password)) {
							while (true) {
								// ���Ӱ� ���¸� �߱޹���
								for (int i = 0; i < ACCOUNT_LENGTH; i++) {
									account += random.nextInt(10);
								}
//								if (index == 0) {
//									account += "a";
//								} else if (index == 1) {
//									account += "b";
//								} else if (index == 2) {
//									account += "c";
//								}

								userCheck = Bank.checkAccount(arrBank, arCount, account);
								if (userCheck == null) {
									break;
								}
							}
							System.out.println("���ο� ���¹�ȣ�� ����Ǿ����ϴ�.");
							System.out.println("���¹�ȣ: " + account);
							account = user.getAccount().charAt(0) + account;
							// ���� ���� ���¹�ȣ�� �ٽ� ����־� �ش�
							user.setAccount(account);
						}
					} else {
						System.out.println("���� �ڵ��� ��ȣ�Դϴ�.");
					}
					continue;
				}

//				flag = true;
//				while (flag) {
//					System.out.println("� �����̽��� �������ּ���");
//					System.out.println(message);
//					index = sc.nextInt();
//					if (index == 4) {
//						break;
//					} // ������ ������ ������ while�� ��� Ż��!
//					index--; // �� ��° �������� �ε��� ��ȣ�� �� �Ŷ� 1�� ���ش�.
//					if (user.checkBank(user) == index) {

						System.out.print("���¹�ȣ: ");
						account = sc.next();

						System.out.print("��й�ȣ: ");
						password = sc.next();

//					} else {
//						System.out.println("������ �߸� �����߽��ϴ�");
//						break;
//					}
					// �α����� �� �� �� ���࿡ �ִ� �������� ������ �����ֿ� ����ִ´�
					user = Bank.login(arrBank, arCount, account, password);
					
					switch (choice) {
					case 2: // �Ա��ϱ�
						// �����ְ� �����Ѵٸ�
						if (user != null) {
							 if(!user.getAccount().startsWith(index + "")) {
			                     System.out.println("���¹�ȣ�� ������ ���࿡���� �Ա� ���� �̿��� �����մϴ�.");
			                     break;
			                  }

							System.out.print("�Աݾ�: ");
							// �Ա��� �� �Է�
							money = sc.nextInt();
							// �Ա��� ���� 0������ ���ƾ�
							if (money > 0) {
								// ���� �Ա��� �� ����
								user.deposit(money);
								System.out.println(money + "�� �Ա� �Ϸ�");
								flag = false;
								break;
							} else {
								System.out.println("�Աݾ��� �ٽ� Ȯ�����ּ���.");
							}
						} else {
							// ������ ������ �α��ο� ������
							System.out.println("�α��� ����");

						}
						break;

					case 3: // ����ϱ�
						if (user != null) {
							System.out.print("��ݾ�: ");
							money = sc.nextInt();
							if (money > 0) {
								// �� ���� �ܰ� ������ �ִ� ������ �۰ų� ���� ���� ����(���� �����̶�� �����ᰡ 50%�� ����)
								// �����ְ� ���������� �ÿ� �ƴ� �ø� ����
								// ���� �����ڰ� ���� �����ں��� �켱������ ���Ǳ� ������ ()�� �켱������ ����
								if (user.getMoney() >= (user instanceof Kookmin ? money * 1.5 : money)) {
									// ����� �� ����
									user.withdraw(money);
									flag = false;
								} else {
									System.out.println("��ݾ��� �ٽ� Ȯ�����ּ���.");
									break;
								}
							}
						} else {
							System.out.println("�α��� ����");
						}
						break;
					case 4: // �ܾ� ��ȸ
						// �������� ������ �����Ѵٸ� (null�� �ƴ϶��)
						if (user != null) {
							System.out.println("���� �ܾ�: " + user.showBalance());
							flag = false;
						} else {
							System.out.println("�α��� ����");
						}
						break;
					}
//				}
			}
		}
	}
}
