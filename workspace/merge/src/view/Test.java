package view;

import java.io.IOException;

import dao.NameDAO;

public class Test {
	public static void main(String[] args) throws IOException {
		// �����ϴ� �޼ҵ带 ����ϱ� ���� ����
		NameDAO nameDAO = new NameDAO();
		
		// boy�� girl�� �ؽ�Ʈ name �ؽ�Ʈ�� ����
		nameDAO.merge("boy.txt", "girl.txt", "name.txt");
		// ���ο� ������ �Ű��ִ� �޼ҵ�
		nameDAO.updateRanking("name.txt");
	}
}
