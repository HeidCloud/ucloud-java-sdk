package com.xiaoleilu.ucloud.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import com.xiaoleilu.hutool.CharsetUtil;
import com.xiaoleilu.hutool.SecureUtil;

public class Signature {

	/**
	 * 生成
	 * 
	 * @param privateKey
	 * @param params
	 * @return
	 */
	public static String generate(String privateKey, Map<String, Object> params) {
		final StringBuilder sb = new StringBuilder();

		for (Entry<String, Object> entry : sortToTreeSet(params)) {
			sb.append(entry.getKey()).append(entry.getValue());
		}
		sb.append(privateKey);

		return SecureUtil.sha1(sb.toString(), CharsetUtil.UTF_8);
	}

	/**
	 * 排序Map
	 * 
	 * @param params 参数列表
	 * @return 排序后的键值对
	 */
	private static TreeSet<Entry<String, Object>> sortToTreeSet(Map<String, Object> params) {
		final TreeSet<Entry<String, Object>> treeSet = new TreeSet<Entry<String, Object>>(new Comparator<Entry<String, Object>>(){
			@Override
			public int compare(Entry<String, Object> o1, Entry<String, Object> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		
		for (Entry<String, Object> entry : params.entrySet()) {
			treeSet.add(entry);
		}
		return treeSet;
	}

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("Action", "CreateUHostInstance");
		map.put("Region", "cn-north-01");
		map.put("ImageId", "f43736e1-65a5-4bea-ad2e-8a46e18883c2");
		map.put("CPU", 2);
		map.put("Memory", 2048);
		map.put("DiskSpace", 10);
		map.put("LoginMode", "Password");
		map.put("Password", "UCloudexample01");
		map.put("Name", "Host01");
		map.put("ChargeType", "Month");
		map.put("Quantity", 1);
		map.put("PublicKey", "ucloudsomeone@example.com1296235120854146120");

		String string = generate("46f09bb9fab4f12dfc160dae12273d5332b5debe", map);

		System.out.println("Java:      " + string);
		System.out.println("Python: 7a517649e4e9da3b6c82c932d667daa1599ae3a1");
		
	}
}
