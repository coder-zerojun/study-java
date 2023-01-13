package threadTest;

public class Thread2 implements Runnable {

	public String hard;
	
	public Thread2() {;}

	public Thread2(String hard) {
		this.hard = hard;
	}


	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
			try {Thread.sleep(500);} catch (InterruptedException e) {;}
		}
	}

}
