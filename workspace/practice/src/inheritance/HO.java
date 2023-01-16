package inheritance;

import java.util.Iterator;
import java.util.Scanner;

public class HO {

	// (역마차에서) 용병 선택
	// 번호 중에서 인원을 골랐다면 그 인원의 정보를 담아준다
	
	// 모험하기

	// 영지 확장하기(건물 건설)

	public static void main(String[] args) {

		HO ho = new HO();
		Carriage car = new Carriage();
		// 용병들의 정보를 담아놓을 DB
		Carriage[][] arrMerc = new Carriage[3][20];
		// 용병들이 각자 어떤 정보를 가지고 있는지 넣을 배열
		Carriage[] mercanary = { new Carriage("JackDaniel", 60, "male", "tanker"),
				new Carriage("Dismas", 40, "male", "dealer"), new Carriage("Dadario", 30, "female", "dealer"),
				 new Carriage("Dormamu", 50, "male", "supporter"), new Carriage("Duna", 40, "female", "tanker"), };
		// 각 타입의 용병들이 몇 명씩 있는지 알기 위함
		int[] mercNum = new int[3];
		// 용병들이 어떤 타입인지를 담아놓을 배열
		Carriage[] whatType = null;
		Carriage mercType = null;
		
		String menuMessage = "[  1. 용병 구인하기 2. 모험 떠나기 3. 영지 확장하기 4. 런 각  ]", askMessage = "무엇을 하시겠습니까? : ";
		Scanner sc = new Scanner(System.in);

		// 인원 뽑기
		int choice = 0
		// 몇 번 방
				, a = 0
				// 횟수 확인용
				, count = 0
				// 어떤 타입을 선택할 건지
				, typeCount = 0;
		// 탈출용
		boolean flag = false;

		while (true) {

			System.out.println(menuMessage);
			System.out.print(askMessage);
			choice = sc.nextInt();

			switch (choice) {

			case 1: // 용병을 뽑기 위한 switch문

				// 몇 명을 뽑을 것인지 결정
				System.out.print("몇 명을 고용 하시겠습니까? : ");
				choice = sc.nextInt();
				System.out.println(choice + "명 뽑겠습니다\n");
				while (choice > count) {
					System.out.println("어떤 타입의 용병을 고용하시겠습니까?");
					System.out.println("[   1.탱커  2.딜러  3.서포터   ]");
					typeCount = sc.nextInt();
					
					whatType = new Carriage[] {new Tanker(), new Dealer(), new Supporter()};
					
					switch (typeCount) {
						
					case 1:
						car.mercType(mercanary, arrMerc, mercNum);
						for (int i = 0; i < mercNum[0]; i++) {
							System.out.println(i+1 + ". " + arrMerc[0][i].getName());
						}
						break;
						
					case 2: 
						car.mercType(mercanary, arrMerc, mercNum);
						for (int i = 0; i < mercNum[1]; i++) {
							System.out.println(i+1 + ". " + arrMerc[1][i].getName());
						}
						break;
						
					case 3:
						car.mercType(mercanary, arrMerc, mercNum);
						for (int i = 0; i < mercNum[2]; i++) {
							System.out.println(i+1 + ". " + arrMerc[2][i].getName());
						}
						break;
					}
										
					System.out.println("★ 뽑아주세요 ★\n");

					// 어떤 용병을 뽑을 것인지 결정
					// 배열에서 전체 값을 가져오는 건 가능한지..?
					a = sc.nextInt();
//					if (mercanary[0].name == "" && mercanary[1].name == "" && mercanary[2].name == ""
//							&& mercanary[3].name == "") {
//						System.out.println("용병들이 없습니다");
//						break;
//					} else {
//						// 만약 1번을 고르면 1번 자리에 있던 용병이 없어지고 뒤에 방에 있는 용병들의 이름이 그 자리를 채우기
//						switch (a) {
//
//						case 1:
//							if (stageCoach.nameCheck(mercanary, a) == 1) {
//								System.out.println("용병이 자리를 비웠습니다");
//								break;
//							}
//							System.out.println(mercanary[a - 1].name + "를 선택하셨습니다\n");
//							for (int i = 0; i < mercanary.length - 4; i++) {
//								mercanary[i] = mercanary[i + 1];
//							}
//							count++;
//							break;
//
//						case 2:
//							if (Carriage.nameCheck(mercanary, a) == 2) {
//								System.out.println("용병이 자리를 비웠습니다");
//								break;
//							}
//							System.out.println(mercanary[a - 1].name + "를 선택하셨습니다\n");
//							for (int i = 1; i < mercanary.length - 4; i++) {
//								mercanary[i] = mercanary[i + 1];
//							}
//							count++;
//							break;
//
//						case 3:
//							if (stageCoach.nameCheck(mercanary, a) == 3) {
//								System.out.println("용병이 자리를 비웠습니다");
//								break;
//							}
//							System.out.println(mercanary[a - 1].name + "를 선택하셨습니다\n");
//							for (int i = 2; i < mercanary.length - 4; i++) {
//								mercanary[i] = mercanary[i + 1];
//							}
//							count++;
//							break;
//
//						case 4:
//							if (stageCoach.nameCheck(mercanary, a) == 4) {
//								System.out.println("용병이 자리를 비웠습니다");
//								break;
//							}
//							System.out.println(mercanary[a - 1].name + "를 선택하셨습니다\n");
//							for (int i = 3; i < mercanary.length - 4; i++) {
//								mercanary[i] = mercanary[i + 1];
//							}
//							count++;
//							break;
//						default:
//							System.out.println("잘못된 선택입니다");
//							break;
//						}
					}

				
				count = 0;
				break;

			case 2: // 모험 떠나기
				System.out.println("먼저 함께 나갈 용병을 선택해 주십시오");
				System.out.println(car);
				break;

			case 3:
				break;

			case 4:
				System.out.println("러니야~");
				flag = true;
				break;
			}

			if (flag) {
				break;
			}
		}
	}
}
