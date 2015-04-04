package com.xiaoleilu.ucloud.uhost.image;

import org.slf4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoleilu.hutool.Log;
import com.xiaoleilu.hutool.StrUtil;

/**
 * 镜像
 * @author Looly
 *
 */
public class Image {
	private static final Logger log = Log.get();
	
	/** 镜像ID */
	private String imageId;
	/** 镜像名称 */
	private String imageName;
	/** 镜像类型：标准镜像：Base，行业镜像：Business， 自定义镜像：Custom */
	private ImageType imageType;
	/** 镜像状态， 可用：Available，制作中：Making， 不可用：Unavailable */
	private String state;
	/** 镜像描述 */
	private String imageDescription;
	
	/** 操作系统名称 */
	private String osName;
	/** 操作系统类型：Liunx，Windows */
	private OsType osType;
	
	/** 创建时间 */
	private long createTime;
	
	// --------------------------------------------------------------- Getters And Setters start
	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public ImageType getImageType() {
		return imageType;
	}

	public void setImageType(ImageType imageType) {
		this.imageType = imageType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public OsType getOsType() {
		return osType;
	}

	public void setOsType(OsType osType) {
		this.osType = osType;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	// --------------------------------------------------------------- Getters And Setters end
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
	/**
	 * Image JSON对象转为Java 对象
	 * @param jsonObj JSON对象
	 * @return Image
	 */
	public static Image parse(JSONObject jsonObj) {
		if(null == jsonObj) {
			return null;
		}
		
		final Image image = new Image();
		
		image.imageId = jsonObj.getString("ImageId");
		image.imageName = jsonObj.getString("ImageName");
		image.state = jsonObj.getString("State");
		image.osName = jsonObj.getString("OsName");
		image.createTime = jsonObj.getLong("CreateTime");
		image.imageDescription = jsonObj.getString("ImageDescription");
		
		String osType = null;
		try {
			osType = jsonObj.getString("OsType");
			if(StrUtil.isNotBlank(osType)) {
				image.osType = OsType.valueOf(osType);
			}
		} catch (Exception e) {
			log.warn("Unknown OS Type {}, error: {}", osType, e.getMessage());
		}
		
		String imageType = null;
		try {
			imageType = jsonObj.getString("ImageType");
			if(StrUtil.isNotBlank(imageType)) {
				image.imageType = ImageType.valueOf(imageType);
			}
		} catch (Exception e) {
			log.warn("Unknown Image Type {}, error: {}", imageType, e.getMessage());
		}
		
		return image;
	}
}
