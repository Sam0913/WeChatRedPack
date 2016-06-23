package com.smart.weixinredpack.util;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 
 * @Description XMLParser 
 * @author Sam 
 * @date 2015年10月26日下午4:31:51
 *
 */
public class XMLParserUtil {
	
	@SuppressWarnings("unchecked")
	public static Map<String,String> getMapStringFromXML(String xmlString) throws Exception{
        //这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
        Document factory = DocumentHelper.parseText(xmlString);
        // 获取当前节点的所有属性节点  
        List<Element> list = factory.getRootElement().elements();  
        Map<String,String> map = new HashMap<String, String>();
        //获取到document里面的全部结点
        for (Element element : list) {  
        	map.put(element.getName(), element.getText());
        }  
        return map;
    }
   
	@SuppressWarnings("unchecked")
	public static Map<String,Object> getMapFromXML(String xmlString) throws Exception{
        //这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
        Document factory = DocumentHelper.parseText(xmlString);
        // 获取当前节点的所有属性节点  
        List<Element> list = factory.getRootElement().elements();  
        Map<String,Object> map = new HashMap<String, Object>();
        //获取到document里面的全部结点
        for (Element element : list) {  
        	map.put(element.getName(), element.getText());
        }  
        return map;
    }
    
    public static InputStream getStringStream(String sInputString) throws UnsupportedEncodingException {
        ByteArrayInputStream tInputStringStream = null;
        if (sInputString != null && !sInputString.trim().equals("")) {
            tInputStringStream = new ByteArrayInputStream(sInputString.getBytes("UTF-8"));
        }
        return tInputStringStream;
    }


}