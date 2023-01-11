package arrayListTask2;

import java.util.ArrayList;

public class Restaurant {

	public ArrayList<Food> foods = DBConnecter.foods;

//	음식 추가
	public void addFood(Food food) {
		foods.add(food);
	}

//	음식 이름으로 음식 종류 조회
	public String typeSearch(String name) {
		for (Food food : foods) {
			if (food.getName().equals(name)) {
				return food.getType();
			}
		}
		return null;
	}

//	사용자가 원하는 종류의 음식 전체 조회
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

//	음식 종류 수정 후 가격 10% 상승
	public void typeChange(Food food) {
		for (Food foodInDatabase : foods) {
			if (foodInDatabase.getName().equals(food.getName())) {
				foodInDatabase.setType(food.getType());
				foodInDatabase.setPrice((int) (foodInDatabase.getPrice() * 1.1));
			}
		}
	}

//	사용자가 원하는 종류의 음식 개수 조회
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
