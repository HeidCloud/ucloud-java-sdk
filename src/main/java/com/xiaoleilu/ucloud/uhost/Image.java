package com.xiaoleilu.ucloud.uhost;

/**
 * 镜像
 * @author Looly
 *
 */
public class Image {
	/** 镜像ID */
	private String imageId;
	/** 镜像名称 */
	private String imageName;
	/** 镜像类型：标准镜像：Base，行业镜像：Business， 自定义镜像：Custom */
	private String imageType;
	/** 镜像状态， 可用：Available，制作中：Making， 不可用：Unavailable */
	private String state;
	/** 镜像描述 */
	private String imageDescription;
	
	/** 操作系统名称 */
	private String osName;
	/** 操作系统类型：Liunx，Windows */
	private String osType;
	
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

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
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

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	// --------------------------------------------------------------- Getters And Setters end
}
