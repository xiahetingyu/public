package com.xiahe.core;

import com.xiahe.entity.ProxyE;
import com.xiahe.tool.NetworkTools;
import com.xiahe.tool.Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Implement_QiYun implements Collector {
	private static String[] property = Tools.merge(Configuration.BROWSER, new String[] { "Host", "www.qydaili.com" });

	@Override
	public void collect() {
		for (int i = 1; i < 200; i++) {
			try {
				// 访问收集网址
				String url = "http://www.qydaili.com/free/?action=china&page=" + i;
				String result = NetworkTools.httpString(url, "GET", null, null, property, null);
				// 筛选代理IP
				if (result != null && result != "") {
					List<ProxyE> es = pattern(result);
					if (es.size() == 0) {
						return;
					}
					// 存入待验证队列
					put(es);
				}
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<ProxyE> pattern(String content) {
		List<ProxyE> es = new ArrayList<>();
		// 根据网站的不同使用不同的匹配方式
		Pattern pattern = Pattern
				.compile(">(\\d{1,3}\\.){3}\\d{1,3}</td><tddata-title=\"PORT\">\\d+</td>".replaceAll("\\s", ""));
		Matcher matcher = pattern.matcher(content.replaceAll("\\s", ""));
		while (matcher.find()) {
			String[] strings = matcher.group().split("</td><tddata-title=\"PORT\">".replaceAll("\\s", ""));
			if (strings != null && strings[0] != "") {
				ProxyE e = new ProxyE();
				e.setIp(strings[0].replaceAll(">", ""));
				e.setPort(Integer.valueOf(strings[1].replaceAll("</td>", "")));
				e.setProxye(e.getIp() + ":" + e.getPort());
				es.add(e);
			}
		}
		return es;
	}

	@Override
	public void put(List<ProxyE> es) {
		for (ProxyE proxyE : es) {
			try {
				Configuration.VERIFICATION.put(proxyE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
