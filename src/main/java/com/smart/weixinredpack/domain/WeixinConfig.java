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
	public static String WXAPPID = "";
	
	/**
	 * mch_id 商户id
	 */
	public static String MCH_ID  = "";
	
	/**
	 * send_name 商户名称
	 */
	public static String SEND_NAME  = "";
	
	/**
     * API密钥
     */
    public static String KEY = "";
    
    /**
     * 密钥文件的存放路径
     */
    public static String KEY_PATH = "";
    
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


    
	public static String getWXAPPID() {
		return WXAPPID;
	}

	public void setWXAPPID(String wXAPPID) {
		WeixinConfig.WXAPPID = wXAPPID;
	}


	public static String getMCH_ID() {
		return MCH_ID;
	}


	public void setMCH_ID(String mCH_ID) {
		WeixinConfig.MCH_ID = mCH_ID;
	}


	public String getSEND_NAME() {
		return SEND_NAME;
	}


	public void setSEND_NAME(String sEND_NAME) {
		WeixinConfig.SEND_NAME = sEND_NAME;
	}

	public static String getKEY() {
		return KEY;
	}

	public void setKEY(String kEY) {
		WeixinConfig.KEY = kEY;
	}

	public static String getKEY_PATH() {
		return KEY_PATH;
	}

	public void setKEY_PATH(String kEY_PATH) {
		WeixinConfig.KEY_PATH = kEY_PATH;
	}
	
	
	
    
	
}
