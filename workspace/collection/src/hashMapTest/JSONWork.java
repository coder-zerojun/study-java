package hashMapTest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONWork {
	public static void main(String[] args) {
//		��ǰ Ŭ���� ����(��ǰ ��ȣ, ��ǰ �̸�, ��ǰ ����, ��ǰ ���)
//		
////		1. ��ǰ 1���� �����Ͽ� jSON �������� ����
//		Product product = new Product(1, "Audi", 35000, 5);
//		JSONObject prodJSON = new JSONObject(product);
//		
//		System.out.println(prodJSON);
//		
////		2. JSON ������ ��ǰ ���� �� ��ǰ ��� ���
//		try {
//			System.out.println(prodJSON.get("count"));
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		
////		3. ���� ���� ��ǰ ���� ����
//		Product dcProduct = new Product(2, "Bugatti", 65000, 3);
//		
//		JSONObject dcJSON = new JSONObject();
////		4. ���� ���� ��ǰ�� KEY���� "discount"�� ����
//		final double discount = 0.8;
////		5. JSON �������� ����
//		JSONObject discJSON = new JSONObject(dcProduct);
//		
////		6. JSON�� ������ �ʵ� �߰�
//		try {
//			dcJSON.put("discount", discJSON);
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		System.out.println(dcJSON);
//		try {
//			discJSON.put("disc", discount);
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		System.out.println(dcJSON);
////		7. JSON ������ ��ǰ ���� �� ���η� ���
//		try {
//			System.out.println(discJSON.get("disc"));
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}

		
		
	      JSONObject productJSON = new JSONObject();
	      JSONArray products = new JSONArray();
	      
//	      ��ǰ Ŭ���� ����(��ǰ ��ȣ, ��ǰ �̸�, ��ǰ ����, ��ǰ ���)
//	      1. ��ǰ 1���� �����Ͽ� JSON�������� ����
	      Product shoes = new Product(1, "����Ű", 129_000, 32);
	      JSONObject shoesJSON = new JSONObject(shoes);
//	      System.out.println(shoesJSON);
//	      2. JSON������ ��ǰ ���� �� ��ǰ ��� ���
//	      try {
//	         System.out.println(shoesJSON.get("stock"));
//	      } catch (JSONException e) {
//	         e.printStackTrace();
//	      }
	      
//	      3. ���� ���� ��ǰ ���� ����
	      Product bag = new Product(2, "����", 12_000_000, 2);
	      
//	      4. ���� ���� ��ǰ�� KEY���� "discount"�� ����
//	      5. JSON�������� ����
	      JSONObject bagJSON = new JSONObject(bag);
//	      6. JSON�� ������ �ʵ� �߰�
	      try {
	         bagJSON.put("discount", 30);
	      } catch (JSONException e) {
	         e.printStackTrace();
	      }
//	      7. JSON������ ��ǰ ���� �� ������ ���
	      try {
	         System.out.println(bagJSON.get("discount"));
	      } catch (JSONException e) {
	         e.printStackTrace();
	      }
	      
//	      �Ź߰� ������ �ϳ��� �����!
	      try {
	    	  products.put(shoesJSON);
	    	  products.put(bagJSON);
//	    	  System.out.println(products);
	    	  System.out.println(products.getJSONObject(0).get("price"));
//	         productJSON.put("shoes", shoesJSON);
//	         productJSON.put("bag", bagJSON);
//	         System.out.println(productJSON);
	      } catch (JSONException e) {
	         e.printStackTrace();
	      }

		
	}
}
