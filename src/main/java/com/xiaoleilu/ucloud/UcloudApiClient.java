package com.xiaoleilu.ucloud;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.xiaoleilu.hutool.HttpUtil;
import com.xiaoleilu.hutool.StrUtil;
import com.xiaoleilu.ucloud.util.Const;

public class UcloudApiClient {
	
	private String baseUrl;
	private String publicKey;
	private String privateKey;
	
	public UcloudApiClient(String baseUrl, String publicKey, String privateKey) {
		this.baseUrl = baseUrl;
		this.publicKey = publicKey;
		this.privateKey = privateKey;
	}
	
	public String get(String uri, Map<String, Object> params) throws IOException{
		Map<String, Object> map = copy(params);
		map.put("PublicKey", this.publicKey);
		encodeParams(map);
		
		String paramStr = HttpUtil.toParams(map);
		String response = HttpUtil.get(uri + "?" + paramStr, Const.CHARSET, false);
		return response;
	}
	
	private Map<String, Object> copy(Map<String, Object> params){
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.putAll(params);
		return hashMap;
	}
	
	/**
	 * url转义参数值
	 * @param params
	 */
	private void encodeParams(Map<String, Object> params){
		Set<String> keys = params.keySet();
		Object value;
		for (String key : keys) {
			value = params.get(key);
			params.put(key, HttpUtil.encode(StrUtil.str(value), Const.CHARSET));
		}
	}
}
