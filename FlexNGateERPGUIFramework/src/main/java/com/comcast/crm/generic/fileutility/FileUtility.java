package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author Deepak
 *
 */
public class FileUtility {
	/**
	 * used to read the data from propertied file based on key
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromPropertiesFile(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./configAppData/commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		
		return data;
	}

}
