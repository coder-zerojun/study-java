package inheritance;

import java.util.Iterator;

public class Carriage {

	// �������� �� �ִ� ���
	// �������� ����

	// �̸�
	private String name;
	// ü��
	private int hp;
	// ����
	private String gender;
	// ������ Ÿ��(��Ŀ, ����, ������)
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "Carriage [   �̸�=" + name + ", ü��=" + hp + ", ����=" + gender + ", Ÿ��=" + type + "]";
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

	public Carriage() {
		;
	}

	// ������ �̸�, hp, ������ �����ؼ� ���� �� ����
	public Carriage(String name, int hp, String gender, String type) {
		this.name = name;
		this.hp = hp;
		this.gender = gender;
		this.type = type;
	}

	// �뺴���� �̸��� ""������ Ȯ���ϴ� �޼ҵ�
	// �� �޼ҵ带 �����ϰ� ���� ����� ������ ���� �ϴ� ���� Ÿ���� �ʿ���
	int nameCheck(Carriage[] mercanary, int a) {
		int merc = 0;
		if (mercanary[a - 1].name == "") {
			merc = a;
		}
		return merc;
	}

	// ���� Ÿ���� �뺴�� �����ֱ�
	void mercType(Carriage[] merc, Carriage[][] arrMerc, int[] mercNum) {
		int a = 0;
		int b = 0;
		int c = 0;
		for (int i = 0; i < merc.length; i++) {
			if (merc[i].getType().equals("tanker")) {
				arrMerc[0][a] = merc[i];
				a++;
				mercNum[0]++;

			} else if (merc[i].getType().equals("dealer")) {
				arrMerc[1][b] = merc[i];
				b++;
				mercNum[1]++;
				continue;
			} else if (merc[i].getType().equals("supporter")) {
				arrMerc[2][c] = merc[i];
				c++;
				mercNum[2]++;
			}
		}
	}

//		if (merc[typeNum].getType().equals("tanker")) {
//			whatType[0] = merc[typeNum];
//		} else if (merc[typeNum].getType().equals("dealer")) {
//			whatType[1] = merc[typeNum];
//		} else if (merc[typeNum].getType().equals("supporter")) {
//			whatType[2] = merc[typeNum];
//		}

	public static void main(String[] args) {

	}
}
