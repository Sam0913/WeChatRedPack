package com.smart.weixinredpack.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import com.smart.weixinredpack.domain.WeixinConfig;
/**
 * 
 * @Description WeixinUtils
 * @author Sam 
 * @date 2016年6月22日下午6:31:19
 *
 */
public class WeixinUtils {

    /**
     * 签名算法
     * @param o 要参与签名的数据对象
     * @return 签名
     * @throws IllegalAccessException
     */
    public static String getSign(Object o) throws IllegalAccessException {
        ArrayList<String> list = new ArrayList<String>();
        Class<? extends Object> cls = o.getClass();
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.get(o) != null && f.get(o) != "") {
            	if(f.getName().equals("packageStr")){
                    list.add("package=" + f.get(o) + "&");
            	}else{
            		list.add(f.getName() + "=" + f.get(o) + "&");
            	}
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
        System.out.println("Sign 生成前 MD5:" + result);
        result = MD5.MD5Encode(result).toUpperCase();
        System.out.println("Sign 结果:" + result);
        return result;
    }
    
    public static void main(String[] args) {
		System.out.println(MD5.MD5Encode("appId=wxd1cb51106e41ec3f&nonceStr=71a8b2ffe0b594a5c1b3c28090384fd7&packageStr=prepay_id=wx20160718132142308ffc9bb40019053467&signType=MD5&timeStamp=1468819299&key=31b38aa0becb5be26bd47137967fcb26").toUpperCase());
	}

    /**
     * 生成NonceStr
     * @return
     */
    public static String getNonceStr() {
        Random random = new Random();
        return MD5.MD5Encode(String.valueOf(random.nextInt(10000)));
    }
    
    /**
     * 生成mchbillno
     * @return
     */
    public static String getMchBillno(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	return WeixinConfig.MCH_ID + sdf.format(new Date()) + RandomCodeUtil.randomInt(10);
    }
    
}
