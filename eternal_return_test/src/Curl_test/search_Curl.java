package Curl_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class search_Curl {
	private static String key = "kRszWI4nU04xYwQepk67n2yTmdEYxSQa4OFkggyK";
	private static String url = "https://open-api.bser.io/v1/";
	
	private String usernumber_url;
	private String rank_url;
	private String stats_url;
	private String char_url;
	
	private String itemArmor_url;
	private String itemWeapon_url;
	
	private String searchGame_url;
	
	private String api_data;
	private String output;
	
	private int responseCode;

	public String usernum_curl(String nickname) {
		String return_usernum = null;
		usernumber_url = url+"user/nickname?query="+encodeURIComponent(nickname);
		try_method(usernumber_url);
        System.out.println("userNum_responseCode : " + responseCode);
        try {
        	JSONParser parser = new JSONParser();
        	JSONObject jsonObj = (JSONObject)parser.parse(api_data);
			JSONObject userObj = (JSONObject)jsonObj.get("user");
			return_usernum = (String) userObj.get("userNum").toString();
		} catch (ParseException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
	    return return_usernum; // rs[0]
	}
	public String rank_curl(String nickname, int SeasonId ,int TeamMode) { // 랭킹 정보
		 rank_url = url+"rank/"+usernum_curl(nickname)+"/"+Integer.toString(SeasonId)+"/"+Integer.toString(TeamMode);
		 try_method(rank_url);
		 System.out.println("rank_responseCode : " + responseCode);
	     return api_data;
	}
	public String stats_curl(String nickname, int SeasonId) { // 계정 정보
		stats_url = url+"user/stats/"+usernum_curl(nickname)+"/"+Integer.toString(SeasonId);
		try_method(stats_url);
		System.out.println("stats_responseCode : " + responseCode);
		return api_data;
	}
	public String char_curl() { // 케릭 코드 검색
		char_url = url+"data/Character";
		try_method(char_url);
		System.out.println("char_responseCode : " + responseCode);
		return api_data;
	}
	public String itemArmor_curl() { // 방어구 코드 검색
		itemArmor_url = url+"data/ItemArmor";
		try_method(itemArmor_url);
		System.out.println("itemArmor_responseCode : " + responseCode);
		return api_data;
	}
	public String itemWeapon_curl() { // 무기 코드 검색
		itemWeapon_url = url+"data/ItemWeapon";
		try_method(itemWeapon_url);
		System.out.println("itemWeapon_responseCode : " + responseCode);
		return api_data;
	}
	public String searchGame_curl(String nickname) { // 게임 전적 검색
		searchGame_url = url+"user/games/"+usernum_curl(nickname);
		try_method(searchGame_url);
		System.out.println("searchGame_responseCode : " + responseCode);
		return api_data;
	}
	public void try_method(String _url) {
		URL urlObject = null;
		HttpURLConnection con = null;
		StringBuffer response = new StringBuffer();
		try {
			urlObject = new URL(_url);
			con = (HttpURLConnection) urlObject.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("accept", "application/json");
	        con.setRequestProperty("x-api-key", key);
	        responseCode = con.getResponseCode();
	        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        
	        while((output = br.readLine()) != null) {
	        	response.append(output);
	        	api_data = output;
	        }
	        br.close();
	        
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String read_item_Jsonfile(String hash) {
		String json_name = null;
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject)parser.parse(api_data);
			JSONArray jsonArr = (JSONArray)jsonObj.get("data");
			for (int i = 0; i < jsonArr.size(); i++) {
				JSONObject json_arr_Obj = (JSONObject)jsonArr.get(i);
				if(json_arr_Obj.get("code").toString().equals(hash)) {
					json_name = json_arr_Obj.get("name").toString();
				}
			}
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return json_name;
	}
	public void read_gameInfo_Jsonfile() {
		switch_korname switch_kor = new switch_korname();
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject)parser.parse(api_data);
			JSONArray jsonArr = (JSONArray)jsonObj.get("userGames");
			JSONObject json_arr_obj = (JSONObject)jsonArr.get(0);
			
			String[] json_name = new String[13];
			json_name[0] = "닉네임 : "+json_arr_obj.get("nickname").toString(); // 닉네임
			json_name[1] = "게임번호 : "+json_arr_obj.get("gameId").toString(); // 게임 ID
			
			char_curl();
			json_name[2] = "실험체 : "+switch_kor.switch_kor_name(read_item_Jsonfile(json_arr_obj.get("characterNum").toString())); // 케릭터 번호
			// 실험체 한글 번역(itemjson 읽기(jsonObj("characterNum"))) 
			json_name[3] = "등수 : "+json_arr_obj.get("gameRank").toString(); // 등수
			json_name[4] = "킬 : "+json_arr_obj.get("playerKill").toString(); // 킬
			json_name[5] = "어시 : "+json_arr_obj.get("playerAssistant").toString(); // 어시
			json_name[6] = "사냥 : "+json_arr_obj.get("monsterKill").toString(); // 동물 킬
			JSONObject obj = (JSONObject) json_arr_obj.get("equipment");
			
			if(obj.get("0") != null) { // 장착 무기 아이템, 자동적으로 json파일 읽어서 출력
				itemWeapon_curl();
				json_name[7] = "0번 장착 아이템 : "+read_item_Jsonfile(obj.get("0").toString());
			} else if(obj.get("0") == null) {
				json_name[7] = "0번 장착 아이템 : 없음";
			} else {
				return;
			}
			itemArmor_curl();
			for (int i = 1; i <= obj.size(); i++) { // 장착 방어구 아이템 1번~5번까지, 자동적으로 json파일 읽어서 출력
				if(obj.get(Integer.toString(i)) != null) {
					json_name[7+i] = i+"번 장착 아이템 : "+read_item_Jsonfile(obj.get(Integer.toString(i)).toString());	
				} else if(obj.get(Integer.toString(i)) == null) {
					json_name[7+i] = i+"번 장착 아이템 : 없음";
				} else {
					return;
				}
			}
			for (int i = 0; i < json_name.length; i++) {
				System.out.println(json_name[i]);
			}

		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		search_Curl search = new search_Curl();
		search.searchGame_curl("LeNoad");
		search.read_gameInfo_Jsonfile();
	}
	public static String encodeURIComponent(String component) {
        String result = null;
        try {
            result = URLEncoder.encode(component, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
