package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import domain.UserVO;

public class UserDAO {

	// ���� ������������ �ش� ��ü�� �����ϴ� ���� �ƴ϶� �̸� �����Ϸ��� �޸𸮿� �Ҵ���ѳ��Ƽ�
	// userid�� ��� �־ ���߿� �� id�� �˻��ϸ� �ش� ������ �������� �ľ��ϱ� ���� ����
	public static Long userId;

	public Connection connection; // ���� ��ü
	public PreparedStatement preparedStatement; // ���� ���� ��ü
	public ResultSet resultSet; // ��� ���̺� ��ü

//	���̵� �ߺ��˻�
	// �Է��� ���̵� �˻��ؼ� ���� �ߺ��Ǵ� ���� �ִٸ� false�� �����Ѵ�
	public boolean checkId(String userIdentification) {
		// �ߺ��Ǵ� ���̵� �ִٸ� �� ���̵��� ������ �������� �Ǳ� ������ �����Լ��� ������ �����´�
		String query = "SELECT COUNT(USER_ID) FROM TBL_USER WHERE USER_IDENTIFICATION = ?";
		// true, false ���� ����� ���� ����
		boolean result = false;
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userIdentification);
			resultSet = preparedStatement.executeQuery();

			// �����Լ��� ������ ���� �������� ������ if������ �߰� ������ �������� �ʾƵ� �ȴ�
			resultSet.next();
			// ���� �������� id�� ������ �ߺ��Ǵ� ���� �ִٸ� ���ڰ� 0�� �ƴ� ���� ������ ������
			// ���ǽ����� ������ �ϰ� �װ��� Ʋ���� �� ��� result�� false Ȥ�� ������ ���̸� true�� ����
			result = resultSet.getInt(1) == 0;

		} catch (SQLException e) {
			System.out.println("checkId(String) SQL�� ����");
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
		// ���ǽ����� �˻��� ����� true Ȥ�� false�� �����Ѵ�
		return result;
	}

