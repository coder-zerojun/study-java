package inheritance;

import java.util.Iterator;

public class Carriage {

	// 영웅들이 모여 있는 장소
	// 영웅들의 정보

	// 이름
	private String name;
	// 체력
	private int hp;
	// 성별
	private String gender;
	// 영웅의 타입(탱커, 딜러, 서포터)
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
		return "Carriage [   이름=" + name + ", 체력=" + hp + ", 성별=" + gender + ", 타입=" + type + "]";
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

	// 영웅의 이름, hp, 성별을 지정해서 받을 수 있음
	public Carriage(String name, int hp, String gender, String type) {
		this.name = name;
		this.hp = hp;
		this.gender = gender;
		this.type = type;
	}

	// 용병들의 이름이 ""인지를 확인하는 메소드
	// 이 메소드를 실행하고 나서 결과를 눈으로 봐야 하니 리턴 타입이 필요함
	int nameCheck(Carriage[] mercanary, int a) {
		int merc = 0;
		if (mercanary[a - 1].name == "") {
			merc = a;
		}
		return merc;
	}

	// 선택 타입의 용병들 보여주기
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
