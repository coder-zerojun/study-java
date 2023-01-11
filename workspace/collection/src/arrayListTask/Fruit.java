package arrayListTask;

public class Fruit {

	private String fruitName;
	private int fruitPrice;
	
	
	
	public Fruit() {;}
	
	
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public int getFruitPrice() {
		return fruitPrice;
	}
	public void setFruitPrice(int fruitPrice) {
		this.fruitPrice = fruitPrice;
	}


	@Override
	public String toString() {
		return "Fruit [fruitName=" + fruitName + ", fruitPrice=" + fruitPrice + "]";
	}
	
	
	
}
