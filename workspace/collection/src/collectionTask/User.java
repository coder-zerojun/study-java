package collectionTask;

public class User {

	// �̸�
	private String name;
	// ���̵�
	private String id;
	// ��й�ȣ
	private String pw;
	// ��ȭ��ȣ
	private String phoneNum;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	// ������
	public User() {;}
	
	
	@Override
	public String toString() {
		return "[�̸�=" + name + ", ���̵�=" + id + ", ��й�ȣ=" + pw + ", ��ȭ��ȣ=" + phoneNum + "]";
	}
	
	
	
	
	
	
}
