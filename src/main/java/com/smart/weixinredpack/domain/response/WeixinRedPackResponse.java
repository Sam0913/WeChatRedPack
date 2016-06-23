package com.smart.weixinredpack.domain.response;

import java.io.Serializable;

import com.smart.weixinredpack.domain.MerchantsGlobalError;

/**
 * 
 * @Description 微信发送红包返回响应
 * @author Sam 
 * @date 2015年7月1日下午6:23:01
 *
 */
public class WeixinRedPackResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private String return_code; //返回状态码
    private String sign; //签名
    private String result_code; //业务结果
    private String return_msg; //返回信息
    public String err_code; //错误代号
    public String err_code_des; //错误文案

    private String mch_billno; //商户订单号
    private String mch_id; //商户号
    private String wxappid; //公众账号appid
    private String re_openid; //用户openid
    private int total_amount; //发送金额
    private String send_time; //红包发放成功时间，格式为yyyyMMddHHmmss，如2015年02月27日9点10分10秒表示为20150227091010。
    private String send_listid; //微信单号
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getMch_billno() {
		return mch_billno;
	}
	public void setMch_billno(String mch_billno) {
		this.mch_billno = mch_billno;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getWxappid() {
		return wxappid;
	}
	public void setWxappid(String wxappid) {
		this.wxappid = wxappid;
	}
	public String getRe_openid() {
		return re_openid;
	}
	public void setRe_openid(String re_openid) {
		this.re_openid = re_openid;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public String getSend_listid() {
		return send_listid;
	}
	public void setSend_listid(String send_listid) {
		this.send_listid = send_listid;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		err_code_des = MerchantsGlobalError.map.get(err_code);
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
    
   
    
}
