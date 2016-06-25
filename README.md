# WeChatRedPack
java封装发送微信红包API功能。

1、目前支持两种红包类型
   * 普通
   * 裂变

##使用方法
1、使用spring依赖注入。提供服务类
```
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
```

2、引入此jar包需要在自己项目中注入WeixinConfig中的配置信息。

3、使用简单粗暴，有问题请联系作者：Sam 。

WeChat： ![image](https://github.com/Sam0913/WeChatRedPack/blob/master/sam.jpg)
