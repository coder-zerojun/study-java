package bank;

public class Bank {
	
	// 고객 이름
	private String name;
	// 계좌 번호
	private String account;
	// 전화번호
	private String phoneNumber;
	// 비밀번호
	private String password;
	// 계좌
	private int money;
	
	
	

	public Bank() {;}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
//	입금
	public void deposit(int money) {
		this.money += money;
	}
	
//	출금
	public void withdraw(int money) {
		this.money -= money;
	}
	
//	잔액 조회
	public int showBalance() {
		return money;
	}
	
	// 은행 확인 메소드
	int checkBank(Bank user) {
		int banCk = 0;
		if(user.getAccount().charAt(6) == 'a') {
			banCk = 0;
		} else if (user.getAccount().charAt(6) == 'b') {
			banCk = 1;
		} else if (user.getAccount().charAt(6) == 'c') {
			banCk = 2;
		
		}
		return banCk;
	}
	
	
//	계좌번호 중복검사
	// arrBank(은행, 고객수) : 저장소, arCount : 각 은행당 고객의 수, account : 계좌번호
	// 객체가 필요 없이 그냥 서비스를 이용할 수 있어야 하기 때문에 static을 붙인다
	public static Bank checkAccount(Bank[][] arrBank, int[] arCount, String account) {
		// 중복이 존재하는지 확인하기 위한 것 (배열의 정보를 담기 위해서)
		Bank bank = null;
		// 배열의 첫 번째 행(은행)의 가짓수 만큼 반복 진행
		for (int i = 0; i < arrBank.length; i++) {
			// for문 바깥쪽에서 j라는 변수를 사용하기 위해서 선언
			int j = 0;
			// 각 은행의 고객 수 만큼 반복 진행
			for (j = 0; j < arCount[i]; j++) {
				// 반복을 진행하는데 받은 계좌번호가 있던 계좌번호와 같은게 있으면
				if(arrBank[i][j].getAccount().equals(account)) {
					// 같은 계좌번호를 가지고 있는 사람의 정보를 담는다
					bank = arrBank[i][j];
					break;
				}
			}
			// j가 각 은행의 i번째에 있는 사람의 수와 같지 않으면 탈출
			if(j != arCount[i]) {break;}
		}
		// 만약 해당하는 사람이 있다면 그 사람의 정보를 리턴해줌
		return bank;
	}
	
//	핸드폰 번호 중복 검사
	// arrBank(은행, 고객수) : 저장소, arCount : 각 은행당 고객의 수, phoneNumber : 전화번호
	public static Bank checkPhoneNumber(Bank[][] arrBank, int[] arCount, String phoneNumber) {
		// 중복이 존재하는지 확인하기 위한 것 (배열의 정보를 담기 위해서), 해당하는 사람의 정보를 넘겨주기 위해
		Bank bank = null;
		// 각 은행의 고객 수 만큼 반복 진행
		for (int i = 0; i < arrBank.length; i++) {
			
			int j = 0;
			// 각 은행의 고객 수 만큼 반복 진행
			for (j = 0; j < arCount[i]; j++) {
				// 반복을 진행하는데 받은 전화번호가 있던 전화번호와 같은게 있으면
				if(arrBank[i][j].getPhoneNumber().equals(phoneNumber)) {
					// 같은 전화번호를 가지고 있는 사람의 정보를 담는다
					bank = arrBank[i][j];
					break;
				}
			}
			// j가 각 은행의 i번째에 있는 사람의 수와 같지 않으면 탈출
			if(j != arCount[i]) {break;}
		}
		return bank;
	}
	
//	로그인
	// 은행 DB, 사람 수, 계좌번호, 비밀번호를 모드 체크해야 함
	public static Bank login(Bank[][] arrBank, int[] arCount, String account, String password) {
		// 은행 DB와 은행별 사람 수와 계좌번호를 넘겨야 함
		Bank user = checkAccount(arrBank, arCount, account);
		// 고객이 null이 아닐 때(계좌가 존재할 때)
		if(user != null) {
			// 그 고객의 비밀번호가 같은 것이 확인 됐을 때
			if(user.getPassword().equals(password)) {
				// 그 사용자를 리턴해줌
				return user;
			}
		}
		// 사용자가 없기 때문에 null 반환(아이디 & 비밀번호 둘 다 맞아야 고객임을 확인할 수 있기 때문)
		return null;
	}
}












