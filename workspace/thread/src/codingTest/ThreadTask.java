package codingTest;

public class ThreadTask implements Runnable {
	
	
	public ThreadTask() {;}

	public void printFirst(Runnable first) {
		first.run(); // ���� ����
	}

	public void printSecond(Runnable second) {
		second.run(); // ���� ����
	}

	public void printThird(Runnable third) {
		third.run(); // ���� ����
	}

	@Override
	public void run() {
		
	}

	
	
	
}
