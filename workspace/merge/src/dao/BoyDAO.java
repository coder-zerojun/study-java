package dao;

import domain.BoyVO;

public class BoyDAO {
	// �޸��忡�� �� ���� �޾ƿ�
	public BoyVO setObject(String line) {
		// �޾ƿ� �� ���� �迭�� �����(���ø��� ���� �� ���ڸ� �迭n��° �濡 ����)
		String[] datas = line.split("\t");
		// boyVO�� ��ƾ� �ϱ� ������ ��������
		BoyVO boyVO = new BoyVO();
		
		int i = 0;
		boyVO.setName(datas[i++]);
		// ���ڿ��� ��ƾ� �ϱ� ������ Integer Ÿ������ �Ľ��ϰ� ,�� �������ش�
		boyVO.setRanking(Integer.parseInt(datas[i++].replaceAll(",", "")));
		boyVO.setPopulation(Integer.parseInt(datas[i++].replaceAll(",", "")));
		
		return boyVO;
	}
}
