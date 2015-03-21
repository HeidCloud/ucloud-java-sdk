package com.xiaoleilu.ucloud.entity;

import com.alibaba.fastjson.JSON;
import com.xiaoleilu.hutool.StrUtil;
import com.xiaoleilu.ucloud.util.ParamName;
import com.xiaoleilu.ucloud.util.RetCode;

/**
 * API响应对象
 * @author Looly
 *
 */
public class Response {
	
	/** 返回结构中的API返回码名称 */
	public final static String KEY_RET_CODE = "RetCode";
	/** 返回结构中的指令名称 */
	public final static String KEY_ACTION = ParamName.ACTION;
	/** 返回结果总数（可选） */
	public final static String KEY_TOTAL_COUNT = "TotalCount";
	/** 返回错误信息（可选） */
	public final static String KEY_MESSAGE = "Message";
	
	/** 指令（错误时不显示） */
	private String action;
	/** API返回码 */
	private int retCode = -1;
	/** 消息（非必需） */
	private String message;
	/** 结果总数（非必需） */
	private int totalCount;
	// --------------------------------------------------------------- Getters and Setters start
	/**
	 * @return 指令
	 */
	public String getAction() {
		return action;
	}
	/**
	 * 设置指令
	 * @param action 指令
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * @return API返回码
	 */
	public int getRetCode() {
		return retCode;
	}
	/**
	 * 设置 API返回码
	 * @param retCode API返回码
	 */
	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	
	/**
	 * @return 消息
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 设置消息
	 * @param message 消息
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @return 总数
	 */
	public int getTotalCount() {
		return totalCount;
	}
	/**
	 * 设置结果数
	 * @param totalCount 结果数
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	// --------------------------------------------------------------- Getters and Setters end
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
	/**
	 * 将服务器返回的JSON转换为Response对象
	 * @param resStr 服务器返回的JSON字符串
	 * @return Response对象
	 */
	public static Response parse(String resStr){
		Response response = new Response();
		
		if(StrUtil.isBlank(resStr)) {
			//服务器没有返回数据
			response.setRetCode(RetCode.ERROR);
			response.setMessage("Ucloud API responsed null !");
			return response;
		}
		
		response = JSON.parseObject(resStr, Response.class);
		return response;
	}
}
