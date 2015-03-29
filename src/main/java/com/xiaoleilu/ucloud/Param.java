package com.xiaoleilu.ucloud;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.xiaoleilu.hutool.Conver;
import com.xiaoleilu.hutool.HttpUtil;
import com.xiaoleilu.hutool.SecureUtil;
import com.xiaoleilu.hutool.StrUtil;
import com.xiaoleilu.ucloud.exception.ParamException;
import com.xiaoleilu.ucloud.util.Config;
import com.xiaoleilu.ucloud.util.Global;

/**
 * 参数对象
 * 
 * @author Looly
 *
 */
public class Param extends TreeMap<String, Object> {
	private static final long serialVersionUID = 1190594719758105119L;
	
	/**
	 * 参数名接口<br>
	 * 具体的参数枚举类需要实现这个接口
	 * @author Looly
	 *
	 */
	public static interface Name{
		String toString();
	}

	// --------------------------------------------------------------- Static method start
	/**
	 * 创建参数对象
	 * 
	 * @return 参数对象
	 */
	public static Param create() {
		return new Param();
	}
	
	/**
	 * 创建参数对象
	 * 
	 * @param paramMap 参数Map
	 * @return 参数对象
	 */
	public static Param create(Map<String, Object> paramMap) {
		return (new Param()).setAll(paramMap);
	}
	// --------------------------------------------------------------- Static method end
	
	// --------------------------------------------------------------- Constructor start
	/**
	 * 构造，使用配置文件中定义的公钥和私钥
	 */
	public Param() {
	}
	// --------------------------------------------------------------- Constructor end

	// -------------------------------------------------------------------- 特定类型值
	/**
	 * 设置列
	 * 
	 * @param name 参数名
	 * @param value 值
	 * @return 本身
	 */
	public Param set(String name, Object value) {
		if (null != name && null != value) {
			put(name, value);
		}
		return this;
	}
	
	/**
	 * 设置列
	 * 
	 * @param paramName 参数名（枚举类型）
	 * @param value 值
	 * @return 本身
	 */
	public Param set(Name paramName, Object value) {
		return set(paramName.toString(), value);
	}
	
	/**
	 * 设置API指令
	 * @param action API指令
	 * @return 本身
	 */
	public Param setAction(Action action) {
		return set(Action.KEY, action);
	}
	
	/**
	 * 设置多列
	 * 
	 * @param attr 属性
	 * @param value 值
	 * @return 本身
	 */
	public Param setAll(Map<String, Object> map) {
		for (Entry<String, Object> entry : map.entrySet()) {
			this.set(entry.getKey(), entry.getValue());
		}
		return this;
	}
	
	/**
	 * 特殊参数：设置密码，此方法对密码做了Base64编码
	 * @param password 密码
	 * @return 本身
	 */
	public Param setPassword(String password){
		return set(PublicName.Password, SecureUtil.base64(password, Global.CHARSET));
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

		return SecureUtil.sha1(sb.toString(), Global.CHARSET);
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
			param.put(key, HttpUtil.encode(StrUtil.str(value), Global.CHARSET));
		}

		return HttpUtil.toParams(param);
	}
	
	/**
	 * 生成Http请求参数字符串
	 * @return Http请求参数字符串
	 */
	public String genHttpParam(Config config){
		//指令名称和数据中心必须存在
		assertParams(PublicName.Action, PublicName.Region);
		
		//1. 设置公钥
		this.set(PublicName.PublicKey, config.getPublicKey());
		//2. 生成签名
		this.set(PublicName.Signature, this.signature(config.getPrivateKey()));
		//3. 生成Http参数字符串
		return this.encode();
	}
	
	/**
	 * 检查参数
	 * @param paramNames 参数名
	 */
	private void assertParams(PublicName... paramNames){
		for (PublicName paramName : paramNames) {
			if(false == this.containsKey(paramName.name())){
				throw new ParamException("Parameter '{}' not found!", paramName);
			}
		}
	}
}
