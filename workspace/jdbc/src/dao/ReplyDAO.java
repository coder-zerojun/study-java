package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.ReplyDTO;
import domain.ReplyVO;

public class ReplyDAO {

	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;

//	���� �߰�
	// �̹� �ִ� ��ۿ��� ������ �߰��� �� ����ϴ� �޼ҵ�
	// ��ۿ� ���� ������ �ݿ��ؾ� �ϹǷ� VO��ü�� �޾ƿ���
	// ȭ��ܿ��� � ��ۿ� ������ �ް������� �����ؾ� �ϱ� ������ target�� �޾ƿ´�
	// ���⼭ target�� java������ �츮�� ���������� ȭ�鿡�� �������� ���� ������ �ִ� ��
	// taget�� ���� ���� ����� ���� ���� ���� group���� ������ �ϱ� ������ ����� id�� Ÿ������ �ش�
	public void addReply(ReplyVO replyVO, Long target) {
		String query = "INSERT INTO TBL_REPLY"
				+ "(REPLY_ID, REPLY_CONTENT, USER_ID, BOARD_ID, REPLY_GROUP, REPLY_DEPTH) "
				// depth�� �ش� ��� ���̺��� ����ۼ��� id�� depth������ 1�� �� �־����� �����̱� ������ �� ��ۺ��� depth�� 1 �� �ش�
				+ "VALUES(SEQ_REPLY.NEXTVAL, ?, ?, ?, ?, (SELECT REPLY_DEPTH + 1 FROM TBL_REPLY WHERE REPLY_ID = ?))";

		connection = DBConnecter.getConnection();
		int index = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(++index, replyVO.getReplyContent());
			preparedStatement.setLong(++index, UserDAO.userId);
			preparedStatement.setLong(++index, replyVO.getBoardId());
			// ����� id�� ���� group���� ������ �ѹ��� ��ȸ�� �����ϱ⿡ target���� ����
			preparedStatement.setLong(++index, target);
			preparedStatement.setLong(++index, target);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("addReply(ReplyVO) SQL�� ����");
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

	// ��� �߰�
	// ������ �ƴ� ó�� ����� �ۼ��Ҷ� ���Ǵ� �޼ҵ�
	public void addReply(ReplyVO replyVO) {
		String query = "INSERT INTO TBL_REPLY"
				+ "(REPLY_ID, REPLY_CONTENT, USER_ID, BOARD_ID, REPLY_GROUP, REPLY_DEPTH) "
				// �ڵ�� ���ʿ��� ���������� �а� �Ǵ� reply_group�� ���� ������� �������� ��ȣ�� ����������
				// depth�� ù ����̱� ������ 0���� �־�����
				+ "VALUES(SEQ_REPLY.NEXTVAL, ?, ?, ?, SEQ_REPLY.CURRVAL, 0)";

		connection = DBConnecter.getConnection();
		int index = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(++index, replyVO.getReplyContent());
			preparedStatement.setLong(++index, UserDAO.userId);
			preparedStatement.setLong(++index, replyVO.getBoardId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("addReply(ReplyVO) SQL�� ����");
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

//	��� ��ü ��ȸ
	// ���۱��� ���� ������
	// ��� ����� �������� ������ �� ������ �������� �޾��� �迭�� �����Ѵ�
	// ����� ������ ������ ������ DTO�� �޾ƿ��� ������ �迭�� Ÿ���� �ش� DTO ������ �޾��� �� �ְ� �Ȱ��� DTO�� �������ش�
	public ArrayList<ReplyDTO> selectAll() {
		// ����� �������� �� �� �ش� ��ۿ� ���� ������ ����� �ۼ��� ������ ������ ���� ���������� �Ѵ�
		// reply_count�� �ش� ��ۿ� ������ �󸶳� �޷ȴ����� �������� �����ε� ���� ������ ���ٸ� null���� �ֱ� ������ �� null ���� 0���� �ٲ㼭 �����´�
		String query = "SELECT NVL(REPLY_COUNT, 0) REPLY_COUNT, REPLY_ID, REPLY_CONTENT, R2.USER_ID, BOARD_ID, REPLY_REGISTER_DATE, REPLY_UPDATE_DATE, "
				+ "R2.REPLY_GROUP, REPLY_DEPTH, " + "USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID "
				// ��� ���̺��� reply_group(��� �׷쿡 �����ִ��� Ȯ���ϱ� ����)���� ���� �����͵� �� �� reply_group�� �� ��ۿ� �޸� ����(reply_id)�� �� ��������
				// �������� ����������(��� �� ������ ���� �׷����� ���� ����� ��� �������� ������ ������ ���� �������� �־ 1�� ����) �� view_reply_user��� �� ���̺��� �����Ѵ�
				+ "FROM (SELECT REPLY_GROUP, COUNT(REPLY_ID) - 1 REPLY_COUNT FROM TBL_REPLY GROUP BY REPLY_GROUP) R1 RIGHT OUTER JOIN VIEW_REPLY_USER R2 "
				// ������ ���� ������ ������������ reply_group�� �信 �ִ� reply_group�� ���� �Ͱ� �� reply_group�� reply_id�� ���� ���� �������� �����´�
				+ "ON R1.REPLY_GROUP = R2.REPLY_GROUP AND R1.REPLY_GROUP = R2.REPLY_ID";

		ReplyDTO replyDTO = null;
		int index = 0;
		ArrayList<ReplyDTO> replies = new ArrayList<ReplyDTO>();

		connection = DBConnecter.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				index = 0;
				replyDTO = new ReplyDTO();
				replyDTO.setReplyCount(resultSet.getLong(++index));
				replyDTO.setReplyId(resultSet.getLong(++index));
				replyDTO.setReplyContent(resultSet.getString(++index));
				replyDTO.setUserId(resultSet.getLong(++index));
				replyDTO.setBoardId(resultSet.getLong(++index));
				replyDTO.setReplyRegisterDate(resultSet.getString(++index));
				replyDTO.setReplyUpdateDate(resultSet.getString(++index));
				replyDTO.setReplyGroup(resultSet.getLong(++index));
				replyDTO.setReplyDepth(resultSet.getLong(++index));
				replyDTO.setUserIdentification(resultSet.getString(++index));
				replyDTO.setUserName(resultSet.getString(++index));
				replyDTO.setUserPassword(resultSet.getString(++index));
				replyDTO.setUserPhone(resultSet.getString(++index));
				replyDTO.setUserNickname(resultSet.getString(++index));
				replyDTO.setUserEmail(resultSet.getString(++index));
				replyDTO.setUserAddress(resultSet.getString(++index));
				replyDTO.setUserBirth(resultSet.getString(++index));
				replyDTO.setUserGender(resultSet.getString(++index));
				replyDTO.setUserRecommenderId(resultSet.getString(++index));
				replies.add(replyDTO);

			}

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
		return replies;
	}

	// ������ ����� ��� ��ȸ
	public ReplyDTO selectUserReply(Long replyId) {
		String query = "SELECT NVL(REPLY_COUNT, 0) REPLY_COUNT, REPLY_ID, REPLY_CONTENT, R2.USER_ID, BOARD_ID, REPLY_REGISTER_DATE, REPLY_UPDATE_DATE, "
				+ "R2.REPLY_GROUP, REPLY_DEPTH, " + "USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID "
				+ "FROM (SELECT REPLY_GROUP, COUNT(REPLY_ID) - 1 REPLY_COUNT FROM TBL_REPLY GROUP BY REPLY_GROUP) R1 RIGHT OUTER JOIN VIEW_REPLY_USER R2 "
				+ "ON R1.REPLY_GROUP = R2.REPLY_GROUP AND R1.REPLY_GROUP = R2.REPLY_ID " + "WHERE REPLY_ID = ?";

		ReplyDTO replyDTO = new ReplyDTO();
		int index;
		connection = DBConnecter.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, replyId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				index = 0;
				replyDTO = new ReplyDTO();
				replyDTO.setReplyCount(resultSet.getLong(++index));
				replyDTO.setReplyId(resultSet.getLong(++index));
				replyDTO.setReplyContent(resultSet.getString(++index));
				replyDTO.setUserId(resultSet.getLong(++index));
				replyDTO.setBoardId(resultSet.getLong(++index));
				replyDTO.setReplyRegisterDate(resultSet.getString(++index));
				replyDTO.setReplyUpdateDate(resultSet.getString(++index));
				replyDTO.setReplyGroup(resultSet.getLong(++index));
				replyDTO.setReplyDepth(resultSet.getLong(++index));
				replyDTO.setUserIdentification(resultSet.getString(++index));
				replyDTO.setUserName(resultSet.getString(++index));
				replyDTO.setUserPassword(resultSet.getString(++index));
				replyDTO.setUserPhone(resultSet.getString(++index));
				replyDTO.setUserNickname(resultSet.getString(++index));
				replyDTO.setUserEmail(resultSet.getString(++index));
				replyDTO.setUserAddress(resultSet.getString(++index));
				replyDTO.setUserBirth(resultSet.getString(++index));
				replyDTO.setUserGender(resultSet.getString(++index));
				replyDTO.setUserRecommenderId(resultSet.getString(++index));

			}

		} catch (SQLException e) {
			System.out.println("selectUserReply(Long) SQL�� ����");
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
		return replyDTO;
	}

//	���� ����
	// �ش� ����� �ۼ��� �� ������ ����� ��ȣ�� ����� ����� �� ��۸� ���� �ȴ�
	public void deleteReReply(Long replyId) {
		String query = "DELETE FROM TBL_REPLY WHERE REPLY_ID =?";

		connection = DBConnecter.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, replyId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("deleteReply(Long) SQL�� ����");
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

//	��� ����
	// ����� ���� �� �� group�� �� ����� ������ ��ȣ�� ���� ��������� �׷��� ����� �����ϸ� �� ��۰� ���� ���� ���۵鵵 ����
	// ������ �Ǿ�� �ϱ� ������ �� �� �����ִ� group_id�� �����Ѵ�
	public void deleteReply(Long groupId) {
		String query = "DELETE FROM TBL_REPLY WHERE REPLY_GROUP =?";

		connection = DBConnecter.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, groupId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("deleteReply(Long) SQL�� ����");
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

//	��� ����
	public void updateReply(ReplyVO replyVO) {
		String query = "UPDATE TBL_REPLY SET REPLY_CONTENT = ?, REPLY_UPDATE_DATE = SYSDATE WHERE REPLY_ID = ?";

		connection = DBConnecter.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, replyVO.getReplyContent());
			preparedStatement.setLong(2, replyVO.getReplyId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("deleteReply(Long) SQL�� ����");
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

}
