package com.smart.weixinredpack.domain;


/**
 * 
 * @Description  微信配置类
 * @author Sam 
 * @date 2016年6月25日下午5:42:59
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
     * 微信红包最小金额1元
     */
    public static final int MIN_PRICE = 100; 
    
    /**
     * 微信普通红包最大金额200元
     */
    public static final int NORMAL_MAX_PRICE = 20000; 
   
    /**
     * 微信裂变红包最大金额1000元
     */
    public static final int FISSION_MAX_PRICE = 100000; 
    
    /**
     * 正常微信红包的API地址
     */
    public static final String NORMAL_API_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
    
    
    /**
     * 裂变微信红包的API地址
     */
    public static final String FISSION_API_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack";
    
	
}
