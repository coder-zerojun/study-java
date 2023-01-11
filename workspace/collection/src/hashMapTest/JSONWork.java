package hashMapTest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONWork {
	public static void main(String[] args) {
//		상품 클래스 선언(상품 번호, 상품 이름, 상품 가격, 상품 재고)
//		
////		1. 상품 1개를 제작하여 jSON 형식으로 변경
//		Product product = new Product(1, "Audi", 35000, 5);
//		JSONObject prodJSON = new JSONObject(product);
//		
//		System.out.println(prodJSON);
//		
////		2. JSON 형식의 상품 정보 중 상품 재고 출력
//		try {
//			System.out.println(prodJSON.get("count"));
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		
////		3. 할인 중인 상품 정보 제작
//		Product dcProduct = new Product(2, "Bugatti", 65000, 3);
//		
//		JSONObject dcJSON = new JSONObject();
////		4. 할인 중인 상품의 KEY값은 "discount"로 설정
//		final double discount = 0.8;
////		5. JSON 형식으로 변경
//		JSONObject discJSON = new JSONObject(dcProduct);
//		
////		6. JSON에 할인율 필드 추가
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
////		7. JSON 형식의 상품 정보 중 할인률 출력
//		try {
//			System.out.println(discJSON.get("disc"));
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}

		
		
	      JSONObject productJSON = new JSONObject();
	      JSONArray products = new JSONArray();
	      
//	      상품 클래스 선언(상품 번호, 상품 이름, 상품 가격, 상품 재고)
//	      1. 상품 1개를 제작하여 JSON형식으로 변경
	      Product shoes = new Product(1, "나이키", 129_000, 32);
	      JSONObject shoesJSON = new JSONObject(shoes);
//	      System.out.println(shoesJSON);
//	      2. JSON형식의 상품 정보 중 상품 재고 출력
//	      try {
//	         System.out.println(shoesJSON.get("stock"));
//	      } catch (JSONException e) {
//	         e.printStackTrace();
//	      }
	      
//	      3. 할인 중인 상품 정보 제작
	      Product bag = new Product(2, "샤넬", 12_000_000, 2);
	      
//	      4. 할인 중인 상품의 KEY값은 "discount"로 설정
//	      5. JSON형식으로 변경
	      JSONObject bagJSON = new JSONObject(bag);
//	      6. JSON에 할인율 필드 추가
	      try {
	         bagJSON.put("discount", 30);
	      } catch (JSONException e) {
	         e.printStackTrace();
	      }
//	      7. JSON형식의 상품 정보 중 할인율 출력
	      try {
	         System.out.println(bagJSON.get("discount"));
	      } catch (JSONException e) {
	         e.printStackTrace();
	      }
	      
//	      신발과 가방을 하나로 묶어보자!
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
