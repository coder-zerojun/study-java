package threadTask;

public class ThreadTest {
	public static void main(String[] args) {

//	�����̳� ���������� 3������ ������ �ִ�
//	�� ������ ���� �Ҹ��� �ٸ��� 2������ ������ ���ÿ� ���.
//	������ 1���� ������ 2���� ������ ��� ��� ���� �������� ���.

//		Runnable runnable = () -> {
//			for (int i = 0; i < 10; i++) {
//				System.out.println(Thread.currentThread().getName());
//				try {Thread.sleep(500);} catch (InterruptedException e){;}
//			}
//		};
		
		// ThreadSet�� run �޼ҵ带 ������ �߰�, run�� Runnalbe �������̽��� ��� �޾��� �� 
		// ����� �� �ִ� �޼ҵ� �̱⿡ ThreadSet�� Runnable Ÿ������ upcasting�� �����ϰ�
		// upcasting�� �޼ҵ�� Thread���� Runnable�� ���� �� �ֱ� ������ ������ε� runnable Ÿ�� ��������� �����ϴ�
		ThreadSet threadSet = new ThreadSet();

		Thread tiger = new Thread(threadSet, "ũ��");
		Thread lion = new Thread(threadSet, "����");
		Thread ruster = new Thread(threadSet, "������");
		
		
		
		for (int i = 0; i < 10; i++) {
			System.out.println(ruster.getName());
		}
		
		tiger.start();
		try {tiger.join();} catch (InterruptedException e) {;}
		lion.start();
		

//	package���� threadTask���� ����� Ŭ������ 2���� �����Ѵ�.
//	�ϳ��� Ŭ�������� main �����尡 �ִ�.
//	Runnable �������̽��� ��Ƽ �����带 �����ϰ� �ݵ�� join()�� ����Ѵ�.
//	�� �� ������ 10������ ���.

//	- �ּ��� �ۼ��Ͽ��°�
//	- Thread�� name�ʵ带 ����� �� �ִ°�
//	- �迭�� ����Ͽ��°�
//	- Ŭ������ �� �� �����Ͽ��°�
//	- ������ : ���ٽ��� ����Ͽ��°�, main �����带 ����Ͽ��°�

	}

}
