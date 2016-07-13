package com.smart.weixinredpack.domain.request;

import java.io.Serializable;

import com.smart.weixinredpack.domain.WeixinConfig;
import com.smart.weixinredpack.util.WeixinUtils;

/**
 * 
 * @Description 微信红包请求的消息的公用部分
 * @author Sam 
 * @date 2016年6月25日下午5:42:59
 *
 */
public class BaseRedPackRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String mch_billno = WeixinUtils.getMchBillno(); //商户订单号，必须唯一，组成： mch_id+yyyymmdd+10位一天内不能重复的数字
    private String mch_id = WeixinConfig.MCH_ID;   //微信支付分配的商户号  
    private String wxappid = WeixinConfig.WXAPPID;  //公众账号appid
    private String send_name = WeixinConfig.SEND_NAME; //商户名称
    private String nonce_str = WeixinUtils.getNonceStr();  //随机字符串，不长于32位
    private String sign;       //签名
    private String re_openid; //接收红包的种子用户（首个用户）用户在wxappid下的openid
    private int total_amount; //红包发放总金额，即一组红包金额总和，包括分享者的红包和裂变的红包，单位分 
    private int total_num;  //红包发放总人数，即总共有多少人可以领到该组红包（包括分享者）
    private String wishing;  //红包祝福语
    private String act_name; //活动名称
    private String remark; //备注
    
    
	public String getNonce_str() {
		return nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getMch_billno() {
		return mch_billno;
	}
	public String getMch_id() {
		return mch_id;
	}
	public String getWxappid() {
		return wxappid;
	}
	public String getSend_name() {
		return send_name;
	}
	public void setSend_name(String send_name) {
		this.send_name = send_name;
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
	public int getTotal_num() {
		return total_num;
	}
	public void setTotal_num(int total_num) {
		this.total_num = total_num;
	}
	public String getWishing() {
		return wishing;
	}
	public void setWishing(String wishing) {
		this.wishing = wishing;
	}
	public String getAct_name() {
		return act_name;
	}
	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
