package com.xiaoleilu.ucloud.util;

import com.xiaoleilu.hutool.Setting;

/**
 * 设置参数
 * @author Looly
 *
 */
public class Config {
	private final static Setting config = new Setting("config/config.setting");
	
	/** 全局字符集 */
	public final static String CHARSET = config.getString("charset");
	
	/** 公钥 */
	public final static String PUBLIC_KEY = config.getString("public_key");
	/** 私钥 */
	public final static String PRIVATE_KEY = config.getString("private_key");
	
	/** API的URL */
	public final static String BASE_URL = config.getString("base_url");
}
