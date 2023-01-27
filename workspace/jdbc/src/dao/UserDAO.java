package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import domain.UserVO;

public class UserDAO {

	// 간이 세션형식으로 해당 객체를 선언하는 것이 아니라 미리 컴파일러가 메모리에 할당시켜놓아서
	// userid를 담고 있어서 나중에 그 id를 검사하면 해당 유저가 누구인지 파악하기 위한 목적
	public static Long userId;

	public Connection connection; // 연결 객체
	public PreparedStatement preparedStatement; // 쿼리 관리 객체
	public ResultSet resultSet; // 결과 테이블 객체

//	아이디 중복검사
	// 입력한 아이디를 검사해서 만약 중복되는 값이 있다면 false를 리턴한다
	public boolean checkId(String userIdentification) {
		// 중복되는 아이디가 있다면 그 아이디의 갯수만 가져오면 되기 때문에 집계함수로 갯수를 가져온다
		String query = "SELECT COUNT(USER_ID) FROM TBL_USER WHERE USER_IDENTIFICATION = ?";
		// true, false 값을 담아줄 변수 선언
		boolean result = false;
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userIdentification);
			resultSet = preparedStatement.executeQuery();

			// 집계함수는 무조건 값을 가져오기 때문에 if문으로 추가 조건을 설정하지 않아도 된다
			resultSet.next();
			// 만약 가져오는 id의 갯수가 중복되는 것이 있다면 숫자가 0이 아닌 것이 나오기 때문에
			// 조건식으로 설정을 하고 그것이 틀리게 될 경우 result에 false 혹은 조건이 참이면 true가 담긴다
			result = resultSet.getInt(1) == 0;

		} catch (SQLException e) {
			System.out.println("checkId(String) SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		// 조건식으로 검사한 결과인 true 혹은 false를 리턴한다
		return result;
	}

//	회원가입
	// 각자 받아온 정보를 VO객체에 담아서 DB로 날려줄 것이기 때문에 매개변수로 정보들이 담겨있는 VO를 담아준다
	public void insert(UserVO userVO) {
		// 아래의 쿼리는 먼저 DB에 접근하여 정보를 담아주기 위한 쿼리
		String queryForJoin = "INSERT INTO TBL_USER"
				+ "(USER_STATUS, USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, USER_PHONE, USER_BIRTH, USER_EMAIL, USER_ADDRESS, USER_RECOMMENDER_ID) "
				+ "VALUES(1, SEQ_USER.NEXTVAL, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)";

//		 기존 테이블에서 추천수 컬럼을 추가하여, 회원 정보 조회 시 추천 수도 같이 가져오도록 설계
//		 String queryForUpdateRecommendCount = 
//				 "UPDATE TBL_USER SET RECOMMEND_COUNT = RECOMMEND_COUNT + 1 WHERE USER_ID = ?";

//		 만약 추천 수 조회가 잦을 경우, 테이블을 따로 분리하여 서브키를 설정한 뒤 조회
//		 테이블이 분리되어서 회원가입 시 TBL_USER에 INSERT 후 TBL_RECOMMEND도 같이 INSERT가 필요하다.
//		 이 때 TRIGGER를 사용하여 TBL_USER에 INSERT이벤트 발생 시 TBL_RECOMMEND에도 자동으로 INSERT 되도록 설계
		// 위에 있는 회원가입 쿼리가 진행된 이후 추천수가 적혀있는 테이블에 접근해서 추천수를 증가시켜주기 위한 쿼리
		String queryForUpdateRecommendCount = "UPDATE TBL_RECOMMEND SET RECOMMEND_COUNT = RECOMMEND_COUNT + 1 WHERE USER_ID = ?";

		// USER 테이블에서 USER_IDENTIFICATION이 ? 인 사람의 ID 번호를 가져온다
		String queryForGetUserId = "SELECT USER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = ?";

		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(queryForJoin);
			preparedStatement.setString(1, userVO.getUserIdentification());
			preparedStatement.setString(2, userVO.getUserName());
			// DB에 저장할 때 암호화가 된 비밀번호를 저장한다
			preparedStatement.setString(3, encrypt(userVO.getUserPassword()));
			preparedStatement.setString(4, userVO.getUserPhone());
			preparedStatement.setString(5, userVO.getUserBirth());
			preparedStatement.setString(6, userVO.getUserEmail());
			preparedStatement.setString(7, userVO.getUserAddress());
			preparedStatement.setString(8, userVO.getUserRecommenderId());
			preparedStatement.executeUpdate();

			// 받아온 값들 중에서 추천인의 IDENTIFICATION 값이 있다면
			if (userVO.getUserRecommenderId() != null) {
				preparedStatement = connection.prepareStatement(queryForGetUserId);
				preparedStatement.setString(1, userVO.getUserRecommenderId());
				// 추천인의 IDENTIFICATION이 넘겨준 값과 같은 사람의 ID를 가져온다
				resultSet = preparedStatement.executeQuery();

				// 만약 가져온 추천인 ID가 실제로 있는 사람의 값이라면
				if (resultSet.next()) {
					// 해당 유저의 ID가 있는 추천 테이블에 추천수를 하나 올려준다
					preparedStatement = connection.prepareStatement(queryForUpdateRecommendCount);
					preparedStatement.setLong(1, resultSet.getLong(1));
					preparedStatement.executeUpdate();
				}
			}

		} catch (SQLException e) {
			System.out.println("insert(UserVO) SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

//	로그인
	// 해당 유저의 IDENTIFICATION 과 PASSWORD를 받아서 확인해보고 맞으면 로그인이 진행된다
	public boolean login(String userIdentification, String userPassword) {
		// 만약 아이디 비밀번호가 둘다 같다면 해당 유저의 id 번호를 가져온다
		String query = "SELECT USER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = ? AND USER_PASSWORD = ?";
		// 로그인이 된 상태를 결정하기 위해 boolean 타입으로 변수 설정
		boolean check = false;
		// 회원 상태를 조회하는 메소드는 숫자값을 반환하니 변수에 담아서 사용
		int userStatus = loginStatus(userIdentification, userPassword);

		// 만약 검색한 유저가 회원으로 등록된 사람이라면 안에 있는 식을 진행한다
		if (userStatus == 1) {

			connection = DBConnecter.getConnection();

			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, userIdentification);
				preparedStatement.setString(2, encrypt(userPassword));

				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					// 가져온 userid를 전역변수에 집어 넣어 주고 해당 프로그램이 끝나기 전까지 유지시킨다
					userId = resultSet.getLong(1);
					// 만약 id를 가져왔으면 그 아이디와 비밀번호에 해당하는 유저가 존재하는 것이기에
					// 로그인 상태를 true로 결정한다
					check = true;
				}

			} catch (SQLException e) {
				System.out.println("login(String, String) SQL문 오류");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (resultSet != null) {
						resultSet.close();
					}
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			// 번호가 0번인 것은 아직 회원이 아닌 상태이다
		} else if (userStatus == 0) {
			System.out.println("존재하지 않는 회원입니다");
			// 나머지는 -1 밖에 없는데 이것은 탈퇴를 진행한 회원이다
		} else {
			System.out.println("탈퇴한 회원입니다");
		}
		// 로그인의 상태를 리턴한다
		return check;
	}

//	유저의 상태를 조회하는 메소드
	// 유저의 아이디와 비밀번호를 받아서 사용한다
	public int loginStatus(String userIdentification, String userPassword) {
		// user 테이블에서 유저의 상태 값을 받아온다
		String queryForStatus = "SELECT USER_STATUS, USER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = ? AND USER_PASSWORD = ?";
		// status는 숫자로 표시해 놔서 그 숫자를 받아놓을 변수 설정
		// 기본 값은 회원이 되지 않은 상태로 표시
		int num = 0;

		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(queryForStatus);
			preparedStatement.setString(1, userIdentification);
			preparedStatement.setString(2, encrypt(userPassword));

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				num = resultSet.getInt(1);
				// 만약 가져온 값이 1이면 그 값은 해당 유저가 회원이라는 뜻
				if (num == 1) {
					// 만약 가져온 값이 -1이라면 그 값은 해당 유저가 탈퇴를 진행한 상태라는 뜻
				} else if (num == -1) {
				}
			}

		} catch (SQLException e) {
			System.out.println("loginStatus(String, String) SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		// 담긴 숫자값을 리턴한다
		return num;
	}

//	회원탈퇴
	// 로그인이 된 상태에서 회원탈퇴 버튼만 누르면 진행이 되기 때문에 받아오는 것은 아무것도 없다
	public void delete() {
		// 해당 유저의 고유 값인 userid가 맞다면 삭제절차를 진행한다 그리고 유저 상태값을 -1로 만들어준다
		String query = "UPDATE TBL_USER SET USER_STATUS = '-1' WHERE USER_ID = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			// 로그인을 하고 나서 담겨져 있는 전역변수 값인 id를 넣어주고 이 값은 로그인이 되어있는 상태에서만 사용이 되기 때문에
			// 로그인이 안되어 있으면 사용할 수 없다
			preparedStatement.setLong(1, userId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("delete() SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

//	아이디 찾기
	// 아이디를 찾을 때 유저의 전화번호로 조회하기 때문에 전화번호를 받아온다
	public String findIdentification(String userPhone) {
		// 각 전화번호는 고유값을 가지고 있기 때문에 그 전화번호가 맞다면 유저의 IDENTIFICATION 값을 가져온다
		String query = "SELECT USER_IDENTIFICATION FROM TBL_USER WHERE USER_PHONE = ?";
		String userIdentification = null;

		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userPhone);

			resultSet = preparedStatement.executeQuery();

			// 만약 전화번호를 잘못 입력하면 null 값이 뜰 수도 있기 때문에
			// 해당 값이 존재한다면 찾고자 하는 값을 가져온다
			if (resultSet.next()) {
				userIdentification = resultSet.getString(1);
			}

		} catch (SQLException e) {
			System.out.println("findIdentification(String) SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return userIdentification;
	}

//	비밀번호 변경
	// 로그인이 되어 있는 상태에서 해당 비밀번호를 입력하면 그 비밀번호로 바로 바뀔 수 있도록 함
	public void updateUserPassword(String userPassword) {
		String query = "UPDATE TBL_USER SET USER_PASSWORD = ? WHERE USER_ID = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			// Base64방식으로 암호화해서 DB에 들어간다
			preparedStatement.setString(1, new String(Base64.getEncoder().encode(userPassword.getBytes())));
			// 로그인이 되어있는지 확인하기 위한 절차
			preparedStatement.setLong(2, userId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("updateUserPassword(String) SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

//	회원정보 수정
	// 각 수정해야 할 값들을 받아와야 하기 때문에 정보들이 적어져 있는 VO객체를 담아온다
	public void update(UserVO userVO) {
		String query = "UPDATE TBL_USER SET USER_NICKNAME = ?, USER_GENDER = ?, USER_BIRTH = TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') WHERE USER_ID = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userVO.getUserNickname());
			preparedStatement.setString(2, userVO.getUserGender());
			preparedStatement.setString(3, userVO.getUserBirth());
			// 로그인이 되어 있는 상태인지 확인
			preparedStatement.setLong(4, userId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update(UserVO) SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

//	회원정보 조회
	// 세션에 담겨있는 유저의 정보를 확인 (마이페이지)
	// static 변수에 담겨 있는 userid를 통해서 해당 회원의 정보를 가져오는 것
	public UserVO select(/* Long userId */) {
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD,"
				+ " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID " + "FROM TBL_USER WHERE USER_ID = ?";
		// VO객체에서 해당 유저의 정보를 가져와야 하기 때문에 객체를 선언해준다
		UserVO userVO = null;
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// 유저의 관한 정보가 있다면 그 정보를 가져와야 하기 때문에 if문 안에서 새로 정의해준다
				userVO = new UserVO();
				userVO.setUserId(resultSet.getLong(1));
				userVO.setUserIdentification(resultSet.getString(2));
				userVO.setUserName(resultSet.getString(3));
				userVO.setUserPassword(resultSet.getString(4));
				userVO.setUserPhone(resultSet.getString(5));
				userVO.setUserNickname(resultSet.getString(6));
				userVO.setUserEmail(resultSet.getString(7));
				userVO.setUserAddress(resultSet.getString(8));
				userVO.setUserBirth(resultSet.getString(9));
				userVO.setUserGender(resultSet.getString(10));
				userVO.setUserRecommenderId(resultSet.getString(11));
			}

		} catch (SQLException e) {
			System.out.println("select(Long) SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return userVO;
	}

//	관리자용
	// 관리자가 직접 해당하는 유저의 정보를 찾아야 하기 때문에 해당 유저의 id를 담아서 검색한다
	public UserVO select(Long userId) {
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD,"
				+ " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID " + "FROM TBL_USER WHERE USER_ID = ?";
		UserVO userVO = null;
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				userVO = new UserVO();
				userVO.setUserId(resultSet.getLong(1));
				userVO.setUserIdentification(resultSet.getString(2));
				userVO.setUserName(resultSet.getString(3));
				userVO.setUserPassword(resultSet.getString(4));
				userVO.setUserPhone(resultSet.getString(5));
				userVO.setUserNickname(resultSet.getString(6));
				userVO.setUserEmail(resultSet.getString(7));
				userVO.setUserAddress(resultSet.getString(8));
				userVO.setUserBirth(resultSet.getString(9));
				userVO.setUserGender(resultSet.getString(10));
				userVO.setUserRecommenderId(resultSet.getString(11));
			}

		} catch (SQLException e) {
			System.out.println("select(Long) SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return userVO;
	}

	// 관리자 대신 이름으로 검색
	public UserVO select(String userIdentification) {
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD,"
				+ " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID " + "FROM TBL_USER WHERE USER_IDENTIFICATION = ?";
		UserVO userVO = null;
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userIdentification);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				userVO = new UserVO();
				userVO.setUserId(resultSet.getLong(1));
				userVO.setUserIdentification(resultSet.getString(2));
				userVO.setUserName(resultSet.getString(3));
				userVO.setUserPassword(resultSet.getString(4));
				userVO.setUserPhone(resultSet.getString(5));
				userVO.setUserNickname(resultSet.getString(6));
				userVO.setUserEmail(resultSet.getString(7));
				userVO.setUserAddress(resultSet.getString(8));
				userVO.setUserBirth(resultSet.getString(9));
				userVO.setUserGender(resultSet.getString(10));
				userVO.setUserRecommenderId(resultSet.getString(11));
			}

		} catch (SQLException e) {
			System.out.println("select(Long) SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return userVO;
	}

//	추천수
	// 유저의 identification 을 받고 나면 그 유저의 추천수를 찾는 메소드
	public Long getCountOfRecommenderId(String userIdentification) {
		// USER테이블에 추천수라는 컬럼을 넣어놨을 때
//		String query = "SELECT RECOMMEND_COUNT FROM TBL_USER WHERE USER_ID = ?";
		// 테이블을 분리해서 추천수를 따로 지정하는 테이블을 만들고 그 안에서 검색할 때
		String query = "SELECT RECOMMEND_COUNT FROM TBL_RECOMMEND WHERE USER_ID = ?";
		// 테이블에서 받아온 추천수를 담아놓을 변수
		Long recommendCount = 0L;
		// 검색하는데 사용한 identification의 userid를 찾아서 담아놓을 변수
		Long userId = select(userIdentification).getUserId();
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			// 찾아온 id의 추천수를 찾기 위해 담아온 id를 ?에 넘겨줌
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// select에서 추천수를 받아왔으니 받아온 추천수를 변수에 담음
				recommendCount = resultSet.getLong(1);
			}
		} catch (SQLException e) {
			System.out.println("getCountOfRecommenderId(Long) SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		// 받아온 추천수를 리턴
		return recommendCount;
	}

//	나를 추천한 사람
	// 나를 추천한 사람이 한 둘이 아닐것이고 그 추천한 사람들의 정보를 받아와서 담아주기 위해 arraylist 로 선언해줌
	public ArrayList<UserVO> selectRecommenders() {
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD,"
				+ " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID FROM TBL_USER WHERE USER_RECOMMENDER_ID = ?";

		// 로그인한 유저의 userid에서 그 identification을 받아와서 변수에 담아줌
		String userIdentification = select(userId).getUserIdentification();
		// user의 정보를 담기 위해 객체 선언
		UserVO userVO = null;
		// 리턴을 arraylist로 하기 때문에 리턴을 하기 위해서 객체 설정, 대신 받는건 가져오는 user의 정보이니 VO객체를 받는 것으로
		// 한다
		ArrayList<UserVO> users = new ArrayList<UserVO>();

		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			// 추천인이 내가 가진 이름이어야 하기 때문에 identification을 담아준 것
			preparedStatement.setString(1, userIdentification);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				userVO = new UserVO();
				userVO.setUserId(resultSet.getLong(1));
				userVO.setUserIdentification(resultSet.getString(2));
				userVO.setUserName(resultSet.getString(3));
				userVO.setUserPassword(resultSet.getString(4));
				userVO.setUserPhone(resultSet.getString(5));
				userVO.setUserNickname(resultSet.getString(6));
				userVO.setUserEmail(resultSet.getString(7));
				userVO.setUserAddress(resultSet.getString(8));
				userVO.setUserBirth(resultSet.getString(9));
				userVO.setUserGender(resultSet.getString(10));
				userVO.setUserRecommenderId(resultSet.getString(11));
				// 받아온 정보들을 list배열에 담아준다
				users.add(userVO);
			}

		} catch (SQLException e) {
			System.out.println("selectRecommenders() SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return users;
	}

//	내가 추천한 사람
	// 내가 추천한 사람의 정보를 가져와주기 위해 타입을 VO타입으로 해준다
	public UserVO getMyRecommender() {
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD,"
				+ " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				// 이쪽에서 바로 ?를 쓰면 화면에서 사용자에게 입력을 받아야 하는 정보이기 때문에
				// 버튼 클릭 하는 순간 내가 추천한 사람의 정보를 바로 가져와야 하기 때문에 서브쿼리가 사용된다
				+ "USER_GENDER, USER_RECOMMENDER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = " + "("
				// 내가 추천한 사람의 아이디를 가져와야 함
				+ "SELECT USER_RECOMMENDER_ID FROM TBL_USER WHERE USER_ID = ?" + ")";
		// 받아올 정보를 저장할 객체지정
		UserVO userVO = null;

		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				userVO = new UserVO();
				userVO.setUserId(resultSet.getLong(1));
				userVO.setUserIdentification(resultSet.getString(2));
				userVO.setUserName(resultSet.getString(3));
				userVO.setUserPassword(resultSet.getString(4));
				userVO.setUserPhone(resultSet.getString(5));
				userVO.setUserNickname(resultSet.getString(6));
				userVO.setUserEmail(resultSet.getString(7));
				userVO.setUserAddress(resultSet.getString(8));
				userVO.setUserBirth(resultSet.getString(9));
				userVO.setUserGender(resultSet.getString(10));
				userVO.setUserRecommenderId(resultSet.getString(11));
			}

		} catch (SQLException e) {
			System.out.println("getMyRecommender() SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return userVO;
	}

	// 암호화 메소드
	public String encrypt(String password) {
		// base64를 기준으로 한 암호화 메소드
		// base64는 static 메소드로 encoder라는 것을 가져오며, encode라는 것은 바이트 배열을 받아서 암호화를 진행한다. 대신
		// encoder는
		// 암호화된 바이트배열을 그대로 리턴하므로 우리가 사용하기 위해서는 다시 String 타입으로 변환해야 한다
		return new String(Base64.getEncoder().encode(password.getBytes()));
	}

	// 팔로우를 진행하는 메소드
	public void insertFollow(Long Id) {
		String query = "INSERT INTO TBL_FOLLOW " + "(FOLLOW_ID, FOLLOWER_ID, FOLLOWING_ID)"
				+ "VALUES(SEQ_FOLLOW.NEXTVAL, ?, ?)";

		connection = DBConnecter.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, Id);
			preparedStatement.setLong(2, userId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insertFollow(Long) SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

//		유저의 팔로우 수를 확인하는 메소드
	public int selectFollower() {
		String query = "SELECT NVL(COUNT(FOLLOWER_ID),0) FROM TBL_FOLLOW WHERE FOLLOWING_ID = ?";

		int count = 0;
		connection = DBConnecter.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();
			count = resultSet.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return count;
	}

//	나를 팔로우한 사람들의 수를 조회
	public int selectFollowing() {
		String query = "SELECT NVL(COUNT(FOLLOWING_ID),0) FROM TBL_FOLLOW WHERE FOLLOWER_ID = ?";
		int count = 0;
		connection = DBConnecter.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();
			count = resultSet.getInt(1);

		} catch (SQLException e) {
			System.out.println("selectFollowing() SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return count;
	}

//		나를 팔로우 한 사람 정보 조회
	public ArrayList<UserVO> selectInfoFollowingMe() {
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID " + "FROM TBL_USER U JOIN TBL_FOLLOW F "
				+ "ON U.USER_ID = F.FOLLOWING_ID AND F.FOLLOWER_ID = ?";
		UserVO userVO = null;
		int index = 0;
		ArrayList<UserVO> arrays = new ArrayList<>();

		connection = DBConnecter.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				index = 0;
				userVO = new UserVO();
				userVO.setUserId(resultSet.getLong(++index));
				userVO.setUserIdentification(resultSet.getString(++index));
				userVO.setUserName(resultSet.getString(++index));
				userVO.setUserPassword(resultSet.getString(++index));
				userVO.setUserPhone(resultSet.getString(++index));
				userVO.setUserNickname(resultSet.getString(++index));
				userVO.setUserEmail(resultSet.getString(++index));
				userVO.setUserAddress(resultSet.getString(++index));
				userVO.setUserBirth(resultSet.getString(++index));
				userVO.setUserGender(resultSet.getString(++index));
				userVO.setUserRecommenderId(resultSet.getString(++index));
				arrays.add(userVO);
			}

		} catch (SQLException e) {
			System.out.println("selectInfoFollwingMe() SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return arrays;
	}

//			나를 팔로우 한 사람 정보 조회
	public ArrayList<UserVO> selectInfoFollowByMe() {
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID " + "FROM TBL_USER U JOIN TBL_FOLLOW F "
				+ "ON U.USER_ID = F.FOLLOWER_ID AND F.FOLLOWING_ID = ?";
		UserVO userVO = null;
		int index = 0;
		ArrayList<UserVO> arrays = new ArrayList<>();

		connection = DBConnecter.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				index = 0;
				userVO = new UserVO();
				userVO.setUserId(resultSet.getLong(++index));
				userVO.setUserIdentification(resultSet.getString(++index));
				userVO.setUserName(resultSet.getString(++index));
				userVO.setUserPassword(resultSet.getString(++index));
				userVO.setUserPhone(resultSet.getString(++index));
				userVO.setUserNickname(resultSet.getString(++index));
				userVO.setUserEmail(resultSet.getString(++index));
				userVO.setUserAddress(resultSet.getString(++index));
				userVO.setUserBirth(resultSet.getString(++index));
				userVO.setUserGender(resultSet.getString(++index));
				userVO.setUserRecommenderId(resultSet.getString(++index));
				arrays.add(userVO);
			}

		} catch (SQLException e) {
			System.out.println("selectInfoFollwingMe() SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return arrays;
	}

}
