package com.xiaoleilu.ucloud.entity;


/**
 * 请求参数类。此类定义了设置数据中心和设置操作的方法
 * @author Looly
 *
 */
public class RequestParam{
	
	/** 数据中心 */
	private String region;
	/** 操作 */
	private String action;

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
	 * 转换为请求API的参数对象
	 * @return 请求API的参数对象
	 */
	public Param toParam(){
		return Param.create().parse(this);
	}
}
