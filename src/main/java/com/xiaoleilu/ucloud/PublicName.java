package com.xiaoleilu.ucloud;

import com.xiaoleilu.ucloud.Param.Name;


/**
 * 参数名常量定义类
 * @author Looly
 *
 */
public enum PublicName implements Name{
	
	/* ----------------------------- 公共参数 ----------------------------- */
	/** 公钥 */
	PublicKey,
	/** 签名 */
	Signature,
	
	/** 指令名称 */
	Action,
	/** 数据中心 */
	Region,
	
	/** 数据偏移量，默认为0 */
	Offset,
	/** 返回数据长度，默认为20 */
	Limit,
	
	/** 密码 */
	Password
}
