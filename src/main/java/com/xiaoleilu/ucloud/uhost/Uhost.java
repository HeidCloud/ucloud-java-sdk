package com.xiaoleilu.ucloud.uhost;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoleilu.ucloud.UcloudApiClient;
import com.xiaoleilu.ucloud.entity.Param;
import com.xiaoleilu.ucloud.util.ParamName;
import com.xiaoleilu.ucloud.util.Region;

/**
 * 云主机
 * @author Looly
 *
 */
public class Uhost {
	final UcloudApiClient client = new UcloudApiClient();
	
	/**
	 * 获取主机或主机列表信息，并可根据数据中心，主机ID等参数进行过滤。
	 * @throws IOException
	 */
	public JSONObject describeUHostInstance() throws IOException{
		Param param = new Param();
		param
		.set(ParamName.ACTION, "DescribeUHostInstance")
		.set(ParamName.REGION, Region.CN_NORTH_03);
		
		UcloudApiClient client = new UcloudApiClient();
		String jsonStr = client.get(param);
		
		return JSON.parseObject(jsonStr);
	}
	
	/**
	 * 获取主机或主机列表信息，并可根据数据中心，主机ID等参数进行过滤。
	 * @throws IOException
	 */
	public JSONObject describeImage() throws IOException{
		Param param = Param.create();
		param
		.set(ParamName.REGION, Region.CN_NORTH_03)
		.set(ParamName.ACTION, "DescribeImage");
		
		
		String jsonStr = client.get(param);
		return JSON.parseObject(jsonStr);
	}
}
