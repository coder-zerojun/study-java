package game;


public class Carriage {

	// �뺴���� ������ ������ �ִ� ��
	// �̸�
	private String name;
	// ü��
	private int health;
	// ����
	private String gender;
	// Ÿ�� (��Ŀ, ����, ������)
	private String type;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// �뺴���� Ÿ�� �˻��ϱ�
	void mercType(Carriage[] merc, int typeNum) {
		
		Carriage[] user = null;
		if(merc[typeNum].getType().equals("tanker")) {
			user[0] = merc[typeNum];
		} else if (merc[typeNum].getType().equals("dealer")) {
			
		} else if (merc[typeNum].getType().equals("supporter")) {
		}
	}
	
	
	// ������
	public Carriage() {;}

	// �뺴���� �������� �޾Ƽ� �����ϵ��� �ϱ� ���ؼ�
	public Carriage(String name, int health, String gender, String type) {
		super();
		this.name = name;
		this.health = health;
		this.gender = gender;
		this.type = type;
	}
	
	
}
