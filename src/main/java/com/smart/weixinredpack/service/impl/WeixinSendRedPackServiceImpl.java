package com.smart.weixinredpack.service.impl;

import org.springframework.stereotype.Service;

import com.smart.weixinredpack.domain.WeixinConfig;
import com.smart.weixinredpack.domain.enums.RedPackType;
import com.smart.weixinredpack.domain.request.BaseRedPackRequest;
import com.smart.weixinredpack.domain.request.WeixinFissionRedPackRequest;
import com.smart.weixinredpack.domain.request.WeixinNormalRedPackRequest;
import com.smart.weixinredpack.domain.response.WeixinRedPackResponse;
import com.smart.weixinredpack.service.IWeixinSendRedPackService;
import com.smart.weixinredpack.util.http.HttpClientUtil;

@Service
public class WeixinSendRedPackServiceImpl implements IWeixinSendRedPackService {
	
	@Override
	public WeixinRedPackResponse sendRedPack(int redPackType,BaseRedPackRequest baseRedPackRequest) throws Exception{
		WeixinRedPackResponse response = new WeixinRedPackResponse();
		String url  = "";
		if(RedPackType.RED_PACK_TYPE_NORMAL.type  ==  redPackType){
			WeixinNormalRedPackRequest normalRedPackRequest = (WeixinNormalRedPackRequest) baseRedPackRequest;
			url = WeixinConfig.NORMAL_API_URL;
			response = HttpClientUtil.doPost(url, normalRedPackRequest, WeixinRedPackResponse.class);
		}else if(RedPackType.RED_PACK_TYPE_FISSION.type == redPackType){
			WeixinFissionRedPackRequest fissionRedPackRequest = (WeixinFissionRedPackRequest) baseRedPackRequest;
			url = WeixinConfig.FISSION_API_URL;
			response = HttpClientUtil.doPost(url, fissionRedPackRequest, WeixinRedPackResponse.class);
		}
		return response;
	}
}
