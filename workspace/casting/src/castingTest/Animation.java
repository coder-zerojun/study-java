package castingTest;

public class Animation extends Video {

	@Override
	void showScreen() {
		System.out.println("애니를 보겠습니다");
	}
	
	void canSubtitle() {
		System.out.println("자막 지원");
	}
	
	
}
