package com.xiaoleilu.ucloud.util;

import java.util.regex.Pattern;

/**
 * 验证器
 * @author Looly
 *
 */
public class Validator {
	private final static Pattern MOBILE =  Pattern.compile("1\\d{10}", Pattern.DOTALL);
	
	/**
	 * 是否为手机号码
	 * @param content 内容
	 * @return 是否为手机号码
	 */
	public static boolean isMobile(String content){
		return MOBILE.matcher(content).matches();
	}
}
