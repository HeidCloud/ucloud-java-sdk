package com.xiaoleilu.ucloud.ufile;

import com.xiaoleilu.ucloud.core.Param;
import com.xiaoleilu.ucloud.core.Response;
import com.xiaoleilu.ucloud.core.Ucloud;
import com.xiaoleilu.ucloud.core.UcloudApiClient;
import com.xiaoleilu.ucloud.util.Config;

/**
 * 对象存储 UFile
 * @author Looly
 *
 */
public class UFile extends Ucloud{
	
	// --------------------------------------------------------------- Constructor start
	/**
	 * 构造，公钥、私钥、API的URL读取默认配置文件中的信息
	 */
	public UFile() {
		super();
	}
	/**
	 * 构造
	 * @param config 配置文件
	 */
	public UFile(Config config) {
		super(config);
	}
	/**
	 * 构造
	 * @param client UcloudApiClient
	 */
	public UFile(UcloudApiClient client) {
		super(client);
	}
	// --------------------------------------------------------------- Constructor end

	/**
	 * 创建Bucket
	 * 
	 * @param param 参数
	 * @return 返回结果
	 */
	public Response createBucket(Param param) {
		return client.get(UFileAction.CreateBucket, param);
	}

	/**
	 * 获取Bucket的描述信息
	 * 
	 * @param param 参数
	 * @return 返回结果
	 */
	public Response describeBucket(Param param) {
		return client.get(UFileAction.DescribeBucket, param);
	}

	/**
	 * 设置Bucket的属性
	 * 
	 * @param param 参数
	 * @return 返回结果
	 */
	public Response updateBucket(Param param) {
		return client.get(UFileAction.UpdateBucket, param);
	}

	/**
	 * 删除Bucket
	 * 
	 * @param bucketName 待删除Bucket的名称
	 * @return 返回结果
	 */
	public Response deleteBucket(String bucketName) {
		return client.get(UFileAction.DeleteBucket, Param.create().set(UFileName.BucketName, bucketName));
	}

	/**
	 * 获取Bucket的文件列表
	 * 
	 * @param param 参数
	 * @return 返回结果
	 */
	public Response getFileList(Param param) {
		return client.get(UFileAction.GetFileList, param);
	}
}
