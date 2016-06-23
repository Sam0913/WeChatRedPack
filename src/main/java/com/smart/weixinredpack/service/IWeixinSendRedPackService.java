package com.smart.weixinredpack.service;

import com.smart.weixinredpack.domain.request.BaseRedPackRequest;
import com.smart.weixinredpack.domain.response.WeixinRedPackResponse;


/**
 * 
 * @Description 微信发送红包接口 
 * @author Sam 
 * @date 2015年7月6日下午7:04:32
 *
 */
public interface IWeixinSendRedPackService {
	
	/**
	 * 发送微信红包
	 * @param redPackType 枚举类型：发送红包有 正常 or 裂变
	 * @param baseRedPackRequest 请求参数
	 * @exception Exception
	 * @return
	 */
	public WeixinRedPackResponse sendRedPack(int redPackType,BaseRedPackRequest baseRedPackRequest) throws Exception;


}
