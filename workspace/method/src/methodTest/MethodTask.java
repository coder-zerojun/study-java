package methodTest;

import java.util.Scanner;

public class MethodTask {

	// 1~10���� println()���� ����ϴ� �޼ҵ�
	void popOut() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
		}
	}

	// "ȫ�浿"�� n�� println()���� ����ϴ� �޼ҵ�
	void popOut2(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println("ȫ�浿");
		}
	}

	// �̸��� n�� println()���� ����ϴ� �޼ҵ�
	void popOut3(String name, int num) {
//			Scanner sc = new Scanner(System.in);
//			name = sc.nextLine();
		for (int i = 0; i < num; i++) {
			System.out.println(name);
		}
	}

	// �� ������ ������ ���ִ� �޼ҵ�
	int subtract(int num1, int num2, int num3) {
		int result = num1 - num2 - num3;
		return result;
	}

	// �� ������ ������ �� ��� ������ �� ���� ���ϴ� �޼ҵ�
//		 String division(int num1, int num2){
//			// �� ������ �Է��ϸ� �� ������ ������ ��� �������� ������
//			 // ���� ���ϸ� ���� ����
//			 int c = num1 / num2;
//			 // �������� ���ϸ� ���� ����
//			 int d = num1 % num2;
//			 
//			 String result = "��    :" + c + "\n������ : " +  d;
//			 return result;
//		}

	int[] divid(int num1, int num2) {
		int[] result = null;

		if (num2 != 0) {
			result = new int[2];
			result[0] = num1 / num2;
			result[1] = num1 % num2;
		}
		return result;
	}

	// 1~n ������ ���� �����ִ� �޼ҵ�
//	int result = 0;
//
//	int plus(int num) {
//		for (int i = 0; i < num; i++) {
//			result = result + i + 1;
//		}
//		return result;
//	}

	// Ȧ���� ¦����, ¦���� Ȧ���� �ٲ��ִ� �޼ҵ�
//	int change(int num) {
//		if (num % 2 == 0) {
//			num = num + 1;
//		} else {
//			num = num - 1;
//		}
//		return num;
//	}

	// ���ڿ��� �Է¹ް� �ҹ��ڴ� �빮�ڷ�, �빮�ڴ� �ҹ��ڷ� �ٲ��ִ� �޼ҵ�
//		String result = "";
//	 	String alpha(String word){
//				for (int i = 0; i < word.length(); i++) {
//					char c = word.charAt(i);
//				
//				if(c >= 65 && c <= 90) {
//					result += (char)(c + 32);
//				} else if(c >= 97 && c <= 122) {
//					result += (char)(c - 32);
//				} else {
//					result += c;
//				}
//			}
//				return result;
//		}

	// ���ڿ��� �Է¹ް� ���ϴ� ������ ������ �����ִ� �޼ҵ�
	int count(String words, char word) {
		int count = 0;
		for (int i = 0; i < words.length(); i++) {
			char c1 = words.charAt(i);

			if (word == c1) {
				count++;
			}
		}
		return count;
	}

	// 5���� ������ �Է¹��� �� ���ϴ� �ε����� ���� �����ִ� �޼ҵ�
		int whereNum(int[] arNum, int index){
			return arNum[index];
		}
		
	// �ѱ��� ������ �ٲ��ִ� �޼ҵ� (�ϰ��̻� -> 1024)
//		changeWord(String word){
//			String hangle = "�����̻�����ĥ�ȱ�"
//					, c = "";
//			for (int i = 0; i < word.length(); i++) {
//				if(word.charAt(i)== hangle); {
//					c += i;
//				}
//			}
//		}
		
	// 5���� ������ �Է¹ް� �ִ밪�� �ּҰ��� �����ִ� �޼ҵ�
