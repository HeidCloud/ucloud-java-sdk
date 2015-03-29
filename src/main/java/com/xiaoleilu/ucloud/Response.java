package com.xiaoleilu.ucloud;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * API响应内容
 * @author Looly
 *
 */
public class Response{
	private JSONObject json;
	
	/**
	 * 将返回的JSON字符串转为响应对象
	 * @param jsonStr 响应JSON字符串
	 * @return 响应对象
	 */
	public static Response parse(String jsonStr) {
		Response response = new Response();
		response.json = JSON.parseObject(jsonStr);
		
		return response;
	}
	
	/**
	 * 获得对象
	 * @param key KEY
	 * @return 对象
	 */
	public Object get(String key) {
		return this.json.get(key);
	}
	
	/**
	 * 获得响应状态码
	 * @return 响应状态码
	 */
	public int getRetCode() {
		return this.json.getIntValue("RetCode");
	}
	
	/**
	 * 获得返回的消息（一般为错误消息）
	 * @return 返回消息
	 */
	public String getMessage() {
		return this.json.getString("Message");
	}
	
	/**
	 * 获得满足条件结果数
	 * @return 满足条件结果数
	 */
	public int getTotalCount() {
		return this.json.getIntValue("TotalCount");
	}
	
	/**
	 * 获得响应JSON对象
	 * @return 响应JSON对象
	 */
	public JSONObject getJson(){
		return this.json;
	}
	
	/**
	 * 输出格式化后的JSON字符串
	 * @return 格式化后的JSON字符串
	 */
	public String toPretty(){
		return JSON.toJSONString(this.json, true);
	}
	
	@Override
	public String toString() {
		return this.json.toJSONString();
	}
}
