package com.xiahe.core;

import com.xiahe.entity.ProxyE;

import java.util.List;

//收集器接口
public interface Collector {

	// 收集方法
	void collect();

	// 从网页中匹配代理IP
	List<ProxyE> pattern(String content);

	// 存入待验证队列
	void put(List<ProxyE> es);

}
