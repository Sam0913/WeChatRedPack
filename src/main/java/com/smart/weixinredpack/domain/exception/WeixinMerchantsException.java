package com.smart.weixinredpack.domain.exception;


/**
 * 
 * @Description 微信异常处理类
 * @author Sam 
 * @date 2016年6月25日下午5:42:59
 *
 */
public class WeixinMerchantsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
     * 错误业务代码
     * 
     */
    private String code;


    public WeixinMerchantsException() {

    }

    public WeixinMerchantsException(String message) {
        super(message);
    }

    public WeixinMerchantsException(String code, String message) {
        super(message);
        this.code = code;
    }

    public WeixinMerchantsException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public WeixinMerchantsException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String toString(){
        return "code:" + code + ", msg:" + getMessage();
    }

}
