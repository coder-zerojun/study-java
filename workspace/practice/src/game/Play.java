package game;

import java.util.Scanner;

public class Play {

	//������ ������ �÷����ϰ� �Ǵ� ��
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String askMessage = "������ �Ͻðڽ��ϱ�? : "
				, menuMessage = "[   1.�뺴���  2. �����ϱ�  3.����Ȯ��  4.��   ]";
		Carriage[] mercanary = {new Carriage("JackDaniel", 75, "male", "tanker"), new Carriage("Dismas", 60, "male", "dealer")
								, new Carriage("Dadario", 45, "female", "supporter"), new Carriage("Rucio", 55, "male", "supporter") };
		Carriage[] userMerc = null;
		// �� Ÿ���� �뺴�� ��� ���� �� �ְ� �ϴ� ��
			
		// �޴����� �����ȣ�� �����ߴ��� �� �� �ִ� ��
		int choice = 0
				// �� ���� �����ߴ��� Ȯ�� �� �� �ִ� ��
				, count = 0
				, typeNum = 0;
		// while�� Ż���� ���� ����
		boolean flag = true;
		
		while(flag) {
			System.out.println(menuMessage);
			System.out.print(askMessage);
			choice = sc.nextInt();
	
			switch (choice) {
			case 1 : 
				System.out.println("���� ����ϰ� �ִ� �뺴�� �� : " + mercanary.length);
				System.out.print("�� ���� �뺴�� ����Ͻðڽ��ϱ�? : ");
				count = sc.nextInt();
					System.out.println("���� Ÿ���� �뺴�� �����Ͻðڽ��ϱ�?");
					System.out.println("[   1.��Ŀ  2.����  3.������   ]");
					typeNum = sc.nextInt();
					int i = 0;
					String nameStack = "";
					for (i = 0; i < mercanary.length ; i++){
						nameStack += mercanary[i].getName() + "   ";
					}
					System.out.println(nameStack);
					
				break;
				
			case 2 :
				break;
				
			case 3 :
				break;
				
			case 4 :
				System.out.println("���̾�~");
				System.out.println("��  !! ������ ����߽��ϴ� !!  ��");
				flag = false;
				break;
			}
		}
	}
}
