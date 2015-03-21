package com.xiaoleilu.ucloud.util;

/**
 * API返回码
 * @author Looly
 *
 */
public class RetCode {
	/** API请求正常 */
	public final static int OK = 0;
	
	/** API请求未知异常 */
	public final static int ERROR= -1;
	
	/** 用户不存在 */
	public final static int USER_NOT_EXISTS= 171;
	
	/** 验证签名错误 */
	public final static int SIGNATURE_VERFY_AC_ERROR= 172;
}
