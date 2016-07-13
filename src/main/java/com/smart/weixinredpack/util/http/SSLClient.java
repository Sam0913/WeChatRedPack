package com.smart.weixinredpack.util.http;


import java.io.InputStream;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.smart.weixinredpack.domain.WeixinConfig;
/**
 * 
 * @Description 用于进行Https请求的HttpClient
 * @author Sam 
 * @date 2015年7月2日下午8:06:24
 *
 */
public class SSLClient extends HttpClientBuilder{
	
	private SSLClient() throws Exception{}
	
	public static CloseableHttpClient getInstance() throws Exception{
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
    	ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource resources = resourcePatternResolver.getResource(WeixinConfig.KEY_PATH);
		InputStream stream = resources.getInputStream();
		try {
			keyStore.load(stream, WeixinConfig.MCH_ID.toCharArray());
		} finally {
			stream.close();
		}
		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, WeixinConfig.MCH_ID.toCharArray()).build();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	}
	
	
}
