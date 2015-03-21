package com.xiaoleilu.ucloud.test;

import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;

import com.xiaoleilu.hutool.Log;
import com.xiaoleilu.ucloud.uhost.Uhost;

/**
 * 云主机单元测试类
 * @author Looly
 *
 */
public class UhostTest {
	private Logger log = Log.get();
	
	Uhost uhost = new Uhost();
	
	@Test
	public void describeUHostInstance() throws IOException{
		log.debug("Junit: {}", uhost.describeUHostInstance().toString());
	}
	
	@Test
	public void describeImage() throws IOException{
		log.debug("Junit: {}", uhost.describeImage().toString());
	}
}
