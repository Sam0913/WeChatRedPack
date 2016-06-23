package com.smart.weixinredpack.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * @Description XmlUtils
 * @author Sam 
 * @date 2016年6月23日下午4:12:42
 *
 */
public class XmlUtils {
	
	/**
	 * bean转换xml
	 * @param obj
	 * @param type
	 * @return
	 */
    public static <T> String convertBeanToXml(Object obj, Class<T> cla) {
        XStream xstream = new XStream(new XppDriver(new XmlFriendlyNameCoder("__", "_")));
        xstream.alias("xml", cla);
        String xml = xstream.toXML(obj);
        return xml;
    }

    /**
     * xml转化bean
     * @param xml
     * @param cls
     * @return
     */
    @SuppressWarnings("unchecked")
	public static <T> T convertXmlBean(String xml,Class<T> cls) {
        XStream xstream = new XStream();
        xstream.alias("xml", cls);
        T response = (T) xstream.fromXML(xml);
        return response;
    }
}
