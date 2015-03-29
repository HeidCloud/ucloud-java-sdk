package com.xiaoleilu.ucloud.test;

import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;

import com.xiaoleilu.hutool.Log;
import com.xiaoleilu.ucloud.Param;
import com.xiaoleilu.ucloud.uhost.Uhost;
import com.xiaoleilu.ucloud.util.Region;

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
		Param param = Param.create()
				.set("Region", Region.CN_NORTH_03)
				.set("Offset", 0)
				.set("Limit", 50);
		
		log.debug("Junit: {}", uhost.describeUHostInstance(param).toPretty());
	}
	
	@Test
	public void describeImage() throws IOException{
		Param param = Param.create()
				.set("Region", Region.CN_NORTH_03)
				.set("Offset", 0)
				.set("Limit", 5);
		
		log.debug("Junit: {}", uhost.describeImage(param).toPretty());
	}
	
	public static void main(String[] args) {
		final Param param = Param.create()
				.set("Region", Region.CN_NORTH_03)
				.set("UHostId", "aaaaaaaaaa");
		
		System.out.println(param);
	}
}