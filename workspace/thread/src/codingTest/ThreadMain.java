package codingTest;

import java.util.Scanner;

public class ThreadMain {
	public static void main(String[] args) {
		
		// 1�� �Է��ϸ� first��� �޼ҵ尡 �ߵ�, 2�� �Է��ϸ� second��� �޼ҵ尡 �ߵ�
		Runnable runNumber = () -> {};
		
		Scanner sc = new Scanner(System.in);
		ThreadMain threadMain = new ThreadMain();
		ThreadTask threadTask = new ThreadTask();
		
		// ���ѽð� : 1�ð�
		// 3���� �����尡 �ִ�.
		// Thread1, Thread2, Thread3
		Thread Thread1 = new Thread();
		Thread Thread2 = new Thread();
		Thread Thread3 = new Thread();
		
		// ����ڰ� �Է��� ������� �� �˸´� ���ڿ��� ��µȴ�.
		// �Է� ��) 3 1 2
		// ��� ��) third first second
		// ��, Thread���� �׻� 1, 2, 3 ������ ����Ǿ�� �Ѵ�.
		int a = sc.nextInt();
		
		
		Thread1.run();
		try {Thread1.join();} catch (InterruptedException e) {;}
		Thread2.run();
		try {Thread2.join();} catch (InterruptedException e) {;}
		Thread3.run();
		
		
		
		// Thread1 : third
		// Thread2 : first
		// Thread3 : second
		
		// ��� �� �������� ��ȣ�� ����� ��� ���������� ó���Ѵ�.
	}

}
