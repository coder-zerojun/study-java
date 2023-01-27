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

//	대댓글 추가
	// 이미 있는 댓글에서 대댓글을 추가할 때 사용하는 메소드
	// 댓글에 대한 정보를 반영해야 하므로 VO객체를 받아오며
	// 화면단에서 어떤 댓글에 대댓글을 달것인지도 선택해야 하기 때문에 target을 받아온다
	// 여기서 target은 java에서는 우리가 지정하지만 화면에서 가져오는 것을 지정해 주는 것
	// taget은 현재 내가 댓글을 쓰는 곳과 같은 group으로 묶여야 하기 때문에 댓글의 id를 타겟으로 준다
	public void addReply(ReplyVO replyVO, Long target) {
		String query = "INSERT INTO TBL_REPLY"
				+ "(REPLY_ID, REPLY_CONTENT, USER_ID, BOARD_ID, REPLY_GROUP, REPLY_DEPTH) "
				// depth는 해당 댓글 테이블에서 댓글작성된 id의 depth값보다 1가 더 주어져야 대댓글이기 때문에 원 댓글보다 depth를 1 더 준다
				+ "VALUES(SEQ_REPLY.NEXTVAL, ?, ?, ?, ?, (SELECT REPLY_DEPTH + 1 FROM TBL_REPLY WHERE REPLY_ID = ?))";

		connection = DBConnecter.getConnection();
		int index = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(++index, replyVO.getReplyContent());
			preparedStatement.setLong(++index, UserDAO.userId);
			preparedStatement.setLong(++index, replyVO.getBoardId());
			// 댓글의 id와 같은 group으로 묶여야 한번에 조회가 가능하기에 target으로 지정
			preparedStatement.setLong(++index, target);
			preparedStatement.setLong(++index, target);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("addReply(ReplyVO) SQL문 오류");
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

	// 댓글 추가
	// 대댓글이 아닌 처음 댓글을 작성할때 사용되는 메소드
	public void addReply(ReplyVO replyVO) {
		String query = "INSERT INTO TBL_REPLY"
				+ "(REPLY_ID, REPLY_CONTENT, USER_ID, BOARD_ID, REPLY_GROUP, REPLY_DEPTH) "
				// 코드는 왼쪽에서 오른쪽으로 읽게 되니 reply_group은 현재 만들어진 시퀀스의 번호가 가져와지고
				// depth는 첫 댓글이기 때문에 0으로 주어진다
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
			System.out.println("addReply(ReplyVO) SQL문 오류");
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

//	댓글 전체 조회
	// 대댓글까지 전부 가져옴
	// 모든 댓글을 가져오기 때문에 각 가져온 정보들을 받아줄 배열로 선언한다
	// 댓글의 정보와 유저의 정보를 DTO에 받아오기 때문에 배열의 타입은 해당 DTO 정보를 받아줄 수 있게 똑같은 DTO로 지정해준다
	public ArrayList<ReplyDTO> selectAll() {
		// 댓글을 가져오게 될 때 해당 댓글에 대한 정보와 댓글을 작성한 유저의 정보도 같이 가져오도록 한다
		// reply_count는 해당 댓글에 대댓글이 얼마나 달렸는지를 가져오는 쿼리인데 만약 대댓글이 없다면 null값이 있기 때문에 그 null 값을 0으로 바꿔서 가져온다
		String query = "SELECT NVL(REPLY_COUNT, 0) REPLY_COUNT, REPLY_ID, REPLY_CONTENT, R2.USER_ID, BOARD_ID, REPLY_REGISTER_DATE, REPLY_UPDATE_DATE, "
				+ "R2.REPLY_GROUP, REPLY_DEPTH, " + "USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID "
				// 댓글 테이블에서 reply_group(어느 그룹에 속해있는지 확인하기 위해)별로 묶인 데이터들 중 각 reply_group과 각 댓글에 달린 대댓글(reply_id)가 몇 개인지를
				// 가져오는 서브쿼리문(대신 이 쿼리는 같은 그룹으로 속한 댓글은 모두 가져오기 때문에 본인의 값도 포함해져 있어서 1을 뺀다) 과 view_reply_user라는 뷰 테이블을 조인한다
				+ "FROM (SELECT REPLY_GROUP, COUNT(REPLY_ID) - 1 REPLY_COUNT FROM TBL_REPLY GROUP BY REPLY_GROUP) R1 RIGHT OUTER JOIN VIEW_REPLY_USER R2 "
				// 조인할 때의 조건은 서브쿼리문의 reply_group과 뷰에 있는 reply_group이 같은 것과 그 reply_group이 reply_id와 같을 때의 정보들을 가져온다
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

	// 지정한 사람의 댓글 조회
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
			System.out.println("selectUserReply(Long) SQL문 오류");
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

//	대댓글 삭제
	// 해당 댓글을 작성할 때 생성된 댓글의 번호로 댓글을 지우니 그 댓글만 삭제 된다
	public void deleteReReply(Long replyId) {
		String query = "DELETE FROM TBL_REPLY WHERE REPLY_ID =?";

		connection = DBConnecter.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, replyId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("deleteReply(Long) SQL문 오류");
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

//	댓글 삭제
	// 댓글을 삭제 할 때 group은 그 댓글의 시퀀스 번호를 따라서 만들어진다 그러니 댓글을 삭제하면 그 댓글과 같이 묶인 대댓글들도 같이
	// 삭제가 되어야 하기 때문에 한 대 묶여있는 group_id를 삭제한다
	public void deleteReply(Long groupId) {
		String query = "DELETE FROM TBL_REPLY WHERE REPLY_GROUP =?";

		connection = DBConnecter.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, groupId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("deleteReply(Long) SQL문 오류");
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

//	댓글 수정
	public void updateReply(ReplyVO replyVO) {
		String query = "UPDATE TBL_REPLY SET REPLY_CONTENT = ?, REPLY_UPDATE_DATE = SYSDATE WHERE REPLY_ID = ?";

		connection = DBConnecter.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, replyVO.getReplyContent());
			preparedStatement.setLong(2, replyVO.getReplyId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("deleteReply(Long) SQL문 오류");
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
