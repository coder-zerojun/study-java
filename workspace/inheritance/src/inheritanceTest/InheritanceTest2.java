package inheritanceTest;

import inheritanceTest.Human.Monkey;

class Human {

	void eat() {
		System.out.println("�Ա�");
	}

	void sleep() {
		System.out.println("�ڱ�");
	}

	void walk() {
		System.out.println("�� �߷� �ȱ�");
	}

class Monkey extends Human {
		void shakeTail() {
			System.out.println("���� ġ��");
		}

		@Override
		void walk() {
		super.walk();
		System.out.println("�� �߷� �ȱ�");
		}

	}

}

public class InheritanceTest2 {
	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}