package lambdaTest;

public class PrintNameTest {

	public void PrintFullName(PrintName printName) {
//		PrintFullName(printName);
		System.out.println(printName.getFullName("hana", "kim"));
		
	}
	
	public static void main(String[] args) {

		PrintNameTest printNameTest = new PrintNameTest();
		printNameTest.PrintFullName(new PrintName() {
			
			@Override
			public String getFullName(String firstName, String lastName) {
				return null;
			}
		});
		
		PrintName printName = (a, b) -> b + a;
//		System.out.println(printName.getFullName("hana", "Kim"));
		
		
		
	}
	
}
