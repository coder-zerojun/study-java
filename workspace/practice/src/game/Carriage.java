package game;


public class Carriage {

	// 용병들의 정보를 가지고 있는 곳
	// 이름
	private String name;
	// 체력
	private int health;
	// 성별
	private String gender;
	// 타입 (탱커, 딜러, 서포터)
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

	// 용병들의 타입 검사하기
	void mercType(Carriage[] merc, int typeNum) {
		
		Carriage[] user = null;
		if(merc[typeNum].getType().equals("tanker")) {
			user[0] = merc[typeNum];
		} else if (merc[typeNum].getType().equals("dealer")) {
			
		} else if (merc[typeNum].getType().equals("supporter")) {
		}
	}
	
	
	// 생성자
	public Carriage() {;}

	// 용병들의 정보들을 받아서 저장하도록 하기 위해서
	public Carriage(String name, int health, String gender, String type) {
		super();
		this.name = name;
		this.health = health;
		this.gender = gender;
		this.type = type;
	}
	
	
}
