package repeatTest;

public class EtcTest {

	public static void main(String[] args) {
		
		// break �� ���
		// �̸��� 10�� ����ϴµ� 7��°���� ���纸�� �ϱ�
		// if ������ break�� ���� ���� if���� �ƴ� if���� ���ΰ� �ִ� �߰�ȣ�� Ż���ϴ� ���̶�� �� Ȯ���غ���
//		for (int i = 0; i < 10; i++) {
//			if (i == 7) {
//				System.out.println(i);
//				break;
//			}
//			System.out.println(i+1 + ".������");
//		}
		
		// 5�� ���� �׸������� �����
//		int count = 0;
//		while(true) {
//			System.out.println(count + 1 + "��°");
//			count++;
//			
//			if(count == 5) {
//				break;
//			}
//		}
		
		
		// continue �� ����غ���
		// 8��° ���� �ѱ�� ��� ����ϱ�
		for (int i = 0; i < 10; i++) {
			if (i == 7) {continue;}
			System.out.println(i + 1 + " ��° ��");
		
		}
		
		
	}
}
