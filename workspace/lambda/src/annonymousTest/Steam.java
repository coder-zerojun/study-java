package annonymousTest;

public class Steam {

	public void register(Form form) {
		String[] menu = form.game();
		for (int i = 0; i < menu.length; i++) {
			
		}
		if(form instanceof FormAdapter) {
			System.out.println("�������� �÷����Դϴ�");
			return;
		}
		form.price("���弿");
	}
}
