package apiTest;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class MessageTest {

	public static void main(String[] args) {
		String api_key = "NCSY4XGIKFBTZHOV";
	       String api_secret = "LDKUIHFNTRQ1UU0LSYJRRYVP9P3GAX5I";
	       Message coolsms = new Message(api_key, api_secret);

	       // 4 params(to, from, type, text) are mandatory. must be filled
	       HashMap<String, String> params = new HashMap<String, String>();
	       params.put("to", "01027570866");
	       params.put("from", "01027570866");
	       params.put("type", "SMS");
	       params.put("text", "문자 발송 테스트");
	       params.put("app_version", "test app 1.2"); // application name and version

	       try {
	         JSONObject obj = (JSONObject) coolsms.send(params);
	         System.out.println(obj.toString());
	       } catch (CoolsmsException e) {
	         System.out.println(e.getMessage());
	         System.out.println(e.getCode());
	       }
	}
}