//	ȸ������
	// ���� �޾ƿ� ������ VO��ü�� ��Ƽ� DB�� ������ ���̱� ������ �Ű������� �������� ����ִ� VO�� ����ش�
	public void insert(UserVO userVO) {
		// �Ʒ��� ������ ���� DB�� �����Ͽ� ������ ����ֱ� ���� ����
		String queryForJoin = "INSERT INTO TBL_USER"
				+ "(USER_STATUS, USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, USER_PHONE, USER_BIRTH, USER_EMAIL, USER_ADDRESS, USER_RECOMMENDER_ID) "
				+ "VALUES(1, SEQ_USER.NEXTVAL, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)";

//		 ���� ���̺��� ��õ�� �÷��� �߰��Ͽ�, ȸ�� ���� ��ȸ �� ��õ ���� ���� ���������� ����
//		 String queryForUpdateRecommendCount = 
//				 "UPDATE TBL_USER SET RECOMMEND_COUNT = RECOMMEND_COUNT + 1 WHERE USER_ID = ?";

//		 ���� ��õ �� ��ȸ�� ���� ���, ���̺��� ���� �и��Ͽ� ����Ű�� ������ �� ��ȸ
//		 ���̺��� �и��Ǿ ȸ������ �� TBL_USER�� INSERT �� TBL_RECOMMEND�� ���� INSERT�� �ʿ��ϴ�.
//		 �� �� TRIGGER�� ����Ͽ� TBL_USER�� INSERT�̺�Ʈ �߻� �� TBL_RECOMMEND���� �ڵ����� INSERT �ǵ��� ����
		// ���� �ִ� ȸ������ ������ ����� ���� ��õ���� �����ִ� ���̺� �����ؼ� ��õ���� ���������ֱ� ���� ����
		String queryForUpdateRecommendCount = "UPDATE TBL_RECOMMEND SET RECOMMEND_COUNT = RECOMMEND_COUNT + 1 WHERE USER_ID = ?";

		// USER ���̺��� USER_IDENTIFICATION�� ? �� ����� ID ��ȣ�� �����´�
		String queryForGetUserId = "SELECT USER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = ?";

		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(queryForJoin);
			preparedStatement.setString(1, userVO.getUserIdentification());
			preparedStatement.setString(2, userVO.getUserName());
			// DB�� ������ �� ��ȣȭ�� �� ��й�ȣ�� �����Ѵ�
			preparedStatement.setString(3, encrypt(userVO.getUserPassword()));
			preparedStatement.setString(4, userVO.getUserPhone());
			preparedStatement.setString(5, userVO.getUserBirth());
			preparedStatement.setString(6, userVO.getUserEmail());
			preparedStatement.setString(7, userVO.getUserAddress());
			preparedStatement.setString(8, userVO.getUserRecommenderId());
			preparedStatement.executeUpdate();

			// �޾ƿ� ���� �߿��� ��õ���� IDENTIFICATION ���� �ִٸ�
			if (userVO.getUserRecommenderId() != null) {
				preparedStatement = connection.prepareStatement(queryForGetUserId);
				preparedStatement.setString(1, userVO.getUserRecommenderId());
				// ��õ���� IDENTIFICATION�� �Ѱ��� ���� ���� ����� ID�� �����´�
				resultSet = preparedStatement.executeQuery();

				// ���� ������ ��õ�� ID�� ������ �ִ� ����� ���̶��
				if (resultSet.next()) {
					// �ش� ������ ID�� �ִ� ��õ ���̺� ��õ���� �ϳ� �÷��ش�
					preparedStatement = connection.prepareStatement(queryForUpdateRecommendCount);
					preparedStatement.setLong(1, resultSet.getLong(1));
					preparedStatement.executeUpdate();
				}
			}

		} catch (SQLException e) {
			System.out.println("insert(UserVO) SQL�� ����");
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

//	�α���
	// �ش� ������ IDENTIFICATION �� PASSWORD�� �޾Ƽ� Ȯ���غ��� ������ �α����� ����ȴ�
	public boolean login(String userIdentification, String userPassword) {
		// ���� ���̵� ��й�ȣ�� �Ѵ� ���ٸ� �ش� ������ id ��ȣ�� �����´�
		String query = "SELECT USER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = ? AND USER_PASSWORD = ?";
		// �α����� �� ���¸� �����ϱ� ���� boolean Ÿ������ ���� ����
		boolean check = false;
		// ȸ�� ���¸� ��ȸ�ϴ� �޼ҵ�� ���ڰ��� ��ȯ�ϴ� ������ ��Ƽ� ���
		int userStatus = loginStatus(userIdentification, userPassword);

		// ���� �˻��� ������ ȸ������ ��ϵ� ����̶�� �ȿ� �ִ� ���� �����Ѵ�
		if (userStatus == 1) {

			connection = DBConnecter.getConnection();

			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, userIdentification);
				preparedStatement.setString(2, encrypt(userPassword));

				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					// ������ userid�� ���������� ���� �־� �ְ� �ش� ���α׷��� ������ ������ ������Ų��
					userId = resultSet.getLong(1);
					// ���� id�� ���������� �� ���̵�� ��й�ȣ�� �ش��ϴ� ������ �����ϴ� ���̱⿡
					// �α��� ���¸� true�� �����Ѵ�
					check = true;
				}

			} catch (SQLException e) {
				System.out.println("login(String, String) SQL�� ����");
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
			// ��ȣ�� 0���� ���� ���� ȸ���� �ƴ� �����̴�
		} else if (userStatus == 0) {
			System.out.println("�������� �ʴ� ȸ���Դϴ�");
			// �������� -1 �ۿ� ���µ� �̰��� Ż�� ������ ȸ���̴�
		} else {
			System.out.println("Ż���� ȸ���Դϴ�");
		}
		// �α����� ���¸� �����Ѵ�
		return check;
	}

//	������ ���¸� ��ȸ�ϴ� �޼ҵ�
	// ������ ���̵�� ��й�ȣ�� �޾Ƽ� ����Ѵ�
	public int loginStatus(String userIdentification, String userPassword) {
		// user ���̺��� ������ ���� ���� �޾ƿ´�
		String queryForStatus = "SELECT USER_STATUS, USER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = ? AND USER_PASSWORD = ?";
		// status�� ���ڷ� ǥ���� ���� �� ���ڸ� �޾Ƴ��� ���� ����
		// �⺻ ���� ȸ���� ���� ���� ���·� ǥ��
		int num = 0;

		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(queryForStatus);
			preparedStatement.setString(1, userIdentification);
			preparedStatement.setString(2, encrypt(userPassword));

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				num = resultSet.getInt(1);
				// ���� ������ ���� 1�̸� �� ���� �ش� ������ ȸ���̶�� ��
				if (num == 1) {
					// ���� ������ ���� -1�̶�� �� ���� �ش� ������ Ż�� ������ ���¶�� ��
				} else if (num == -1) {
				}
			}

		} catch (SQLException e) {
			System.out.println("loginStatus(String, String) SQL�� ����");
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
		// ��� ���ڰ��� �����Ѵ�
		return num;
	}

