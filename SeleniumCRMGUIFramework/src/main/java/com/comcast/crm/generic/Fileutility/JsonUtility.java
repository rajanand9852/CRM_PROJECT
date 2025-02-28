package com.comcast.crm.generic.Fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDataFromjsonfile(String key) throws FileNotFoundException {
		FileInputStream fileJ=new FileInputStream("./configData/AppCommonData.json");
		
		 JSONParser parser =new JSONParser();
		 Object obj=parser.parse(fileJ);

		 JSONObject map=(JSONObject)obj;
		 String data=(String) map.get(key);
		 return data;

		
	}

}
