package jsonTest;

public class Mercanary {
// 용병에 관한 정보
	
	private String name;
	private int age;
	private int career;
	private String type;
	
	
	public Mercanary() {;}

	public Mercanary(String name, int age, int career, String type) {
		super();
		this.name = name;
		this.age = age;
		this.career = career;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Mercanary [name=" + name + ", age=" + age + ", career=" + career + ", type=" + type + "]";
	}

	
	
	
}
