package com.xiaoleilu.ucloud.core;

import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import com.xiaoleilu.hutool.HttpUtil;
import com.xiaoleilu.hutool.Log;
import com.xiaoleilu.hutool.StrUtil;
import com.xiaoleilu.hutool.log.LogWrapper;
import com.xiaoleilu.ucloud.core.Response.RetCode;
import com.xiaoleilu.ucloud.util.Config;
import com.xiaoleilu.ucloud.util.Global;

/**
 * Ucloud Api请求客户端
 * @author Looly
 *
 */
public class UcloudApiClient {
	private final static LogWrapper log = Log.get();
	
	/** 公共参数设置 */
	private Config config;
	
	// --------------------------------------------------------------- Constructor start
	/**
	 * 构造
	 * @param config 公共参数设置，包括公钥、私钥、API URL等
	 */
	public UcloudApiClient(Config config) {
		super();
		this.config = config;
	}
	
	/**
	 * 构造，使用默认的公共参数配置文件
	 */
	public UcloudApiClient() {
		super();
		this.config = Config.createFromSetting();
	}
	// --------------------------------------------------------------- Constructor end
	
	/**
	 * get请求API
	 * @param resource 请求的资源
	 * @param param 参数
	 * @return 请求结果
	 * @throws IOException
	 */
	public String getForStr(String resource, Param param){
		final String uri = StrUtil.format("{}{}?{}", config.getBaseUrl(), resource, param.genHttpParam(config));
		log.debug("Get: {}", uri);
		
		String resStr = null;
		try {
			resStr = HttpUtil.get(uri, Global.CHARSET, false);
		} catch (IOException e) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("RetCode"	, RetCode.ERROR);
			jsonObject.put("Message", e.getMessage());
			resStr = jsonObject.toString();
		}
		
//		log.debug("Response: {}", resStr);
		return resStr;
	}
	
	/**
	 * get请求API
	 * @param resource 请求的资源
	 * @param param 参数
	 * @return 请求结果
	 * @throws IOException
	 */
	public Response get(String resource, Param param){
		return Response.parse(getForStr(resource, param));
	}
	
	/**
	 * get请求API<br>
	 * resource 使用默认的 /
	 * @param param 参数
	 * @return 请求结果
	 * @throws IOException
	 */
	public Response get(Param param){
		return get("/", param);
	}
	
	/**
	 * get请求API<br>
	 * resource 使用默认的 /
	 * @param action API指令
	 * @param param 参数
	 * @return 请求结果
	 * @throws IOException
	 */
	public Response get(Action action, Param param){
		param.setAction(action);
		return get("/", param);
	}
}
