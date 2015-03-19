package com.xiaoleilu.ucloud.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.xiaoleilu.hutool.Conver;
import com.xiaoleilu.hutool.HttpUtil;
import com.xiaoleilu.hutool.InjectUtil;
import com.xiaoleilu.hutool.SecureUtil;
import com.xiaoleilu.hutool.StrUtil;
import com.xiaoleilu.hutool.exceptions.UtilException;
import com.xiaoleilu.ucloud.util.Config;
import com.xiaoleilu.ucloud.util.ParamName;

/**
 * 请求API的参数对象
 * 
 * @author Looly
 *
 */
public class Param extends TreeMap<String, Object> {
	private static final long serialVersionUID = 1L;

	// --------------------------------------------------------------- Static method start
	/**
	 * 创建参数对象
	 * 
	 * @return 参数对象
	 */
	public static Param create() {
		return new Param();
	}
	// --------------------------------------------------------------- Static method end
	
	private String privateKey;

	// --------------------------------------------------------------- Constructor start
	/**
	 * 构造，使用配置文件中定义的公钥和私钥
	 */
	public Param() {
		this(Config.PUBLIC_KEY, Config.PRIVATE_KEY);
	}
	
	/**
	 * 构造
	 * @param publicKey 自定义的公钥
	 * @param privateKey 自定义的私钥
	 */
	public Param(String publicKey, String privateKey) {
		this.set(ParamName.PUBLIC_KEY, publicKey);
		this.privateKey = privateKey;
	}
	// --------------------------------------------------------------- Constructor end

	/**
	 * 填充Value Object对象
	 * 
	 * @param vo Value Object（或者POJO）
	 * @return vo
	 */
	public <T> T fillVo(T vo) {
		InjectUtil.injectFromMap(vo, this);
		return vo;
	}

	/**
	 * 填充Value Object对象
	 * 
	 * @param clazz Value Object（或者POJO）的类
	 * @return vo
	 */
	public <T> T toVo(Class<T> clazz) {
		if (clazz == null) {
			throw new NullPointerException("Provided Class is null!");
		}
		T vo;
		try {
			vo = clazz.newInstance();
		} catch (Exception e) {
			throw new UtilException(StrUtil.format("Instance Value Object [] error!", clazz.getName()));
		}
		InjectUtil.injectFromMap(vo, this);
		return vo;
	}

	/**
	 * 将值对象转换为Entity<br>
	 * 类名会被当作表名，小写第一个字母
	 * 
	 * @param vo 值对象
	 * @return 自己
	 */
	public Param parse(Object vo) {
		this.putAll(InjectUtil.toMap(vo, false));
		return this;
	}

	// -------------------------------------------------------------------- 特定类型值
	/**
	 * 设置列
	 * 
	 * @param attr 属性
	 * @param value 值
	 * @return 本身
	 */
	public Param set(String attr, Object value) {
		super.put(attr, value);
		return this;
	}

	/**
	 * 设置列，当键或值为null时忽略
	 * 
	 * @param attr 属性
	 * @param value 值
	 * @return 本身
	 */
	public Param setIgnoreNull(String attr, Object value) {
		if (null != attr && null != value) {
			set(attr, value);
		}
		return this;
	}

	/**
	 * 获得特定类型值
	 * 
	 * @param attr 字段名
	 * @param defaultValue 默认值
	 * @return 字段值
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(String attr, T defaultValue) {
		final Object result = get(attr);
		return (T) (result != null ? result : defaultValue);
	}

	/**
	 * @param attr 字段名
	 * @return 字段值
	 */
	public String getStr(String attr) {
		return Conver.toStr(get(attr), null);
	}

	/**
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Integer getInt(String attr) {
		return Conver.toInt(get(attr), null);
	}

	/**
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Long getLong(String attr) {
		return Conver.toLong(get(attr), null);
	}

	/**
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Float getFloat(String attr) {
		return Conver.toFloat(get(attr), null);
	}

	/**
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Boolean getBool(String attr) {
		return Conver.toBool(get(attr), null);
	}

	/**
	 * @param attr 字段名
	 * @return 字段值
	 */
	public byte[] getBytes(String attr) {
		return get(attr, null);
	}

	/**
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Date getDate(String attr) {
		return get(attr, null);
	}

	/**
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Time getTime(String attr) {
		return get(attr, null);
	}

	/**
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Timestamp getTimestamp(String attr) {
		return get(attr, null);
	}

	/**
	 * @param attr 字段名
	 * @return 字段值
	 */
	public Number getNumber(String attr) {
		return get(attr, null);
	}

	/**
	 * @param attr 字段名
	 * @return 字段值
	 */
	public BigDecimal getBigDecimal(String attr) {
		return get(attr, null);
	}

	/**
	 * @param attr 字段名
	 * @return 字段值
	 */
	public BigInteger getBigInteger(String attr) {
		return get(attr, null);
	}

	/**
	 * 浅复制本对象
	 * @return Param对象
	 */
	public Param clone() {
		return (Param) super.clone();
	}
	
	/**
	 * 生成签名
	 * 
	 * @param privateKey 私钥
	 * @return 签名
	 */
	public String signature(String privateKey) {
		final StringBuilder sb = new StringBuilder();

		for (Entry<String, Object> entry : this.entrySet()) {
			sb.append(entry.getKey()).append(entry.getValue());
		}
		sb.append(privateKey);

		return SecureUtil.sha1(sb.toString(), Config.CHARSET);
	}
	
	/**
	 * url转义参数值
	 */
	public String encode() {
		final Param param = this.clone();
		
		final Set<String> keys = param.keySet();
		Object value;
		for (String key : keys) {
			value = param.get(key);
			param.put(key, HttpUtil.encode(StrUtil.str(value), Config.CHARSET));
		}

		return HttpUtil.toParams(param);
	}
	
	/**
	 * 生成Http请求参数字符串
	 * @return Http请求参数字符串
	 */
	public String genHttpParam(){
		//1. 生成签名
		this.set(ParamName.SIGNATURE, this.signature(privateKey));
		//2. 生成Http参数字符串
		return this.encode();
	}
}
