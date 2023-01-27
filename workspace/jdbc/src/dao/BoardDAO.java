package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.BoardDTO;
import domain.BoardVO;

public class BoardDAO {
   public Connection connection; //연결 객체
   public PreparedStatement preparedStatement; //쿼리 관리 객체
   public ResultSet resultSet; //결과 테이블 객체
   
//   게시글 추가
   // 게시글에 관련한 정보들을 받아와서 넘겨줘야 하기 때문에 VO객체를 가져와준다
   public void insert(BoardVO boardVO) {
      String query = "INSERT INTO TBL_BOARD"
            + "(BOARD_ID, BOARD_TITLE, BOARD_CONTENT, BOARD_REGISTER_DATE, BOARD_UPDATE_DATE, USER_ID) "
            + "VALUES(SEQ_BOARD.NEXTVAL, ?, ?, SYSDATE, SYSDATE, ?)";
      connection = DBConnecter.getConnection();
      
      try {
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, boardVO.getBoardTitle());
         preparedStatement.setString(2, boardVO.getBoardContent());
         preparedStatement.setLong(3, boardVO.getUserId());
         preparedStatement.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e);
         }
      }
   }
//   게시글 조회
//   게시글 번호를 받고 그 번호로 조회한다
//   대신 조회할 때 어떤 정보를 필요로 하게 될지 모르기 때문에 board에 관한 정보와 그 게시글을 작성한 user의 정보가 둘다 필요할 수 있기 때문에
//   2개를 화면에서 보여줄 수 있게 할 DTO를 설정하고 그것을 가져온다
//   user와 board를 조인해서 가져오기 때문에 이 2개를 받을 객체가 없어서 DTO를 만드는 것
   public BoardDTO select(Long boardId) {
      String query = "SELECT BOARD_ID, BOARD_TITLE, BOARD_CONTENT, BOARD_REGISTER_DATE, "
            + " BOARD_UPDATE_DATE, U.USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
            + " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, "
            + " USER_RECOMMENDER_ID "
            + "FROM TBL_USER U JOIN TBL_BOARD B "
            + "ON U.USER_ID = B.USER_ID AND BOARD_ID = ?";
      
      BoardDTO boardDTO = null;
      // 각 해당 행의 번호를 가져오게 하기 위해 index 설정
      int index = 0;
      connection = DBConnecter.getConnection();
      try {
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setLong(1, boardId);
         resultSet = preparedStatement.executeQuery();
         if(resultSet.next()) {
            boardDTO = new BoardDTO();
            boardDTO.setBoardId(resultSet.getLong(++index));
            boardDTO.setBoardTitle(resultSet.getString(++index));
            boardDTO.setBoardContent(resultSet.getString(++index));
            boardDTO.setBoardRegisterDate(resultSet.getString(++index));
            boardDTO.setBoardUpdateDate(resultSet.getString(++index));
            boardDTO.setUserId(resultSet.getLong(++index));
            boardDTO.setUserIdentification(resultSet.getString(++index));
            boardDTO.setUserName(resultSet.getString(++index));
            boardDTO.setUserPassword(resultSet.getString(++index));
            boardDTO.setUserPhone(resultSet.getString(++index));
            boardDTO.setUserNickname(resultSet.getString(++index));
            boardDTO.setUserEmail(resultSet.getString(++index));
            boardDTO.setUserAddress(resultSet.getString(++index));
            boardDTO.setUserBirth(resultSet.getString(++index));
            boardDTO.setUserGender(resultSet.getString(++index));
            boardDTO.setUserRecommenderId(resultSet.getString(++index));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(resultSet != null) {
               resultSet.close();
            }
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e);
         }
      }
      
      return boardDTO;
   }
//   게시글 수정
   // 로그인이 되어있는 상태에서 수정이 가능하며
   // 수정해야 되는 정보들을 가져와야 되기 때문에 정보들이 저장되어있는 VO객체를 가져온다
   public void update(BoardVO boardVO) {
      String query = "UPDATE TBL_BOARD SET BOARD_TITLE = ?, BOARD_CONTENT = ?, BOARD_UPDATE_DATE = SYSDATE "
            + "WHERE BOARD_ID = ?";
      connection = DBConnecter.getConnection();
      try {
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, boardVO.getBoardTitle());
         preparedStatement.setString(2, boardVO.getBoardContent());
         preparedStatement.setLong(3, boardVO.getBoardId());
         preparedStatement.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e);
         }
      }
   }
   
//   게시글 삭제
   // 로그인이 되어 있는 상태에서만(해당 글의 주인) 삭제가 가능하며
   // 그 해당 게시글의 번호를 가지고 삭제를 한다
   public void delete(Long boardId) {
      String query = "DELETE FROM TBL_BOARD WHERE BOARD_ID = ?";
      
      connection = DBConnecter.getConnection();
      try {
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setLong(1, boardId);
         preparedStatement.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e);
         }
      }
      
   }
   
//   게시글 전체 조회
   public ArrayList<BoardDTO> selectAll(){
      String query = "SELECT BOARD_ID, BOARD_TITLE, BOARD_CONTENT, BOARD_REGISTER_DATE, "
            + " BOARD_UPDATE_DATE, U.USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
            + " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, "
            + " USER_RECOMMENDER_ID "
            + "FROM TBL_USER U JOIN TBL_BOARD B "
            + "ON U.USER_ID = B.USER_ID";
      
      
      BoardDTO boardDTO = null;
      ArrayList<BoardDTO> boards = new ArrayList<BoardDTO>();
      int index = 0;
      connection = DBConnecter.getConnection();
      try {
         preparedStatement = connection.prepareStatement(query);
         resultSet = preparedStatement.executeQuery();
         while(resultSet.next()) {
            index = 0;
            boardDTO = new BoardDTO();
            boardDTO.setBoardId(resultSet.getLong(++index));
            boardDTO.setBoardTitle(resultSet.getString(++index));
            boardDTO.setBoardContent(resultSet.getString(++index));
            boardDTO.setBoardRegisterDate(resultSet.getString(++index));
            boardDTO.setBoardUpdateDate(resultSet.getString(++index));
            boardDTO.setUserId(resultSet.getLong(++index));
            boardDTO.setUserIdentification(resultSet.getString(++index));
            boardDTO.setUserName(resultSet.getString(++index));
            boardDTO.setUserPassword(resultSet.getString(++index));
            boardDTO.setUserPhone(resultSet.getString(++index));
            boardDTO.setUserNickname(resultSet.getString(++index));
            boardDTO.setUserEmail(resultSet.getString(++index));
            boardDTO.setUserAddress(resultSet.getString(++index));
            boardDTO.setUserBirth(resultSet.getString(++index));
            boardDTO.setUserGender(resultSet.getString(++index));
            boardDTO.setUserRecommenderId(resultSet.getString(++index));
            boards.add(boardDTO);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(resultSet != null) {
               resultSet.close();
            }
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e);
         }
      }
      
      return boards;
   }
}



















