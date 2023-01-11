package arrayListTask2;

import java.util.ArrayList;
import java.util.Collections;

public class DateApp {

	public ArrayList<Love> loves = DBConnecter.loves;

//	사용자가 원하는 나이의 이상형 목록 조회
	public ArrayList<Love> SearchLoveByAge(int age) {
		ArrayList<Love> result = new ArrayList<Love>();
		for (Love love : loves) {
			if (love.getAge() == age) {
				result.add(love);
			}
		}
		return result;
	}

//	이상형의 나이 수정
	// 이상형 나이 수정 버튼을 누르면 나오는 메소드
	// 수정하고자 하는 나이를 입력하면 그 번호가 수정
	public void updateAge(Love love) {
		for (Love lover : loves) {
			if (lover.getNumber() == love.getNumber()) {
				lover.setAge(love.getAge());
			}
		}
	}

//	이상형 나이 순 정렬
	public void sortByAge() {
//		
		ArrayList<Love> batch = new ArrayList<Love>();
		ArrayList<Integer> ages = new ArrayList<Integer>();
		// loves에서 나이를 가져와서 정렬
		for (Love love : batch) {
			ages.add(love.getAge());
		}
		loves = batch;
	}
}
