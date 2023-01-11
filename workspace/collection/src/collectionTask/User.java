package collectionTask;

public class User {

	// 이름
	private String name;
	// 아이디
	private String id;
	// 비밀번호
	private String pw;
	// 전화번호
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
	
	// 생성자
	public User() {;}
	
	
	@Override
	public String toString() {
		return "[이름=" + name + ", 아이디=" + id + ", 비밀번호=" + pw + ", 전화번호=" + phoneNum + "]";
	}
	
	
	
	
	
	
}
