package hashMapTest;

public class Product {

	private int number;
	private String name;
	private int price;
	private int count;
	
	public Product() {;}
	
	public Product(int number, String name, int price, int count) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.count = count;
	}


	
	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Product [number=" + number + ", name=" + name + ", price=" + price + ", count=" + count + "]";
	}


	
	
	
	
	
	
	
	
}
