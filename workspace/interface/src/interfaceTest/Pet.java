package interfaceTest;

public interface Pet {

	// static은 Pet 인터페이스를 사용하는 모든 객체들이 공유하도록 하기 위해
	
	public final static int EYES = 2;
	public int NOSE = 1;
	
	public void giveYourHand();
	public void bang();
	public void sitDown();
	public void waitNow();
	public void getNose();
}
