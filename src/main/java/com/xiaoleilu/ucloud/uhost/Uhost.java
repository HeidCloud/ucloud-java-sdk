package com.xiaoleilu.ucloud.uhost;

import java.io.IOException;

import com.xiaoleilu.ucloud.UcloudApiClient;
import com.xiaoleilu.ucloud.entity.Request;
import com.xiaoleilu.ucloud.entity.Response;
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
	public Response describeUHostInstance() throws IOException{
		final Request request = new Request("DescribeUHostInstance", Region.CN_NORTH_03);
		return client.get(request);
	}
	
	/**
	 * 获取主机或主机列表信息，并可根据数据中心，主机ID等参数进行过滤。
	 * @throws IOException
	 */
	public Response describeImage() throws IOException{
		final Request request = new Request("DescribeImage", Region.CN_NORTH_03);
		return client.get(request);
	}
}
