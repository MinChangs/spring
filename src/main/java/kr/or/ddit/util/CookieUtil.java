package kr.or.ddit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	private static final Logger logger = LoggerFactory
			.getLogger(CookieUtil.class);
	public static String cookieString;//분석할 쿠키 문자열
	
	/**
	* Method : setCookieString
	* 작성자 : PC24
	* 변경이력 :
	* @param cookieString
	* Method 설명 : 분석할 쿠기 문자열을 받는다
	*/
	public static void setCookieString(String cookieString) {
		CookieUtil.cookieString = cookieString;
		
	}
	/**
	* Method : getCookie
	* 작성자 : PC24
	* 변경이력 :
	* @param cookie
	* @return
	* Method 설명 : 쿠키문자열에서 특정 쿠키 값을 가져온다
	*/
	
	public static String getCookie(String cookie) {

		String [] cookieArray = CookieUtil.cookieString.split("; ");
		//cookieArray[0]= "userId=brown"
		//cookieArray[1]= "rememberme=true"
		//cookieArray[2]= "test=testValue"
		String cookieValue="";
		
		for(String str : cookieArray){
			logger.debug("str : {}",str);
			if(str.startsWith(cookie+"=")){
				String[] cookieStr = str.split("=");
				cookieValue = cookieStr[1];
				break;
			}
		}
		return cookieValue;
	}
	
	/*
	public static String getCookie(String cookie) {
		//"userId=brown; rememberme=true; test=testValue"
		//cookie = "userId"
		String [] arr = CookieUtil.cookieString.split("; ");
		String value ="";
		if(cookie.equals(""))
			return value;
		for(int i=0; i<arr.length; i++){
			if(arr[i].contains(cookie+"=")){
				value = arr[i].replace(cookie+"=", "");
				break;
			}
		}
		return value;
	}
	*/

}
