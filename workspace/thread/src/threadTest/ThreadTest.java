package threadTest;

public class ThreadTest {
	public static void main(String[] args) {
		
		
//		Thread2 thread = new Thread2();
		Runnable target = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
				try {Thread.sleep(500);} catch (InterruptedException e) {;}
			}
		};
		
		Thread2 t2 = new Thread2();
		Thread t1 = new Thread(t2, "!");
//		Thread t2 = new Thread(target, "?");
//		Thread t3 = new Thread(target, "%");
//		
//		// 메인 쓰레드
//		for (int i = 0; i < 10; i++) {
//			System.out.println(t3.getName());
//		}
//		
		t1.start();
		
//		t1.start();
//		
//		try {t1.join();} catch (InterruptedException e) {;}
//		
//		t2.start();
		

		
//		Thread1 t1 = new Thread1("♥");
//		Thread1 t2 = new Thread1("★");
		
		
//		t1.start();
//		t2.start();
		
//		t1.run();
//		t2.run();
		
		
		
	}
}
