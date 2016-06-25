# WeChatRedPack
java封装发送微信红包API功能。

1、目前支持两种红包类型
   * 普通
   * 裂变
  
2、目前对微信红包api的发送增加了金额校验，暂时未对发送频率做限制，后期会使用redis进行限制。

3、使用简单粗暴，调用者只需要关心返回结果成功or失败，整个调用过程是透明化，有问题请联系作者：Sam 。


##使用方法
1、下载使用maven install 安装到本地or远程私服仓库，在自己项目pom添加依赖即可。

2、需要在引入项目中使用spring注入WeixinConfig中的微信商户配置信息。
```
//wxappid 
public static String WXAPPID = null;

//mch_id 商户id
public static String MCH_ID  = null;

//send_name 商户名称
public static String SEND_NAME  = null;

//API密钥
public static final String KEY = null;

//密钥文件的存放路径
public static final String KEY_PATH = null;
```
3、在需要发送红包功能类中使用spring依赖注入,提供服务类。
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
WeChat： 
![image](https://github.com/Sam0913/WeChatRedPack/blob/master/sam.jpg)
