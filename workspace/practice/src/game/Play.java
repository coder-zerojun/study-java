package game;

import java.util.Scanner;

public class Play {

	//실제로 게임을 플레이하게 되는 곳
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String askMessage = "무엇을 하시겠습니까? : "
				, menuMessage = "[   1.용병고용  2. 모험하기  3.영지확장  4.런   ]";
		Carriage[] mercanary = {new Carriage("JackDaniel", 75, "male", "tanker"), new Carriage("Dismas", 60, "male", "dealer")
								, new Carriage("Dadario", 45, "female", "supporter"), new Carriage("Rucio", 55, "male", "supporter") };
		Carriage[] userMerc = null;
		// 각 타입의 용병을 담아 놓을 수 있게 하는 것
			
		// 메뉴에서 어느번호를 선택했는지 알 수 있는 것
		int choice = 0
				// 몇 명을 선택했는지 확인 할 수 있는 것
				, count = 0
				, typeNum = 0;
		// while문 탈출을 위한 변수
		boolean flag = true;
		
		while(flag) {
			System.out.println(menuMessage);
			System.out.print(askMessage);
			choice = sc.nextInt();
	
			switch (choice) {
			case 1 : 
				System.out.println("현재 대기하고 있는 용병의 수 : " + mercanary.length);
				System.out.print("몇 명의 용병을 고용하시겠습니까? : ");
				count = sc.nextInt();
					System.out.println("무슨 타입의 용병을 선택하시겠습니까?");
					System.out.println("[   1.탱커  2.딜러  3.서포터   ]");
					typeNum = sc.nextInt();
					int i = 0;
					String nameStack = "";
					for (i = 0; i < mercanary.length ; i++){
						nameStack += mercanary[i].getName() + "   ";
					}
					System.out.println(nameStack);
					
				break;
				
			case 2 :
				break;
				
			case 3 :
				break;
				
			case 4 :
				System.out.println("런이야~");
				System.out.println("◀  !! 세상은 멸망했습니다 !!  ▶");
				flag = false;
				break;
			}
		}
	}
}
