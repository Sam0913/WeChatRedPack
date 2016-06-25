package com.smart.weixinredpack.domain.request;
/**
 * 
 * @Description WeixinNormalRedPackRequest  微信普通红包的请求对象
 * @author Sam 
 * @date 2016年6月25日下午5:42:59
 *
 */
public class WeixinNormalRedPackRequest extends BaseRedPackRequest{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String client_ip; //调用接口的机器Ip地址

	public String getClient_ip() {
		return client_ip;
	}

	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}
    
    
}
