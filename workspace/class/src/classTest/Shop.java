package classTest;

public class Shop {

//	��ǰ��
	String item;
//	��ǰ����
	int price;
//	���
	int number;

	// �Ǹ� ��ǰ�� �̸�, ����, ��� Ȯ���� �� �ְ� ��
	public Shop(String item, int price, int number) {
		this.item = item;
		this.price = price;
		this.number = number;
	}

	// ��ǰ �Ǹ�
	int sell(Customer customer) {
		number--;
	      int result = (int)(price * (1.0 - customer.sail / 100.0));
	      customer.bank -= result;
	      return result;
	}

	public static void main(String[] args) {


	}
}
