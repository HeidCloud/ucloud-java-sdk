package com.xiaoleilu.ucloud.unet.security;

import com.xiaoleilu.hutool.StrUtil;

/**
 * 防火墙规则
 * @author Looly
 *
 */
public class SecurityRule {
	/** 网络协议 */
	private Proto proto;
	/** 目标端口 */
	private int destPort;
	/** 源地址 */
	private int srcIp;
	/** 防火墙动作 */
	private SecurityAction action;
	/** 规则优先级 */
	private int priority;

	// --------------------------------------------------------------- Constructor start
	/**
	 * 构造
	 */
	public SecurityRule() {
	}
	// --------------------------------------------------------------- Constructor end

	// --------------------------------------------------------------- Getters and Setters start
	/**
	 * @return 网络协议
	 */
	public Proto getProto() {
		return proto;
	}
	/**
	 * 设置网络协议
	 * @param proto 网络协议
	 */
	public void setProto(Proto proto) {
		this.proto = proto;
	}

	/**
	 * @return 目标端口
	 */
	public int getDestPort() {
		return destPort;
	}
	/**
	 * 设置目标端口
	 * @param destPort 目标端口
	 */
	public void setDestPort(int destPort) {
		this.destPort = destPort;
	}
	/**
	 * @return 源地址
	 */
	public int getSrcIp() {
		return srcIp;
	}
	/**
	 * 设置源地址
	 * @param srcIp 源地址
	 */
	public void setSrcIp(int srcIp) {
		this.srcIp = srcIp;
	}

	/**
	 * @return 防火墙动作
	 */
	public SecurityAction getAction() {
		return action;
	}
	/**
	 * 设置防火墙动作
	 * @param action 防火墙动作
	 */
	public void setAction(SecurityAction action) {
		this.action = action;
	}

	/**
	 * @return 规则优先级
	 */
	public int getPriority() {
		return priority;
	}
	/**
	 * 设置规则优先级
	 * @param priority 规则优先级
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	// --------------------------------------------------------------- Getters and Setters end
	@Override
	public String toString() {
		return StrUtil.format("{}|{}|{}|{}|{}", this.proto, this.destPort, this.srcIp, this.action, this.priority);
	}
}
