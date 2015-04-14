package com.xiaoleilu.ucloud.util;

import java.util.Map.Entry;

import com.xiaoleilu.hutool.SecureUtil;
import com.xiaoleilu.hutool.StrUtil;
import com.xiaoleilu.ucloud.core.Param;

/**
 * 签名工具类
 * @author Looly
 *
 */
public class SignatureUtil {
	
	/**
	 * 签名
	 * @param signStr 被签名字符串
	 * @param privateKey 私钥
	 * @return 签名值
	 */
	public static String sign(String signStr, String privateKey) {
		return SecureUtil.sha1(StrUtil.builder(signStr, privateKey).toString(), Global.CHARSET);
	}
	
	/**
	 * 签名
	 * @param signStr 被签名字符串
	 * @param privateKey 私钥
	 * @return 签名值
	 */
	public static String sign(Param param, String privateKey) {
		final StringBuilder sb = new StringBuilder();

		for (Entry<String, Object> entry : param.entrySet()) {
			sb.append(entry.getKey()).append(entry.getValue());
		}
		
		return sign(sb.toString(), privateKey);
	}
}