//	ȸ��Ż��
	// �α����� �� ���¿��� ȸ��Ż�� ��ư�� ������ ������ �Ǳ� ������ �޾ƿ��� ���� �ƹ��͵� ����
	public void delete() {
		// �ش� ������ ���� ���� userid�� �´ٸ� ���������� �����Ѵ� �׸��� ���� ���°��� -1�� ������ش�
		String query = "UPDATE TBL_USER SET USER_STATUS = '-1' WHERE USER_ID = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			// �α����� �ϰ� ���� ����� �ִ� �������� ���� id�� �־��ְ� �� ���� �α����� �Ǿ��ִ� ���¿����� ����� �Ǳ� ������
			// �α����� �ȵǾ� ������ ����� �� ����
			preparedStatement.setLong(1, userId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("delete() SQL�� ����");
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

//	���̵� ã��
	// ���̵� ã�� �� ������ ��ȭ��ȣ�� ��ȸ�ϱ� ������ ��ȭ��ȣ�� �޾ƿ´�
	public String findIdentification(String userPhone) {
		// �� ��ȭ��ȣ�� �������� ������ �ֱ� ������ �� ��ȭ��ȣ�� �´ٸ� ������ IDENTIFICATION ���� �����´�
		String query = "SELECT USER_IDENTIFICATION FROM TBL_USER WHERE USER_PHONE = ?";
		String userIdentification = null;

		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userPhone);

			resultSet = preparedStatement.executeQuery();

			// ���� ��ȭ��ȣ�� �߸� �Է��ϸ� null ���� �� ���� �ֱ� ������
			// �ش� ���� �����Ѵٸ� ã���� �ϴ� ���� �����´�
			if (resultSet.next()) {
				userIdentification = resultSet.getString(1);
			}

		} catch (SQLException e) {
			System.out.println("findIdentification(String) SQL�� ����");
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

//	��й�ȣ ����
	// �α����� �Ǿ� �ִ� ���¿��� �ش� ��й�ȣ�� �Է��ϸ� �� ��й�ȣ�� �ٷ� �ٲ� �� �ֵ��� ��
	public void updateUserPassword(String userPassword) {
		String query = "UPDATE TBL_USER SET USER_PASSWORD = ? WHERE USER_ID = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			// Base64������� ��ȣȭ�ؼ� DB�� ����
			preparedStatement.setString(1, new String(Base64.getEncoder().encode(userPassword.getBytes())));
			// �α����� �Ǿ��ִ��� Ȯ���ϱ� ���� ����
			preparedStatement.setLong(2, userId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("updateUserPassword(String) SQL�� ����");
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

//	ȸ������ ����
	// �� �����ؾ� �� ������ �޾ƿ;� �ϱ� ������ �������� ������ �ִ� VO��ü�� ��ƿ´�
	public void update(UserVO userVO) {
		String query = "UPDATE TBL_USER SET USER_NICKNAME = ?, USER_GENDER = ?, USER_BIRTH = TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') WHERE USER_ID = ?";
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userVO.getUserNickname());
			preparedStatement.setString(2, userVO.getUserGender());
			preparedStatement.setString(3, userVO.getUserBirth());
			// �α����� �Ǿ� �ִ� �������� Ȯ��
			preparedStatement.setLong(4, userId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update(UserVO) SQL�� ����");
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

//	ȸ������ ��ȸ
	// ���ǿ� ����ִ� ������ ������ Ȯ�� (����������)
	// static ������ ��� �ִ� userid�� ���ؼ� �ش� ȸ���� ������ �������� ��
	public UserVO select(/* Long userId */) {
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD,"
				+ " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID " + "FROM TBL_USER WHERE USER_ID = ?";
		// VO��ü���� �ش� ������ ������ �����;� �ϱ� ������ ��ü�� �������ش�
		UserVO userVO = null;
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// ������ ���� ������ �ִٸ� �� ������ �����;� �ϱ� ������ if�� �ȿ��� ���� �������ش�
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
			System.out.println("select(Long) SQL�� ����");
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

//	�����ڿ�
	// �����ڰ� ���� �ش��ϴ� ������ ������ ã�ƾ� �ϱ� ������ �ش� ������ id�� ��Ƽ� �˻��Ѵ�
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
			System.out.println("select(Long) SQL�� ����");
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

	// ������ ��� �̸����� �˻�
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
			System.out.println("select(Long) SQL�� ����");
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

//	��õ��
	// ������ identification �� �ް� ���� �� ������ ��õ���� ã�� �޼ҵ�
	public Long getCountOfRecommenderId(String userIdentification) {
		// USER���̺� ��õ����� �÷��� �־���� ��
//		String query = "SELECT RECOMMEND_COUNT FROM TBL_USER WHERE USER_ID = ?";
		// ���̺��� �и��ؼ� ��õ���� ���� �����ϴ� ���̺��� ����� �� �ȿ��� �˻��� ��
		String query = "SELECT RECOMMEND_COUNT FROM TBL_RECOMMEND WHERE USER_ID = ?";
		// ���̺��� �޾ƿ� ��õ���� ��Ƴ��� ����
		Long recommendCount = 0L;
		// �˻��ϴµ� ����� identification�� userid�� ã�Ƽ� ��Ƴ��� ����
		Long userId = select(userIdentification).getUserId();
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			// ã�ƿ� id�� ��õ���� ã�� ���� ��ƿ� id�� ?�� �Ѱ���
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// select���� ��õ���� �޾ƿ����� �޾ƿ� ��õ���� ������ ����
				recommendCount = resultSet.getLong(1);
			}
		} catch (SQLException e) {
			System.out.println("getCountOfRecommenderId(Long) SQL�� ����");
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
		// �޾ƿ� ��õ���� ����
		return recommendCount;
	}

//	���� ��õ�� ���
	// ���� ��õ�� ����� �� ���� �ƴҰ��̰� �� ��õ�� ������� ������ �޾ƿͼ� ����ֱ� ���� arraylist �� ��������
	public ArrayList<UserVO> selectRecommenders() {
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD,"
				+ " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID FROM TBL_USER WHERE USER_RECOMMENDER_ID = ?";

		// �α����� ������ userid���� �� identification�� �޾ƿͼ� ������ �����
		String userIdentification = select(userId).getUserIdentification();
		// user�� ������ ��� ���� ��ü ����
		UserVO userVO = null;
		// ������ arraylist�� �ϱ� ������ ������ �ϱ� ���ؼ� ��ü ����, ��� �޴°� �������� user�� �����̴� VO��ü�� �޴� ������
		// �Ѵ�
		ArrayList<UserVO> users = new ArrayList<UserVO>();

		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			// ��õ���� ���� ���� �̸��̾�� �ϱ� ������ identification�� ����� ��
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
				// �޾ƿ� �������� list�迭�� ����ش�
				users.add(userVO);
			}

		} catch (SQLException e) {
			System.out.println("selectRecommenders() SQL�� ����");
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

//	���� ��õ�� ���
	// ���� ��õ�� ����� ������ �������ֱ� ���� Ÿ���� VOŸ������ ���ش�
	public UserVO getMyRecommender() {
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD,"
				+ " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				// ���ʿ��� �ٷ� ?�� ���� ȭ�鿡�� ����ڿ��� �Է��� �޾ƾ� �ϴ� �����̱� ������
				// ��ư Ŭ�� �ϴ� ���� ���� ��õ�� ����� ������ �ٷ� �����;� �ϱ� ������ ���������� ���ȴ�
				+ "USER_GENDER, USER_RECOMMENDER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = " + "("
				// ���� ��õ�� ����� ���̵� �����;� ��
				+ "SELECT USER_RECOMMENDER_ID FROM TBL_USER WHERE USER_ID = ?" + ")";
		// �޾ƿ� ������ ������ ��ü����
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
			System.out.println("getMyRecommender() SQL�� ����");
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

	// ��ȣȭ �޼ҵ�
	public String encrypt(String password) {
		// base64�� �������� �� ��ȣȭ �޼ҵ�
		// base64�� static �޼ҵ�� encoder��� ���� ��������, encode��� ���� ����Ʈ �迭�� �޾Ƽ� ��ȣȭ�� �����Ѵ�. ���
		// encoder��
		// ��ȣȭ�� ����Ʈ�迭�� �״�� �����ϹǷ� �츮�� ����ϱ� ���ؼ��� �ٽ� String Ÿ������ ��ȯ�ؾ� �Ѵ�
		return new String(Base64.getEncoder().encode(password.getBytes()));
	}

	// �ȷο츦 �����ϴ� �޼ҵ�
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
			System.out.println("insertFollow(Long) SQL�� ����");
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

//		������ �ȷο� ���� Ȯ���ϴ� �޼ҵ�
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

//	���� �ȷο��� ������� ���� ��ȸ
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
			System.out.println("selectFollowing() SQL�� ����");
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

//		���� �ȷο� �� ��� ���� ��ȸ
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
			System.out.println("selectInfoFollwingMe() SQL�� ����");
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

//			���� �ȷο� �� ��� ���� ��ȸ
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
			System.out.println("selectInfoFollwingMe() SQL�� ����");
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
