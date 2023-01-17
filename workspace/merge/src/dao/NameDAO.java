package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import domain.BoyVO;
import domain.GirlVO;
import domain.Name;
import domain.NameDTO;

public class NameDAO {
	public ArrayList<GirlVO> girls = new ArrayList<GirlVO>();
	public ArrayList<BoyVO> boys = new ArrayList<BoyVO>();
	
	// 병합하기 위한 메소드 선언(boy.txt, girl.txt, 그 두개를 병합할 path 총 3개를 받아야 함)
	public void merge(String path1, String path2, String path3) throws IOException {
//		남자 텍스트로부터 각 정보를 받아오기
		BufferedReader boyReader = DBConnecter.getReader(path1);
//		여자 텍스트로부터 각 정보를 받아오기
		BufferedReader girlReader = DBConnecter.getReader(path2);
//		path3을 받을 객체 만들기
		BufferedWriter bufferedWriter = null;
		
		GirlDAO girlDAO = new GirlDAO();
		BoyDAO boyDAO = new BoyDAO();
		
		// 받은 line들과 그 line들을 병합할 temp 변수 선언
		String line = null, temp = "";
		// boy에서 각 줄당 가져와서 line에 담고 
		while((line = boyReader.readLine()) != null) {
			// boys arraylist에 받은 line들을 저장한다
			boys.add(boyDAO.setObject(line));
			temp += line + "\n";
		}
		// 받아왔으면 닫는다
		boyReader.close();
		
//		
		while((line = girlReader.readLine()) != null) {
			girls.add(girlDAO.setObject(line));
			temp += line + "\n";
		}
		
		girlReader.close();
		// path3에 2개의 텍스트가 하나로 병합된다
		bufferedWriter = DBConnecter.getWriter(path3);
		
		bufferedWriter.write(temp);
		bufferedWriter.close();
	}
	// 새로운 순위를 매겨주는 메소드
	public void updateRanking(String path) throws IOException {
		BufferedWriter bufferedWriter = DBConnecter.getWriter(path);
		ArrayList<Name> names = new ArrayList<Name>();
		List<Integer> populations = null;
		HashSet<Integer> populationSet = null;
		int ranking = 1, count = 0;
		String temp = "";
		
		names.addAll(girls);
		names.addAll(boys);
		
		populationSet = new HashSet(names.stream()
				.map(Name::getPopulation).collect(Collectors.toList()));
		
		populations = new ArrayList<Integer>(populationSet).stream()
				.sorted(Collections.reverseOrder()).collect(Collectors.toList());
		
		for (Integer population : populations) {
			count = 0;
			for (Name nameVO : names) {
				if(population == nameVO.getPopulation()) {
					NameDTO nameDTO = new NameDTO();
					nameDTO.setGender(nameVO instanceof BoyVO ? "B" : "G");
					nameDTO.setName(nameVO.getName());
					nameDTO.setRanking(ranking);
					nameDTO.setPopulation(nameVO.getPopulation());
					temp += nameDTO.toString() + "\n";
					
					count++;
				}
			}
			if(count > 1) {
				ranking += count;
				continue;
			}
			ranking ++;
		}
		
		bufferedWriter.write(temp);
		bufferedWriter.close();
	}
	
	public static String insertComma(int number) {
		String temp = String.valueOf(number);
		String result = "";
		
		for (int i = 0; i < temp.length(); i++) {
			if(i != 0 && i % 3 == 0) {
				result = "," + result;
			}
			result = temp.charAt(temp.length() - 1 - i) + result;
		}
		return result;
	}
}














