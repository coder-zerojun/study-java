package exceptionTest;

public class BadWordException extends Exception {
	
	// Exception ��� : �����Ϸ��� üũ
	// RuntimeException ��� : �����Ϸ��� üũ���� ����
	public BadWordException(String message) {
		super(message);
	}
}
