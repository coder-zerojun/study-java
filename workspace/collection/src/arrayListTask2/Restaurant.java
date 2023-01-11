package arrayListTask2;

import java.util.ArrayList;

public class Restaurant {

	public ArrayList<Food> foods = DBConnecter.foods;

//	���� �߰�
	public void addFood(Food food) {
		foods.add(food);
	}

//	���� �̸����� ���� ���� ��ȸ
	public String typeSearch(String name) {
		for (Food food : foods) {
			if (food.getName().equals(name)) {
				return food.getType();
			}
		}
		return null;
	}

//	����ڰ� ���ϴ� ������ ���� ��ü ��ȸ
//	public String allTypeSearch(String type) {
//		String searchedFood = "";
//		for (Food food : foods) {
//			if (food.getType().equals(type)) {
//				searchedFood += food.getName();
//			}
//		}
//		return searchedFood;
//	}

	public ArrayList<Food> findAllByKind(String type) {
		ArrayList<Food> results = new ArrayList<Food>();
		for (Food food : foods) {
			if (food.getType().equals(type)) {
				results.add(food);
			}
		}
		return results;
	}

//	���� ���� ���� �� ���� 10% ���
	public void typeChange(Food food) {
		for (Food foodInDatabase : foods) {
			if (foodInDatabase.getName().equals(food.getName())) {
				foodInDatabase.setType(food.getType());
				foodInDatabase.setPrice((int) (foodInDatabase.getPrice() * 1.1));
			}
		}
	}

//	����ڰ� ���ϴ� ������ ���� ���� ��ȸ
	public int typeCount(String type) {
		int count = 0;
		for (Food food : foods) {
			if (foods.contains(type)) {
				count++;
			}
		}
		return count;
	}
}
