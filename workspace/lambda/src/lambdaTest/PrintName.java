package lambdaTest;

@FunctionalInterface
public interface PrintName {
	// ���� �̸��� �Է¹޴� �޼ҵ�, �� ���� �Ѱ��ֱ� ���� String Ÿ��  
	public String getFullName(String firstName, String lastName);
}
