package com.smart.weixinredpack.domain.enums;

/**
 * 
 * @Description:红包类型
 * @author Sam 
 * @date 2016年6月25日下午5:42:59
 *
 */
public enum RedPackType {

    RED_PACK_TYPE_NORMAL(1,"正常红包"),
    RED_PACK_TYPE_FISSION(2,"裂变红包"); 
    
    public int type; //类型
    public String value; //描述

    RedPackType(int type,String value){
    	this.type = type;
        this.value = value;
    }

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

    
    
}
