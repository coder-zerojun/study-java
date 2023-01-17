package domain;

import dao.NameDAO;

// 기본적으로 있는 정보가 아닌 gender라는 새로운 정보가 필요하기 때문에 DTO를 생성
public class NameDTO extends Name{
	private String gender;
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	// gender가 나중에 병합하고 나서 가장 먼저 나와야 하기 때문에 gender를 먼저 넣고 재정의해줌
	public String toString() {
		return gender + "\t" + getName() + "\t" + getRanking() + "\t" + NameDAO.insertComma(getPopulation());
	}
}
