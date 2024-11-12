package com.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//don't create main method
public class FileUtility
{
	public String getDataFromPropertiesFile(String key) throws IOException
	{
	 FileInputStream fis=new FileInputStream("./configAppData/CommonData.properties");
	 Properties pObj=new Properties();
	 pObj.load(fis); 
	 String data=pObj.getProperty(key);
	 
	 return data;
	}
}





