package com.xiaoleilu.ucloud.uhost;

import java.io.IOException;

import com.xiaoleilu.ucloud.Param;
import com.xiaoleilu.ucloud.Response;
import com.xiaoleilu.ucloud.UcloudApiClient;

/**
 * 云主机
 * @author Looly
 *
 */
public class Uhost {
	final UcloudApiClient client = new UcloudApiClient();
	
	/**
	 * 指定数据中心，根据资源使用量创建指定数量的UHost实例。
	 * @param 参数
	 * @throws IOException
	 */
	public Response createUHostInstance(Param param){
		return client.get(UHostAction.CreateUHostInstance, param);
	}
	
	/**
	 * 获取主机或主机列表信息，并可根据数据中心，主机ID等参数进行过滤。
	 * @param 参数
	 * @throws IOException
	 */
	public Response describeUHostInstance(Param param){
		return client.get(UHostAction.DescribeUHostInstance, param);
	}
	
	/**
	 * 获取主机或主机列表信息，并可根据数据中心，主机ID等参数进行过滤。
	 * @throws IOException
	 */
	public Response describeImage(Param param){
		return client.get(UHostAction.DescribeImage, param);
	}
}
