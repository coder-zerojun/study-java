package inheritanceTest;

class A {
	String name = "A";
	int data = 10;

	void printName() {
		System.out.println(name);
	}
}

class B extends A {
	void printData() {
		System.out.println(data);
	}
}

public class InheritanceTest1 {
	public static void main(String[] args) {
		B b = new B();				// 자식 생성자를 생성하면 부모 생성자를 
		System.out.println(b);
		b.name = "B";
		b.printName();
		b.printData();
	}
}
