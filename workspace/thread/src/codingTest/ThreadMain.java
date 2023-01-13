package codingTest;

import java.util.Scanner;

public class ThreadMain {
	public static void main(String[] args) {
		
		// 1을 입력하면 first라는 메소드가 발동, 2를 입력하면 second라는 메소드가 발동
		Runnable runNumber = () -> {};
		
		Scanner sc = new Scanner(System.in);
		ThreadMain threadMain = new ThreadMain();
		ThreadTask threadTask = new ThreadTask();
		
		// 제한시간 : 1시간
		// 3개의 쓰레드가 있다.
		// Thread1, Thread2, Thread3
		Thread Thread1 = new Thread();
		Thread Thread2 = new Thread();
		Thread Thread3 = new Thread();
		
		// 사용자가 입력한 순서대로 각 알맞는 문자열이 출력된다.
		// 입력 예) 3 1 2
		// 출력 예) third first second
		// 단, Thread들은 항상 1, 2, 3 순서로 실행되어야 한다.
		int a = sc.nextInt();
		
		
		Thread1.run();
		try {Thread1.join();} catch (InterruptedException e) {;}
		Thread2.run();
		try {Thread2.join();} catch (InterruptedException e) {;}
		Thread3.run();
		
		
		
		// Thread1 : third
		// Thread2 : first
		// Thread3 : second
		
		// 출력 시 쓰레드의 번호도 출력할 경우 가산점으로 처리한다.
	}

}
