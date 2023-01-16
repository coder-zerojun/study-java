package jsonTest;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONTest {
	public static void main(String[] args) {
		
//		JSON 형식으로 변경
		Mercanary mercanary = new Mercanary("Dismas", 47, 8, "Tanker");
		JSONObject mercJSON = new JSONObject(mercanary);

//		JSON 형식의 용병 정보들 중 경력 항목 출력
//		try {
//			System.out.println(mercJSON.get("career"));
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
		
		
		System.out.println(mercanary);
		
//		지휘관 역할을 할 새로운 용병에 관한 정보 작성
		Mercanary special = new Mercanary("DuningCruger", 69, 15, "Dealer");
		JSONObject commandJSON = new JSONObject(special);
		
//		지휘관의 키 값은 commander임
		JSONObject specialJSON = new JSONObject(commandJSON);
		try {
			specialJSON.put("commander", commandJSON);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
//		commander JSON에 의뢰 해결한 수를 필드에 추가한다
		try {
			commandJSON.put("succesCount", 82);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(specialJSON);

//		JSON 형식의 용병정보 중에서 나이 정보를 출력한다
//		try {
//			System.out.println(commandJSON.get("age"));
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
		
		
		
//		용병에 관한 HashMap을 선언한다
		HashMap<String, Mercanary> hashTest = new HashMap<String, Mercanary>();
		
//		hashMap 안에 JSON 형식의 배열로 된 mercanary를 담음
		hashTest.put("normal", mercanary);
		// 출력해보기
		System.out.println(hashTest);
		
		
		
//		배열의 정보를 가지고 있는 hashTest를 JSON으로 만들 Object를 만든다
		JSONObject mapTest = new JSONObject(hashTest);
		
//		값이 제대로 들어갔는지 mapTest에서 해당 정보를 출력한다
		try {
			System.out.println(mapTest.get("normal"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
//		다시 한번 감싸준다
		JSONObject doubleTest = new JSONObject();
		try {
			System.out.println(doubleTest.put("Influencer", hashTest));
		} catch (JSONException e) {
			e.printStackTrace();
		}


		JSONObject firstJSON = new JSONObject();
		
		try {
			// 한 번 감싸진 JSON을 새로운 Object에 담아서 다운캐스팅 해주기
			firstJSON = (JSONObject) doubleTest.get("Influencer");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		System.out.println(firstJSON);
		
		// 한 번 다운캐스팅 된 firstJSON에 접근이 가능한지 출력
		try {
			System.out.println(firstJSON.get("normal"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		// JSON Object를 hashMap 타입으로 형변환하기
		HashMap<String, Object> secondJSON = new HashMap<>();
		try {
			secondJSON = (HashMap) firstJSON.get("normal");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		System.out.println(secondJSON);
		
		
		
		
		
	}
}
