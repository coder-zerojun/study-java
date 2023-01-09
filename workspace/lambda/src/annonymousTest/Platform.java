package annonymousTest;

import java.util.Iterator;

public class Platform {

	public static void main(String[] args) {
		
		Steam valve = new Steam();
		
		valve.register(new Form() {
			
			@Override
			public void price(String price) {
				String[] valMenu = game();
				for (int i = 0; i < valMenu.length; i++) {
					if(valMenu[i].equals(price)) {
						System.out.println(price + "판매 완료");
					}
				}
			}
			
			@Override
			public String[] game() {
				return new String[] {"데드셀","콜오브듀티","헤임달"};
			}
		});
		
		
		
		
		
	}
}
