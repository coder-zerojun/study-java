package arrayListTask;

import java.util.ArrayList;

public class Market {

	public ArrayList<Fruit> fruits = DBConnecter.fruits;

	// ���� �˻�
	public Fruit checkFruit(String name) {
		for (Fruit fruit : fruits) {
			if (fruit.getFruitName().equals(name)) {
				return fruit;
			}
		}
		return null;
	}

//	�����߰�
	// ȭ�鿡�� ���ϵ��� ������ �Է��ϸ� ������ ���� DB�ȿ� �־��ֱ�
	public void addFruit(Fruit fruit) {
		fruits.add(fruit);
	}

//	���ϻ���
	// ȭ�鿡�� ������ �̸��� �˻��ؼ� �ִٸ� �ش� ���Ͽ� ���� ���� �����
	public void deleteFruit(String fruitName) {
		for (Fruit fruit : fruits) {
			if (fruit.getFruitName().equals(fruitName)) {
				fruits.remove(fruit);
			}
		}
	}

//	���� ������ ��� ���ݺ��� ���� �� �˻�
	// ȭ�鿡�� ������ �̸��� �˻��ؼ� �ִٸ� �ش� ������ ������ ��պ��� �������� ����
//	public void fruitAvgCheck(String fruitName) {
//		int i = 0, total = 0, avg = 0;
//		for (Fruit fruit : fruits) {
//			total += fruits.get(i).getFruitPrice();
//			avg = total / fruits.size();
//		}
//	}

//	���� ��ü ��ȸ
	public ArrayList<Fruit> allFruitSearch() {
		return fruits;
	}

//	���� �̸����� ���� ��ȸ
	public void searchFruitPrice(String fruitName) {
		for (Fruit fruit : fruits) {
			if (fruits.contains(fruitName)) {
				fruit.getFruitName();
			}
		}
	}

}
