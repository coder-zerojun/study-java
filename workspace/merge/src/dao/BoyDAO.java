package dao;

import domain.BoyVO;

public class BoyDAO {
	// 메모장에서 한 줄을 받아옴
	public BoyVO setObject(String line) {
		// 받아온 한 줄을 배열에 담아줌(스플릿을 통해 각 문자를 배열n번째 방에 담음)
		String[] datas = line.split("\t");
		// boyVO에 담아야 하기 때문에 선언해줌
		BoyVO boyVO = new BoyVO();
		
		int i = 0;
		boyVO.setName(datas[i++]);
		// 문자열을 담아야 하기 때문에 Integer 타입으로 파싱하고 ,를 제거해준다
		boyVO.setRanking(Integer.parseInt(datas[i++].replaceAll(",", "")));
		boyVO.setPopulation(Integer.parseInt(datas[i++].replaceAll(",", "")));
		
		return boyVO;
	}
}
