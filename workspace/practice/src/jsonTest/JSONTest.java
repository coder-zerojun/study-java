package jsonTest;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONTest {
	public static void main(String[] args) {
		
//		JSON �������� ����
		Mercanary mercanary = new Mercanary("Dismas", 47, 8, "Tanker");
		JSONObject mercJSON = new JSONObject(mercanary);

//		JSON ������ �뺴 ������ �� ��� �׸� ���
//		try {
//			System.out.println(mercJSON.get("career"));
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
		
		
		System.out.println(mercanary);
		
//		���ְ� ������ �� ���ο� �뺴�� ���� ���� �ۼ�
		Mercanary special = new Mercanary("DuningCruger", 69, 15, "Dealer");
		JSONObject commandJSON = new JSONObject(special);
		
//		���ְ��� Ű ���� commander��
		JSONObject specialJSON = new JSONObject(commandJSON);
		try {
			specialJSON.put("commander", commandJSON);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
//		commander JSON�� �Ƿ� �ذ��� ���� �ʵ忡 �߰��Ѵ�
		try {
			commandJSON.put("succesCount", 82);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(specialJSON);

//		JSON ������ �뺴���� �߿��� ���� ������ ����Ѵ�
//		try {
//			System.out.println(commandJSON.get("age"));
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
		
		
		
//		�뺴�� ���� HashMap�� �����Ѵ�
		HashMap<String, Mercanary> hashTest = new HashMap<String, Mercanary>();
		
//		hashMap �ȿ� JSON ������ �迭�� �� mercanary�� ����
		hashTest.put("normal", mercanary);
		// ����غ���
		System.out.println(hashTest);
		
		
		
//		�迭�� ������ ������ �ִ� hashTest�� JSON���� ���� Object�� �����
		JSONObject mapTest = new JSONObject(hashTest);
		
//		���� ����� ������ mapTest���� �ش� ������ ����Ѵ�
		try {
			System.out.println(mapTest.get("normal"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
//		�ٽ� �ѹ� �����ش�
		JSONObject doubleTest = new JSONObject();
		try {
			System.out.println(doubleTest.put("Influencer", hashTest));
		} catch (JSONException e) {
			e.printStackTrace();
		}


		JSONObject firstJSON = new JSONObject();
		
		try {
			// �� �� ������ JSON�� ���ο� Object�� ��Ƽ� �ٿ�ĳ���� ���ֱ�
			firstJSON = (JSONObject) doubleTest.get("Influencer");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		System.out.println(firstJSON);
		
		// �� �� �ٿ�ĳ���� �� firstJSON�� ������ �������� ���
		try {
			System.out.println(firstJSON.get("normal"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		// JSON Object�� hashMap Ÿ������ ����ȯ�ϱ�
		HashMap<String, Object> secondJSON = new HashMap<>();
		try {
			secondJSON = (HashMap) firstJSON.get("normal");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		System.out.println(secondJSON);
		
		
		
		
		
	}
}
