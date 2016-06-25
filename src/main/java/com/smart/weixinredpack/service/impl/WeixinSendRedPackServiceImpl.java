package com.smart.weixinredpack.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.smart.weixinredpack.domain.WeixinConfig;
import com.smart.weixinredpack.domain.enums.RedPackType;
import com.smart.weixinredpack.domain.exception.WeixinMerchantsException;
import com.smart.weixinredpack.domain.request.BaseRedPackRequest;
import com.smart.weixinredpack.domain.request.WeixinFissionRedPackRequest;
import com.smart.weixinredpack.domain.request.WeixinNormalRedPackRequest;
import com.smart.weixinredpack.domain.response.WeixinRedPackResponse;
import com.smart.weixinredpack.service.IWeixinSendRedPackService;
import com.smart.weixinredpack.util.http.HttpClientUtil;

@Service
public class WeixinSendRedPackServiceImpl implements IWeixinSendRedPackService {
	private final static Logger LOGGER = LoggerFactory.getLogger(WeixinSendRedPackServiceImpl.class);
	
	@Override
	public boolean sendRedPack(int redPackType,BaseRedPackRequest baseRedPackRequest) throws Exception{
		if(baseRedPackRequest.getTotal_amount() < WeixinConfig.MIN_PRICE){
			throw new WeixinMerchantsException("红包最小金额1.0元");
		}
		WeixinRedPackResponse response = new WeixinRedPackResponse();
		boolean isSucces = false; 
		String url  = "";
		if(RedPackType.RED_PACK_TYPE_NORMAL.type  ==  redPackType){
			WeixinNormalRedPackRequest normalRedPackRequest = (WeixinNormalRedPackRequest) baseRedPackRequest;
			if(normalRedPackRequest.getTotal_amount() < WeixinConfig.NORMAL_MAX_PRICE){
				throw new WeixinMerchantsException("正常类型红包金额最大不能超过200.0元");
			}
			url = WeixinConfig.NORMAL_API_URL;
			response = HttpClientUtil.doPost(url, normalRedPackRequest, WeixinRedPackResponse.class);
		}else if(RedPackType.RED_PACK_TYPE_FISSION.type == redPackType){
			WeixinFissionRedPackRequest fissionRedPackRequest = (WeixinFissionRedPackRequest) baseRedPackRequest;
			if(fissionRedPackRequest.getTotal_amount() < WeixinConfig.FISSION_MAX_PRICE){
				throw new WeixinMerchantsException("裂变类型红包金额最大不能超过200.0元");
			}
			url = WeixinConfig.FISSION_API_URL;
			response = HttpClientUtil.doPost(url, fissionRedPackRequest, WeixinRedPackResponse.class);
		}
		if(null != response && "SUCCESS".equals(response.getReturn_code())){
			if("SUCCESS".equals(response.getResult_code())){
				LOGGER.info("发送微信红包成功");
				isSucces = true;
			}else{
				LOGGER.error("发送微信红包异常：{}",response.getReturn_msg());
			}
		}
		return isSucces;
	}
}
