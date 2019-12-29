package com.xiahe.core;

import com.xiahe.entity.ProxyE;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Configuration {

	// 核心线程池
	public static final Executor EXECUTOR = Executors.newCachedThreadPool();

	// 待验证队列
	public static final BlockingQueue<ProxyE> VERIFICATION = new LinkedBlockingQueue<>(64);

	// 待写入队列
	public static final BlockingQueue<ProxyE> CACHE = new LinkedBlockingQueue<>(32);

	// 验证地址
	public static final String VER = "https://g.alicdn.com/tbc/global/0.0.8/index-min.css";

	// 请求头
	public static final String[] BROWSER;

	// 加载数据
	static {
		List<String> list = new ArrayList<String>();
		try {
			InputStream inputStream = Configuration.class.getResourceAsStream("/core/browser.txt");
			Scanner scanner = new Scanner(inputStream);
			for (String line; scanner.hasNext() && (line = scanner.nextLine()) != null;) {
				list.add(line);
			}
			scanner.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		BROWSER = list.toArray(new String[] {});
	}

}
