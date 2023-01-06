package bank;

public class Bank {
	
	// �� �̸�
	private String name;
	// ���� ��ȣ
	private String account;
	// ��ȭ��ȣ
	private String phoneNumber;
	// ��й�ȣ
	private String password;
	// ����
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
	
//	�Ա�
	public void deposit(int money) {
		this.money += money;
	}
	
//	���
	public void withdraw(int money) {
		this.money -= money;
	}
	
//	�ܾ� ��ȸ
	public int showBalance() {
		return money;
	}
	
	// ���� Ȯ�� �޼ҵ�
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
	
	
//	���¹�ȣ �ߺ��˻�
	// arrBank(����, ����) : �����, arCount : �� ����� ���� ��, account : ���¹�ȣ
	// ��ü�� �ʿ� ���� �׳� ���񽺸� �̿��� �� �־�� �ϱ� ������ static�� ���δ�
	public static Bank checkAccount(Bank[][] arrBank, int[] arCount, String account) {
		// �ߺ��� �����ϴ��� Ȯ���ϱ� ���� �� (�迭�� ������ ��� ���ؼ�)
		Bank bank = null;
		// �迭�� ù ��° ��(����)�� ������ ��ŭ �ݺ� ����
		for (int i = 0; i < arrBank.length; i++) {
			// for�� �ٱ��ʿ��� j��� ������ ����ϱ� ���ؼ� ����
			int j = 0;
			// �� ������ �� �� ��ŭ �ݺ� ����
			for (j = 0; j < arCount[i]; j++) {
				// �ݺ��� �����ϴµ� ���� ���¹�ȣ�� �ִ� ���¹�ȣ�� ������ ������
				if(arrBank[i][j].getAccount().equals(account)) {
					// ���� ���¹�ȣ�� ������ �ִ� ����� ������ ��´�
					bank = arrBank[i][j];
					break;
				}
			}
			// j�� �� ������ i��°�� �ִ� ����� ���� ���� ������ Ż��
			if(j != arCount[i]) {break;}
		}
		// ���� �ش��ϴ� ����� �ִٸ� �� ����� ������ ��������
		return bank;
	}
	
//	�ڵ��� ��ȣ �ߺ� �˻�
	// arrBank(����, ����) : �����, arCount : �� ����� ���� ��, phoneNumber : ��ȭ��ȣ
	public static Bank checkPhoneNumber(Bank[][] arrBank, int[] arCount, String phoneNumber) {
		// �ߺ��� �����ϴ��� Ȯ���ϱ� ���� �� (�迭�� ������ ��� ���ؼ�), �ش��ϴ� ����� ������ �Ѱ��ֱ� ����
		Bank bank = null;
		// �� ������ �� �� ��ŭ �ݺ� ����
		for (int i = 0; i < arrBank.length; i++) {
			
			int j = 0;
			// �� ������ �� �� ��ŭ �ݺ� ����
			for (j = 0; j < arCount[i]; j++) {
				// �ݺ��� �����ϴµ� ���� ��ȭ��ȣ�� �ִ� ��ȭ��ȣ�� ������ ������
				if(arrBank[i][j].getPhoneNumber().equals(phoneNumber)) {
					// ���� ��ȭ��ȣ�� ������ �ִ� ����� ������ ��´�
					bank = arrBank[i][j];
					break;
				}
			}
			// j�� �� ������ i��°�� �ִ� ����� ���� ���� ������ Ż��
			if(j != arCount[i]) {break;}
		}
		return bank;
	}
	
//	�α���
	// ���� DB, ��� ��, ���¹�ȣ, ��й�ȣ�� ��� üũ�ؾ� ��
	public static Bank login(Bank[][] arrBank, int[] arCount, String account, String password) {
		// ���� DB�� ���ະ ��� ���� ���¹�ȣ�� �Ѱܾ� ��
		Bank user = checkAccount(arrBank, arCount, account);
		// ���� null�� �ƴ� ��(���°� ������ ��)
		if(user != null) {
			// �� ���� ��й�ȣ�� ���� ���� Ȯ�� ���� ��
			if(user.getPassword().equals(password)) {
				// �� ����ڸ� ��������
				return user;
			}
		}
		// ����ڰ� ���� ������ null ��ȯ(���̵� & ��й�ȣ �� �� �¾ƾ� ������ Ȯ���� �� �ֱ� ����)
		return null;
	}
}












