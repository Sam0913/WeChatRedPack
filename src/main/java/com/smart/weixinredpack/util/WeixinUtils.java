package com.smart.weixinredpack.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;

import com.smart.weixinredpack.domain.WeixinConfig;
import com.smart.weixinredpack.domain.request.BaseRedPackRequest;
/**
 * 
 * @Description WeixinUtils
 * @author Sam 
 * @date 2016年6月22日下午6:31:19
 *
 */
public class WeixinUtils {

	
	/**
	 * 生成签名
	 * @param request
	 * @return
	 * @throws Exception
	 */
    @SuppressWarnings("unchecked")
	public static String buildRequestSign(BaseRedPackRequest request) throws Exception {
        try {
            Map<String, String> sPara = BeanUtils.describe(request);
            return getWxSign(sPara);
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * 生成NonceStr
     * @return
     */
    public static String getNonceStr() {
        Random random = new Random();
        return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)), "UTF-8");
    }
    
    /**
     * 生成mchbillno
     * @return
     */
    public static String getMchBillno(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	return WeixinConfig.MCH_ID + sdf.format(new Date()) + RandomCodeUtil.randomInt(10);
    }
    
    /**
	 * 签名算法
	 * @param map
	 * @return
	 */
    public static String getWxSign(Map<String,String> map){
        ArrayList<String> list = new ArrayList<String>();
        for(Map.Entry<String,String> entry:map.entrySet()){
            if(entry.getValue()!=""){
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + WeixinConfig.KEY;
        result = DigestUtils.md5Hex(result).toUpperCase();
        return result;
    }
    
}
