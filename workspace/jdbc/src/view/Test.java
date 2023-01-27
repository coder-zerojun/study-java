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
//			System.out.println("��� ������ ���̵�");
//			return;
//		}
//		System.out.println("�ߺ��� ���̵�");

//		System.out.println(userDAO.select(1L));

//		[�ǽ�] �޼ҵ� ��ü ����
//		ȸ������
		UserVO userVO = new UserVO();
//		userVO.setUserIdentification("lss1234");
//		userVO.setUserName("�̼���");
//		userVO.setUserPassword("1234");
//		userVO.setUserAddress("��⵵ ���ֽ�");
//		userVO.setUserBirth("1545-04-08");
//		userVO.setUserEmail("lss1234@naver.com");
//		userVO.setUserPhone("01099998888");
//		userVO.setUserRecommenderId("");
//		userDAO.insert(userVO);

//		userVO.setUserIdentification("jbg1234");
//		userVO.setUserName("�庸��");
//		userVO.setUserPassword("9999");
//		userVO.setUserAddress("����Ư���� ���Ǳ�");
//		userVO.setUserBirth("2000-12-04");
//		userVO.setUserEmail("jbg1234@gmail.com");
//		userVO.setUserPhone("01099991234");
//		userVO.setUserRecommenderId("lss1234");

//		userVO.setUserIdentification("gy1234");
//		userVO.setUserName("����");
//		userVO.setUserPassword("1111");
//		userVO.setUserAddress("������ ������");
//		userVO.setUserBirth("2010-12-04");
//		userVO.setUserEmail("gy1234@gmail.com");
//		userVO.setUserPhone("01011112222");
//		userVO.setUserRecommenderId("lss1234");
////		
//		if(userDAO.checkId(userVO.getUserIdentification())) {
//			userDAO.insert(userVO);
//		}else {
//			System.out.println("�ߺ��� ���̵�");
//		}

//		�α���
//		if(userDAO.login("lss1234", "1234")) {
//			System.out.println("�α��� ����");
//			System.out.println(userDAO.userId);
//		}else {
//			System.out.println("�α��� ����");
//		}
		
		
//		ȸ���� ���� ��ȸ
//		if(userDAO.loginStatus("lss1234", "1234")) {
//			System.out.println("�����ϴ� ���̵�");
//		}else {
//			System.out.println("Ż���� ���̵�");
//		}

//		���̵� ã��
//		System.out.println(userDAO.findIdentification("01099991234"));

//		��й�ȣ ����
//		userDAO.updateUserPassword("3333");

//		if(userDAO.login("lss1234", "3333")) {
//			System.out.println("�α��� ����");
//			System.out.println(UserDAO.userId);
//		}else {
//			System.out.println("�α��� ����");
//		}

//		ȸ������ ��ȸ
//		UserVO user = userDAO.select();

//		ȸ������ ����
//		user.setUserNickname("�źϿ�");
//		userDAO.update(user);

//		��õ��
//		System.out.println(userDAO.getCountOfRecommenderId("jbg1234"));

//		���� ��õ�� ���
//		userDAO.selectRecommenders().stream().map(UserVO::toString).forEach(System.out::println);

//		���� ��õ�� ���

//		if(userDAO.login("jbg1234", "9999")) {
//			System.out.println("�α��� ����");
//			System.out.println(UserDAO.userId);
//		}else {
//			System.out.println("�α��� ����");
//		}

//		UserVO user = userDAO.getMyRecommender();
//		if(user != null) {
//			System.out.println(user);
//			
//		}else {
//			System.out.println("��õ�� ����� �����ϴ�.");
//		}

//		ȸ�� Ż��
//		userDAO.delete();
//		==========================================================================
//		BoardDAO boardDAO = new BoardDAO();

//		�Խñ� �߰�
//		BoardVO boardVO = new BoardVO();
////		
//		if (userDAO.login("lss1234", "1234")) {
//			System.out.println("�α��� ����");																																																																					
//			System.out.println(UserDAO.userId);
//		} else {
//			System.out.println("�α��� ����");
//		}
////		
//		boardVO.setBoardTitle("�뷮����");
//		boardVO.setBoardContent("�� ������ ������ �˸��� ����.");
//		boardVO.setUserId(UserDAO.userId);
//		
//		boardDAO.insert(boardVO);

//		�Խñ� ��ȸ
//		System.out.println(boardDAO.select(1L));
//		BoardDTO boardDTO = boardDAO.select(1L);
//		System.out.println(boardDTO);

//		�Խñ� ����
//		if(UserDAO.userId == boardDTO.getUserId()) {
//			boardDTO.setBoardTitle("������ ����");
		// update���� VO ��ü�� �޾ƿͼ� ������ �������� DTO�� �ִ� VO��ü�� ������ �ѱ�� �޼ҵ带 ����ؼ�
		// �����ϴ� �޼ҵ带 �����Ų��
//			boardDAO.update(boardDTO.toBoardVO());
//		}else {
//			System.out.println("�ۼ��ڸ� ������ �����մϴ�.");
//		}

//		�Խñ� ����
		// ���������� ������ ���� ���� �α��� �� ���̵�� ȭ������ �����ֱ� ���� ������ ����ִ�
		// DTO���� ������ ������ �ִ� ���̵� ���� �ȴٸ� �� �ش� �Խñ��� �����Ѵ�
