package com.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092200572231";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDisYfEchc4Hz4uLctctfkwaxPz0vBX6EszbvkRZeJFW5H2aA9sA5UyWNEj3hlS10SoYOfSYzh926X19T+eC0ct6vpBHLI/Jhl3zr0ZQoLjAtvUMZOz5Hd0NcBfVwKCqx6F6TdyKUw+CKLJ6CriTyzO/xtr10Zz9IC5/eTOuXTb8qancdmYFvQcJP6vsF4B/PXYGduSCOs66XJ/7BdjPXnbMWP3vshzAUtMXl1+lQFJ1vLiBXcOyo4i9Q236Ns7BKtpHGoBcGfuD4/5iyDyjrhssVlKvK3AuZH+wQlaflOlGfEVL4i/fi/uwHjO3Wl7S4Q2AlMvHCLdJR2DMZHtoWx5AgMBAAECggEAL1DcxK0Hmagzw1G9o6E73NZMuNSrY73RjG+6Pt5kJxPg2GyJ44Kv7m1JYdImuPrDkt1/JZOeI+7nqfnBiIxUFAp6p4KE1ddu82nMYGxYg2eCWLzsVlz2beQWPhAcLwfmfA7citCB4GTPDZOO9+OMt7vZjl3Fj8hV4fxTeK6O7KVJdH1jW07O6mFOlW6iqIHV0QAbqwpCUFC/FLf5M7isau+ZSAkDs2NWn2d60x6XCKZfl78Bp6w10Qdzldg0InvUHsp3G1/YVk0eD+XJx596mRNHT+Ij9u1x7Y3lkXyZpn5kZC4GVa4ENMw1zfyr2ghAULUj9nuYxYgccSltRyFTcQKBgQD4lVVcRi4Svj6Jd5K0aYI9WmSxsuBIOsWldnpAzGUjbFO1DaGiL86SxRc5l3GrICGQNFxQtACfBO5eL/iX7aNNiXumISFvSOtjEGCWNnIDytwdN0LYOLEW6GmuYOtMUAZdIj2kYBfkrcGgL6sE+7SXCrZAwg041bc/o1Ukn5xtRQKBgQDpdQDZwhVOHXYAUAeAoE/IZtbuaXZtdyVwvtPi+/HheQcdIgc4e7KK9nEmliuDF7wUsQSoZCYToBuY6wAAoJGCNMT68C32tvfQg/WQ+lWFB65psyRsKmn4EJlcOLvTCpc4WRUkI7rsrDRz7rULMmOVzyMJWzs1F30Z3nqFguVzpQKBgGlxNqcQYcSzi+VVohYC1yrdJ+80V+xreaDo84x+5ruy3ILlCFW6f55EGcjlE2MqGvKHM01MPSM2vUGYiZMwSt+93IQoc3036hi4PrAY4h33s4x0/1amHYABD6rXE5foLfrdZlZOKHRou8QN1DYl6oFTGuG3LlKYXMWSq7AAQCMdAoGBAIM+JqNEq8uFXnAgjYcvGIsV3WCcY1p4r9CpRt8FOl7CNlCXb62+RIpAry29IGsLLc4IEhFEc+92g+08t3yiyAqF9fMIkR5wj/JmLOg7A1bNEa0Ua7ZvRbGSS1UAA/9JpeeklPEDMTOaP8ao/Jh11GxEzXKWGjvnn4mqfACQrMONAoGAQPFVz43SLvIQ2mpvsFGJJ9e2JXIEAJpLYXwawGTZLNP/vC9nzhZ5tu3p42X0Ct6Wp0FmIidgFsdXnKN5TFPUk+/7HItTmHI9Lg4UJwYqO1z7hVmGgjrioYTyo654pHieIxiTch4exJopaqEe20NJFkbSBEz/DH1Jkg6bZab0LVE=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxrzivPwQ28AMw65IsKWWCJqgh4gl3fKGT5pPLX7N6RrhgEo8FzpeVT/xsUnf/X2LK12a5HsCdRFZl+Q9mywFl1IPP75Wo+tEnlAKUzzVypMBY82NOiI8R8adsnXeC6f2CqPGKTin88dpUVP4Lr4O9g4AVL5f54COkXZFgLfFqkcY67k99/9j0OGhQIthqaedtg92Wpq61P9k4dXWrsRLM7SODvkjn5k0ckrj/1+hJsVxMrsNXqMZTwwLDaZ/ZY8bsss/JR+RLG6UXuGs+E2VxfkYbhKGEipiP6tt+wzNDC2ylkyv2lbmMuwqnwJ5EnmipgYXS4MimGziYbEJAraYYQIDAQAB";


	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

