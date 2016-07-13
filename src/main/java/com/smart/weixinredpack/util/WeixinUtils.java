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
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.get(o) != null && f.get(o) != "") {
                list.add(f.getName() + "=" + f.get(o) + "&");
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
