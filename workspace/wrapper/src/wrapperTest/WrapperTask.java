package wrapperTest;

public class WrapperTask {
	public static void main(String[] args) {
		
		// 1, 12.5, 86.6F, 'z', "Hi", false
		// 위 6개의 값을 6칸 배열에 담기
		
		
//		Object[] ar = new Object[6];
		Object[] arData = {1, 12.5, 86.6F, 'z', "Hi", false};
		
//		Integer num = 1;
//		Double doub = 12.5;
//		Float flot = 86.6F;
//		Character cha = 'z';
//		String hi = "Hi";
//		Boolean tOrF = false;
//		
//		ar[0] = num;
//		ar[1] = doub;
//		ar[2] = flot;
//		ar[3] = cha;
//		ar[4] = hi;
//		ar[5] = tOrF;
		
		for (int i = 0; i < arData.length; i++) {
			System.out.println(arData[i]);
		}
		
	}
}
