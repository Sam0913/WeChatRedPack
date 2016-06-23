package com.smart.weixinredpack.domain.request;
/**
 * 
 * @Description WeixinFissionRedPackRequest  微信裂变红包的请求对象
 * @author Sam 
 * @date 2016年6月22日下午4:24:42
 *
 */
public class WeixinFissionRedPackRequest extends BaseRedPackRequest{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String amt_type; //红包金额设置方式ALL_RAND—全部随机,商户指定总金额和红包发放总人数，由微信支付随机计算出各红包金额 
	public String getAmt_type() {
		return amt_type;
	}
	public void setAmt_type(String amt_type) {
		this.amt_type = amt_type;
	}

	
    
    
}
