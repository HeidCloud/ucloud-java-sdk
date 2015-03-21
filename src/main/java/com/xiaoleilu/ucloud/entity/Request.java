package com.xiaoleilu.ucloud.entity;

import com.xiaoleilu.ucloud.util.Config;
import com.xiaoleilu.ucloud.util.ParamName;


/**
 * 请求参数类。此类定义了设置数据中心和设置操作的方法
 * @author Looly
 *
 */
public class Request{
	
	/** 指令名称 */
	private String action;
	/** 数据中心 */
	private String region;
	/** 指令参数 */
	private Param param;
	
	// --------------------------------------------------------------- Constructor start
	/**
	 * 构造请求对象
	 * @param action 指令名称
	 * @param region 数据中心
	 * @param param 指令参数
	 */
	public Request(String action, String region, Param param) {
		super();
		this.action = action;
		this.region = region;
		this.param = param;
	}
	
	/**
	 * 构造请求对象
	 * @param action 指令名称
	 * @param region 数据中心
	 */
	public Request(String action, String region) {
		this(action, region, Param.create());
	}
	// --------------------------------------------------------------- Constructor end
	
	// --------------------------------------------------------------- Getters and Setters start
	/**
	 * @return 获得操作名
	 */
	public String getAction() {
		return action;
	}
	/**
	 * 设置 操作<br>
	 * @see com.xiaoleilu.ucloud.util.Region
	 * @param action 操作名
	 */
	public void setAction(String action){
		this.action = action;
	}

	/**
	 * @return 获得数据中心名
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * 设置 数据中心
	 * @see com.xiaoleilu.ucloud.util.Region
	 * 
	 * @param region 数据中心名
	 */
	public void setRegion(String region){
		this.region = region;
	}
	
	/**
	 * @return 指令参数
	 */
	public Param getParam() {
		return param;
	}
	/**
	 * 设置指令参数
	 * @param param 指令参数
	 */
	public void setParam(Param param) {
		this.param = param;
	}
	// --------------------------------------------------------------- Getters and Setters end
	
	/**
	 * 生成参数对象
	 * @return 参数对象
	 */
	public Param genParam(){
		final Param clonedParam = this.param.clone();
		clonedParam
		.set(ParamName.ACTION, this.action)
		.set(ParamName.REGION, this.region);
		
		return clonedParam;
	}
	
	/**
	 * 生成Http请求参数字符串
	 * @param config 公共参数设置
	 * @return Http请求参数字符串
	 */
	public String genHttpParam(Config config){
		return genParam().genHttpParam(config);
	}
	
}
