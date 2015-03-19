package com.xiaoleilu.ucloud.uhost.param;

import com.xiaoleilu.ucloud.entity.RequestParam;

/**
 * 获取指定数据中心镜像列表，用户可通过指定操作系统类型，镜像Id进行过滤。
 * @author Looly
 *
 */
public class DescribeImageParam extends RequestParam{
	
	/**
	 * 构造，自动设置操作名称
	 */
	public DescribeImageParam() {
		this.setAction("DescribeImage");
	}
}
