package com.xiaoleilu.ucloud.test;

import org.junit.Test;
import org.slf4j.Logger;

import com.xiaoleilu.hutool.Log;
import com.xiaoleilu.ucloud.Param;
import com.xiaoleilu.ucloud.PublicName;
import com.xiaoleilu.ucloud.Response;
import com.xiaoleilu.ucloud.uhost.ChargeType;
import com.xiaoleilu.ucloud.uhost.LoginMode;
import com.xiaoleilu.ucloud.uhost.UHostName;
import com.xiaoleilu.ucloud.uhost.Uhost;
import com.xiaoleilu.ucloud.uhost.image.Image;
import com.xiaoleilu.ucloud.uhost.image.ImageFilter;
import com.xiaoleilu.ucloud.uhost.image.ImageType;
import com.xiaoleilu.ucloud.uhost.image.OsType;
import com.xiaoleilu.ucloud.util.Region;

/**
 * 云主机单元测试类
 * @author Looly
 *
 */
public class UhostTest {
	private final static  Logger log = Log.get();
	
	Uhost uhost = new Uhost();
	
	@Test
	public void getUhostInstacePrice(){
		final Param param = Param.create()
				.set(PublicName.Region, Region.CN_NORTH_03)
				//CentOS 7.0 64位
				.set(UHostName.ImageId, "uimage-5yt2b0")
				.set(UHostName.CPU, 1)
				.set(UHostName.Memory, 2048)
				.set(UHostName.Count, 1)
				.set(UHostName.DiskSpace, 10)
				.set(UHostName.ChargeType, ChargeType.Month);
		
		Response resp = uhost.getUHostInstancePrice(param);
		log.debug("Junit: {}", resp.toPretty());
	}
	
	@Test
	public void createUHostInstance(){
		final Param param = Param.create()
				.set(PublicName.Region, Region.CN_NORTH_03)
				//CentOS 7.0 64位
				.set(UHostName.ImageId, "uimage-5yt2b0")
				.set(UHostName.LoginMode, LoginMode.Password)
				.setPassword("123456")
				.set(UHostName.CPU, 1)
				.set(UHostName.Memory, 2048)
				.set(UHostName.DiskSpace, 10)
				.set(UHostName.Name, "LoolyCentOS7")
				.set(UHostName.ChargeType, ChargeType.Month)
				.set(UHostName.Quantity, 1);
		
		log.debug("create instance param: {}", param);
//		Response resp = uhost.createUHostInstance(param);
//		log.debug("Junit: {}", resp.toPretty());
	}
	
	@Test
	public void startHostInstance(){
		Response resp = uhost.startUHostInstance(Region.CN_NORTH_03, "uhost-agd0gk");
		log.debug("Junit: {}", resp.toPretty());
	}
	
	@Test
	public void stopHostInstance(){
		Response resp = uhost.stopUHostInstance(Region.CN_NORTH_03, "uhost-agd0gk");
		log.debug("Junit: {}", resp.toPretty());
	}
	
	@Test
	public void describeUHostInstance(){
		Param param = Param.create()
				.set(PublicName.Region, Region.CN_NORTH_03)
				.set(PublicName.Offset, 0)
				.set(PublicName.Limit, 50);
		
		log.debug("Junit: {}", uhost.describeUHostInstance(param).toPretty());
	}
	
	@Test
	public void describeImage(){
		Param param = Param.create()
				.set(PublicName.Region, Region.CN_NORTH_03)
				.set(UHostName.OsType, OsType.Linux)
				.set(UHostName.ImageType, ImageType.Base)
				.set(PublicName.Offset, 0)
				.set(PublicName.Limit, 5);
		
		log.debug("Junit: {}", uhost.describeImage(param, new ImageFilter(){
			
			@Override
			public boolean filter(Image image) {
				return image.getOsName().toLowerCase().contains("centos 7");
			}
		}).toPretty());
	}
}
