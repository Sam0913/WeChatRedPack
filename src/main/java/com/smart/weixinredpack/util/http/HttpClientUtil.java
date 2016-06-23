package com.smart.weixinredpack.util.http;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.smart.weixinredpack.domain.enums.HttpType;
import com.smart.weixinredpack.domain.exception.WeixinMerchantsException;
import com.smart.weixinredpack.util.XmlUtils;
/**
 * 
 * @Description 发送请求工具
 * @author Sam 
 * @date 2015年7月2日下午4:57:13
 *
 */
public class HttpClientUtil {
	
	/**
	 * 默认发送https post请求
	 * @param url
	 * @param param
	 * @param cla
	 * @param httpType
	 * @return
	 */
	public final static <T> T doPost(String url,Object param,Class<T> cla){
		return doPost(url, param, cla, HttpType.https);
	}
	
	/**
	 * 发送 post，参数json
	 * @param url
	 * @param param
	 * @param cla 返回类型
	 * @return
	 * 
	 */
	public final static <T> T doPost(String url,Object param,Class<T> cla,HttpType httpType) {
		CloseableHttpClient httpClient = HttpClients.custom().build();
		HttpPost httpPost = null;
		String result = null;
		T t = null;
		try{
			//根据传入的类型执行不同的请求类型
			if(HttpType.https.equals(httpType)){
				httpClient = new SSLClient().build();
			}
			httpPost = new HttpPost(url);
			
			//设置参数，把参数转化成xml
			StringEntity sEntity = null;
			if(param instanceof String){
				sEntity = new StringEntity(param.toString(),"UTF-8");
			}else{
				sEntity = new StringEntity(XmlUtils.convertBeanToXml(param, String.class),"UTF-8");
			}
			sEntity.setContentEncoding("UTF-8");
			sEntity.setContentType("application/x-www-form-urlencoded");   
			httpPost.setEntity(sEntity);
			
			HttpResponse response = httpClient.execute(httpPost);
			if(response != null){
				HttpEntity resEntity = response.getEntity();
				if(resEntity != null){
			        result = EntityUtils.toString(response.getEntity());// 返回xml格式
			        try{
			        	t = XmlUtils.convertXmlBean(result,cla);
			        }catch(Exception e){
	                    throw new WeixinMerchantsException(e.getMessage(),e);
			        }
				}
			}
		}catch(WeixinMerchantsException ex){
			throw ex;
		}catch(Exception ex){
			throw new WeixinMerchantsException("发送微信POST请求异常:"+ex.getMessage());
		}
		return t;
	}
	
	
	

	/**
	 * 默认是https get请求
	 * @param url
	 * @param cla
	 * @return
	 */
	public final static <T> T doGet(String url,Class<T> cla){
		return doGet(url, cla, HttpType.https);
	}

	/**
	 * 发送https get
	 * @param url
	 * @param cla 返回类型
	 * @return
	 */
	public final static <T> T doGet(String url,Class<T> cla,HttpType httpType) {
		CloseableHttpClient httpClient = HttpClients.custom().build();
		HttpGet httpGet = null;
		String result = null;
		T t = null; //返回的泛型类
		try{
			//根据传入的类型执行不同的请求类型
			if(HttpType.https.equals(httpType)){
				httpClient = new SSLClient().build();
			}
			
			httpGet = new HttpGet(url);
			HttpResponse response = httpClient.execute(httpGet);
			if(response != null){
				HttpEntity resEntity = response.getEntity();
				if(resEntity != null){
			        try{
		        		result  = EntityUtils.toString(resEntity,"UTF-8");
			        	t = XmlUtils.convertXmlBean(result,cla);
			        }catch(Exception e){
	                    throw new WeixinMerchantsException(e.getMessage(), e);
			        }
				}
			}
		}catch(WeixinMerchantsException ex){
			throw ex;
		}catch(Exception ex){
			throw new WeixinMerchantsException("发送微信get请求异常",ex);
		}
		return t;
	}

}