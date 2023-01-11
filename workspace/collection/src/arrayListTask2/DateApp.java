package arrayListTask2;

import java.util.ArrayList;
import java.util.Collections;

public class DateApp {

	public ArrayList<Love> loves = DBConnecter.loves;

//	����ڰ� ���ϴ� ������ �̻��� ��� ��ȸ
	public ArrayList<Love> SearchLoveByAge(int age) {
		ArrayList<Love> result = new ArrayList<Love>();
		for (Love love : loves) {
			if (love.getAge() == age) {
				result.add(love);
			}
		}
		return result;
	}

//	�̻����� ���� ����
	// �̻��� ���� ���� ��ư�� ������ ������ �޼ҵ�
	// �����ϰ��� �ϴ� ���̸� �Է��ϸ� �� ��ȣ�� ����
	public void updateAge(Love love) {
		for (Love lover : loves) {
			if (lover.getNumber() == love.getNumber()) {
				lover.setAge(love.getAge());
			}
		}
	}

//	�̻��� ���� �� ����
	public void sortByAge() {
//		
		ArrayList<Love> batch = new ArrayList<Love>();
		ArrayList<Integer> ages = new ArrayList<Integer>();
		// loves���� ���̸� �����ͼ� ����
		for (Love love : batch) {
			ages.add(love.getAge());
		}
		loves = batch;
	}
}
