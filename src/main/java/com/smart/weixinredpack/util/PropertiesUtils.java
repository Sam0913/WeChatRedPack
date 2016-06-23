package com.smart.weixinredpack.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
/**
 * 
 * @Description PropertiesUtils
 * @author Sam 
 * @date 2015年7月7日下午4:23:59
 *
 */
public class PropertiesUtils {

	public static String getPropertiesByKey(String key) {
		String keyStr = "";
		Properties p = new Properties();
		InputStreamReader inputStream = null;
		try {
			inputStream = new InputStreamReader(PropertiesUtils.class.getClassLoader().getResourceAsStream("weixin.properties"), "UTF-8");
			p.load(inputStream);
			keyStr = p.getProperty(key);
		} catch (IOException e1) {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
		}

		return keyStr;
	}
}
