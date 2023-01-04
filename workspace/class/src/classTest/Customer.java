package classTest;

public class Customer {

//	이름
	String name;
//	휴대폰번호
	String phoneNum;
//	통장잔고
	int bank;
//	할인율
	int sail;


	// 고객 정보로 이름, 통장잔고, 할인율을 조회가능하게 만듬
	public Customer(String name, String phoneNum, int bank, int sail) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.bank = bank;
		this.sail = sail;
	}
	
		
		

}
