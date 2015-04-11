package com.xiaoleilu.ucloud.test;

import org.slf4j.Logger;

import com.xiaoleilu.hutool.Log;
import com.xiaoleilu.ucloud.core.Response;
import com.xiaoleilu.ucloud.umon.UMon;

/**
 * 云监控 测试类
 * @author Looly
 *
 */
public class UMonTest {
	private final static  Logger log = Log.get();
	
	private final UMon uMon = new UMon();
	
	/**
	 * 发送短信测试
	 */
//	@Test
	public void sendSmdTest(){
		Response resp = uMon.sendSms("测试短信", "18801050000");
		log.debug("Junit: {}", resp.toPretty());
	}
}
