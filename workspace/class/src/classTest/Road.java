package classTest;

class Car {
	// �귣��
	String brand;
	// ����
	String color;
	// ����
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



	// �õ��ѱ�(�귣�� �õ� �ѱ�)
	void turnOn(){
		System.out.println(this.brand + " �õ� �ѱ�");
	}
	
	// �õ�����(�귣�� �õ� ����)
	void turnOff(){
		System.out.println(this.brand + " �õ� ����");
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