//		if(UserDAO.userId == boardDTO.getUserId()) {
//		 �Խñ��� ��ȣ�� ���� �޼ҵ带 �����ϴ� DTO���� �ش� �Խñ��� ��ȣ�� �����ͼ� ���� �޼ҵ� ����
//			boardDAO.delete(boardDTO.getBoardId());
//		}else {
//			System.out.println("�ۼ��ڸ� ������ �����մϴ�.");
//		}

//		�Խñ� ��ü ��ȸ
//		boardDAO.selectAll().stream().map(BoardDTO::toString).forEach(System.out::println);
//		=====================================================================================

//		if (userDAO.login("lss1234", "1234")) {
//			System.out.println("�α��� ����");
//		} else {
//			System.out.println("�α��� ����");
//		}
//		
//		BoardDTO boardDTO = boardDAO.select(2L);
//		System.out.println(boardDTO);

//	      ��� �߰�
		ReplyVO replyVO = new ReplyVO();
//	      replyVO.setBoardId(boardDTO.getBoardId());
//	      replyVO.setReplyContent("ù��° ���");
//	      replyVO.setReplyContent("�ι�° ���");
//	      
//	      replyDAO.addReply(replyVO);

//	      ���� �߰�
//	      replyVO.setBoardId(boardDTO.getBoardId());
//	      replyVO.setReplyContent("ù��° ����� ù��° ����");
//	      replyVO.setReplyContent("ù��° ����� �ι�° ����");
//	      replyVO.setReplyContent("�ι�° ����� ù��° ����");
//	      
//	      replyDAO.addReply(replyVO, 10L);

//		  ��� ��ȸ
//		  ReplyDTO replyDTO = replyDAO.selectUserReply(11L);
//		  System.out.println(replyDTO);

//	      ��� ��ü ��ȸ
//	      replyDAO.selectAll().stream().filter(dto -> dto.getReplyGroup() == 10).map(ReplyDTO::toString).forEach(System.out::println);
//	      replyDAO.selectAll().stream().filter(dto -> dto.getReplyGroup() == 5).map(ReplyDTO::toString).forEach(System.out::println);

//		  ���� ����
		// ����� �ۼ��� �������� Ȯ���ϴ� ������ ����
//		if (userDAO.userId == replyDTO.getUserId()) {
//			replyDAO.deleteReReply(11L);
//		} else {
//			System.out.println("�ۼ��ڸ� ������ �����մϴ�.");
//		}

//		  ��� ����
//		  replyDAO.deleteReply(1L);

//		  ��� ����
//		if (userDAO.userId == replyDTO.getUserId()) {
//			replyDAO.selectAll().stream().filter(dto -> dto.getReplyId() == 11).map(ReplyDTO::toReplyVO).forEach(vo -> {
//				vo.setReplyContent("������ ���");
//				replyDAO.updateReply(vo);
//			});
//		} else {
//			System.out.println("�ۼ��ڸ� ������ �����մϴ�.");
//		}
//		ReplyDTO replyDTO = new ReplyDTO();
//		ReplyVO replyVO = new ReplyVO();

//		if (userDAO.login("lss1234", "1234")) {
//			System.out.println("�α��� ����");
//		} else {
//			System.out.println("�α��� ����");
//		}

		// ��� ��ü���� replyId �� ?�� ����� ����
		// replyId �� ? �� ���� �������� ������ ���͸� �ɾ���
		// ������ arraylist���� ������ DTOŬ�������� VOŸ������ ��ȯ�ϴ� �޼ҵ带 ����� map�� ���� �ٲ��ְ�
		// �α����� ������ id�� ������ ����� �ۼ��� id�� ���ٸ� ���� �޼ҵ带 �����Ѵ�
//		replyDAO.selectAll().stream().filter(dto -> dto.getReplyId() == 18).map(ReplyDTO::toReplyVO).forEach(vo -> {
//			if (userDAO.userId == vo.getUserId()) {
//				replyDAO.deleteReReply(vo.getReplyId());
//			}
//		});

//		userDAO�� �ִ� �޼ҵ带 ����ϱ� ���� ������ ��ü
//		UserDAO userDAO = new UserDAO();
////		replyDAO�� �ִ� �޼ҵ带 ����ϱ� ���� ������ ��ü
//		ReplyDAO replyDAO = new ReplyDAO();
//		
////		�α���
		if (userDAO.login("lss1234", "1234")) {
			System.out.println("�α��� ����");
		} else {
			System.out.println("�α��� ����");
		}
//
////		��� ��ȸ
//		// replyDTO�� replyDAO�� �ִ� ����� �ۼ��� ������ ������ �������� �޼ҵ带 ����ش�
//		ReplyDTO replyDTO = replyDAO.selectUserReply(14L);
//
////		��� ����
////		�α����� �Ҷ� ���ǿ� ����ִ� �������� userId�� replyDTO�� ��� userId�� ���ٸ� ������ �������ش�
//		if (userDAO.userId == replyDTO.getUserId()) {
//			replyDAO.deleteReReply(14L);
//			System.out.println("[ ����� �����Ǿ����ϴ� ]");
//		} else {
//			System.out.println("�ۼ��ڸ� ������ �����մϴ�.");
//		}

//		userDAO.insertFollow(22L);
		
		// ������ �ȷο� �� ����� ���� ��ȸ
//		System.out.println(userDAO.selectFollower());
		// ������ �ȷο� �� ����� ���� ��ȸ
//		System.out.println(userDAO.selectFollowing());
		// ���� �ȷο� �� �������� ���� ��ȸ
		System.out.println(userDAO.selectInfoFollowingMe());
		// ���� �ȷο� �� �������� ���� ��ȸ
		System.out.println(userDAO.selectInfoFollowByMe());
		
	}
}
