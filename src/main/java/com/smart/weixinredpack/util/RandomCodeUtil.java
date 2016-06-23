package com.smart.weixinredpack.util;


import java.util.Random;
/**
 * 随机数codeutil
 * @author Sam 
 *
 */
public class RandomCodeUtil {

	/**
	 * 获得随机数 int
	 * @param p 位数
	 * @return
	 */
	public static String randomInt(int p){
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < p; i++){
			result.append(nextInt(0,9));
		}
		return result.toString();
	}
	
	/**
	 * 随机生成一个int型
	 * @param min 目前没有用 从0开始
	 * @param max 最大值，不包括当前值
	 * @return
	 */
	public static int nextInt(int min, int max) {
		Random rand = new Random();
		  
		int value = 0;
		value = rand.nextInt(max); 

		return value;
	}
	
}
