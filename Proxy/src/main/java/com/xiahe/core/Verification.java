package com.xiahe.core;

import com.xiahe.entity.ProxyE;
import com.xiahe.tool.NetworkTools;
import com.xiahe.tool.Tools;

import java.sql.Timestamp;

//可用性验证器 
public class Verification implements Runnable {
	private static String[] property = Tools.merge(Configuration.BROWSER, new String[] { "Host", Configuration.VER });

	// 验证代理IP
	public static boolean verification(ProxyE e) {
		e.setTime(new Timestamp(System.currentTimeMillis()));// 设置更新时间
		System.out.println("Verification:" + e);
		for (int i = 0; i < 2; i++) {
			try {
				String result = NetworkTools.httpsString(Configuration.VER, "GET", null, null, property, e.getProxy());
				e.setVer(e.getVer() + (result != null ? 1 : -1));// 验证结果
				return result != null;
			} catch (Exception exception) {
			}
		}
		e.setVer(-1);
		return false;
	}

	// 判断是否有网络
	public static boolean isOnline() {
		try {
			return NetworkTools.httpsString(Configuration.VER, "GET", null, null, property, null) != null;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				ProxyE take = Configuration.VERIFICATION.take();
				// 验证失败直接丢弃|网络来源的代理IP
				boolean verification = verification(take);
				if (verification) {
					Configuration.CACHE.put(take);
				}
				// 验证失败放入队列删除|本地数据库代理IP
				if (!verification && take.getOther() != null) {
					Configuration.CACHE.put(take);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
