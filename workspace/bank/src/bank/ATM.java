package bank;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {

		// 은행과 고객의 정보를 집어넣은 것
		Bank[][] arrBank = new Bank[3][100];
		// 은행당 고객의 수
		int[] arCount = new int[3];
		// 어떤 은행을 선택한 것인지 은행을 담아 놓은 배열
		Bank[] arBank = null;

		final int ACCOUNT_LENGTH = 6;

		String message = "1. 신한은행\n2. 국민은행\n3. 카카오뱅크\n4.나가기";
//		계좌개설, 입금하기, 출금하기, 잔액조회, 계좌번호 찾기(새로운 계좌발급, 핸드폰 번호로 서비스 이용가능), 나가기
		String menu = "1. 계좌개설\n2. 입금하기\n3. 출금하기\n4. 잔액조회\n5. 계좌번호 찾기\n6. 은행 다시 선택";
		Scanner sc = new Scanner(System.in);
		// index 무슨 은행인지 선택(몇 번 째 은행인지), choice = 몇 번인지를 선택하는 것
		int index = 0, choice = 0, money = 0;
		String account = "", phoneNumber = null, password = null;
		// 랜덤을 사용하기 위해서
		Random random = new Random();
		// user : 예금주의 정보를 집어넣는 변수 , userCheck : 받은 정보들이 중복인지 확인하기 위해 사용하는 변수, bankChk : 
		Bank user = null, userCheck = null;
		boolean flag = true;

		while (true) {
//			어떤 은행을 고를 것인지 은행을 선택한다.
			System.out.println(message);
//			인덱스 값을 입력받는다
			index = sc.nextInt();
			// 4번을 골랐을 때 나가는 결과를 내기 때문에 조건을 만족하면 바로 나가게 된다
			if (index == 4) {
				break;
			} // 나가기 눌렀을 때에는 while문 즉시 탈출!
			index--; // 몇 번째 은행인지 인덱스 번호로 쓸 거라서 1을 빼준다.

			// 메뉴중에서 제대로 된 메뉴를 선택하기 전까지 계속 반복
			while (true) {
				System.out.println(menu);
//				System.out.println(arrBank[0][0]);
//				System.out.println(arrBank[0]);
				System.out.println(arCount[0]);
				System.out.println(arCount[1]);
				// 사람들이 선택한 값을 choice에 담아 놓는다
				choice = sc.nextInt();
				// 6번 메뉴(다른 은행 선택)을 누르게 되면 while문을 탈출한다
				if (choice == 6) {
					break;
				}
				// 메뉴중에서 1번을 눌렀을 때
				if (choice == 1) { // 계좌 개설

					// 어떤 계좌를 선택한 고객인지를 받아놓는 것, 고객의 수를 구할 수 있음 (계좌를 선택할 때마다 생성됨)
					arBank = new Bank[] { new Shinhan(), new Kookmin(), new KaKao() };
//					account = "";
					// 계좌를 개설한 은행에서만 입금 가능 '계좌번호에 무슨 은행인지 표시'

					// while문이 참인 동안 계속 반복해서 돈다
					while (true) {
						// 계좌번호가 6자리로 정해져 있기 때문에 혹시나 가독성을 위해 6이라는 자릿수를 담아놓고 사용한다
						for (int i = 0; i < ACCOUNT_LENGTH; i++) {
							// 계좌번호에 랜덤으로 번호 부여하기 (나오는 번호는 0~9까지)
							account += random.nextInt(10);
						}
//						if (index == 0) {
//							account += "a";
//						} else if (index == 1) {
//							account += "b";
//						} else if (index == 2) {
//							account += "c";
//						}

						// 계좌번호 중복체크
						userCheck = Bank.checkAccount(arrBank, arCount, account);
						// 중복이 없을 경우 while문 탈출
						if (userCheck == null) {
							break;
						}
					}
					// arBank의 index번 은행에
					user = arBank[index];
					
					account = index + account;

					
					// 예금주가 받게 된 계좌 번호를 집어넣는다
					user.setAccount(account);
					// 계좌번호 초기화
					account = "";
//					System.out.println(account);

					System.out.print("예금주: ");
					user.setName(sc.next());
					arBank[index] = user;

					while (true) {
						System.out.print("핸드폰 번호['-' 제외]: ");
						// 핸드폰 번호를 입력받는다
						phoneNumber = sc.next();

						// 전화번호를 받았을 때 그 안에 - 가 있으면 빈 값으로 바꿔주기
						// replaceAll 을 하고 바로 그 값을 출력하는게 아니라서 그 값을 다시 넣어준다
						phoneNumber = phoneNumber.replaceAll("-", "");
						// 전화번호의 길이가 11이라면
						if (phoneNumber.length() == 11) {
							// 전화번호가 010으로 시작해야만 하는 조건
							if (phoneNumber.startsWith("010")) {
								// 전화번호 중복 체크
								userCheck = Bank.checkPhoneNumber(arrBank, arCount, phoneNumber);
								// 중복이 없다면 while문 탈출
								if (userCheck == null) {
									break;
								}
							}
						}
						System.out.println("잘못된 핸드폰 번호입니다.");
					}
					// 중복이 없다면 핸드폰 번호를 다시 집어 넣는다
					user.setPhoneNumber(phoneNumber);

					// 비밀번호 생성
					while (true) {
						System.out.print("비밀번호[4자리]: ");
						// 비밀번호 입력받기
						password = sc.next();
						// 비밀번호가 4자리가 되도록 조건문 작성
						if (password.length() == 4) {
							break;
						}
						System.out.println("비밀번호는 4자리로 설정해주세요.");
					}
					// while문 조건을 만족했으면 비밀번호를 집어넣는다
					user.setPassword(password);

					// 은행 DB의 index번째의 은행에 고객수가 있는 arCount의 index번째의 방에 회원의 정보를 집어넣는다
					arrBank[index][arCount[index]] = user;
					// 각은행에 계좌 개설을 하게 됐으니 arCount의 index번 은행에 있는 고객의 수를 증가시킨다
					arCount[index]++;
					System.out.println("환영합니다 " + user.getName() + " 고객님, 계좌개설이 완료되었습니다.");
					System.out.println("계좌번호: " + user.getAccount());
//					System.out.println(arBank[0].getName());
//					System.out.println(arBank[1].getName());

					continue;

				}

				else if (choice == 5) { // 계좌번호 찾기
					System.out.print("핸드폰 번호: ");
					// 전화번호 입력받기
					phoneNumber = sc.next();
					// 은행에서 핸드폰 번호를 먼저 검사하는 것
					user = Bank.checkPhoneNumber(arrBank, arCount, phoneNumber);
					// 예금주가 존재한다면
					if (user != null) {
						System.out.print("비밀번호: ");
						// 비밀번호 입력받기
						password = sc.next();

						// 원래 없던 것, 이 코드가 없으면 다시 계좌번호를 만들면 전에 있던 계좌번호에 계좌번호를 덧씌움
						account = "";
						// 예금주 변수에 담겨져 있는 비밀번호가 입력한 비밀번호와 같다면
						if (user.getPassword().equals(password)) {
							while (true) {
								// 새롭게 계좌를 발급받음
								for (int i = 0; i < ACCOUNT_LENGTH; i++) {
									account += random.nextInt(10);
								}
//								if (index == 0) {
//									account += "a";
//								} else if (index == 1) {
//									account += "b";
//								} else if (index == 2) {
//									account += "c";
//								}

								userCheck = Bank.checkAccount(arrBank, arCount, account);
								if (userCheck == null) {
									break;
								}
							}
							System.out.println("새로운 계좌번호로 변경되었습니다.");
							System.out.println("계좌번호: " + account);
							account = user.getAccount().charAt(0) + account;
							// 새로 받은 계좌번호를 다시 집어넣어 준다
							user.setAccount(account);
						}
					} else {
						System.out.println("없는 핸드폰 번호입니다.");
					}
					continue;
				}

//				flag = true;
//				while (flag) {
//					System.out.println("어떤 은행이신지 선택해주세요");
//					System.out.println(message);
//					index = sc.nextInt();
//					if (index == 4) {
//						break;
//					} // 나가기 눌렀을 때에는 while문 즉시 탈출!
//					index--; // 몇 번째 은행인지 인덱스 번호로 쓸 거라서 1을 빼준다.
//					if (user.checkBank(user) == index) {

						System.out.print("계좌번호: ");
						account = sc.next();

						System.out.print("비밀번호: ");
						password = sc.next();

//					} else {
//						System.out.println("은행을 잘못 선택했습니다");
//						break;
//					}
					// 로그인을 할 때 각 은행에 있는 정보들을 가져와 예금주에 집어넣는다
					user = Bank.login(arrBank, arCount, account, password);
					
					switch (choice) {
					case 2: // 입금하기
						// 예금주가 존재한다면
						if (user != null) {
							 if(!user.getAccount().startsWith(index + "")) {
			                     System.out.println("계좌번호를 개설한 은행에서만 입금 서비스 이용이 가능합니다.");
			                     break;
			                  }

							System.out.print("입금액: ");
							// 입금할 돈 입력
							money = sc.nextInt();
							// 입금할 돈이 0원보다 많아야
							if (money > 0) {
								// 돈을 입금할 수 있음
								user.deposit(money);
								System.out.println(money + "원 입금 완료");
								flag = false;
								break;
							} else {
								System.out.println("입금액을 다시 확인해주세요.");
							}
						} else {
							// 정보가 없으면 로그인에 실패함
							System.out.println("로그인 실패");

						}
						break;

					case 3: // 출금하기
						if (user != null) {
							System.out.print("출금액: ");
							money = sc.nextInt();
							if (money > 0) {
								// 내 통장 잔고에 가지고 있는 돈보다 작거나 같은 양이 돈을(국민 은행이라면 수수료가 50%가 있음)
								// 예금주가 국민은행일 시와 아닐 시를 나눔
								// 관계 연산자가 삼항 연산자보다 우선적으로 계산되기 때문에 ()로 우선순위를 높임
								if (user.getMoney() >= (user instanceof Kookmin ? money * 1.5 : money)) {
									// 출금할 수 있음
									user.withdraw(money);
									flag = false;
								} else {
									System.out.println("출금액을 다시 확인해주세요.");
									break;
								}
							}
						} else {
							System.out.println("로그인 실패");
						}
						break;
					case 4: // 잔액 조회
						// 예금주의 정보가 존재한다면 (null이 아니라면)
						if (user != null) {
							System.out.println("현재 잔액: " + user.showBalance());
							flag = false;
						} else {
							System.out.println("로그인 실패");
						}
						break;
					}
//				}
			}
		}
	}
}
