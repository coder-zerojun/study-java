package view;

import java.util.Collection;
import java.util.Collections;

import dao.BoardDAO;
import dao.ReplyDAO;
import dao.UserDAO;
import domain.BoardDTO;
import domain.ReplyDTO;
import domain.ReplyVO;
import domain.UserVO;

public class Test {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		BoardDAO boardDAO = new BoardDAO();
		ReplyDAO replyDAO = new ReplyDAO();

//		UserDAO userDAO = new UserDAO();
//		if(userDAO.checkId("hds1234")) {
//			System.out.println("사용 가능한 아이디");
//			return;
//		}
//		System.out.println("중복된 아이디");

//		System.out.println(userDAO.select(1L));

//		[실습] 메소드 전체 검증
//		회원가입
		UserVO userVO = new UserVO();
//		userVO.setUserIdentification("lss1234");
//		userVO.setUserName("이순신");
//		userVO.setUserPassword("1234");
//		userVO.setUserAddress("경기도 파주시");
//		userVO.setUserBirth("1545-04-08");
//		userVO.setUserEmail("lss1234@naver.com");
//		userVO.setUserPhone("01099998888");
//		userVO.setUserRecommenderId("");
//		userDAO.insert(userVO);

//		userVO.setUserIdentification("jbg1234");
//		userVO.setUserName("장보고");
//		userVO.setUserPassword("9999");
//		userVO.setUserAddress("서울특별시 관악구");
//		userVO.setUserBirth("2000-12-04");
//		userVO.setUserEmail("jbg1234@gmail.com");
//		userVO.setUserPhone("01099991234");
//		userVO.setUserRecommenderId("lss1234");

//		userVO.setUserIdentification("gy1234");
//		userVO.setUserName("권율");
//		userVO.setUserPassword("1111");
//		userVO.setUserAddress("강원도 강릉시");
//		userVO.setUserBirth("2010-12-04");
//		userVO.setUserEmail("gy1234@gmail.com");
//		userVO.setUserPhone("01011112222");
//		userVO.setUserRecommenderId("lss1234");
////		
//		if(userDAO.checkId(userVO.getUserIdentification())) {
//			userDAO.insert(userVO);
//		}else {
//			System.out.println("중복된 아이디");
//		}

//		로그인
//		if(userDAO.login("lss1234", "1234")) {
//			System.out.println("로그인 성공");
//			System.out.println(userDAO.userId);
//		}else {
//			System.out.println("로그인 실패");
//		}
		
		
//		회원의 상태 조회
//		if(userDAO.loginStatus("lss1234", "1234")) {
//			System.out.println("존재하는 아이디");
//		}else {
//			System.out.println("탈퇴한 아이디");
//		}

//		아이디 찾기
//		System.out.println(userDAO.findIdentification("01099991234"));

//		비밀번호 변경
//		userDAO.updateUserPassword("3333");

//		if(userDAO.login("lss1234", "3333")) {
//			System.out.println("로그인 성공");
//			System.out.println(UserDAO.userId);
//		}else {
//			System.out.println("로그인 실패");
//		}

//		회원정보 조회
//		UserVO user = userDAO.select();

//		회원정보 수정
//		user.setUserNickname("거북왕");
//		userDAO.update(user);

//		추천수
//		System.out.println(userDAO.getCountOfRecommenderId("jbg1234"));

//		나를 추천한 사람
//		userDAO.selectRecommenders().stream().map(UserVO::toString).forEach(System.out::println);

//		내가 추천한 사람

//		if(userDAO.login("jbg1234", "9999")) {
//			System.out.println("로그인 성공");
//			System.out.println(UserDAO.userId);
//		}else {
//			System.out.println("로그인 실패");
//		}

//		UserVO user = userDAO.getMyRecommender();
//		if(user != null) {
//			System.out.println(user);
//			
//		}else {
//			System.out.println("추천한 사람이 없습니다.");
//		}

//		회원 탈퇴
//		userDAO.delete();
//		==========================================================================
//		BoardDAO boardDAO = new BoardDAO();

//		게시글 추가
//		BoardVO boardVO = new BoardVO();
////		
//		if (userDAO.login("lss1234", "1234")) {
//			System.out.println("로그인 성공");																																																																					
//			System.out.println(UserDAO.userId);
//		} else {
//			System.out.println("로그인 실패");
//		}
////		
//		boardVO.setBoardTitle("노량해전");
//		boardVO.setBoardContent("내 죽음을 적에게 알리지 말라.");
//		boardVO.setUserId(UserDAO.userId);
//		
//		boardDAO.insert(boardVO);

//		게시글 조회
//		System.out.println(boardDAO.select(1L));
//		BoardDTO boardDTO = boardDAO.select(1L);
//		System.out.println(boardDTO);

//		게시글 수정
//		if(UserDAO.userId == boardDTO.getUserId()) {
//			boardDTO.setBoardTitle("수정된 제목");
		// update문은 VO 객체를 받아와서 정보를 가져오니 DTO에 있는 VO객체로 정보를 넘기는 메소드를 사용해서
		// 수정하는 메소드를 실행시킨다
//			boardDAO.update(boardDTO.toBoardVO());
//		}else {
//			System.out.println("작성자만 수정이 가능합니다.");
//		}

//		게시글 삭제
		// 전역변수로 지정한 현재 내가 로그인 한 아이디와 화면으로 보여주기 위한 정보가 담겨있는
		// DTO에서 가져온 정보에 있는 아이디가 같게 된다면 그 해당 게시글을 삭제한다
//		if(UserDAO.userId == boardDTO.getUserId()) {
//		 게시글의 번호로 삭제 메소드를 실행하니 DTO에서 해당 게시글의 번호를 가져와서 삭제 메소드 실행
//			boardDAO.delete(boardDTO.getBoardId());
//		}else {
//			System.out.println("작성자만 삭제가 가능합니다.");
//		}

//		게시글 전체 조회
//		boardDAO.selectAll().stream().map(BoardDTO::toString).forEach(System.out::println);
//		=====================================================================================

//		if (userDAO.login("lss1234", "1234")) {
//			System.out.println("로그인 성공");
//		} else {
//			System.out.println("로그인 실패");
//		}
//		
//		BoardDTO boardDTO = boardDAO.select(2L);
//		System.out.println(boardDTO);

//	      댓글 추가
		ReplyVO replyVO = new ReplyVO();
//	      replyVO.setBoardId(boardDTO.getBoardId());
//	      replyVO.setReplyContent("첫번째 댓글");
//	      replyVO.setReplyContent("두번째 댓글");
//	      
//	      replyDAO.addReply(replyVO);

//	      대댓글 추가
//	      replyVO.setBoardId(boardDTO.getBoardId());
//	      replyVO.setReplyContent("첫번째 댓글의 첫번째 대댓글");
//	      replyVO.setReplyContent("첫번째 댓글의 두번째 대댓글");
//	      replyVO.setReplyContent("두번째 댓글의 첫번째 대댓글");
//	      
//	      replyDAO.addReply(replyVO, 10L);

//		  댓글 조회
//		  ReplyDTO replyDTO = replyDAO.selectUserReply(11L);
//		  System.out.println(replyDTO);

//	      댓글 전체 조회
//	      replyDAO.selectAll().stream().filter(dto -> dto.getReplyGroup() == 10).map(ReplyDTO::toString).forEach(System.out::println);
//	      replyDAO.selectAll().stream().filter(dto -> dto.getReplyGroup() == 5).map(ReplyDTO::toString).forEach(System.out::println);

//		  대댓글 삭제
		// 댓글을 작성한 유저인지 확인하는 과정이 없음
//		if (userDAO.userId == replyDTO.getUserId()) {
//			replyDAO.deleteReReply(11L);
//		} else {
//			System.out.println("작성자만 삭제가 가능합니다.");
//		}

//		  댓글 삭제
//		  replyDAO.deleteReply(1L);

//		  댓글 수정
//		if (userDAO.userId == replyDTO.getUserId()) {
//			replyDAO.selectAll().stream().filter(dto -> dto.getReplyId() == 11).map(ReplyDTO::toReplyVO).forEach(vo -> {
//				vo.setReplyContent("수정된 댓글");
//				replyDAO.updateReply(vo);
//			});
//		} else {
//			System.out.println("작성자만 수정이 가능합니다.");
//		}
//		ReplyDTO replyDTO = new ReplyDTO();
//		ReplyVO replyVO = new ReplyVO();

//		if (userDAO.login("lss1234", "1234")) {
//			System.out.println("로그인 성공");
//		} else {
//			System.out.println("로그인 실패");
//		}

