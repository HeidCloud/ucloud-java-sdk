![封面](https://gitcafe-image.b0.upaiyun.com/c6f592a6a94231bd62b5da91510dcf0a.jpg)

# ucloud-java-sdk
ucloud-java-sdk是Ucloud官方API的Java封装，此SDK不但提供了接口的完整封装，还提供了一些自动化运维和自动化伸缩的相关功能。

## 安装

### Maven
在项目的pom.xml的dependencies中加入以下内容:

```XML
<dependency>
    <groupId>com.xiaoleilu</groupId>
    <artifactId>ucloud-java-sdk</artifactId>
    <version>X.X.X</version>
</dependency>
```

注：ucloud-java-sdk的版本可以通过 http://search.maven.org/ 搜索`ucloud-java-sdk`找到项目。

### 非Maven项目
可以从[http://search.maven.org/](http://search.maven.org/) 搜索`ucloud-java-sdk`找到项目，点击对应版本，下面是相应的Jar包，导入即可使用。

下载地址：

http://search.maven.org/remotecontent?filepath=com/xiaoleilu/ucloud-java-sdk/0.2.1/ucloud-java-sdk-0.2.2.jar


## 开始

### UcloudApiClient 使用

```Java
package com.xiaoleilu.ucloud.test;

import com.xiaoleilu.ucloud.Param;
import com.xiaoleilu.ucloud.Response;
import com.xiaoleilu.ucloud.UcloudApiClient;
import com.xiaoleilu.ucloud.util.Config;

public class UcloudApiClientTest {
	
	/**
	 * UcloudApiClient使用样例
	 */
	public static void main(String[] args) {
		UcloudApiClient client;
		
		//使用默认的Ucloud Api请求客户端
		//默认读取classpath下的config.setting文件。文件内容请参阅doc/config_sample.setting
		client = new UcloudApiClient();
		
		//自定义配置内容
		final Config config = new Config(
				//公钥
				"ucloudsomeone@example.com1296235120854146120", 
				//私钥
				"46f09bb9fab4f12dfc160dae12273d5332b5debe", 
				//请求API的URL
				"https://api.ucloud.cn");
		client = new UcloudApiClient(config);
		
		//构造参数
		Param param = Param.create()
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
				.set("Quantity", 1);
		
		//请求API，Response是个封装了返回JSON的一个对象
		Response response = client.get(param);
		
		//返回的状态码
		response.getRetCode();
		//获得原始JSON对象（使用FastJSON）
		response.getJson();
		
	}
}
```

## 详细文档请参阅Wiki：

[https://gitcafe.com/looly/ucloud-java-sdk/wiki/pages](https://gitcafe.com/looly/ucloud-java-sdk/wiki/pages)