package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DBConnecter {
	// path를 입력받고 사용하는 형식
	public static BufferedWriter getWriter(String path) throws IOException {
		return new BufferedWriter(new FileWriter(path));
	}
	
	public static BufferedWriter getAppend(String path) throws IOException {
		return new BufferedWriter(new FileWriter(path, true));
	}
	
	public static BufferedReader getReader(String path) throws IOException {
		return new BufferedReader(new FileReader(path));
	}
}





