		// 댓글 전체에서 replyId 가 ?인 댓글을 삭제
		// replyId 가 ? 인 것을 가져오는 것으로 필터를 걸어줌
		// 가져온 arraylist에서 가져온 DTO클래스에서 VO타입으로 변환하는 메소드를 사용해 map을 통해 바꿔주고
		// 로그인한 유저의 id와 가져온 댓글의 작성자 id가 같다면 삭제 메소드를 진행한다
//		replyDAO.selectAll().stream().filter(dto -> dto.getReplyId() == 18).map(ReplyDTO::toReplyVO).forEach(vo -> {
//			if (userDAO.userId == vo.getUserId()) {
//				replyDAO.deleteReReply(vo.getReplyId());
//			}
//		});

//		userDAO에 있는 메소드를 사용하기 위해 선언한 객체
//		UserDAO userDAO = new UserDAO();
////		replyDAO에 있는 메소드를 사용하기 위해 선언한 객체
//		ReplyDAO replyDAO = new ReplyDAO();
//		
////		로그인
		if (userDAO.login("lss1234", "1234")) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
//
////		댓글 조회
//		// replyDTO에 replyDAO에 있는 댓글을 작성한 유저의 정보를 가져오는 메소드를 담아준다
//		ReplyDTO replyDTO = replyDAO.selectUserReply(14L);
//
////		댓글 삭제
////		로그인을 할때 세션에 담겨있는 전역변수 userId와 replyDTO에 담긴 userId가 같다면 삭제를 진행해준다
//		if (userDAO.userId == replyDTO.getUserId()) {
//			replyDAO.deleteReReply(14L);
//			System.out.println("[ 댓글이 삭제되었습니다 ]");
//		} else {
//			System.out.println("작성자만 삭제가 가능합니다.");
//		}

//		userDAO.insertFollow(22L);
		
		// 유저가 팔로우 한 사람의 수를 조회
//		System.out.println(userDAO.selectFollower());
		// 유저를 팔로우 한 사람의 수를 조회
//		System.out.println(userDAO.selectFollowing());
		// 나를 팔로우 한 유저들의 정보 조회
		System.out.println(userDAO.selectInfoFollowingMe());
		// 내가 팔로우 한 유저들의 정보 조회
		System.out.println(userDAO.selectInfoFollowByMe());
		
	}
}
