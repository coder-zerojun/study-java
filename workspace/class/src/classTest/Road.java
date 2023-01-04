package classTest;

class Car {
	// 브랜드
	String brand;
	// 색상
	String color;
	// 가격
	int price;
	
	
	Car(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	
	
	public Car(String color, int price) {
		this.color = color;
		this.price = price;
	}



	// 시동켜기(브랜드 시동 켜기)
	void turnOn(){
		System.out.println(this.brand + " 시동 켜기");
	}
	
	// 시동끄기(브랜드 시동 끄기)
	void turnOff(){
		System.out.println(this.brand + " 시동 끄기");
	}
	
	
}


public class Road {

	public static void main(String[] args) {
		
		Car car = new Car("kia", "black", 3000);
		Car momCar = new Car("benz", "peridotGreen", 6000);
		Car dadCar = new Car("red", 5000);
//		car.brand = "kia";
//		car.color = "black"
//		car.price = 5000;
		
		car.turnOn();
		car.turnOff();
		
		dadCar.turnOn();
		dadCar.turnOff();
		
		
	}
	
	
	
	
	
}
