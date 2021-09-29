package Curl_test;

public class switch_korname {
	private String[] char_kor_name = {"재키", "아야", "피오라", "매그너스", "자히르", "나딘", "현우", "하트", "아이솔", "리 다이린",
			"유키", "혜진", "쇼우", "키아라", "시셀라", "실비아", "아드리아나", "쇼이치", "엠마", "레녹스", "로지", "루크", "캐시", "아델라", "버니스",
			"바바라", "알렉스", "수아", "레온", "일레븐", "리오", "윌리엄", "니키", "나타폰", "얀", "이바", "다니엘", "제니"};
	
  /*private String[] char_eng_name = {"Jackie","Aya","Fiora","Magnus","Zahir","Nadine","Hyunwoo",
			"Hart","Isol","LiDailin","Yuki","Hyejin","Xiukai","Chiara","Sissela","Silvia","Adriana","Shoichi",
			"Emma","Lenox","Rozzi","Luke","Cathy","Adela","Bernice","Barbara","Alex","Sua","Leon","Eleven","Rio",
			"William","Nicky","Nathapon","Jan","Eva","Daniel","Jenny"}; */
	
    public String switch_kor_name(String switch_eng){
    	String return_kor_name = null;
    		switch(switch_eng){
			case "Jackie" : return_kor_name = char_kor_name[0]; break;
			case "Aya" : return_kor_name = char_kor_name[1]; break;
			case "Fiora" : return_kor_name = char_kor_name[2]; break;
			case "Magnus" : return_kor_name = char_kor_name[3]; break;
			case "Zahir" : return_kor_name = char_kor_name[4]; break;
			case "Nadine" : return_kor_name = char_kor_name[5]; break;
			case "Hyunwoo" : return_kor_name = char_kor_name[6]; break;
			case "Hart" : return_kor_name = char_kor_name[7]; break;
			case "Isol" : return_kor_name = char_kor_name[8]; break;
			case "LiDailin" : return_kor_name = char_kor_name[9]; break;
			case "Yuki" : return_kor_name = char_kor_name[10]; break;
			case "Hyejin" : return_kor_name = char_kor_name[11]; break;
			case "Xiukai" : return_kor_name = char_kor_name[12]; break;
			case "Chiara" : return_kor_name = char_kor_name[13]; break;
			case "Sissela" : return_kor_name = char_kor_name[14]; break;
			case "Silvia" : return_kor_name = char_kor_name[15]; break;
			case "Adriana" : return_kor_name = char_kor_name[16]; break;
			case "Shoichi" : return_kor_name = char_kor_name[17]; break;
			case "Emma" : return_kor_name = char_kor_name[18]; break;
			case "Lenox" : return_kor_name = char_kor_name[19]; break;
			case "Rozzi" : return_kor_name = char_kor_name[20]; break;
			case "Luke" : return_kor_name = char_kor_name[21]; break;
			case "Cathy" : return_kor_name = char_kor_name[22]; break;
			case "Adela" : return_kor_name = char_kor_name[23]; break;
			case "Bernice" : return_kor_name = char_kor_name[24]; break;
			case "Barbara" : return_kor_name = char_kor_name[25]; break;
			case "Alex" : return_kor_name = char_kor_name[26]; break;
			case "Sua" : return_kor_name = char_kor_name[27]; break;
			case "Leon" : return_kor_name = char_kor_name[28]; break;
			case "Eleven" : return_kor_name = char_kor_name[29]; break;
			case "Rio" : return_kor_name = char_kor_name[30]; break;
			case "William" : return_kor_name = char_kor_name[31]; break;
			case "Nicky" : return_kor_name = char_kor_name[32]; break;
			case "Nathapon" : return_kor_name = char_kor_name[33]; break;
			case "Jan" : return_kor_name = char_kor_name[34]; break;
			case "Eva" : return_kor_name = char_kor_name[35]; break;
			case "Daniel" : return_kor_name = char_kor_name[36]; break;
			case "Jenny" : return_kor_name = char_kor_name[37]; break;
		}
    	return return_kor_name;
    }
}