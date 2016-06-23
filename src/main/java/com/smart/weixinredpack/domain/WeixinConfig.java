package com.smart.weixinredpack.domain;


/**
 * @Description 微信配置类
 * @author Sam 
 * @date 2015年7月1日下午10:55:08
 *
 */
public class WeixinConfig {
	
	/**
	 * wxappid 
	 */
	public static String WXAPPID = null;
	
	/**
	 * mch_id 商户id
	 */
	public static String MCH_ID  = null;
	
	/**
	 * send_name 商户名称
	 */
	public static String SEND_NAME  = null;

	/**
     * API密钥
     */
    public static final String KEY = null;
    
    /**
     * 密钥文件的存放路径
     */
    public static final String KEY_PATH = null;
    
    /**
     * 正常微信红包的API地址
     */
    public static final String NORMAL_API_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
    
    
    /**
     * 裂变微信红包的API地址
     */
    public static final String FISSION_API_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack";
    
	
}
