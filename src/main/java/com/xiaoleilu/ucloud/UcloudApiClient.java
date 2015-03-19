package com.xiaoleilu.ucloud;

import java.io.IOException;

import com.xiaoleilu.hutool.HttpUtil;
import com.xiaoleilu.hutool.Log;
import com.xiaoleilu.hutool.StrUtil;
import com.xiaoleilu.hutool.log.LogWrapper;
import com.xiaoleilu.ucloud.entity.Param;
import com.xiaoleilu.ucloud.util.Config;

/**
 * Ucloud Api请求客户端
 * @author Looly
 *
 */
public class UcloudApiClient {
	private final static LogWrapper log = Log.get();
	
	
	// --------------------------------------------------------------- Constructor start
	public UcloudApiClient() {
	}
	// --------------------------------------------------------------- Constructor end
	
	/**
	 * get请求API
	 * @param resource 请求的资源
	 * @param param 参数
	 * @return 请求结果
	 * @throws IOException
	 */
	public String get(String resource, Param param) throws IOException{
		String uri = StrUtil.format("{}{}?{}", Config.BASE_URL, resource, param.genHttpParam());
		
		log.debug("Get {}", uri);
		String response = HttpUtil.get(uri, Config.CHARSET, false);
		return response;
	}
	
	/**
	 * get请求API<br>
	 * resource 使用默认的 /
	 * @param param 参数
	 * @return 请求结果
	 * @throws IOException
	 */
	public String get(Param param) throws IOException{
		return get("/", param);
	}
	
	public static void main(String[] args) throws IOException {
		
		Param param = new Param();
		param
			.set("Action", "SendSms")
			.set("Content", "message")
			.set("Phone.0", "18847336369");
		
		UcloudApiClient client = new UcloudApiClient();
		String res = client.get("/", param);
		
		System.out.println(res);
	}
}
