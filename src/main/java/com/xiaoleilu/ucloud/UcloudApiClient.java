package com.xiaoleilu.ucloud;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.xiaoleilu.hutool.HttpUtil;
import com.xiaoleilu.hutool.StrUtil;
import com.xiaoleilu.ucloud.util.Config;

public class UcloudApiClient {
	
	private String publicKey;
	
	public UcloudApiClient(String publicKey) {
		this.publicKey = publicKey;
	}
	
	public String get(String uri, Map<String, Object> params) throws IOException{
		Map<String, Object> map = clone(params);
		map.put("PublicKey", this.publicKey);
		
		String response = HttpUtil.get(Config.BASE_URL + "/" + uri + "?" + encodeParams(map), Config.CHARSET, false);
		return response;
	}
	
	/**
	 * 浅复制map
	 * @param params 参数map
	 * @return 复制后的map
	 */
	private Map<String, Object> clone(Map<String, Object> params){
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.putAll(params);
		return hashMap;
	}
	
	/**
	 * url转义参数值
	 * @param params
	 */
	private String encodeParams(Map<String, Object> params){
		Set<String> keys = params.keySet();
		Object value;
		for (String key : keys) {
			value = params.get(key);
			params.put(key, HttpUtil.encode(StrUtil.str(value), Config.CHARSET));
		}
		
		return HttpUtil.toParams(params);
	}
	
	public static void main(String[] args) {
		UcloudApiClient client = new UcloudApiClient("ucloudsomeone@example.com1296235120854146120");
	}
}
