package com.crm.generic.fileUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {
	public String getDataFromJSONFile(String key) throws IOException, ParseException
	{
		FileReader fr=new FileReader("./configAppData/CommonData.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(fr);
		JSONObject map=(JSONObject) obj;
		String data= map.get(key).toString();
		
		return data;
	}

}