//		int[] maxAndMin(){
//			int[] arData = {3, 8, 11, 7, 5};
//			int max = 0, min = 0;
//			int[] result = new int[2];
//
//			for (int i = 0; i < arData.length; i++) {
//
//				if(max < arData[i]) {max = arData[i];}
//				if(min < arData[i]) {min = arData[i];}
//				
//				max = arData[0];
//				min = arData[0];
//			}
//			
//			for (int i = 0; i < result.length; i++) {
//				result[0] = max;
//				result[1] = min;
//			}
//			return result;
//		}
	// 5���� ������ �Է¹ް� �ִ밪�� �ּҰ��� �����ִ� �޼ҵ�(void)

	
		
		
		
		
		
		
		
		
		
	// 1~10���� println()���� ����ϴ� �޼ҵ�
	void printFrom1To10() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
		}
	}

	// "ȫ�浿"�� n�� println()���� ����ϴ� �޼ҵ�
	void printHong(int count) {
		for (int i = 0; i < count; i++) {
			System.out.println("ȫ�浿");
		}
	}

	// �̸��� n�� println()���� ����ϴ� �޼ҵ�
	void printName(String name, int count) {
		for (int i = 0; i < count; i++) {
			System.out.println(name);
		}
	}

	// �� ������ ������ ���ִ� �޼ҵ�
	int sub(int number1, int number2, int number3) {
		int result = number1 - number2 - number3;
		return result;
	}

	// �� ������ ������ �� ��� ������ �� ���� ���ϴ� �޼ҵ�
	// �� ������ �Է��ؾ� �ϴ� �Ű������� 2�� ����
	int[] div(int number1, int number2) {
		// ��� ��������� 2���� ���� �ޱ� ���� �迭�� ���� ����
		// �и� 0 �̵��� �Ǹ� null ���� �������� �����Ѵ�
		int[] result = null;

		// number2�� �и� �ش��ϴ� �и� 0�� �Ǹ� �ȵǱ� ������
		// ���ǽĿ� �и� 0�� �ƴ� ��츦 ������ ���� ���ǽ��� ����
		if (number2 != 0) {
			// ��� ��������� 2���� ���� �ʿ��ϱ� ������ 
			// �迭 ���δ� 2���� ���� ������ �ż� 2�� �ڸ��� ����
			result = new int[2];
			// �迭�� ù��° �濡�� ���� �� 
			result[0] = number1 / number2;
			// �ι�° �濡�� �������� �� �Է�
			result[1] = number1 % number2;
		}
		// �迭�� ������ ������ �����Ͽ� 2���� �� ����
		return result;
	}

	// 1~n������ ���� �����ִ� �޼ҵ�
	// n������ ���̱� ������ ������ ����� �ؼ� �Ű����� ����
	int getTotalFrom1(int end) {
		// ���� ���ؾ� �ϱ� ������ ���� ������� ���� ����
		int total = 0;
		// n�������� ���� ���ؾ� �ϱ� ������ for���� ���� n������ �ݺ��� ����
		for (int i = 0; i < end; i++) {
			// total�� ���� ���̱� ������ total�� ���� i�� ���� ���� �ִµ�
			// i�� 0���� �����߱� ������ 1�� �����ش�
			total += i + 1;
		}
		// ���� ���� ���� �������ָ� ���� ���� �� �ִ�
		return total;
	}

	// Ȧ���� ¦����, ¦���� Ȧ���� �ٲ��ִ� �޼ҵ�
	// �� �ϳ��� �������ְ� �� ���� ¦���� Ȧ���� 
	// �ٲ��ָ� �Ǳ� ������ 1���� int������ �Ű����� ����
	int change(int number) {
		// Ȧ���̴� ¦���̴� �� ���� +1�� ���� �Ǹ� 
		// Ȧ���� ¦����, ¦���� Ȧ���� �ٲ�� ��
		return ++number;
	}

	// ���ڿ��� �Է¹ް� �ҹ��ڴ� �빮�ڷ�, �빮�ڴ� �ҹ��ڷ� �ٲ��ִ� �޼ҵ�
	// ���ڿ��� �Է¹޴� ���̱� ������ String Ÿ������ �Ű����� ����
	String changeToUpperOrLower(String str) {
		// ���� ��Ƴ��� result ���� ����
		// ��� �� ���� ��� ���������� ���� �ϱ� ����
		// null ��� �� ���ڿ� ���� �־���
		String result = "";
		// ���ڿ��� ���̸�ŭ �ݺ������� ������ �����̱� ������
		// for���� ���� �ݺ� Ƚ�� ����
		for (int i = 0; i < str.length(); i++) {
			// c��� ������ �Ű������� ���� ���ڿ� ���� �ִ� 
			// �� ���ڵ��� �ϳ��� ���� ������
			char c = str.charAt(i);
			// ������ ���ڸ��� �빮�ڶ��( 65 <= �ƽ�Ű �ڵ� �� <= 90)
			// (��� JAVA�������� ����� ��ȣ�� �� �� ���� ������ �� �����ڸ� ���� ���� ����) 
			if (c >= 65 && c <= 90) {
				// �빮�ڸ� �ҹ����� �ƽ�Ű�ڵ� ������ �����ְ� ����ȯ�� ���� �ٽ� ���ڰ����� �ٲ��� ��
				// result�� ����ִ´�
				result += (char)(c + 32);

				// �빮�ڰ� �ƴ϶�� �����߿� �ҹ��ڰ� �� �� �ֱ� ������
				// ���������� �ҹ��ڶ�� �빮�ڷ� �ٲ� �� �ֵ��� �� �ƽ�Ű�ڵ� ���� ��ȯ ��
			} else if (c >= 97 && c <= 122) {
				// �� ������� c��� ������ ��´�
				result += (char) (c - 32);

				// �� ���ܷ� �빮�ڳ� �ҹ��ڿ� ���Ե��� �ʴ� ������
			} else {
				// �׳� c���� ��´�
				result += c;
			}
		}
		// �ݺ��� ���� �Ǿ��ٸ� c�� ��� result�� �����Ѵ�
		return result;
	}

	// ���ڿ��� �Է¹ް� ���ϴ� ������ ������ �����ִ� �޼ҵ�
	// ���ڿ��� �Է¹ް�, ���ϴ� ���ڵ� ���� �ϱ� ������ 
	// �Ű������� 2�� �ʿ��ϳ�, �ϳ��� ���ڿ�, ������ �ϳ��� ���� �̱� ������
	// �ϳ��� String Ÿ��, ������ �ϳ��� char Ÿ������ �����Ѵ�
	int getCount(String str, char c) {
		// ���� ���ڿ� �� �� ���� ã�� ���ڰ� �ִٸ� �� Ƚ���� ������ ������ �����Ѵ�
		int count = 0;
		// ���ڿ��� ���̸�ŭ ���ڿ� �ӿ��� ���ڸ� ã�ƺ��� �ϹǷ�
		// for���� ���� ���ڿ� ���̸�ŭ �ݺ��� �����Ѵ�
		for (int i = 0; i < str.length(); i++) {
			// ���� �ݺ��� �����ϴ� �߿� i��° �ڸ��� �ִ� ���ڿ��� ����
			// ���ڰ��� ��ġ�Ѵٸ� count�� Ƚ���� 1�� ������Ų��
			if (str.charAt(i) == c) {
				count++;
			}
		}
		// count�� ���� �� ���� ���ڰ� �ִ� Ƚ���̴� count�� �����Ѵ�
		return count;
	}

	
	// 5���� ������ �Է¹��� �� ���ϴ� �ε����� ���� �����ִ� �޼ҵ�
	// 5���� ������ �Է¹����� ������ �����ϸ� �ʹ� �������� ������ �迭�� �����ϸ�
	// �迭�� �����ϸ� �� �ε��� ���� ���� �޾Ƽ� ����� �� �ִ�
	int getValue(int[] arData, int index) {
		// �迭[�ε�����] > �� �ε��� ��ȣ������ �迭 �� ���� ��
		return arData[index];
	}

	// �ѱ��� ������ �ٲ��ִ� �޼ҵ�(�ϰ��̻� -> 1024)
	// �ѱ��� �Է¹ޱ� ���� String Ÿ������ ���ڿ��� �޴´�
	int changeToInteger(String hangle) {
		// ���ڿ��� �˻������� �� �ε��� ��ȣ�� �ִ� ���� ��� �������� üũ�ϱ�
		String hangleOriginal = "�����̻�����ĥ�ȱ�";
		// ������ ���� �ϱ� ���� ���� null�� �ƴ� ���ڿ��� �������
		String result = "";
		// ���ڸ� �Է� �޾����� ���ڿ��� �ڸ��� ��ŭ �ݺ��� �����ϱ� ���� for�� ���
		for (int i = 0; i < hangle.length(); i++) {
			// ��������� �� ���ڿ��� i��° ���� �ִ� ���ڰ� ��� ��ġ�� �ִ��� Ȯ���ϰ�
			// �� ���� �޴µ� �ϴ� �� ���ڵ��� � �������� ��� �����ؾ��ϱ� ������
			// ���ڰ����� ����ȯ�� �޾Ƽ� ���� �س�����
			result += hangleOriginal.indexOf(hangle.charAt(i));
		}
//		result���� ���ڿ��� ���� �� ������ intŸ������ ����ȯ�� ���� ���ڰ� ������ �Ѵ�
		return Integer.parseInt(result);
	}

	// 5���� ������ �Է¹ް� �ִ밪�� �ּҰ��� �����ִ� �޼ҵ�
	// 5���� ������ �迭 ������� �Է¹ޱ� ���� �迭�� ����
	int[] getMaxAndMin(int[] arData) {
		// �ִ밪�� �ּҰ��� ���� �� ���� ������ �迭�� �������ش�
		int[] result = { arData[0], arData[0] };

		// �迭�� ���� ��ŭ �ݺ��� �����ؾ� �ϱ� ������ for���� ���� �ݺ�
		for (int i = 0; i < arData.length; i++) {
			// ���� 0��° �濡 �ִ� ���� i��°�� ������ ������ ������
			// �� ū ���� 0���� �־��ش�
			if (result[0] < arData[i]) {
				result[0] = arData[i];
			}
			// 0������ �ִ��� ����ֱ� ������ 1�� ���� �ּҰ��� ���µ�
			// 1�� ������ �� ���� ���� �ִٸ� �� ���� 1�� �濡 �ִ´�
			if (result[1] > arData[i]) {
				result[1] = arData[i];
			}
		}
		// �迭�� ���̰� 2���� �迭�� �����߱� ������ �ִ񰪰� �ּڰ��� �� �� �� ������
		// ���� �� �ִ� result�� �������ش�
		return result;
	}

	// 5���� ������ �Է¹ް� �ִ밪�� �ּҰ��� �����ִ� �޼ҵ�(void)
	// �� �������� ������ ���� �ʰ� �ٸ��ʿ��� ����� �迭�� �ּҰ��� �����´�
	void getMaxAndMin(int[] arData, int[] result) {
		
		// �ִ� �ּҰ��� result �迭 �ȿ� �ִ� �۾�
		// ���� �޾ƿ��� ������ �޾ƿ��鼭 �̹� �����
		result[0] = arData[0];
		result[1] = arData[0];

		// ����� �迭�� ���̸�ŭ �ݺ��ؼ� ����
		for (int i = 0; i < arData.length; i++) {
			if (result[0] < arData[i]) {
				result[0] = arData[i];
			}
			if (result[1] > arData[i]) {
				result[1] = arData[i];
			}
		}
	}
	
	// indexOf() �����
	// ���ڿ��� ���ڸ� �Է¹��� �� �ش� ���ڰ� �� �� ° �ε����� �ִ��� �˻��ϰ�
	// ���� �ش� ���ڰ� ���ٸ� -1�� �����Ѵ�
		int search(String words, char word){
			// �ε��� ��ȣ�� ���� ����
			int c = 0;
			
			// ���ڿ��� ���� ��ŭ �ݺ��� �����ؾ� ��ü ���ڿ����� �� ���ڰ��� ã��
			for (int i = 0; i < words.length(); i++) {
				
				// ���ڿ��� i��°�� �ִ� ���ڰ� �˻��ϰ��� �ϴ� word�� ���ٸ�
				// c��� ������ i��� �ε��� ��ȣ�� �޴´�
				if(words.charAt(i) == word) {
					c = i;
					break;
				} // �ٸ� ���� (�ش� ���ڰ� ��ü�� ���Ҵµ� ���ٸ� -1�� ��ȯ)
				else {
					c = -1;
				}
			}
			return c;
		}
		
		
		
		
	
	

	public static void main(String[] args) {

		MethodTask methodTask = new MethodTask();
		Scanner sc = new Scanner(System.in);
		
//		methodTask.printFrom1To10();								// 1��° (1~10���� ��)
//		methodTask.printHong(7);									// 2��° (ȫ�浿 ���)
//		methodTask.printName("������", 5);							// 3��° (�̸� ���)
//		System.out.println(methodTask.sub(10, 7, 9));				// 4��° (����)
		
//		int[] result = methodTask.div(13, 5);						// 5��° (��, ������)
//		if (result == null) {
//			System.out.println("0���� ���� �� �����ϴ�");
//		} else {
//		System.out.println("�� : " + result[0]);
//		System.out.println("������ : " + result[1]);
//		}
		
//		System.out.println(methodTask.getTotalFrom1(100));			// 6��° (1~n���� ��)
//		System.out.println(methodTask.change(10));					// 7��° (Ȧ��, ¦�� ��ȯ)
//		System.out.println(methodTask.changeToUpperOrLower("aBc"));	// 8��° (��ҹ��� ��ȯ)
//		System.out.println(methodTask.getCount("HandMade", 'e'));	// 9��° (���� ã��)
		
//		int[] arData = {1, 3, 5, 4, 9};								// 10��° (�迭�� �ε��� ��ȣ�� �� ã��)
//		System.out.println(methodTask.getValue(arData, 3));			
		
//		System.out.println(methodTask.changeToInteger("���ϰ���ĥ��"));	// 11��° (�ѱ۷� ���� ���� ��¥ ���� �ٲٱ�)
		
//		int[] arData = {0, 11, 3, 8, 4, 7};							// 12��° (�ִ밪, �ּҰ�)
//		int[] result = methodTask.getMaxAndMin(arData);
//		
//		System.out.println("�ִ밪 : " + result[0]);
//		System.out.println("�ּҰ� : " + result[1]);
		
//		int[] result = new int[2];									// 13��° (�ִ밪, �ּҰ� void)
//		int[] arData = {5, 11, 1, 8, 4, 7};			
//		
//		methodTask.getMaxAndMin(arData, result);
//		System.out.println("�ִ밪 : " + result[0]);
//		System.out.println("�ּҰ� : " + result[1]);
		
		int result1 = methodTask.search("Hello", 'l');
		System.out.println(result1);
		
		
		// �����Ÿ�. �ּҰ��� �޾ƿԴٴ� ���� �̰��� �迭�̱� ������ ������ ���ΰ�?
		
		
	}

}
