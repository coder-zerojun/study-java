package arrayListTask;

import java.util.ArrayList;

public class Market {

	public ArrayList<Fruit> fruits = DBConnecter.fruits;

	// 과일 검사
	public Fruit checkFruit(String name) {
		for (Fruit fruit : fruits) {
			if (fruit.getFruitName().equals(name)) {
				return fruit;
			}
		}
		return null;
	}

//	과일추가
	// 화면에서 과일들의 정보를 입력하면 과일을 과일 DB안에 넣어주기
	public void addFruit(Fruit fruit) {
		fruits.add(fruit);
	}

//	과일삭제
	// 화면에서 과일의 이름을 검색해서 있다면 해당 과일에 대한 정보 지우기
	public void deleteFruit(String fruitName) {
		for (Fruit fruit : fruits) {
			if (fruit.getFruitName().equals(fruitName)) {
				fruits.remove(fruit);
			}
		}
	}

//	과일 가격이 평균 가격보다 낮은 지 검사
	// 화면에서 과일의 이름을 검색해서 있다면 해당 과일의 가격이 평균보다 낮은지를 조사
//	public void fruitAvgCheck(String fruitName) {
//		int i = 0, total = 0, avg = 0;
//		for (Fruit fruit : fruits) {
//			total += fruits.get(i).getFruitPrice();
//			avg = total / fruits.size();
//		}
//	}

//	과일 전체 조회
	public ArrayList<Fruit> allFruitSearch() {
		return fruits;
	}

//	과일 이름으로 가격 조회
	public void searchFruitPrice(String fruitName) {
		for (Fruit fruit : fruits) {
			if (fruits.contains(fruitName)) {
				fruit.getFruitName();
			}
		}
	}

}
