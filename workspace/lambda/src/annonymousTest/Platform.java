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
						System.out.println(price + "�Ǹ� �Ϸ�");
					}
				}
			}
			
			@Override
			public String[] game() {
				return new String[] {"���弿","�ݿ����Ƽ","���Ӵ�"};
			}
		});
		
		
		
		
		
	}
}
