package com.xiaoleilu.ucloud.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.xiaoleilu.hutool.SecureUtil;

/**
 * HmacSHA1算法
 * @author Looly
 *
 */
public class HmacSHA1 {
	private static final String ALGORITHM = "HmacSHA1";
	private static Mac macInstance;

	static {
		macInstance = createMac();
	}
	
	/**
	 * 创建Mac实例
	 * @return Mac
	 */
	public static Mac createMac() {
		try {
			return macInstance = Mac.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Unsupported algorithm: " + ALGORITHM);
		}
	}

	/**
	 * 签名
	 * @param privateKey 私钥
	 * @param data 数据
	 * @return 签名
	 */
	public static String sign(String privateKey, String data) {
		try {
			byte[] signData = sign(privateKey.getBytes(Global.CHARSET), data.getBytes(Global.CHARSET));
			return SecureUtil.base64(signData);
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}

	/**
	 * 签名
	 * @param key 键
	 * @param data 数据
	 * @return 签名
	 */
	private static byte[] sign(byte[] key, byte[] data) {
		Mac mac = null;
		try {
			mac = (Mac) macInstance.clone();
		} catch (CloneNotSupportedException e) {
			mac = createMac();
		}
		try {
			mac.init(new SecretKeySpec(key, ALGORITHM));
		} catch (InvalidKeyException e) {
			throw new RuntimeException(e);
		}
		return mac.doFinal(data);
	}
}