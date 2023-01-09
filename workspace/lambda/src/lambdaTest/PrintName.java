package lambdaTest;

@FunctionalInterface
public interface PrintName {
	// 성과 이름을 입력받는 메소드, 들어간 값을 넘겨주기 위해 String 타입  
	public String getFullName(String firstName, String lastName);
}
