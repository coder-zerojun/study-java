package annonymousTest;

public class Steam {

	public void register(Form form) {
		String[] menu = form.game();
		for (int i = 0; i < menu.length; i++) {
			
		}
		if(form instanceof FormAdapter) {
			System.out.println("ÇÒÀÎÁßÀÎ ÇÃ·§ÆûÀÔ´Ï´Ù");
			return;
		}
		form.price("µ¥µå¼¿");
	}
}
