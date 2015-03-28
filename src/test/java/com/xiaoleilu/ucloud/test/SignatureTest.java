package com.xiaoleilu.ucloud.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;

import com.xiaoleilu.hutool.Log;
import com.xiaoleilu.ucloud.Param;

/**
 * 签名单元测试类
 * @author Looly
 *
 */
public class SignatureTest {
	private final static Logger log = Log.get();
	
	/**
	 * 验证签名算法生成的签名是否与官方一致
	 */
	@Test
	public void sinatureTest(){
		
		String officalPythonSignature = "7a517649e4e9da3b6c82c932d667daa1599ae3a1";
		
		String publicKey = "ucloudsomeone@example.com1296235120854146120";
		String privateKey = "46f09bb9fab4f12dfc160dae12273d5332b5debe";
		
		Param param = new Param();
		param
		.set("Action", "CreateUHostInstance")
		.set("Region", "cn-north-01")
		.set("ImageId", "f43736e1-65a5-4bea-ad2e-8a46e18883c2")
		.set("CPU", 2)
		.set("Memory", 2048)
		.set("DiskSpace", 10)
		.set("LoginMode", "Password")
		.set("Password", "UCloudexample01")
		.set("Name", "Host01")
		.set("ChargeType", "Month")
		.set("Quantity", 1)
		.set("PublicKey", publicKey);

		String signature = param.signature(privateKey);
		
		log.debug("Java                  signature: {}", signature);
		log.debug("Offical Python signature: {}", officalPythonSignature);
		
		//验证生成的签名是否与官方一致
		Assert.assertEquals(signature, officalPythonSignature);
	}
}
