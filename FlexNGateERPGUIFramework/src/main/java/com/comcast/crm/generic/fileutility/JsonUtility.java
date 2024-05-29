package com.comcast.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * 
 * @author Deepak
 *
 */
public class JsonUtility {
	/**
	 * read data from excel based on json key
	 * @param key
	 * @return
	 * @throws Throwable
	 * @throws ParseException
	 */
	public String getDataFrpomJsonFile(String key) throws Throwable, ParseException {
		FileReader fileR = new FileReader("./configAppData/appCommonData.json");
		JSONParser parser = new JSONParser();
	    Object obj = parser.parse(fileR);		
	   JSONObject map = (JSONObject)obj;
	   String data = (String) map.get(key);
	   return data;
	}

}
