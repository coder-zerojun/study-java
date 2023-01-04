package classTest;

public class Shop {

//	상품명
	String item;
//	상품가격
	int price;
//	재고
	int number;

	// 판매 물품의 이름, 가격, 재고를 확인할 수 있게 함
	public Shop(String item, int price, int number) {
		this.item = item;
		this.price = price;
		this.number = number;
	}

	// 상품 판매
	int sell(Customer customer) {
		number--;
	      int result = (int)(price * (1.0 - customer.sail / 100.0));
	      customer.bank -= result;
	      return result;
	}

	public static void main(String[] args) {


	}
}
