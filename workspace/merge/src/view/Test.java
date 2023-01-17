package view;

import java.io.IOException;

import dao.NameDAO;

public class Test {
	public static void main(String[] args) throws IOException {
		// 병합하는 메소드를 사용하기 위해 선언
		NameDAO nameDAO = new NameDAO();
		
		// boy와 girl의 텍스트 name 텍스트에 병합
		nameDAO.merge("boy.txt", "girl.txt", "name.txt");
		// 새로운 순위를 매겨주는 메소드
		nameDAO.updateRanking("name.txt");
	}
}
